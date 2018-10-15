Meta: 
@TabletPC 

Scenario: This test compares the information from the test case with the text on the site for tabletPC

Given I open a browser for tabletPC tests
When I select the companies on the left
And I select the companies in the search
Then Company verification on the left
And Company verification in the search
