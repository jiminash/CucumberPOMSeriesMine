Feature: Element textbox 

Scenario Outline: textbox with proper input
Given user navigates to textbox
When user provides the values
|adsd|
|fom@gmail.com|
|add|
|xss|
Then details are displayed in page 
|adsd|
|fom@gmail.com|
|add|
|xss|

