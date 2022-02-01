Feature: Element radiobutton 

Background:
 Given user navigates to radioButton


Scenario:  user with first radio
Given user click the "yes" 
Then userText is displayed

@skip_scenario
Scenario:  user with second radio
Given user click the "impressive" 
Then userText is displayed
