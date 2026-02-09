📌 Project Description (Main)

Selenium Automation Framework – UI & API Hybrid Testing

This project is a scalable Selenium automation framework built using Java and Maven, designed to test a web-based Todo application using a hybrid approach (API + UI).
The framework leverages API calls to handle authentication and test setup, allowing UI tests to focus only on business functionality, which improves execution speed, reliability, and test stability.

The framework follows industry best practices such as Page Object Model (POM), clean project structure, reusable utilities, configuration management, parallel execution support, and detailed reporting using Allure Reports.
Tests are fully integrated with GitHub Actions for Continuous Integration (CI), enabling automated test execution on every push or pull request.

🚀 Key Features

Hybrid UI + API testing strategy

API-based authentication to bypass UI login flows

Selenium WebDriver with Java & Maven

Page Object Model (POM) design pattern

Parallel test execution support (ThreadLocal WebDriver)

Allure reporting with steps, features, stories, and screenshots on failure

GitHub Actions CI workflow

Config-driven execution (browser, environment, credentials)

Clean separation of tests, utilities, configs, and API layers

Robust teardown with failure handling and screenshots

Scalable and maintainable framework structure

🧰 Tech Stack & Tools

Language: Java

Build Tool: Maven

UI Automation: Selenium WebDriver

API Testing: Rest Assured

Test Framework: TestNG

Reporting: Allure Reports

CI/CD: GitHub Actions

Design Pattern: Page Object Model (POM)

Driver Management: WebDriverManager

Version Control: Git & GitHub

🧪 Testing Approach

API requests are used to:

Register users

Authenticate and retrieve tokens

Create test data (todos)

Authentication cookies are injected into the browser to skip UI login

UI tests validate core application functionality such as:

Login & signup flows

Todo creation

Todo deletion

This approach significantly reduces test execution time and improves reliability.

📊 Reporting

Allure reports include:

Test suites, features, and stories

Step-by-step execution

Failure screenshots

Severity levels

Reports can be generated locally and in CI environments

🔁 CI Integration

Automated test execution using GitHub Actions

Runs on push and pull request events

Headless browser execution for CI compatibility

📁 Project Structure (High-Level)
src
 ├── main
 │   ├── api
 │   ├── utils
 │   ├── config
 └── test
     ├── testcases
     ├── pages
     ├── base
     └── listeners

⭐ Why This Project?

This framework demonstrates:

Real-world automation architecture

Professional CI/CD integration

Efficient hybrid testing strategy

Clean and maintainable test design

Ideal for showcasing QA Automation Engineer skills in a portfolio.
