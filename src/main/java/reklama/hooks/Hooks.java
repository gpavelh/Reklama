package reklama.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import reklama.configReader.PropertiesReader;
import reklama.pages.BasePage;

import static reklama.configReader.ChromeConfig.getChromeDriver;

public class Hooks {

    private PropertiesReader confReader = new PropertiesReader();

    @Before
    public void test() {
        BasePage.driver = getChromeDriver();
        BasePage.driver.get(confReader.getValue("url"));
    }

    @After
    public void closeDriver(){
        BasePage.driver.close();
    }
}
