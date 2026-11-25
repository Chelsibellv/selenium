package org.stepdefinition;


import org.reusable.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClass {
	
	@Before
	private void precon() {
		launchBrowser();
		launchUrl("https://www.lvly.com.au/");
	}
	@After
	private void poscon() {
		driver.close();
	}
}
