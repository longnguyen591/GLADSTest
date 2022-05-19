package ngf.glads.qa.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ngf.glads.qa.base.TestBase;
import ngf.glads.qa.util.CommonActions;
import ngf.glads.qa.util.JavaScriptUtil;

public class HomePage extends TestBase {

	// This page stores all the elements and their associated actions in the Home
	// Page

	By UdopMgtLink = By.cssSelector("a[href='#scenarios']");		
	By ChecklistMgtLink = By.cssSelector("a[href='#checklist']");		
	By DataMngtLink = By.cssSelector("a[href='#data']");
	By UserMngtLink = By.cssSelector("a[href='#user']");
	
	By AccountMenudropDwn = By.id("userProfileTag");

	By addUdoptemplateIcon = By
			.cssSelector("i.icon.icon-PlusCircle-o.icon-button.fontIcon--large.ScenarioManagementHeader-button");
	By UdopDetailsPanel = By
			.cssSelector("div.ScenarioManagementDetailsData.InfoPanel-content");
	By coreLayersBtn = By
			.cssSelector("i.icon.icon-CoreLayers.icon-button.fontIcon--large.ScenarioManagementHeader-button");
	By templateNameField = By.cssSelector("input.ScenarioDetailsName-input");
	By deleteIcon = By.cssSelector("stk-icon[title='Delete']");
	By templateOwnerField = By.cssSelector("span.AutoComplete-Label");
	// auto-complete[data-bind='t: {title: ownerAutoCompleteTooltip()}']");
	
	By templateOwnerIcon = By.cssSelector("stk-icon.ScenarioManagementDetailsData-editableIcon");

	By publishTemplateIcon = By.cssSelector("span[data-bind='t: statusActionToTake()']");
	By saveTemplateIcon = By.cssSelector("a#saveScenarioDetailsButton");
	By exitUdopDetailsIcon = By.id("closeScenarioManagementDetails");

	By searchUdop = By.cssSelector("input[placeholder='Search All UDOPs']");
	By Helpcontent = By.xpath("//*[contains(text(),'Help')]");
	By AboutSoftware = By.xpath("//*[contains(text(),'About Software')]");
	By closeAboutSoftware = By.cssSelector("div.button.button--primarySubmit");
	By serverVersion = By.cssSelector("div.InfoPanel-content.AboutSoftware-VersionContent");
	By ownerManager = By.cssSelector("li[title='glads manager']");

	By Logout = By.xpath("//*[contains(text(),'Log Out')]");
	By editUdopIcon = By.cssSelector("a.TableRow-darkLink.EditScenarioProperties");
	By globeIcon = By.cssSelector("i.icon.icon-Globe.icon-button.fontIcon--medium-large");
	By templatePageTitle = By.cssSelector("span[data-bind='text: pageTitle()']");
	By acceptDelete = By.cssSelector("div.button.button--primarySubmit.ok");
	By errorMessage = By.cssSelector("div.toast.toast-error");
	By contextMenu = By.cssSelector("div.ContextMenu");
	By ownerMultiGroup = By.cssSelector("li[title='glads multiGroup']");
			//By.xpath("//*[@class='AutoComplete-Suggestions']//following::li[5]");
	By placeholder = By.cssSelector("input[placeholder='Search for a user']");

	By ownerStatus = By.cssSelector("div[data-bind='text: ownedBy, t: {title: ownedBy()}']");
	By templateDescField = By.cssSelector("span.ScenarioManagementDetailsData-Form--label");
	By descFieldTextarea = By.cssSelector("textarea[placeholder='Add description here']");
	By templateTable = By.cssSelector("div.scenarioTemplates");
	By addInstanceButton = By.id("addInstanceButton");
	By instancePanel = By
			.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/scenario-management-table/div/div[2]/div[2]");
	By instanceNameField = By.cssSelector("input.ScenarioDetailsName-input");
	By instanceOwnerField = By.cssSelector("div#scenarioDetailsOwner");
	By exitSearchbox = By.cssSelector("i.icon.icon-X.icon-button.fontIcon--small");
	By ownerOperator = By.cssSelector("li[title='glads operator']");
	By editInstanceIcon = By.xpath(
			"/html/body/div[1]/div[1]/div/div/div/div/div/div/scenario-management-table/div/div[2]/div[1]/scenario-management-expandable-row[1]/div/div[2]/scenario-management-row/div/scenario-management-actions/div/a[1]/stk-icon");
	By tableRow = By.cssSelector("div.TableRow.expanded.row");
	By clearOwnerIcon = By.cssSelector("span.AutoComplete-ClearIcon");
	By instanceOwnerIcon = By.cssSelector("div[data-bind='click: editOwnerField']");
	By instanceGlobeIcon= By.cssSelector("stk-icon[title='Edit UDOP']");

