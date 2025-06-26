package com.qa.stepdefinations;

import com.qa.base.Base;
import com.qa.pages.AddEmployeePage;
import com.qa.pages.LoginPage;
import com.qa.util.CaptureScreenshot;
import com.qa.util.ReadProperties;
import com.qa.util.WaitMethods;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

/**
 * @author HP this class is the glue code of EmployeeCRUD.feature
 *
 */
public class EmployeeCRUDSteps extends Base{
	
	Scenario scenario;
	LoginPage objloginpage;
	AddEmployeePage addEmployee;
	
	@Before
	public void startApplication(Scenario scenario)
	{
		this.scenario=scenario;
		
	}
	
@After
public void closeApplication()
{
	closeBrowser();
	scenario.write("Closing the orange HRMS application");
	
	}

@Given("^Navigate to PIM after log in with Admin user$")
public void navigate_to_PIM_after_log_in_with_Admin_user() throws Throwable {
	
	driver=initializeWebDriver(); //this is user define method from base class to initiate webdriver
	WaitMethods.staticWait(5000);
	scenario.write("Open the browser and orange hrms application");
	objloginpage=new LoginPage(driver,scenario);
	
	scenario.write("Logging to the application");
	scenario.embed(CaptureScreenshot.captureImage(driver),"image/png");
	
	objloginpage.logintoApplication(ReadProperties.getAppUserName(), ReadProperties.getAppPassword());
	WaitMethods.staticWait(5000);
	scenario.write("Login sucessfully");
	scenario.embed(CaptureScreenshot.captureImage(driver),"image/png");
	
	addEmployee=new AddEmployeePage(driver,scenario);
	String actualPIMpageTitle=addEmployee.navigateToPIMPage();
	Assert.assertEquals("PIM", actualPIMpageTitle);
	scenario.write("Navigate to PIM page after login");
	scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
}

@When("^I Add employee with  first name as \"([^\"]*)\" and mname as \"([^\"]*)\" and lName as \"([^\"]*)\"$")
public void i_Add_employee_with_first_name_as_and_mname_as_and_lName_as(String fName, String mName, String lname) throws Throwable {
	AddEmployeePage addemployeeobj=new AddEmployeePage(driver, scenario);
	String addEmployeePageTitle=addemployeeobj.navigateToAddEmployee();
	Assert.assertEquals("Add Employee", addEmployeePageTitle);
	scenario.write("Navigate to add Employee Page");
	WaitMethods.staticWait(3000);
	scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	addemployeeobj.addEmployee(fName,mName,lname);
	WaitMethods.staticWait(5000);
	scenario.write("Employee sucessfully added");
	scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	
	
}

@Then("^I  verify employeeAdded in list with  first name as \"([^\"]*)\" and mname as \"([^\"]*)\" and lName as \"([^\"]*)\"$")
public void i_verify_employeeAdded_in_list_with_first_name_as_and_mname_as_and_lName_as(String fName, String mName, String lname) throws Throwable {
	AddEmployeePage addemployeeobj=new AddEmployeePage(driver, scenario);
	addemployeeobj.navigateToEmployeeList();
	scenario.write("Navigate to employee list");
	scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	WaitMethods.staticWait(3000);
	addemployeeobj.searchEmployee(fName, mName, lname);
	scenario.write("search employee");
	scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	WaitMethods.staticWait(3000);
}


@When("^I click on Edit button and update below values and save the Data$")
public void i_click_on_Edit_button_and_update_below_values_and_save_the_Data(DataTable editEmpInfotable) throws Throwable {
	
	addEmployee=new AddEmployeePage(driver, scenario);
	System.out.println("=====" + editEmpInfotable.raw().get(0).get(1));
	addEmployee.editEmployee(editEmpInfotable.raw().get(0).get(1),editEmpInfotable.raw().get(1).get(1),editEmpInfotable.raw().get(2).get(1));
	scenario.write("Edit employee data");
	scenario.embed(CaptureScreenshot.captureImage(driver),"image/png");
	WaitMethods.staticWait(3000);
	   
}
@Then("^I search the employee and ensure that it is searched using below values$")
public void i_search_the_employee_and_ensure_that_it_is_searched_using_below_values(
		DataTable searchEditedempinfoTable) throws Throwable {
	scenario.write("Searching theedited amp in the list");
	addEmployee.navigateToEmployeeList();
	addEmployee.searchEmployee(searchEditedempinfoTable.raw().get(0).get(1),
			searchEditedempinfoTable.raw().get(1).get(1), searchEditedempinfoTable.raw().get(2).get(1));
	WaitMethods.staticWait(5000);
	scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
}
@Then("^I select and Delete the Updated Employee and verify employee is not  in search result$")
public void i_select_and_Delete_the_Updated_Employee_and_verify_employee_is_not_in_search_result() throws Throwable {
	scenario.write("Deleting the searched employee !");
	addEmployee.deleteSearhedEmp();
	WaitMethods.staticWait(5000);
	scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
}

}