# language: en
# Author: Andres Perez Urango
@CarnivalTests
Feature: Carnival Tests - Zemoga Test Automation

  US1 --> As a user I want to search cruises to The Bahamas with duration between 6 and 9 days
  so that I will visualize all the options to choose one. Right now, I don’t care about departure port.

  US2 --> As a user I want to choose one sail and learn more about the trip,
  so that I will get more info about itinerary.

  @UserStory001
  Scenario: The user search for a Cruise
    Given the user goes to the carnival page
    When the user selects a cruise to The Bahamas with duration between 6 and 9 days
    Then the user should see all the options to choose one
    When the user filters by price
    Then the user should see only cruises with prices between the selected ranges 640 - 11000

  @UserStory002
  Scenario: Booking Page
    #Precondition
    Given the user goes to the carnival page
    When the user selects a cruise to The Bahamas with duration between 6 and 9 days
    Then the user should see all the options to choose one
    #Precondition's end
    Given the user chose a sail and wants to learn more about the trip
    When the user can click on Learn More for each trip day
    Then the user should see the BOOK NOW button present


