package com.bai.lpstore.init.impl;

import com.bai.lpstore.esi.EsiReader;
import com.bai.lpstore.init.LpItemInEsi;
import com.bai.lpstore.mapper.LpOfferMapper;
import com.bai.lpstore.mapper.LpStoreMapper;
import com.bai.lpstore.pojo.LpItem;
import com.bai.lpstore.pojo.entity.LpInformation;
import com.bai.lpstore.pojo.entity.LpOffer;
import com.bai.lpstore.tools.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <h3>EVE-DEV</h3>
 * <p>忠诚点商店初始化</p>
 *
 * @author : 白恒
 * @date : 2020-06-12 14:55
 **/
@Service
public class LpItemEsiImpl implements LpItemInEsi {

    @Autowired
    private EsiReader esiReader;

    @Autowired
    private LpStoreMapper lpStoreMapper;

    @Autowired
    private LpOfferMapper lpOfferMapper;

    @Override
    public void LpItemInit() {

        List<Integer> list = esiReader.getNpcCorpsIds();

        Integer offerID = 1;

        for(Integer corpID:list){
            List<LpItem> lpItems = esiReader.getLpItemsFromCorp(corpID);
            if(lpItems == null || lpItems.size() == 0) continue;
            for(LpItem lpItem : lpItems){
                LpInformation lpInformation = new LpInformation(lpItem);
                lpInformation.setOfferID(offerID);

                System.out.println(lpInformation);

                lpStoreMapper.insertLp(lpInformation);

                for(Map.Entry<Integer, Integer> entry:lpItem.getRequired_items().entrySet()){
                    LpOffer lpOffer = new LpOffer();
                    lpOffer.setOfferID(offerID);
                    lpOffer.setTypeID(entry.getKey());
                    lpOffer.setQuantity(entry.getValue());

                    System.out.println(lpOffer);

                    ThreadPoolUtils.getInstance().submit(new Runnable() {
                        @Override
                        public void run() {
                            lpOfferMapper.insertLpOffer(lpOffer);
                        }
                    });
                }
                offerID++;
            }
        }

    }
}
