package reklama.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reklama.annotations.ElementTitle;
import reklama.annotations.PageName;

@PageName("Main Page")
public class MainPage extends BasePage {

    public MainPage() {
        PageFactory.initElements(BasePage.driver,this);
    }
    @ElementTitle("Search field")
    @FindBy(id = "search_value")
    public WebElement searchField;

    @ElementTitle("Мои объявления")
    @FindBy(id = "maniSluds")
    public WebElement myAds;

    @FindBy(xpath = "//div[@class='place_ru']//a[@title='Подать объявление']")
    public WebElement submitAd;

    @ElementTitle("Легковые авто")
    @FindBy(xpath = "//h3[contains(text(),'Легковые авто')]")
    public WebElement cars;


    @Override
    public void isLoaded() {
        if (!searchField.isDisplayed()) {
            Assertions.fail("");
        }
    }
}
