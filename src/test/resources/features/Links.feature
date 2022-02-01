Feature: Element links 

@skip_scenario
Scenario: to check the links are valid
Given user tries each link

Scenario Outline: to check the links are valid
Given user tries the links "<links>"
Then new tab is opened
When user gets the title of the page
Then page title should be "ToolsQA"
And window to be closed

Examples:
|links|
|simple|
|dynamic|