package com.github.vbauer.herald.ext.spring.bean;

import com.github.vbauer.herald.annotation.Log;
import org.junit.Assert;
import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Vladislav Bauer
 */

@Component
public class RunnerBean implements CommandLineRunner, ApplicationRunner {

    @Log
    private Logger logger;


    @Override
    public void run(final String... args) throws Exception {
        checkIt();
    }

    @Override
    public void run(final ApplicationArguments applicationArguments) throws Exception {
        checkIt();
    }


    private void checkIt() {
        Assert.assertNotNull(logger);
    }

}
