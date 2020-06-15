package com.bai.lpstore.controller;

import com.bai.lpstore.esi.EsiReader;
import com.bai.lpstore.init.LpItemInEsi;
import com.bai.lpstore.pojo.entity.Blueprint;
import com.bai.lpstore.init.BlueprintInYaml;
import com.bai.lpstore.init.CorporationInYaml;
import com.bai.lpstore.init.NameInYaml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3>EVE-DEV</h3>
 * <p>ESI</p>
 *
 * @author : 白恒
 * @date : 2020-06-12 09:20
 **/

@RestController
public class DbInitController {

    @Autowired
    private EsiReader esiReader;

    @Autowired
    private CorporationInYaml corporationInYaml;

    @Autowired
    private BlueprintInYaml blueprintInYaml;

    @Autowired
    private NameInYaml nameInYaml;

    @Autowired
    private LpItemInEsi lpItemInEsi;

    @GetMapping("/test")
    public Blueprint test(){
        Blueprint blueprint = new Blueprint();
        blueprint.setMaterialID(1);
        return blueprint;
    }

    @GetMapping("/init/lpstore")
    public String initLpStore(){
        return "已经初始化";
//        lpItemInEsi.LpItemInit();
//        System.out.println("完成");
//        return "初始化完成";
    }

    @GetMapping("/init/blueprint")
    public String initBlueprint(){
        return "已经初始化";
//        blueprintInYaml.blueprintInit();
//        System.out.println("完成");
//        return "初始化完成";
    }

    @GetMapping("/init/name")
    public String initName(){
        return "已经初始化";
//        nameInYaml.nameInit();
//        System.out.println("完成");
//        return "初始化完成";
    }

    @GetMapping("/init/corporation")
    public String initCorp(){
        return "已经初始化";
//        corporationInYaml.corporationInit();
//        System.out.println("完成");
//        return "初始化完成";
    }



}
