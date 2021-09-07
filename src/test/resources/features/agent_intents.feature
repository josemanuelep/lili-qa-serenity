@AgentIntents
Feature: Test cases for creating, editing, deleting and filtering intents associated with an agent

  Background: Login to page
    Given User wants go to login in vozy page as qabotdesigner in pip organization

  @AgentIntents @SearchIntens @Regression
  Scenario Outline:  Search agent and into agent search intent using search box
    Given Go to agent folders and search folder <folder>
    When  Search and open agent <agent>
    And   Open design items
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
    And   Open design items
    Given Filter by date <date>
    Then the results should have correct date <date> field
    Examples:
      | folder   | agent    | date            |
#      | NOV06           | agenteNov06         | Today            |
#      | WS_Prueba_Front | Prueba links        | Yesterday        |
#      | NOV06           | agenteNov06         | This week        |
#      | NEW TEST        | Agent-transfer-test | All time         |
      | NEW TEST | Agent 03 | February 2 2021 |
#      | NOV06           | agenteNov06         | September 6 2021 |

  @AgentIntents @DeleteIntent @Regression
  Scenario Outline:  Search agent and into agent folder and delete given intent
    Given Go to agent folders and search folder <folder>
    When  Search and open agent <agent>
    And   Open design items
    And   Search intent called <intent>
    When  Intent is deleted should see confimation alert message

    Examples:
      | folder | agent       | intent                 |
      | NOV06  | agenteNov06 | intent-confirmation-no |

  @AgentIntents @CreateIntent @Regression
  Scenario:  Search agent and into agent folder and create given intent
    Given Go to agent folders and search folder QA_Env
    When  Search and open agent Test_SMS
    And   Open design items
    Then  create intent called addressIntent with these utterances
      | uttercanceName   | slotName |
      | la dirreccion es | slotTest |
      | la casa queda en | slotTest |
      | esta por         | slotTest |

