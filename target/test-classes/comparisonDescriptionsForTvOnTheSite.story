Meta: 
@Tv

Scenario: This test compares the description and headers with the text from the test case

Given I open a browser for TV
When I enter https://catalog.onliner.by/tv - page of Tv
And I get heading texts
And I get description texts
Then Headers match
Then Descriptions match