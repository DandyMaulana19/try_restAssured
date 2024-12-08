$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/End2End_Test.feature");
formatter.feature({
  "name": "End to End simulation Test",
  "description": "Description: We will test some scenario implement E2E Test",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a user I can add new data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@addData"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "A list of item are available",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.a_list_of_item_are_available()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add item to list",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.i_add_item_to_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The item is available",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.the_item_is_available()"
});
formatter.result({
  "status": "passed"
});
});