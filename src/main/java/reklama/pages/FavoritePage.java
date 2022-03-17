package reklama.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reklama.annotations.PageName;

import java.util.List;

import static reklama.testData.TestData.getDriver;

@PageName("Favorite Page")
public class FavoritePage extends BasePage{

    public FavoritePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id ="details_view")
    public WebElement pageTable;

    public static List<WebElement> getFavoriteAdsCosts() {
        return getDriver().findElements(By.xpath("//div[@class='table_ver1']//span[@class='normal-price']"));
    }

    @Override
    public void isLoaded() {
        if (!pageTable.isDisplayed()) {
            Assertions.fail("Page not loaded");
        }
    }
}
