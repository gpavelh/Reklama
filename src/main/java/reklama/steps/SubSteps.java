package reklama.steps;

import org.openqa.selenium.By;
import org.reflections.Reflections;
import reklama.annotations.PageName;
import reklama.pages.BasePage;

import java.util.Set;

public class SubSteps {

    public void click(String elem) {
        BasePage.getFieldByAnnotation(BasePage.currentPage.getClass(), elem).click();
    }

    public void clickToTableElement(String elemName) {
        BasePage.driver.findElement(By.xpath("//form[@id ='categories']//a[contains(text(),'" + elemName + "')]")).click();
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
