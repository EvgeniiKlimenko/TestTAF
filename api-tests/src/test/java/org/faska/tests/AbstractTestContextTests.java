package org.faska.tests;

import lombok.Setter;
import org.faska.configuration.TestContextConfiguration;
import org.faska.domain.CatFactsService;
import org.faska.domain.CoinDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Basic class for all further test classes.
 *
 */
@Setter
@SpringBootTest
@ContextConfiguration(classes = {TestContextConfiguration.class})
public abstract class AbstractTestContextTests extends AbstractTestNGSpringContextTests {

    @Value( "${test.user.name}" )
    private String userName;

    @Value( "${test.user.password}" )
    private String userPassword;


    @Autowired
    protected CatFactsService catFactsService;

    @Autowired
    protected CoinDeskService coinDeskService;
}
