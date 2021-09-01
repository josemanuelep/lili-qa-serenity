@AgentIntents
Feature: Search for intents of given agent

  Background: Login to page
    Given User wants go to login in vozy page as qabotdesigner in pip organization

  @AgentIntents  @SearchIntens
  Scenario Outline:  Search agent and into agent search intent
    Given Go to agent folders and search folder <folder>
    When  Search and open agent <agent>
    And   Open desing items
    And   Search intent called <intent>
    Then  The inten should be visible <intent>
    Examples:
      | folder      | agent                 | intent                 |
      | NOV06       | agenteNov06           | intent-confirmation-no |
      | QA_Env      | Test_SMS              | getuserphone           |
      | AirPack_POC | LILI_AirPak_Assistant | 1_welcome_repeat       |
