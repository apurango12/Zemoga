package Utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;


public class Utils extends PageObject {

    public void moveToElement(WebElementFacade webElementFacade){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElementFacade).click().perform();
    }

    public void moveSliderBar(WebElementFacade webElementFacade){
        Actions move = new Actions(getDriver());
        move.moveToElement(webElementFacade).clickAndHold().moveByOffset(270,0).release().perform();
    }

}
