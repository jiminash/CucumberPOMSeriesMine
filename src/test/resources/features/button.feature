Feature: Element button 

Background:
Given user navigates to buttons



Scenario Outline:  user clicks 
Given user clicks all click buttons available "<clicks>"
Then its respective message is displayed "<message>"
Then its respective2 
Then its respective3 
Examples:

|clicks|message|
#|doubleClk| You have done a double click |
#|rightClk| You have done a right click |
|Clk| You have done a dynamic click |



