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

    @And("check that favorite count equals {int} on icon {string}")
    public void checkFavoriteCount(int count, String elemName) {
        subSteps.checkFavoriteCountOnIcon(elemName, count);
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

    @When("save all field value {string} to stash with key {string}")
    public void saveAllValuesToStash(String elemName, String stashKey) {
        subSteps.saveAllValueToStash(elemName, stashKey);
    }

    @When("add all ad to favorite")
    public void addAllAdToFavorites() {
        subSteps.hoverAndClickToAllElements("Ad cost");
    }

    @When("equals favorite ads and stash value {string}")
    public void equalsValueAndStash(String stashKey) {
        subSteps.checkAdsCostAndStashValue(Stash.getValue(stashKey));
    }

    @When("equals all favorite ads and stash value {string}")
    public void equalsAllValueAndStash(String stashKey) {
        subSteps.checkAllAdsCostAndStashValue(Stash.getValue(stashKey));
    }

    @When("quick/advanced search ad {string}")
    public void quickSearchAd(String adName) {
        subSteps.search(adName);
    }

}
