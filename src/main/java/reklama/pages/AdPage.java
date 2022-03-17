package reklama.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reklama.annotations.ElementTitle;
import reklama.annotations.PageName;

import static reklama.testData.TestData.getDriver;

@PageName("Ad Page")
public class AdPage extends BasePage {

    public AdPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "content")
    public WebElement pageContent;

    @ElementTitle("Add to favorite")
    @FindBy(xpath = "//a[.='Добавить в избранное']")
    public WebElement addToFavoriteButton;

    @ElementTitle("Lot price")
    @FindBy(id = "price-full")
    public WebElement price;

    @ElementTitle("Favorite")
    @FindBy(id = "favorites-link")
    public WebElement favoriteButton;

    @ElementTitle("Favorites count")
    @FindBy(id = "favorites_count")
    public WebElement favoriteCount;

    @Override
    public void isLoaded() {
        if (!pageContent.isDisplayed()){
            Assertions.fail("Page not loaded");
        }
    }
}
