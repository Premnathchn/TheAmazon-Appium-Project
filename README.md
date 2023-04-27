
# Appium Automation Framework

Begin with installing the dependencies below, and continue with the Getting Started page.

### Dependencies
There are several prerequisite dependencies you should install on your machine prior to starting to work with this framework:


* [Java JDK](https://www.oracle.com/be/java/technologies/javase/jdk11-archive-downloads.html)

* Appium installed and the server is running

* Install [Android Studio](https://developer.android.com/studio) and Additional Android SDK tools

* An IDE to write your tests on - [Eclipse](https://www.eclipse.org/downloads/packages/release/2023-03/r/eclipse-ide-java-developersr) or [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)

* [Maven](https://maven.apache.org/) (Optional - Needed only for command line executions as IDEs have Maven in-built.)


Eclipse users should also install:

1. Eclipse has in-built Maven plugin 
    - Optional - [Maven Plugin](http://marketplace.eclipse.org/content/m2e-connector-maven-dependency-plugin)

3. Any Cucumber Plugin
	- For Eclipse users- Cucumber eclipse plugin from Help-> Marketplace

#### Optional Installations
* For source control management, you can install [git](https://git-scm.com/downloads).


## Downloading the framework:

Download or clone the Project [repository](https://github.com/Premnathchn/TheAmazon-Appium-Project.git).

After downloading and unzipping the project to your computer, open it from your IDE by choosing the folder containing the pom.xml file.

Project directory structure is documented in the end of this page.

**********************
# Getting Started

This procedure leads you through the various framework aspects:

* Framework features
* Execution of the Scenario file
* Test writing guidelines
* Object Repository creation guidelines
* Viewing test execution results

##  Framework features:

	- Used Appium with java to implement the test cases
	
	- Used Page Object Model(POM), to store and handle the element locators
	
	- Constructed the testcase using BDD and Gherkin statements
	
	- Scenario outline has been used to improve the re-usability of the Gherkin statements
	
	- All the reusuable methods are available under _src/main/java/helper/*.java
	
	- All the action classes are available under _src/main/java/actions/*.java. Eg: click(), SendKeys(), getText() etc.,
	
	- Customised Exception is used to reflect the error messages in the reports in a better way
	
	- Test-data hasn't been hard-coded. Its stored in a properties file for better maintainability. under _src/test/resources/data/*.properties files
	
	- Handled the foreseen exceptions using try/catch block
	
	- Provide the logs in the step implementation methods whenever required. Eg: log.info()
	
	- Extent-Reports of previous executions are available with time-stamp under top _emailable-reports folder
	
	

##  Execution of the Scenario file:

The scenario is located under the _src/test/resources/features folder.
	
	- Update the feature file path in TestRunner file.
		- @CucumberOptions(features = "<Path to feature file To be updated>"
		- Eg: @CucumberOptions(features = "D:\\Appium-Automation-Framework\\src\\test\\resources\\features",
		
	- We can Run in command line using Maven using the below commands.
		- mvn test -Dcucumber.options="--tags @CartNavigation"
		- We can also pass parameters during run time, using the below command.
			- mvn test -Dbrowser="chrome" -Durl="https://www.amazon.com" -Dcucumber.options="--tags @CartNavigation"


##  Test writing guidelines:

	- Begin with @featuretagname, Feature: name of feature, @scenariotagname (can be the same as the feature's tag).
	
	- Write your scenario using [Given/When/Then/And](https://github.com/cucumber/cucumber/wiki/Given-When-Then) BDD statements.
	
	- Write your first scenario for the app's initial starting point, and later create scenarios for other cases; name them differently to enable easy identification in execution report, and name their tags differently if you want to run them separately.
	
	- Add steps for taking screenshots to allow close examination of test results later on.
	
	- Add steps for waiting a few seconds upon app's page loading.



## Object Repository creation guidelines:

Store you page objects under _src/test/resources/object-repository

Follow below guidelines in naming the page object names.

	- Locator Key definition
		- ApplicationName.PageName.ElementName.LocatorStrategy
	
	- LocatorStrategy definition
		- For By.Id --> .ID
		- For By.AccessibilityID --> .AID
		- For By.xpath --> .XPATH
		- For By.className --> .CLASS


## Viewing test execution results:

All the previous executions are recorded with time-stamp, and stored under the top _emailable-reports folder.

	- Open the .html file under the run-folder with preferred browser to view the extent-results.
	- Screenshots are attached to be each steps of the test-cases.
	- In  case of failures, both logs and screenshots are attached to the report.


**********************

## Project Directory Structure
```
.
│   pom.xml                                                     # Maven pom file for build and dependencies  
│   README.md                                                   # The current readme file  
│
│   emailable-results                                           # Reports for all the previous executions
│  
├───Resources                                                   # Default Resources dir       
│  
└───src	
    └───main
    │     └───java
    │     │    └───actions                                      # This method contains all the common action methods. Eg: click(), get(), sendKeys() etc.,
    │     │    │       Click.java                            
    │     │    │       Get.java                            
    │     │    │       Keyboard.java                       
    │     │    │       Screenshot.java                      
    │     │    │       Swipe.java                               
    │     │    │       Type.java                                
    │     │    │       Verify.java                              
    │     │    │        
    │     │    └───base                                         # This folder contains the common methods for RunID and post test actions
    │     │    │       Keywords.java                            
    │     │    │       RunManager.java                          
    │     │    │       Test.java                                
    │     │    │              
    │     │    └───constants                                    # This folder contains the common constant keywords for the framework
    │     │    │       Device.java                              
    │     │    │       Keys.java                                
    │     │    │       OS.java                                  
    │     │    │       
    │     │    └───driver                                       # This folder contains the driver capalities settings classes
    │     │    │       AndroidManager.java                      
    │     │    │       DriverManager.java                       
    │     │    │       DriverManagerFactory.java                
    │     │    │       DriverType.java                          
    │     │    │       IOSManager.java                          
    │     │    │       
    │     │    └───exceptions                                   # Custom exception classes
    │     │    │       ApplicationException.java                
    │     │    │       EnvironmentException.java                
    │     │    │       
    │     │    └───helper                                       # Contains all the helper methods for the framework
    │     │            Device.java                              
    │     │            PropertyReader.java                      
    │     │            Tools.java                               
    │     │       
    │     └───resources       
    │          └───log4j.properties                              
    │            
    └───test
        └───java
        │    └───pages                                           # Contains all the test page classes
        │    │      AmazonHomePage.java                          
        │    │      AmazonSearchResultsPage.java                  
        │    │      CartPage.java                     
        │    │      ProductDetailsPage.java  
        │    │ 
        │    └───runners
        │    │      TestRunner.java                              # TestRunner.java file
        │    │              
        │    └───stepdefinitions                                 # Contains all the stepdefinition files
        │           StepsBase.java                               
        │           TheSportsbetStepDef.java                     
        │    
        └───resources
             └───data
             │      Data-Input.properties                        # Common test-data file
             │
             └───features
             │      TheSportsbet.feature                         # Contains all the feature files                      
             │       
             └───object-repository
             │      Locators-Android.properties                  # Object repository for Android
             │      Locators-iOS.properties                      # Object repository for iOS
             │       
             └───settings
                    ProjectSettings.properties                   # Contains all the framework/project configuration data
                    ReportSettings.xml                           # Testreport related file
                    RunCount.properties                          # Contains details of all previous test executions with timestamp






@Premnath.ayyadurai
``` 