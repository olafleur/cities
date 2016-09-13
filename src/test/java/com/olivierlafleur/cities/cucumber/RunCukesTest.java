package com.olivierlafleur.cities.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class RunCukesTest {
    @BeforeClass
    public static void createAndStartService() {
        System.setProperty("webdriver.chrome.driver", "C:\\path\\chromedriver.exe");
    }
}
