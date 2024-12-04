$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/End2End_Test.feature");
formatter.feature({
  "name": "End to End simulation Test",
  "description": "Description: We will test some scenario implement E2E Test",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a user I can add new data",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "A list of item are available",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.a_list_of_item_are_available()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\r\n\tat stepdefinitions.StepDefinitions.a_list_of_item_are_available(StepDefinitions.java:11)\r\n\tat ✽.A list of item are available(file:///D:/My%20Project/QA%20mini%20class/restassuredtest/src/test/resources/features/End2End_Test.feature:5)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "I add item to list",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.i_add_item_to_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The item is available",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.the_item_is_available()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "As a user I can update data",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "A list of item are available",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.a_list_of_item_are_available()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\r\n\tat stepdefinitions.StepDefinitions.a_list_of_item_are_available(StepDefinitions.java:11)\r\n\tat ✽.A list of item are available(file:///D:/My%20Project/QA%20mini%20class/restassuredtest/src/test/resources/features/End2End_Test.feature:10)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "I add item to list",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.i_add_item_to_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The item is available",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.the_item_is_available()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I can update that item",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.i_can_update_that_item()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "As a user I can detele data",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "A list of item are available",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.a_list_of_item_are_available()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\r\n\tat stepdefinitions.StepDefinitions.a_list_of_item_are_available(StepDefinitions.java:11)\r\n\tat ✽.A list of item are available(file:///D:/My%20Project/QA%20mini%20class/restassuredtest/src/test/resources/features/End2End_Test.feature:16)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "I add item to list",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.i_add_item_to_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The item is available",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.the_item_is_available()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I delete that item",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "The item is not available",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});