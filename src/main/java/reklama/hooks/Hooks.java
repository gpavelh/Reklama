package reklama.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reklama.configReader.PropertiesReader;

import static reklama.configReader.ChromeConfig.getChromeDriver;
import static reklama.testData.TestData.getDriver;
import static reklama.testData.TestData.setDriver;
import static reklama.utils.Stash.clearStash;

public class Hooks {
    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);
    private PropertiesReader confReader = new PropertiesReader();

    @Before
    public void test() {
        LOG.info("<----------TEST START---------->");
        setDriver(getChromeDriver());
        getDriver().get(confReader.getValue("url"));
    }

    @After
    public void closeDriver() {
        getDriver().close();
        clearStash();
        LOG.info("<----------TEST END---------->");
    }
}
