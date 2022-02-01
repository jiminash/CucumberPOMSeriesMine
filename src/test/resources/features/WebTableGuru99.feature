Feature: Element WebTable Guru99

Background:
 Given user navigates to WebTableGuru99

Scenario: user can locate single data in table
Given user searches the row 3
Then the data is visible
|Navin Fluorine Inter|
|	A	|
| 339.3	|
| 199.9	|
| + 8.6 |


Scenario: user can locate all datas in table
Given user searches the list 
Then all the datas is visible




