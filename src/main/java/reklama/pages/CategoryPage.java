package reklama.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reklama.annotations.PageName;

import static reklama.testData.TestData.getDriver;

@PageName("Category Page")
public class CategoryPage extends BasePage {

    public CategoryPage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "categories")
    public WebElement categoryTable;

    public static WebElement getTableElement(String elemName) {
        return getDriver().findElement(By.xpath("//form[@id ='categories']//a[contains(text(),'" + elemName + "')]"));
    }

    @Override
    public void isLoaded() {
        if (!categoryTable.isDisplayed()) {
            Assertions.fail("Page not loaded");
        }
    }
}
