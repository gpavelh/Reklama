package reklama.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reklama.annotations.ElementTitle;

import java.util.Arrays;


public abstract class BasePage {

    public static WebDriver driver;
    public static BasePage currentPage;

    public abstract void isLoaded();


    public static WebElement getFieldByAnnotation(Class<? extends BasePage> page, String fieldName) {
        String field = Arrays.stream(page.getFields())
                .filter(f->f.isAnnotationPresent(ElementTitle.class))
                .filter(f->f.getAnnotation(ElementTitle.class).value().equals(fieldName)).findFirst().orElseThrow(() -> new RuntimeException(String.format("Error while searching field '%s' and annotation ElementTitle",fieldName))).getName();

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
    }}
