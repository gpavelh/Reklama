package reklama.pages;

import org.openqa.selenium.support.PageFactory;
import reklama.annotations.PageName;

@PageName("Car Page")
public class CarsPage {

    public CarsPage() {
        PageFactory.initElements(BasePage.driver,this);
    }

}
