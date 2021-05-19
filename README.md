### An automation script that automates the registration process and the verification of successful login.

It is a fully automated script the completly automates the process of validating the data provided , registration of new user
and verification of the abilty to login after the registration process.

## what does the script do
Automation testing for Registration and login functionality for website ("https://www.phptravels.net/register")

1-Extract the valid data form the data provided in an Excel Sheet

2-Verfiy that the URL provided in the requirments navigate the correct destination

3-Register a new user at "https://www.phptravels.net/register" using the valid data provided (fully automated)

4-Verify the successful login in functionality by using the data passed the registration

5-Genrating customized reports including screenshots and video records for Testcases includes Status (pass/fail) of all test cases 



## Built With
* JAVA                  - Programming Language

* Selenium              -WebDriver

* TestNG                -testing framework

* Maven                 -software project management and comprehension tool

* Extent Reporting      -Extent Reporting Framework

* AUTtest Recorder       -Video Recording framework


## How to use it

- First you have to add AUTtestRecorder jar file to your local repository (Because it doesnot have an online maven dependcy)
  
  * You can find the jar file on the project folder (ATUTestRecorder_2.1.jar) copy the path of the jar file. open the Terminal copy the     below command
  
```
mvn install:install-file -Dfile={Path}/ATUTestRecorder_2.1.jar -DgroupId=org.aut.tm -DartifactId=cxf-bundle -Dversion=2.7.3 -Dpackaging=jar
```
  
- And then just open your command prompt and navigate to the directory where the project files are  , and then type these two command     lines

```
mvn clean
mvn test
```

## Task Requirments
1.	Enter First Name which must start with capital letter.

2.	Enter Last Name which must start with capital letter and can’t be equal First Name.

3.	Enter a valid Mobile Number.

4.	Enter a valid E-mail that should be unique for every user.

5.	Enter a Password and check that it must have capital letter, small letter, with a limit of 8 characters.

6.	After successful registration, verify that the user can login.


## Test Cases

Test case #1 : Check the valdity of the URL

Test case #2 : Check Registration functionality

Test case #3 : Check the login functionality

## How the script works

1-fisrt it exrtact data from the testData excel sheet provided

2-validate data according the constrains given in the requirments sheet

3-navigate to the URL "https://www.phptravels.net/register"

4-Check if the url navigated to the correct distnation

5-use the valid data extracted to register a new user

6-check if the registration of a new user is done successufly

7-Report the status of the test case if (pass/fail) and provide screen shots & video records in the report

8-use the data of successufly registerd users to check the abilty of login functionality

9-Report the status of the test case if (pass/fail) and provide screen shots & video records in the report


## Reports
* Report include

- Number of total executed test cases 

- Number of passed TestCases

- Number of Failed TestCases

- Total time taken 

- Pass percentage

- Screen Shots

-Video Records

## Reports Results Samples

<img src="https://imgur.com/I6DFAc6.png" width="80%">


<img src="https://i.imgur.com/HfpmX7D.png" width="80%">



## TestCases Execution

- Registration test Case execution ( https://imgur.com/HaCQsl9 )

![TesCase GIF](https://imgur.com/43gUHx3.gif)

- Login Test Case execution ( https://imgur.com/Eu60YSY )

![TestCase GIF](https://imgur.com/1B6nxNa.gif)
