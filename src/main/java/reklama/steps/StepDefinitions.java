package reklama.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import reklama.utils.Stash;

public class StepDefinitions {

    SubSteps subSteps = new SubSteps();

    @When("page {string} open")
    public void mainPageOpened(String pageName) {
        subSteps.pageIsLoaded(pageName);
    }

    @And("click to category {string}")
    public void clickToCategory(String elemName) {
        subSteps.clickToCategory(elemName);
    }

    @And("click to element/button {string}")
    public void clickToElement(String elemName) {
        subSteps.clickToElement(elemName);
    }

    @And("hover and click to element/category/button {string}")
    public void hoverAndClickToElement(String elemName) {
        subSteps.hoverAndClickToElem(elemName);
    }

    @And("choose brand/type/breed/model {string}")
    public void chooseTableElementMenu(String elemName) {
        subSteps.clickToTableElement(elemName);
    }

    @When("select ad number {int}")
    public void selectAd(int adNumber) {
        subSteps.openAd(adNumber);
    }

    @When("save field value {string} to stash with key {string}")
    public void saveValueToStash(String elemName, String stashKey) {
        subSteps.saveElemValueToStash(elemName, stashKey);
    }

    @When("equals favorite ads and stash value {string}")
    public void equalsValueAndStash(String stashKey) {
        subSteps.checkAdsCostAndStashValue(Stash.getValue(stashKey));
    }
}
