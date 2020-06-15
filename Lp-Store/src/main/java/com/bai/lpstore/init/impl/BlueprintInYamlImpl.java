package com.bai.lpstore.init.impl;

import com.bai.lpstore.mapper.BlueprintMapper;
import com.bai.lpstore.pojo.entity.Blueprint;
import com.bai.lpstore.init.BlueprintInYaml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

/**
 * <h3>EVE-DEV</h3>
 * <p></p>
 *
 * @author : 白恒
 * @date : 2020-06-12 09:41
 **/
@Service
public class BlueprintInYamlImpl implements BlueprintInYaml {

    @Autowired
    private BlueprintMapper blueprintMapper;


    @Override
    public void blueprintInit() {

        Yaml yam = new Yaml();
        try {
            Map<String, Object> map = yam.load(new FileInputStream("D:\\git\\github\\EVE-DEV\\Lp-Store\\src\\main\\resources\\static\\blueprints.yaml"));

            System.out.println("size:" + map.size());

            for(Object s : map.keySet()){
                Map<String, Object> print = (Map<String, Object>) map.get(s);
                Map<String, Object> activities = (Map<String, Object>) print.get("activities");
                if(activities == null) {
                    continue;
                }
                Map<String, Object> manufacturing = (Map<String, Object>) activities.get("manufacturing");
                if(manufacturing == null){
                    continue;
                }
                ArrayList<Object> materials = (ArrayList<Object>) manufacturing.get("materials");
                ArrayList<Object> products = (ArrayList<Object>) manufacturing.get("products");
                if(materials == null || products == null) continue;

                Blueprint blueprint = new Blueprint();
                blueprint.setBlueprintID((Integer) s);

                for(Object product:products){
                    blueprint.setProductID((int) ((Map<String, Object>)product).get("typeID"));
                    blueprint.setProductQuantity((int) ((Map<String, Object>)product).get("quantity"));
                }
                for(Object material:materials){
                    blueprint.setMaterialID((int) ((Map<String, Object>)material).get("typeID"));
                    blueprint.setMaterialQuantity((int) ((Map<String, Object>)material).get("quantity"));
                    blueprintMapper.insertBlueprint(blueprint);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
