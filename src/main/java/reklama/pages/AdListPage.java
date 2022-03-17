package reklama.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reklama.annotations.ElementTitle;
import reklama.annotations.PageName;

import static reklama.testData.TestData.getDriver;

@PageName("AdList Page")
public class AdListPage extends BasePage {

    public AdListPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @ElementTitle("Ad List")
    @FindBy(id = "posts")
    public WebElement adListTable;

    @ElementTitle("Favorite")
    @FindBy(id = "favorites-link")
    public WebElement favoriteButton;

    @Override
    public void isLoaded() {
        if (!adListTable.isDisplayed()) {
            Assertions.fail("Page not loaded");
        }
    }
}
