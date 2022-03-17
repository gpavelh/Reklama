package reklama.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import reklama.annotations.ElementTitle;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.SECONDS;
import static reklama.testData.TestData.getDriver;


public abstract class BasePage {

    public static BasePage currentPage;
    public static FluentWait<WebDriver> wait;

    public abstract void isLoaded();

    public BasePage() {
        wait = new FluentWait<>(getDriver())
                .pollingEvery(Duration.of(3, SECONDS))
                .withTimeout(Duration.of(60, SECONDS));
    }


    public static <T> WebElement getFieldByAnnotation(Class<? extends BasePage> page, String fieldName) {
        String field = Arrays.stream(page.getFields())
                .filter(f -> f.isAnnotationPresent(ElementTitle.class))
                .filter(f -> f.getAnnotation(ElementTitle.class).value().equals(fieldName)).findFirst().orElseThrow(() -> new RuntimeException(String.format("Error while searching field '%s' and annotation ElementTitle", fieldName))).getName();

        Object obj = null;
        try {
            obj = getField(field);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (obj instanceof WebElement) {
            return (WebElement) obj;
        } else {
            throw new RuntimeException("Object in not a WebElement");
        }
    }

    public static Object getField(String fieldName) {
        try {
            Object field = currentPage.getClass().getDeclaredField(fieldName).get(currentPage);
            return field;
        } catch (NullPointerException | NoSuchFieldException | IllegalAccessException npe) {
            throw new RuntimeException("field not found");
        }
    }
}
