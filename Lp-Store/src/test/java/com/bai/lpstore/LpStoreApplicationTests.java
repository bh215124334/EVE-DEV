package com.bai.lpstore;

import com.bai.lpstore.mapper.NameMapper;
import com.bai.lpstore.esi.impl.EsiReaderImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LpStoreApplicationTests {

    @Autowired
    private EsiReaderImpl esiReader;

    @Autowired
    private NameMapper nameMapper;

    @Test
    void contextLoads() {
        System.out.println(esiReader.getChineseName(18));

    }

}
