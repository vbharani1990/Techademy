Feature: WordPress

Scenario: Verify WordPress homepage title
    Given I launch the WordPress homepage
    Then I verify the title of the page is "Blog Tool, Publishing Platform, and CMS – WordPress.org"

  Scenario: Navigate to Get WordPress page
    Given I launch the WordPress homepage
    When I click on "Get WordPress"
    Then I verify the text in the middle of the page is "Get WordPress"

  Scenario: Search for a picture and verify the pictures are displayed
    Given I launch the WordPress homepage
    When I click on "Community" and then click on "Photo Directory"
    	And I search for a picture by name "logo"
    Then I verify pictures are displayed in the search results
	