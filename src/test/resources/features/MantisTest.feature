Feature: Bug report cycle

  Scenario: tester reports an issue

    Given User log in as "tester1"
    And report issue
    When user fills the form "tester1_issue"
    And submit issue
    Then user open bug table
    And user find "assigned (dev1)"
    And logout
    Given User log in as "dev1"
    And user open bug table
    And user find "assigned (dev1)"
    And user open task
    And check the "task view" section
    Then user changes the status issue to "resolved" "dev1"
    And click button resolve
    And logout
    Given User log in as "lead1"
    And user open bug table
    And user find "resolved (dev1)"
    And user open task
    Then user changes the status issue to "closed" "lead1"
    And click button close
    And user open bug table
    And user change filter off
    And user find "closed (lead1)"







