Feature: Element WebTable 

Background:
 Given user navigates to WebTable


Scenario:  user looks all the datas in the table
Given user searchs the first row
Then it matches the list
| Cierra |
| Vega | 
| 39 | 
| cierra@example.com |
| 10000 |
| Insurance |

Scenario: user searches table using search box
Given user enters the word
Then item is listed 


