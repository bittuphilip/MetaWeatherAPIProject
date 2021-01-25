# MetaWeatherAPIProject

Framework helps to automate the Meta Weather API using BDD aaproach


## Part One: 

### Tools:

Maven
Cucumber-JVM
TestNG
RestAssured
Selenium WebDriver


### Requirements
#### In order to utilise this project you need to have the following installed locally:

1.Maven latest version
2.Java JDK1.8 or later version


### Execution/Usage Steps:

1. Download and Unzip to a Local machine folder.
2. Open Command Prompt as administrator Change directory to the folder containing the framework
3. Type "mvn clean verify" / "mvn clean install"


### Framework Structure:

* Feature File Location: src/test/resources/AppFeatures

	(In Feature file you can add your BDD Features)

* Step Definition Location: src/test/java/stepdefinitions
	(In Step Definitons you can write your code for the featurees you added)

* Test Runner File Location: src/test/java/testRunner
	(Test Runner File is to execute the feature file)

* Listener Package Location: src/main/java/listener
	(Package to Generate the Logs)

* Resources package location: src/main/java/resources
	(Package for Utils and Poperty files)


### Reporting and Logs: 

* Reports are added to the respective folder "/ExtentReport"

* Logs are added to the respective folder "/logs"



### How to Test:

* Q: Feature to test: As a MetaWeather API client, I want to retrieve “tomorrows” weather for “Nottingham”

	Ans: To test this feature Change the date in the "GlobalWeatherDetails.feature" in date column

##### Note: You can change any date and add any location in the Date and Place column 


* Q: Stretch Feature:

	Ans: Added the Stretch Feature added in "VerifyPlaceID.feature"





##########################################################################################################



## Part Two:

* Q1: Explain why you chose to use those particular frameworks in the technical challenge?
	Ans: I have used BDD framework because it follows BDD approach. 

	1. Since we are using feature file which helps in the parametrization of data so we dont require the excel to pass our data.It helps in the optimization and clarity of the 		code.
	2. In BDD Approach we are writing test cases using Gherkin language which is understandable by all non-technical person also.





* Q2: What questions would you ask your Product Owner / what information would you need to know, to be able to test the whole MetaWeather API service comprehensively?
	Ans: I would like to get the information from the Product Owner mentioned below:

	1. How many character of the place name user need to pass in the API url(https://www.metaweather.com/api/location/search/?query=london)
	eg. London/Lon/Lo
	2. What all status codes do i need to validate like 400/500 error
	3. Who is the Target group?
	4. Can i get details about "Application Features"
	5. What is the Business goals.

##### Note: If i get these details then i will be able to test the whole Meta Weather API service more comprehensively.




* Q3: After completing the technical challenge, what would you do differently if you were asked to do the same challenge again?
	Ans: If i get the challenge again I can add more positive and negative features.


