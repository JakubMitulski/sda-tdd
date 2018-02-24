package com.sda.cucumber;

import com.sda.CalcService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CalcServiceSteps {

    private String text;
    private CalcService calcService;
    private int actual;

    @Given("^I initialize CalcService$")
    public void I_initialize_CalcService() {
        calcService = new CalcService();
    }

    @And("^I pass text value to compute$")
    public void I_pass_text_value_to_compute() {
        text = "2;3;4";
    }

    @When("^I execute calculate method$")
    public void I_execute_calculate_method() {
        actual = calcService.calculate(text);
    }

    @And("^I pass null$")
    public void I_pass_null() {
        text = null;
    }

    @Then("^I get (.*) as result$")
    public void I_get_value_as_result(int result) {
        Assert.assertEquals(result, actual);
    }

    @And("^I pass blank$")
    public void I_pass_blank() {
        text = "";
    }

    @And("^I pass text with letters$")
    public void I_pass_text_with_letters() {
        text = "";
    }

    @And("^I pass recipe$")
    public void I_pass_recipe() {
        text = "";
    }

    @And("^I pass (.*) value$")
    public void I_pass_text_value(String text) {
        this.text = text;
    }
}
