@AgentIntents
Feature: Test cases for creating, editing, deleting and filtering intents associated with an agent

  Background: Login to page
    Given User wants go to login in vozy page as qabotdesigner in pip organization

  @AgentIntents @SearchIntens @Regression
  Scenario Outline:  Search agent and into agent search intent using search box
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

  @AgentIntents @SearchIntensByDate @Regression
  Scenario Outline:  Search agent and into agent search intent using search box and date picker
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

  @AgentIntents @DeleteIntent @Regression
  Scenario Outline:  Search agent and into agent folder and delete given intent
    Given Go to agent folders and search folder <folder>
    When  Search and open agent <agent>
    And   Open desing items
    And   Search intent called <intent>
    When  Intent is deleted should see confimation alert message

    Examples:
      | folder | agent       | intent                 |
      | NOV06  | agenteNov06 | intent-confirmation-no |


  @AgentIntents @CreateIntent @Regression
  Scenario:  Search agent and into agent folder and create given intent
    Given Go to agent folders and search folder QA_Env
    When  Search and open agent Test_SMS
    And   Open desing items
    Then  create intent called addressIntent with these utterances
      | uttercanceName   | slotName |
      | la dirreccion es | slotTest |
      | la casa queda en | slotTest |
      | esta por         | slotTest |

