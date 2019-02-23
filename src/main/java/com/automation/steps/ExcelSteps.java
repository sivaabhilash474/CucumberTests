package com.automation.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class ExcelSteps {
	
	@Given("^I entered the following values for the \"([^\"]*)\" scenario:$")
	public void i_entered_the_following_values_for_the_scenario(String arg1, DataTable arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    System.out.println("here comes the values");
	}

	@Given("^I validate the system generated excel report files match the business generated files:$")
	public void i_validate_the_system_generated_excel_report_files_match_the_business_generated_files(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	   System.out.println("method 2");
	}


}
