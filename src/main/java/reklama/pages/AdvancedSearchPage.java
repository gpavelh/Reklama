package reklama.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reklama.annotations.ElementTitle;
import reklama.annotations.PageName;

import static reklama.testData.TestData.getDriver;

@PageName("Advanced Search Page")
public class AdvancedSearchPage extends BasePage {

    public AdvancedSearchPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(name = "searchform")
    public WebElement searchForm;

    @ElementTitle("Search field")
    @FindBy(xpath = "//input[contains(@name,'s_andlike')]")
    public WebElement searchField;

    @ElementTitle("Search button")
    @FindBy(xpath = "//td[@class='button']//input[@value='Искать!']")
    public WebElement searchButton;

    @Override
    public void isLoaded() {
        if (!searchForm.isDisplayed()) {
            Assertions.fail("Page not loaded");
        }
    }

}
