package reklama.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class StepDefinitions {

    SubSteps subSteps = new SubSteps();

    @When("page {string} open")
    public void mainPageOpened(String pageName) {
        subSteps.pageIsLoaded(pageName);
    }

    @And("click to element/category {string}")
    public void clickToElement(String elemName) {
        subSteps.click(elemName);
    }

    @And("choose brand/type/breed/model {string}")
    public void chooseTableElementMenu(String elemName) {
        subSteps.clickToTableElement(elemName);
    }
}
