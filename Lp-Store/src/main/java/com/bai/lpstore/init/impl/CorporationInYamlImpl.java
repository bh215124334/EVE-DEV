package com.bai.lpstore.init.impl;

import com.bai.lpstore.esi.EsiReader;
import com.bai.lpstore.mapper.CorporationMapper;
import com.bai.lpstore.pojo.entity.Corporation;
import com.bai.lpstore.init.CorporationInYaml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * <h3>EVE-DEV</h3>
 * <p>初始化公司信息</p>
 *
 * @author : 白恒
 * @date : 2020-06-12 14:08
 **/
@Service
public class CorporationInYamlImpl implements CorporationInYaml {

    @Autowired
    private EsiReader esiReader;

    @Autowired
    private CorporationMapper corporationMapper;

    @Override
    public void corporationInit() {
        Yaml yam = new Yaml();
        try {
            List<Object> list = yam.load(new FileInputStream("D:\\git\\github\\EVE-DEV\\Lp-Store\\src\\main\\resources\\static\\crpNPCCorporations.yaml"));

            System.out.println("size:" + list.size());

            Corporation corporation = new Corporation();

            for(Object o : list){
                Map<String, Object> map = (Map<String, Object>) o;
                corporation.setCorporationID(Integer.parseInt(map.get("corporationID").toString()));
                corporation.setCorporationName(esiReader.getChineseName(corporation.getCorporationID()).getName());
                System.out.println(corporation);

                corporation.setFactionName("无势力");
                corporation.setFactionID(-1);

                if(map.containsKey("factionID")){
                    corporation.setFactionID(Integer.parseInt(map.get("factionID").toString()));
                    corporation.setFactionName(esiReader.getChineseName(corporation.getFactionID()).getName());
                }

                corporationMapper.insertCorp(corporation);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

