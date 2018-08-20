# Cucumber Java-Browserstack
## Integration with BrowserStack.

<a href="https://cucumber.io"><img src="https://cucumber.io/images/cucumber-logo.svg" height="150" />
<a href="http://automate.browserstack.com/"><img src ="https://d98b8t1nnulk5.cloudfront.net/production/images/layout/logo-header.png?1469004780" height="80"/> 

## Setup
* Clone the repo
* Install dependencies `mvn install`
* Set variables in Stepdefs page with your [BrowserStack Username and Access Key](https://www.browserstack.com/accounts/settings). 

## Running your tests
* To run a single test, run `mvn test -Dbrowser=<BROWSER>`
  * Note - use command line properties to set additional webdriver capabilities
* For example to run a test on Chrome 68 on Windows 10 with Local Testing enabled, command will be as below:
  `mvn test -Dbrowser=chrome -Dbrowser_version=68.0 -Dos=windows -Dos_version=10 -Dlocal=true`
* To run a test on mobile device say iPhone 7 with OS version 10.3, command will be as below: 
  `mvn test -Ddevice="iphone 7" -Dreal_mobile=true -Dos_version=10.3`
* Find list of available devices and OS-Browser combinations [here](https://www.browserstack.com/list-of-browsers-and-platforms?product=automate)

## Addtional Resources
* [Read about BDD](https://docs.cucumber.io/bdd/)
* [Documentation for writing Cucumber tests in Java](https://docs.cucumber.io/cucumber/step-definitions/)