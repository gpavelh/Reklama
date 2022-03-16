package reklama.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reklama.configReader.PropertiesReader;
import reklama.pages.BasePage;

import static reklama.configReader.ChromeConfig.getChromeDriver;

public class Hooks {
    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);
    private PropertiesReader confReader = new PropertiesReader();

    @Before
    public void test() {
        LOG.info("<----------TEST START---------->");
        BasePage.driver = getChromeDriver();
        BasePage.driver.get(confReader.getValue("url"));
    }

    @After
    public void closeDriver(){
        BasePage.driver.close();
    }
}
