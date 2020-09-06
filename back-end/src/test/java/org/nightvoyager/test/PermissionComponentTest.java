package org.nightvoyager.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PermissionComponentTest {
    private static final String[][] permission2D = new String[][]{
            new String[]{"A","B"},
            new String[]{"C","D","A"}
    };


    @Autowired
    private Logger logger;

    @Test
    public void cacheTest(){
        logger.info(permission2D.hashCode() + "");
    }
}
