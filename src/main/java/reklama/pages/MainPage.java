package reklama.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reklama.annotations.ElementTitle;
import reklama.annotations.PageName;

import static reklama.testData.TestData.getDriver;

@PageName("Main Page")
public class MainPage extends BasePage {

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @ElementTitle("Search field")
    @FindBy(id = "search_value")
    public WebElement searchField;

    @ElementTitle("Мои объявления")
    @FindBy(id = "maniSluds")
    public WebElement myAds;

    @FindBy(xpath = "//div[@class='place_ru']//a[@title='Подать объявление']")
    public WebElement submitAd;

    public static WebElement getCategory(String categoryName) {
        return getDriver().findElement(By.xpath("//h3[contains(text(),'" + categoryName + "')]"));
    }


    @Override
    public void isLoaded() {
        if (!searchField.isDisplayed()) {
            Assertions.fail("Page not loaded");
        }
    }
}
