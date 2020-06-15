package com.bai.lpstore.esi.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bai.lpstore.esi.EsiReader;
import com.bai.lpstore.pojo.LpItem;
import com.bai.lpstore.pojo.Name;
import com.bai.lpstore.tools.HttpClientResult;
import com.bai.lpstore.tools.HttpUtil;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * <h3>EVE-DEV</h3>
 * <p></p>
 *
 * @author : 白恒
 * @date : 2020-06-11 09:48
 **/

@Repository
public class EsiReaderImpl implements EsiReader {

    @Value("${loyaltyEsi}")
    String loyaltyEsi;

    @Value("${nameEsi}")
    String nameEsi;

    @Value("${datasource}")
    String datasource;

    @Value("${npccorpsEsi}")
    String npccorpsEsi;


    @Override
    public List<LpItem> getLpItemsFromCorp(int corpId) {

//        System.out.println(loyaltyEsi);

        String url = loyaltyEsi + corpId + "/offers/";
        Map<String ,String> param = new HashMap<>();
        param.put("datasource", datasource);
        HttpClientResult clientResult = HttpUtil.doGet(url, param);
        if(clientResult.getCode() != 200) return null;

        JSONArray jsonArray = JSONArray.parseArray(clientResult.getContent());
        return getLpItemsFromJsonArray(jsonArray, corpId);
    }

    @Override
    public Name getChineseName(int typeId) {

//        System.out.println(nameEsi);

        String body = "["+typeId+"]";
        StringEntity entity = null;
        try{
            entity = new StringEntity(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = nameEsi;
        Map<String, String> param = new HashMap<>();
        param.put("datasource", datasource);
        HttpClientResult clientResult = HttpUtil.doPost(url, param, entity);
        JSONArray jsonArray = JSONArray.parseArray(clientResult.getContent());
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        Name name = new Name();
        name.setID(typeId);
        name.setName(jsonObject.getString("name"));

        return name;
    }

    @Override
    public List<Integer> getNpcCorpsIds() {
        Map<String, String> param = new HashMap<>();
        param.put("datasource", datasource);
        String result = HttpUtil.doGet(npccorpsEsi, param).getContent();
        String temp = result.substring(1, result.length()-1);
        String[] array = temp.split(",");
        List<Integer> list = new ArrayList<>();
        for(String s : array){
            list.add(Integer.parseInt(s));
        }
        return list;
    }


    private List<LpItem> getLpItemsFromJsonArray(JSONArray jsonArray, int corpID) {

        List<LpItem> lpItems = new ArrayList<>();

        for(int i = 0;i < jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            LpItem lpItem = new LpItem();
            lpItem.setIsk_cost(jsonObject.getLongValue("isk_cost"));
            lpItem.setLp_cost(jsonObject.getIntValue("lp_cost"));
            lpItem.setAk_cost(jsonObject.getIntValue("ak_cost"));

            lpItem.setType_id(jsonObject.getIntValue("type_id"));
            lpItem.setOffer_id(corpID);
            lpItem.setQuantity(jsonObject.getIntValue("quantity"));

            JSONArray temp = jsonObject.getJSONArray("required_items");
            Map<Integer, Integer> required_items = new HashMap<>();
            for(int j = 0; j < temp.size(); j++){
                JSONObject object = temp.getJSONObject(j);
                required_items.put(object.getInteger("type_id"), object.getInteger("quantity"));
            }
            lpItem.setRequired_items(required_items);

            lpItems.add(lpItem);
        }
        return lpItems;
    }

}