	CommonActions action;
	WebDriver driver;
	Properties prop;
	JavaScriptUtil jsUtil;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		action = new CommonActions(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	public boolean UdopLink() {
		boolean UdopTab = true;
		try {
		UdopTab = action.isDisplayed(UdopMgtLink);
		if (UdopTab = true) 
			action.doClick(UdopMgtLink);
		}
		 catch (Exception e) {
			 System.out.println("Udop tab is not available");

		}
		return UdopTab;
	}

	
	public boolean ChecklistLink() {
		boolean ChecklistTab = true;
		try {
			ChecklistTab = action.isDisplayed(ChecklistMgtLink);
			if (ChecklistTab = true) 
				action.doClick(ChecklistMgtLink);
		}
			catch (Exception e)  {
				System.out.println("Checklist tab is not available");
				
		}
		return ChecklistTab;
	}

	public boolean DataLink() {
		boolean DataTab = true;
		try {
			DataTab = action.isDisplayed(DataMngtLink);
			if (DataTab = true)
				action.doClick(DataMngtLink);
		} catch(Exception e) {
			System.out.println("Data Management tab is not available");
		}

		return DataTab;
	}

	
	public boolean UserMngtLink() {
		boolean UserTab = true;
		try {
			UserTab = action.isDisplayed(UserMngtLink);
			if (UserTab = true) 
				action.doClick(UserMngtLink);
			}
		 catch(Exception e){
			 System.out.println("User Management tab is not available");
		}
		return UserTab;
	}

	
	public boolean AcctOptmenu() {
		action.doClick(AccountMenudropDwn);
		boolean acctMenu = action.isDisplayed(contextMenu);
		return acctMenu;

	}

	public boolean addUdopIcon() {
		action.doClick(addUdoptemplateIcon);
		boolean detailspanel = action.waitForElementPresent(UdopDetailsPanel);
		return detailspanel;
	}

	// @SuppressWarnings("deprecation")
	public String addTemplate_withOwner() throws InterruptedException {
		addUdopIcon();
		// jsUtil.sendKeysUsingJSWithElement(action.getElement(templateNameField),
		// "created by automation");
		action.doSendKeys(templateNameField, "created by automation");
		Thread.sleep(1000);
		action.doClick(publishTemplateIcon);
		action.doClick(templateOwnerField);
		action.doClear(placeholder);
		action.doSendKeys(placeholder, "glads");
		// jsUtil.clickElementByJS(action.getElement(ownerManager));
		action.doClick(ownerMultiGroup);
		Thread.sleep(1000);
		String owner = action.doGetText(templateOwnerField);
		System.out.println("Template's owner: " + owner);
		//action.doClick(saveTemplateIcon);
		action.doClick(exitUdopDetailsIcon);
		return owner;

	}

	public String addTemplate_noOwner() throws InterruptedException {
		addUdopIcon();
		action.doSendKeys(templateNameField, "test template");
		action.doClick(publishTemplateIcon);
		action.doClick(templateOwnerField);
		action.doClick(saveTemplateIcon);
		action.doClick(exitUdopDetailsIcon);
		String ownerstatus = action.doGetText(ownerStatus);
		System.out.println("Successfully added template without owner " + ownerstatus);
		return ownerstatus;
	}

	
	public boolean deleteTemplate() throws InterruptedException {
		action.doClick(editUdopIcon);
		action.doClick(deleteIcon);
		action.doClick(acceptDelete);
		try {
			if (action.isDisplayed(errorMessage)) {
				String errormessage = action.doGetText(errorMessage);
				System.out.println(
						"Manager cannot delete template owned by another manager: " + "\"" + errormessage + "\"");
			
				action.doClick(editUdopIcon);
				action.doClick(templateOwnerField);
				action.doClear(placeholder);
				jsUtil.clickElementByJS(action.getElement(clearOwnerIcon));
				
				Thread.sleep(2000);
				action.doClick(deleteIcon);
				action.doClick(acceptDelete);

			}		

		} catch (Exception e) {
			System.out.println("Successfully changed ownership and deleted template");
		}

		return true;
	}

	public String editTemplateOwner() throws InterruptedException {
		action.doClick(editUdopIcon);

		String owner = action.doGetText(templateOwnerField);
		System.out.println("Previous template's owner: " + owner);
		String newOwner;

		if (owner.contains("manager")) {
			action.doClick(templateOwnerField);
			action.doClear(placeholder);
			Thread.sleep(1000);
			action.doSendKeys(placeholder, "glads");
			// jsUtil.sendKeysUsingJSWithElement(action.getElement(placeholder),
			// "multigroup");
			action.doClick(ownerMultiGroup);
			Thread.sleep(1000);
			newOwner = action.doGetText(templateOwnerField);
			System.out.println("changed ownership to: " + newOwner);
		}

		else if (owner.contains("multiGroup")) {
			action.doClick(templateOwnerField);
			action.doClear(placeholder);
			Thread.sleep(1000);
			action.doSendKeys(placeholder, "glads");
			Thread.sleep(1000);
			jsUtil.clickElementByJS(action.getElement(ownerManager));
			// action.doClick(ownerManager);
			newOwner = action.doGetText(templateOwnerField);
			System.out.println("changed ownership to: " + newOwner);

		} else {
			action.doClick(templateOwnerField);
			action.doClear(placeholder);
			Thread.sleep(1000);
			action.doClick(publishTemplateIcon);
			Thread.sleep(1000);
			newOwner = action.doGetText(templateOwnerField);
			System.out.println("changed ownership to: " + newOwner);
		}

		action.doClick(exitUdopDetailsIcon);

		return newOwner;

	}

	public String Helpcontent() throws InterruptedException {
		action.doClick(AccountMenudropDwn);
		action.doClick(Helpcontent);
		String mainTab = driver.getWindowHandle();

		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(mainTab)) {
				driver.switchTo().window(tab);
			}
		}
		String helpPageTitle = driver.getTitle();
		System.out.println("Help page title is " + helpPageTitle);
		driver.close();

