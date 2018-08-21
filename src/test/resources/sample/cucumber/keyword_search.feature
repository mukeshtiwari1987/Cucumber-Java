Feature: Searching with keyword
  Searching with keyword should fetch appropriate results


  Scenario: Searching for keyword should fetch related results
    Given I am in Google homepage
    When I enter the keyword "github"
    Then I should get results in searchpage as "github - Google"