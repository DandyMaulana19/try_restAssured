$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/End2End_Test.feature");
formatter.feature({
  "name": "End to End simulation Test",
  "description": "Description: We will test some scenario implement E2E Test",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "As a user I can add new data",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@addData"
    }
  ]
});
formatter.step({
  "name": "A list of item are available",
  "keyword": "Given "
});
formatter.step({
  "name": "I add item to list \u003cpayload\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "The item is available",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "payload"
      ]
    },
    {
      "cells": [
        "1"
      ]
    },
    {
      "cells": [
        "2"
      ]
    }
  ]
});
formatter.scenario({
  "name": "As a user I can add new data",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@addData"
    }
  ]
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
  "name": "I add item to list 1",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.i_add_item_to_list(int)"
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
formatter.scenario({
  "name": "As a user I can add new data",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@addData"
    }
  ]
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
  "name": "I add item to list 2",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitions.i_add_item_to_list(int)"
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