		for (String tab : driver.getWindowHandles()) {
			if (!mainTab.equals(tab)) {
				driver.switchTo().window(mainTab);
			}
		}

		Thread.sleep(1000);
		return helpPageTitle;

	}

	public String AboutSoftware() {
		action.doClick(AccountMenudropDwn);
		action.doClick(AboutSoftware);
		String version = action.doGetText(serverVersion);
		System.out.println(version);
		action.doClick(closeAboutSoftware);
		return version;

	}

	public String enterUdopTemplate_owner() throws InterruptedException {
		action.doClick(globeIcon);
		action.waitForElementPresent(templatePageTitle);
		Thread.sleep(3000);
		String template = action.doGetText(templatePageTitle);
		System.out.println("Successfully entered " + "\"" + template + "\"");

		return template;
	}

	public boolean searchTemplate() throws InterruptedException {
		String desc1 = "UDOP description 1";
		String desc2 = "UDOP description 2";
		String template1 = "test1";
		String template2 = "test2";
		String searchdesc = "description";
		addUdopIcon();
		action.doSendKeys(templateNameField, template1);
		action.doClick(templateDescField);
		// jsUtil.clickElementByJS(action.getElement(templateDescField));
		// jsUtil.sendKeysUsingJSWithElement(action.getElement(descFieldTextarea),
		// template1);
		action.doSendKeys(descFieldTextarea, desc1);
		action.doClick(publishTemplateIcon);
		action.doClick(saveTemplateIcon);
		action.doClick(exitUdopDetailsIcon);

		addUdopIcon();
		action.doSendKeys(templateNameField, template2);
		action.doClick(templateDescField);
		action.doSendKeys(descFieldTextarea, desc2);
		action.doClick(publishTemplateIcon);
		action.doClick(saveTemplateIcon);
		action.doClick(exitUdopDetailsIcon);

		Thread.sleep(1000);
		action.doClick(searchUdop);
		action.doSendKeys(searchUdop, searchdesc);
		boolean result = action.waitForTextPresentInElement(templateTable, desc1);
		action.doClick(exitSearchbox);

		return result;

	}

	public String createInstance() throws InterruptedException {
		action.doClick(editUdopIcon);
		action.doClick(addInstanceButton);
		action.isDisplayed(instancePanel);
		action.waitForElementPresent(instancePanel);
		jsUtil.clickElementByJS(action.getElement(instanceNameField));
		action.doSendKeys(instanceNameField, "test instance");
		Thread.sleep(1000);
		jsUtil.clickElementByJS(action.getElement(instanceOwnerIcon));
		action.doClear(placeholder);
		action.doSendKeys(placeholder, "glads");
		action.waitForElementPresent(ownerMultiGroup);
		action.doClick(ownerMultiGroup);
		String instanceOwner = action.doGetText(placeholder);
		action.doClick(exitUdopDetailsIcon);
		//action.doClick(saveTemplateIcon);
		/*action.doClick(AccountMenudropDwn);
		action.doClick(Logout);*/

		return instanceOwner;
	}

	@SuppressWarnings("unused")
	public boolean editInstance() throws InterruptedException {
		boolean instanceicon;

		if (instanceicon = action.isDisplayed(editInstanceIcon)) {
			action.doClick(editInstanceIcon);

		} else {
			action.doClick(tableRow);
			action.doClick(editInstanceIcon);
		}

		action.waitForElementPresent(instancePanel);
		jsUtil.clickElementByJS(action.getElement(instanceNameField));
		action.doSendKeys(instanceNameField, "change instance name");

		String owner = action.doGetText(instanceOwnerField);
		System.out.println("Previous instance's owner: " + owner);
		String newOwner;

		if (owner.contains("multiGroup")) {
			action.doClick(instanceOwnerField);
			action.doClear(placeholder);
			action.doSendKeys(placeholder, "glads");
			action.doClick(ownerOperator);
			newOwner = action.doGetText(instanceOwnerField);
			System.out.println("changed ownership to: " + newOwner);
		}

		else if (owner.contains("operator")) {
			action.doClick(instanceOwnerField);
			action.doClear(placeholder);
			action.doSendKeys(placeholder, "glads");
			action.doClick(ownerMultiGroup);
			newOwner = action.doGetText(instanceOwnerField);
			System.out.println("changed ownership to: " + newOwner);

		} else {
			action.doClick(instanceOwnerIcon);
			action.doClear(placeholder);
			Thread.sleep(1000);
			newOwner = action.doGetText(instanceOwnerField);
			System.out.println("changed ownership to: " + newOwner);
		}

		action.doClick(exitUdopDetailsIcon);

		return true;

	}

	public boolean managerEditInstanceOwner() {
		action.doClick(tableRow);
		action.doClick(editInstanceIcon);
		action.waitForElementPresent(instancePanel);
		String owner = action.doGetText(instanceOwnerField);
		System.out.println("Previous instance's owner: " + owner);
		String newOwner;

		if (owner.contains("multiGroup")) {
			action.doClick(instanceOwnerField);
			action.doClear(placeholder);
			action.doSendKeys(placeholder, "glads");
			action.doClick(ownerOperator);
			newOwner = action.doGetText(instanceOwnerField);
			System.out.println("changed ownership to: " + newOwner);
		}

		else if (owner.contains("operator")) {
			action.doClick(instanceOwnerField);
			action.doClear(placeholder);
			action.doSendKeys(placeholder, "glads");
			action.doClick(ownerMultiGroup);
			newOwner = action.doGetText(instanceOwnerField);
			System.out.println("changed ownership to: " + newOwner);

		}
		action.doClick(exitUdopDetailsIcon);

		return true;

	}

	@SuppressWarnings("unused")
	public boolean deleteInstance() {
		boolean instanceicon;
		boolean deleteInstanceIcon;

		if (instanceicon = action.isDisplayed(editInstanceIcon)) {
			action.doClick(editInstanceIcon);

		} else {
			action.doClick(tableRow);
			action.doClick(editInstanceIcon);
		}

		//action.waitForElementPresent(instancePanel);
		String owner = action.doGetText(instanceOwnerField);

		if (owner.equalsIgnoreCase("glads multigroup")) {
			deleteInstanceIcon = action.isDisplayed(deleteIcon);
			action.doClick(deleteIcon);
			action.doClick(acceptDelete);
		}

		else {
			deleteInstanceIcon = false;
			action.doClick(exitUdopDetailsIcon);
		}

		return true;
	}
	
	
	
	public void enterUdopInstance() throws InterruptedException {
		createInstance();
		action.doClick(instanceGlobeIcon);
		
	}

}