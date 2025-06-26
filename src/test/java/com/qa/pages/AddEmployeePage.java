package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;
import junit.framework.Assert;


/**
 * @author HP page object repository
 *
 */
/**
 * @author HP
 *
 */
/**
 * @author HP
 *
 */
public class AddEmployeePage {

	WebDriver driver;
	Scenario scenario;
	
	/**
	 * Navigate to PIM Page
	 */
	@FindBy(xpath="//span[text()='PIM']")
	WebElement PIMPageLink;
	
	@FindBy(xpath="//span/child::h6[text()='PIM']")
	WebElement PIMPageTitle;
	
	/* *** addEmployee  */
	
	@FindBy(xpath="	//a[text()='Add Employee']")
	WebElement navigateToAddEmp;
	
	@FindBy(xpath="//h6[text()='Add Employee']")
	WebElement addempTitle;
	
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement empFirstName;
	
	@FindBy(xpath="//input[@name='middleName']")
	WebElement empMidName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement empLastName;
	

	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	
	/* Search added employee */
	
	@FindBy(xpath="//a[text()='Employee List']")
	WebElement navigateToEmployeeList;
	
	@FindBy(xpath="//label[text()='Employee Name']/following::input[1]")
	WebElement searchByElement;
	
	@FindBy(xpath="//button[text()=' Search ']")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/child::div[3]")
	WebElement searchedElement;
	
	// Delete the employee
	//button[text()=' Yes, Delete ']
	
	//Edit the employee
	
	@FindBy(xpath="//i[@class='oxd-icon bi-pencil-fill']")
	WebElement editEmployeeButton;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement updateEmpFname;
	
	@FindBy(xpath="//input[@placeholder='Middle Name']")
	WebElement updateEmpMname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement updateEmpLname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveUpdatedEmpButton;
	
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
	WebElement deleteButton;

	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	WebElement confirmDeleteButton;
		
	
	/**
	 * @param
	 * @param ---Page class constructor
	 */
	
	public AddEmployeePage(WebDriver driver,Scenario scenario)
	{
		this.driver=driver;
		this.scenario=scenario;
		PageFactory.initElements(driver, this);
		
	}
	
	
	/**
	 * @param updatedFname - update the employee data
	 * @param updatedMname
	 * @param updatedLname
	 */
	public void editEmployee(String updatedFname, String updatedMname, String updatedLname)
	{
		ElementActions.clickElement(driver, editEmployeeButton, scenario);
		WaitMethods.staticWait(5000);
		updateEmpFname.clear();
		ElementActions.sendKeys(driver, updateEmpFname, scenario, updatedFname);
		updateEmpMname.clear();
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, updateEmpMname, scenario, updatedMname);
		updateEmpLname.clear();
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, updateEmpLname, scenario, updatedLname);
		WaitMethods.staticWait(5000);
		ElementActions.clickElement(driver, saveUpdatedEmpButton, scenario);
		WaitMethods.staticWait(5000);
	}
	
	
	/**
	 *  search employee for that to navigate to employee list
	 */
	public void navigateToEmployeeList()
	{
		ElementActions.clickElement(driver, navigateToEmployeeList, scenario);
	}
	
	/**
	 * @param fname
	 * @param mname search employee
	 * @param lname
	 * @return
	 */
	public String searchEmployee(String fname,String mname,String lname)
	{
		ElementActions.sendKeys(driver, searchByElement, scenario, fname+" "+mname+" "+lname);
		ElementActions.clickElement(driver, searchButton, scenario);
		return ElementActions.getText(driver, searchedElement, scenario);
		
	}
	
	

	public String navigateToPIMPage()
	{
		ElementActions.clickElement(driver, PIMPageLink, scenario);
		return ElementActions.getText(driver,PIMPageTitle, scenario);
		
	}
	
	/**
	 * @return Navigate Add employee 
	 */
	public String navigateToAddEmployee()
	{
		ElementActions.clickElement(driver, navigateToAddEmp, scenario);
		return ElementActions.getText(driver, addempTitle, scenario);
		
	}
	
	// Delete search employee

	public void deleteSearhedEmp() {

		ElementActions.clickElement(driver, deleteButton, scenario);
		ElementActions.clickElement(driver, confirmDeleteButton, scenario);

	}
	
	/**
	 * @param Add FName
	 * @param Add MName
	 * @param Add lName on add employee page
	 * @return 
	 */
	public String addEmployee(String FName, String MName,String lName)
	{
		ElementActions.sendKeys(driver, empFirstName, scenario, FName);
		ElementActions.sendKeys(driver, empMidName, scenario, MName);
		ElementActions.sendKeys(driver, empLastName, scenario, lName);
		ElementActions.clickElement(driver, saveButton, scenario);
		return lName;
		
		
	}
}
