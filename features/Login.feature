Feature: Application Login

Scenario: Home page default login
Given User is on "http://www.qaclickacademy.com/"
When User click on Login
Then Login page is populated
And User enter username as "rithik" and password as "malhotra"