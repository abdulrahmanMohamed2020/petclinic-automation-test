# petclinic-automation-test
 
 
## Project Overview:
* This automation framework utilizes Selenium and Java to automate test cases for [pet clinic]. It aims to provide comprehensive test coverage for the main features of the application. This README file serves as a guide for setting up and using the framework effectively.

## Features Covered:
* Verify image on home page
* Find all the Veterinarians which are added in the application
* Find all the existing owners which are added in application
* Add a new owner, add pet for that owner.
* Check all the information added for the newly created owner and pet is correct

## Getting Started

To use this automation framework, ensure that you have the following prerequisites:

- Java Development Kit (JDK) installed (version 17 or higher)
- Docker installed and get a docker image for Docker Registry as we are using Remote WebDriver
- Allure Report Commands
- Make a container using this command line
     ```
       docker run -d -p 4444:4444 -p 5900:5900 -v /dev/shm:/dev/shm [image name]:[version]
     ```

To set up the framework locally, follow these steps:

1. Clone the repository: `git clone https://github.com/abdulrahmanMohamed2020/petclinic-automation-test.git`
2. Install the required dependencies: `mvn install`

## Usage
To execute the test cases, use the following command:

1. Open the project using any IDE
   - in case you don't have an IDE you can open a command-line terminal on the project root path and type
     ```
      mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml
     ```
2. Wait till all dependencies are resolved
3. Run the testing.xml file
4. After executing, you can easily generate the **Allure Report** by opening a command-line terminal on the project 
root path and type
```
allure serve "allure-result" path
```

## Structure Explanation

- `src/main/java`: This directory contains the main Java source code files for the project.
  - `org.alef.education.constants`: This package contains classes responsible for Owner and Pet test data.
  - `org.alef.education.core`: This package contains The Base class which contains reusable methods also classes for browser configurations.
  - `org.alef.education.pages`: This package contains the pages elements and locators.
- `src/test/resources`: This directory includes the test runner file which is testng.xml.

## The main Frameworks included in the project:
* Selenium Webdriver
* TestNG
* Allure Report
* Commons IO
## Project Design:
* Page Object Model (POM) design pattern
* Fluent design approach (method chaining)
* Have a supporting Core package in src/main/java file path, named **"core"** that includes Capabilities classes which serve as a core engine for the project
## How to check the execution log and open the latest execution reports from GitHub Actions:
* You need to be logged in to GitHub as a prerequisite
* Go to github-pages in the Environment tab
* Click on **"View Deployment"**
