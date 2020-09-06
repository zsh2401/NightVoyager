package org.nightvoyager.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nightvoyager.app.App;
import org.nightvoyager.app.entities.PersonInfo;
import org.nightvoyager.app.services.db.IPersonRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class PersonRepoTest {

    @Autowired
    private Logger logger;

    @Autowired
    private IPersonRepository personRepo;

    @Before
    public void initialize(){
        logger.info("initializing");
    }

    @After
    public void cleanup(){
        logger.info("clean up");
    }

    @Test
    public void personGet(){
        personRepo.save(new PersonInfo());
        personRepo.flush();
    }
}
