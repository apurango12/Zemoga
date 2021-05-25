package StepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import PageObjects.CarnivalPage;

public class CarnivalDefinitions {

    @Steps
    CarnivalPage carnivalTests;

    @Given("^the user goes to the carnival page$")
    public void theUserGoesToTheCarnivalPage(){
        carnivalTests.openBrowser();
        carnivalTests.closeModalAndCookies();
    }

    @When("^the user selects a cruise to (.*) with duration between (.*) and (.*) days$")
    public void theUserSelectsACruiseToTheBahamasWithDurationBetweenAndDays(String destination, String startDate, String endDate){
        carnivalTests.searchCruise(destination, startDate, endDate);
    }

    @Then("^the user should see all the options to choose one$")
    public void theUserShouldSeeAllTheOptionsToChooseOne(){
        carnivalTests.checkResultsGrid();
    }

    @When("^the user filters by price$")
    public void theUserFiltersByPrice() {
        carnivalTests.filteringByPriceAndCheckingDefaultPriceIsTheCheapest();
    }

    @Then("^the user should see only cruises with prices between the selected ranges (.*) - (.*)$")
    public void theUserShouldSeeOnlyCruisesWithPricesBetweenTheSelectedRanges(int minRange, int maxRange) {
        carnivalTests.checkingIfThePrincesAreBetweenTheRanges(minRange, maxRange);
    }

    @Given("^the user chose a sail and wants to learn more about the trip$")
    public void theUserChoseASailAndWantsToLearnMoreAboutTheTrip() {
        carnivalTests.choseSail();
    }

    @When("^the user can click on Learn More for each trip day$")
    public void theUserCanClickOnLearnMoreForEachTripDay() {
        carnivalTests.learnMoreAboutEachTripDay();
    }

    @Then("^the user should see the (.*) button present$")
    public void theUserShouldSeeTheBOOKNOWButtonPresent(String buttonText) {
        carnivalTests.checkBookNow(buttonText);
    }
}
