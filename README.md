##################Prerequisite to run this project###################

Java JDK(1.8 or higher)
Appium Server
Connted ADB Devide (to exceute .apk file inside Android Simulator)
Android Studio(To create ADB Device)
Eclipse or any Java supported Editor
git(Reposotory Management tool)

##########################Test Cases Overview#########################

Test cases(scenarios) are designed in BDD style gherkins language(Given-When-Then) format and part of feature file

1st testcase(scenario) is verifying the presentce of text message in the landing screen of the sunflower app.

2nd testcase(scenario) is verifying the presence of ADD PLANT Button.

3rd testcase(scenario) is verifying that both the screen tabs are working fine and clickable.

4th testcase(scenario) is verifying that the ADD PLANT Button is working as expected and app navigates to Plant List Tab.


######################################Project Structure####################################

The Project is developed using Java,Maven,Junit Runner class(highly configurable),cucumber(BDD) and written in a generic way.
As it's written in industry standard BDD(Cucumber) framework, it's easily understandable for business users.
It uses Global hooks(@BeforeAll, @AfterAll) to launch Appium server and stops it when all scenarios are executed.
It generates nice Junit style and cucumber reports which business user can use for reference.
ExcelReader is integrated as a part of util package under src/main/java folder.
As it's developed using Maven, this project can be run from CLI also without any IDE support.



####################################Execution Video########################################

Execution Video's are uploaded under same project directory in github inside the "Test Execcution" folder.
