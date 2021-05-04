Feature: Sign up button should be present on landing welcome page and on Sign up page, user should able to provide information

Scenario: Validate that the user should get a validation message on entering invalid data in first name and last name fields
   Given App is open and user is on sign up page
   When User enters invalid first name and last name details
   Then validation messages should be displayed
   
Scenario: Validate that the user should get a  validation message  on entering invalid Email ID
   When User enters invalid email id
   Then validation messages should be displayed
   
Scenario: Validate that the user should  get a  validation message on leaving Email ID field  blank
When User leaves Email ID field blank
Then validation messages should be displayed

Scenario: Validate that the user should get a validation message on entering phone number with less than 10 digits in the Phone number field
When User enters  phone number with less than 10 digits
Then validation messages should be displayed

Scenario: Validate that the user should get a  validation message on entering phone number with more than 10 digits in Phone number field
When User enters  phone number with more than 10 digits
Then validation messages should be displayed

Scenario: Validate that the user should get a validation message on entering already registered phone number
When User enters already registered phone number
Then validation messages should be displayed

Scenario: Validate that the user should  get a  validation message on leaving password field  blank
When User leaves the password field blank
Then validation messages should be displayed

Scenario: Validate that the password strength message  and progress bar is displayed while entering password in Password field
When User enters password
Then validation messages should be displayed

Scenario: Validate that the user should get a  validation message on entering different data in Password and Confirm Password fields 
When User enters password and confirm password data differently
Then validation messages should be displayed

Scenario: Validate that the Sign Up button is disabled  when Terms & Conditions is unchecked
When Check box is unchecked
