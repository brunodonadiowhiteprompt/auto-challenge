# Automation Challenge

This repository contains the requested work for the proposed challenge.

## UI Automation Challenge

The project in the _ui-auto-challenge_ folder contains the solution for the requested UI automation tests. It has been done on **Java** by using **TestNG** as testing framework, **Selenium** as automation framework, and **Log4j** as logging utility.

In order to build and execute the project, you may use **Maven**. You can run the following command to trigger the tests.

`mvn test -Denv=test -Ddriver=chrome`

Note that there are two parameters in the line above. The **env** parameter defines the execution environment for the automation. In this case, the only available environment is `test`, which points to https://www.saucedemo.com. The **driver** parameter determines the driver that will be used during the execution. You can use `chrome`, `safari`, `firefox`, `edge` or `opera`.  
After executing the tests, you will be able to locate the execution report generated by the **Maven Surefire Plugin** in the _target/surefire-reports_ directory. Also, you can review the execution logs from the _logs_ directory.

You can get more information about how to download Maven on it's official site: https://maven.apache.org/users/index.html

### Test Cases

#### Standard User Login

```
Given the user is at Login page
When the user fills the Username field
and the user fills the Password field
and the user clicks on Continue button
Then the user should be authenticated
```

#### Purchase all the T-Shirts

```
Given the user is at Login page
and the user performs login as Standard User
When the user adds all the T-Shirts to the shopping cart
and the user clicks on Shopping Cart link
and the user clicks on Checkout button
and the user fills the First Name field
and the user fills the Last Name field
and the user fills the Postal Code field
and the user clicks on Continue button
and the user clicks on Finish button
Then Order Confirmation message is displayed
```

## API Automation Challenge

The project in the _api-auto-challenge_ folder contains the solution for the requested API automation test. It has been done on **Java** by using **TestNG** as testing framework, **REST Assured** as request-handler framework, and **Log4j** as logging utility.

In order to build and execute the project, you may use **Maven**. You can run the following command to trigger the tests.

`mvn test -Denv=test`

The **env** parameter defines the execution environment from where the resources are gonna be requested. In this case, the only available environment is `test`, which points to https://api.openweathermap.org/data/2.5.  
After executing the tests, you will be able to locate the execution report generated by the **Maven Surefire Plugin** in the _target/surefire-reports_ directory. Also, you can review the execution logs from the _logs_ directory.

### Test Cases

#### London Weather Test

```
Request weather information for London, UK
```

## Built With
- [Java](https://www.java.com/) - The programming language
- [TestNG](https://testng.org/) - The Java testing framework
- [Selenium](https://www.selenium.dev/) - The browser automation tool
- [REST Assured](https://rest-assured.io/) - The REST test and validation tool
- [Log4j](https://logging.apache.org/log4j) - The Java logging utility
- [Maven](https://maven.apache.org/) - The Java build automation tool

## Automation Architecture
In order to integrate the scripts involved in this challenge into a CI/CD environment, I would setup some automation server, like **Jenkins**, in order to create different jobs which may include or not specific test cases depending on the test suite needed. Those jobs could be triggered both manually or each time a new build is generated for the application. Each test suite would be executed at different steps of the development life cycle.  
Also, if needed, jobs might be programmed to run on a schedule.  
For reporting, I would organize the execution reports generated for each build, and report any incidence to the development team in case of a failure, including the test case that was executed, the environment details, the desired instructions in order to reproduce the failure, and any generated assets from the test session.  
There are several tools that can be used in order to integrate the documented test cases with the test runs and the execution results, like **TestRail** or **CucumberStudio**.

## Executions Results

You can find both reports and logs generated from the execution of both the projects in the _execution-results_ folder.
