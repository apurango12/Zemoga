package PageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CarnivalPageObjects extends PageObject {
    /*
    User Story 01
    */
    @FindBy(xpath = "//button[@class='cgh-advisory__actions--close']")
    public WebElementFacade closeModal;

    @FindBy(xpath = "//button[@id='cookie-consent-btn']")
    public WebElementFacade closeCookies;

    @FindBy(xpath = "//a[@id='cdc-destinations']")
    public WebElementFacade sailTo;

    @FindBy(xpath = "//a[@id='cdc-durations']")
    public WebElementFacade durationOptions;

    @FindBy(xpath = "//li[@class='cdc-filters-tab cdc-filters-tab--searchcta ng-scope']")
    public WebElementFacade searchCruises;

    @FindBy(xpath = "//*[@class='ccs-search-results ng-scope ng-isolate-scope']")
    public WebElementFacade containerResults;

    @FindBy(xpath = "//span[text()='Pricing']")
    public WebElementFacade pricing;

    @FindBy(xpath = "//span[@class='rz-pointer rz-pointer-min']")
    public WebElementFacade slideBar;

    @FindBy(xpath = "//span[text()='Price Range Avg Per Person']")
    public WebElementFacade span;

    @FindBy(xpath = "//span[contains(@class, 'price-value ng-binding')]")
    public List<WebElementFacade> listPrices;



    /*
    User Story 02
    */
    @FindBy(xpath = "//a[contains(@class, 'learn-more')]")
    public List<WebElementFacade> learnMore;

    @FindBy(xpath = "//p[@class='day']//following::span[text()='Learn More ']")
    public List<WebElementFacade> learnMoreForEachDay;

    @FindBy(xpath = "//div[@class='itinerary-details ng-scope']//ul[@class='slick-dots']//li")
    public List<WebElementFacade> presentationSlides;

    @FindBy(xpath = "//button[@aria-label='Next']")
    public WebElementFacade buttonNext;

    @FindBy(xpath = "//button[@class='overlay-close-wrapper close-overlay-white']")
    public WebElementFacade closeLearnMore;

    @FindBy(xpath = "//span[text()='Book Now']")
    public WebElementFacade bookNow;
}
