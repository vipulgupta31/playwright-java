# Running automation tests at scale with Playwright Java

Playwright, which was first released in January 2020, has quickly gained popularity. Playwright has become popular due to its stability, open-source nature, and support for multiple languages such as C#, Java, and Python. This support makes it easy for users to migrate from existing tools to Playwright.

This repository holds beginner code to help you understand Playwright with Java. It contains different test files to help understand the difference in execution when cases are executed on local and cloud. For Cloud execution, the LambdaTest Platform has been used. We showcase both single and parallel execution on the cloud.

## What is Playwright?
Playwright is an open-source automation framework library created by Microsoft to test and automate web applications. This library is compatible with Windows, macOS, and Linux, and supports cross-browser automation testing on Chromium (Google Chrome, Microsoft Edge), Mozilla Firefox, and WebKit (Apple Safari).

Playwright is a more effective framework for cross-browser testing and web scraping than its likes because it provides a unified, high-level API for automating web applications across multiple browsers. Testers can use these APIs to navigate to URLs, and interact with elements, perform actions like filling forms and, scraping data.

## Why choose Playwright with Java
Even though Playwright supports a variety of programming languages, Java is still a popular choice due to its widespread adoption and robust ecosystem. 

A few other advantages that make this combination a powerful one to use are:
- Seamless Configuration
- Cross-Platform Compatibility
- Modern Language Bindings
- Comprehensive Documentation

## Framework setup for Playwright and Java
At a high level, the setup can be divided into 3 parts,
1. Installing Java 11
2. Creating a Maven Project
3. Adding [Playwright Maven dependency]([url](https://mvnrepository.com/artifact/com.microsoft.playwright/playwright))


## About Project
It is created using Playwright with Java, TestNG, and Maven for Web-based automation.

This is the list of tools, being used in this framework:
1. Apache Maven
2. Java 11
3. Playwright Cloud Grid - [LambdaTest](http://www.lambdatest.com?fp_ref=vipul51) Platform
4. TestNG Framework

## Test Execution
As we are creating a TestNG test case, for execution simply right-click in the IDE and run the test case as a TestNG test.
