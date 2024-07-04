# Solvd Automation Testing Project using Carina Framework for Jewelery for Pandora Application

This project is a testing exercise. It is using the application "Jewelery for Pandora".
It uses Maven for dependency management.

## Prerequisites

This project requires JDK 21 or higher. Make sure you have the correct version installed and configured on your system.

## Goals

- Understand how to test native applications using Carina Framework
- Practice with automation tests for Android platform; learn how to set up an emulator and application for automated testing.
- Practice creation of the test cases
- Practice locators strategies for mobile applications
- Practice Github reviews for Pull Requests

## Project Structure

1. `com.solvd`: Contains the main classes for the application pages that are being tested. Each class represents a different page on the website and contains methods for interacting with the elements on that page.
2. `config.properties`: Contains the configuration for emulator and applications activities and capabilities.
3. `com.solvd.test`: Contains the test classes. These classes use TestNG for structuring and running the tests.
4. `src/test/resources`: Contains the TestNG suite xml file for running the tests.

## Dependencies

This project uses the following dependencies (this section can change!):

- Carina Core: provides the fundamental components and features of the Carina framework, which includes support for WebDriver.
- Carina API: provides methods for sending HTTP requests and validating responses.
- TestNG: For structuring and running the tests.
- Maven: For managing the project's dependencies.
- SLF4J and Log4j: For logging.
- MyBatis: MyBatis is a persistence framework that automates the mapping between SQL databases and objects in Java.

## To-do

- [ ] Create Pages for Jewelery for Pandora application
- [ ] Create Components for Jewelery for Pandora application
- [ ] Find out how to create reliable selectors for native application