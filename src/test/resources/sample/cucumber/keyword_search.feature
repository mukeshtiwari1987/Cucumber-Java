Feature: Searching with keyword
  Searching with keyword should fetch appropriate results


  Scenario Outline: Searching for keyword should fetch related results
    Given I am in Google homepage
    When I enter the keyword <keyword>
    Then I should get results in searchpage as <results>

    Examples:

      |keyword|results|
      |"github" |"github - Google"|
#    |"browserstack"|"browserstack - Google"|
#    |"bamboo"|"bamboo - Google" |