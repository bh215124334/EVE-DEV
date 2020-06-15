package com.bai.lpstore.init.impl;

import com.bai.lpstore.mapper.NameMapper;
import com.bai.lpstore.pojo.Name;
import com.bai.lpstore.init.NameInYaml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * <h3>EVE-DEV</h3>
 * <p>名字初始化</p>
 *
 * @author : 白恒
 * @date : 2020-06-12 10:55
 **/
@Service
public class NameInYamlImpl implements NameInYaml {

    @Autowired
    private NameMapper nameMapper;

    @Override
    public void nameInit() {

        Yaml yam = new Yaml();
        try {
            Map<String, Object> map = yam.load(new FileInputStream("D:\\git\\github\\EVE-DEV\\Lp-Store\\src\\main\\resources\\static\\typeIDs.yaml"));

            System.out.println("size:" + map.size());

            for(Object s : map.keySet()){
                Map<String, Object> item = (Map<String, Object>) map.get(s);
                Map<String, Object> transName = (Map<String, Object>) item.get("name");

                Name name = new Name();
                name.setID((Integer) s);
                name.setName((String) transName.get("zh"));
                name.setVolume(item.containsKey("volume")? Double.parseDouble(item.get("volume").toString()) : 0);

                System.out.println(name);
                nameMapper.insertName(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
