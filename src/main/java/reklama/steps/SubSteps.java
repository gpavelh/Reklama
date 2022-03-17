package reklama.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.reflections.Reflections;
import reklama.annotations.PageName;
import reklama.pages.BasePage;
import reklama.utils.Stash;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static reklama.pages.BasePage.getFieldByAnnotation;
import static reklama.pages.CategoryPage.getTableElement;
import static reklama.pages.FavoritePage.getFavoriteAdsCosts;
import static reklama.pages.MainPage.getCategory;
import static reklama.testData.TestData.getDriver;

public class SubSteps {

    /**
     * click to element
     *
     * @param elementName
     */
    public void clickToElement(String elementName) {
        getFieldByAnnotation(BasePage.currentPage.getClass(), elementName).click();
    }

    /**
     * click to category on Main Page
     *
     * @param elementName
     */
    public void clickToCategory(String elementName) {
        getCategory(elementName).click();
    }

    public void hoverAndClickToElem(String elementName) {
        WebElement elem = getFieldByAnnotation(BasePage.currentPage.getClass(), elementName);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(elem).build().perform();
        elem.click();
    }

    public void clickToTableElement(String elemName) {
        getTableElement(elemName).click();
    }

    public void openAd(int adNumber) {
        getFieldByAnnotation(BasePage.currentPage.getClass(), "Ad List")
                .findElements(By.xpath(".//tbody//tr"))
                .get(adNumber - 1)
                .click();
    }

    public void saveElemValueToStash(String elemName, String stashKey) {
        String value = getFieldByAnnotation(BasePage.currentPage.getClass(), elemName).getText();
        Stash.put(stashKey, value);
    }

    public void checkAdsCostAndStashValue(String stashValue) {
        List<WebElement> resultList = getFavoriteAdsCosts().stream()
                .filter(f -> f.getText().equals(stashValue))
                .collect(Collectors.toList());
        Assertions.assertTrue(resultList.size() >= 1, "Values is not present!");
    }

    /**
     * init page
     *
     * @param pageName
     */
    public void pageIsLoaded(String pageName) {
        Reflections reflections = new Reflections("reklama.pages");

        Set<Class<? extends BasePage>> allPages = reflections.getSubTypesOf(BasePage.class);

        for (Class<? extends BasePage> currentPage : allPages
        ) {
            if (currentPage.getAnnotation(PageName.class).value().equals(pageName)) {
                try {
                    BasePage page = currentPage.getConstructor().newInstance();
                    page.isLoaded();
                    page.currentPage = page;
                } catch (Exception e) {
                    throw new RuntimeException("Page not loaded");
                }
            }
        }
    }

}
