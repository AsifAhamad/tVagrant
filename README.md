# tVagrant
Searching a book in Goodreads.com

Few details about the framework:

I have used Selenium to automate the test scenarios. Have followed Page object model (POM) design pattern and used Maven build tool for project management. TestNG is used as testing framework. Eclipse IDE is used to for developing the framework in Java.

Project Folder/File Structure:

src/main/java - Contains the Base class and page objects.

src/test/java - Contains the automated scenario.

Resources/data.properties* - Contains test data and browser configuration

pom.xml - contains the Maven dependencies

testing.xml - Test suit containing single test scenario

Test-output - contains the TestNG output reports in html format

* Needs attention before execution


Instructions to import this project:

1. Download as Zip or copy Github link

2. Create Maven project

3. Select project and Import project from file system or Import from Git 

4. Click finish to import and let maven finish the download of dependencies

5. Run testng.xml for execution of Automation Scenario
