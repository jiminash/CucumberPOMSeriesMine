Feature: image element
  I want to use this template for my feature file

  Background: 
    Given user goes to image page

  @tag1
  Scenario: user cannot view image
    Then image is not displayed

  @tag1
  Scenario Outline: user can view image
    Given user verifies the "<link>"
    When new page is opened in same tab "<link>"
    When user gets the title of the page
    Then page title should be "ToolsQA"

    Examples: 
      | link         |
      | valid link   |
      | invalid link |
