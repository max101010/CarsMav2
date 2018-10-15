Meta: 
@TestTable

Scenario: This test checks the work of custom web elements for a table

Given I open a browser for table tests
Given I enter https://www.myscore.com.ua/football/russia/premier-league/standings/ for the table test
When I select a table
Then The number of the first line is 1
And The size of the table is 17
