# Zemoga Test Automation - Arcadio De Jesus Buelvas Hernandez

This repo uses:

Selenium
Cucumber
Gherkin
SerenityBDD
Java 8
chromedriver
Junit
Gradle

Environment Setup
1 --> Install Java 8 --> https://www.java.com/es/download/help/windows_manual_download.html#download
2 --> Install Gradle --> https://gradle.org/install/
3 --> Install a IDE, IntelliJ can be fine (Optional)

Install Dependencies
USING IDE.
Open the project and Run the "build.gradle" file.

Run Test
USING CMD.
To run all tests --> gradle clean test aggregate (this command also creates an HTML with the report execution)

USING IDE.
To run a single test --> Go to Runners folder open the Java class called "Runner" and change the @Tags. (For example, for this tests, there are 2 Tags options @UserStory001 and UserStory002)

@CucumberOptions(features = {"src/test/resources/features/"},
        tags = "@CarnivalTests",
        glue = "StepsDefinitions",
        snippets = SnippetType.CAMELCASE )
About the Framework and Desing Pattern.
The Framework is built to use BDD (Behavior Driven Development) under the POM (Page Object Model) design pattern.

All the logic of the tests can be found in --> src/test/ java/PageObjects/CarnivalPage

All the mapping of the elements can be found in --> src/tes/java/PageObjects/CarnivalPage

The Runner for the tests can be found at --> src/test/Runners/Runner

The definition of the test steps (Orchestrator) can be found in --> src/test/StepDefinitions

Some utilities can be found in --> src/test/Utils/Utils

The behavior of the test is written in Gherkin with the main idea that a person without programming knowledge can understand what the test is doing. Cucumber Scenarios was also used for this. You can find the test's .feature here src/test/resources/carnival.feature.

An HTML report is created automatically for each execution of the tests using this command -> gradle clean test aggregate.

You can find the report at target/site/serenity/index.html
