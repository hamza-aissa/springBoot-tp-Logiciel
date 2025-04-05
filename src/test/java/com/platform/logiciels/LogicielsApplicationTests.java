package com.platform.logiciels;

import com.platform.logiciels.entities.Logiciel;
import com.platform.logiciels.repos.LogicielRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class LogicielsApplicationTests {
    @Autowired
    private LogicielRepository logicielRepository;
    @Test
    void contextLoads() {
    }
    @Test
    void testCreateLogiciel() {
        Logiciel TestLogiciel = new Logiciel("AccountingSoftware", "2024.1", 2.20f, new Date(System.currentTimeMillis()), "hamza");
        logicielRepository.save(TestLogiciel);
    }
    @Test
    public void testFindProduit()
    {
        Logiciel l = logicielRepository.findById(1L).get();
        System.out.println(l);
    }
    @Test
    public void testUpdateProduit()
    {
        Logiciel l = logicielRepository.findById(1L).get();
        l.setVersionLogiciel("2024.8");
        logicielRepository.save(l);
    }
    @Test
    public void testDeleteProduit()
    {
        logicielRepository.deleteById(1L);;

    }


    @Test
    public void testListerTousProduits()
    {
        List<Logiciel> logiciels = logicielRepository.findAll();
        for (Logiciel l : logiciels)
        {
            System.out.println(l);
        }
    }
}
