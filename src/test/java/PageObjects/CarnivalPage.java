package PageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import Utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class CarnivalPage extends PageObject {

    Utils utils;
    CarnivalPageObjects carnivalPageObjects;
    Logger logger = Logger.getLogger(CarnivalPage.class.getName());

    /*
    User Story 01
     */
    public void openBrowser(){
        getDriver().get("https://www.carnival.com/");
        getDriver().manage().deleteAllCookies();
    }

    public void closeModalAndCookies() {
        utils.moveToElement(carnivalPageObjects.closeModal);
        carnivalPageObjects.closeCookies.click();
    }

    public void searchCruise(String destination, String startDate, String endDate) {
        carnivalPageObjects.sailTo.click();
        WebElementFacade destinationPlace = $("//button[@class='cdc-filter-button ng-binding'][contains(text(),'" + destination + "')]");
        destinationPlace.click();
        carnivalPageObjects.durationOptions.click();
        WebElementFacade durationDays = $("//button[@class='cdc-filter-button ng-binding'][contains(text(),'" + startDate + " - " + endDate + " Days')]");
        durationDays.click();
        carnivalPageObjects.searchCruises.click();
    }

    public void checkResultsGrid() {
        if (carnivalPageObjects.containerResults.isPresent()) {
            logger.info("There is at least 1 result in the grid");
        } else {
            Assert.fail("There is not results in the grid or the container is not Present");
        }
    }

    public void filteringByPriceAndCheckingDefaultPriceIsTheCheapest() {
        waitFor(carnivalPageObjects.pricing).waitUntilClickable().and().click();
        utils.moveToElement(carnivalPageObjects.span);
        if (!carnivalPageObjects.slideBar.getAttribute("aria-valuenow").equals("400")) {
            Assert.fail("The default Price is not the cheapest");
        } else {
            logger.info("The default Price is the cheapest");
        }
        utils.moveSliderBar(carnivalPageObjects.slideBar);
    }

    public void checkingIfThePrincesAreBetweenTheRanges(int minRange, int maxRange) {
        for (WebElementFacade listPrice : carnivalPageObjects.listPrices) {
            if (Integer.parseInt(listPrice.getText()) < minRange || Integer.parseInt(listPrice.getText()) > maxRange) {
                Assert.fail("There are prices out of the ranges.");
            }
        }
    }

    /*
    User Story 02
     */
    public void choseSail(){
        carnivalPageObjects.learnMore.get(0).click();
    }

    public void learnMoreAboutEachTripDay(){
        Random random = new Random();
        int dayNumber = random.nextInt(7);
        carnivalPageObjects.learnMoreForEachDay.get(dayNumber).click();
        for(int i=0; i < carnivalPageObjects.presentationSlides.size()-1; i++){
            carnivalPageObjects.buttonNext.click();
        }
        utils.moveToElement(carnivalPageObjects.closeLearnMore);
    }

    public void checkBookNow(String buttonText){
        if (carnivalPageObjects.bookNow.getText().equals(buttonText)){
            logger.info("Great, the BOOK NOW button is present");
        } else {
            Assert.fail("The BOOK NOW button is not present");
        }
    }
}
