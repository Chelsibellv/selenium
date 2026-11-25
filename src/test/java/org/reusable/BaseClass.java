	package org.reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static Select s;
	public static Actions act;
	public static WebDriverWait wait;
    public static JavascriptExecutor js;
    public static Alert a;
	
	// WebDriver Methods
    
    public static void launchBrowser() {
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    }

    public static void closeBrowser() {
    	driver.close();
    }

    public static void quitBrowser() {
    	driver.quit();
    }

    public static void minimizeWindow() {
    	driver.manage().window().minimize();
    }

    public static void launchUrl(String url) {
    	driver.get(url);
    }

    public static void navigateBack() {
    	driver.navigate().back();
    }

    public static void navigateFront() {
    	driver.navigate().forward();
    }

    public static void refreshPage() {
    	driver.navigate().refresh();
    }
    
    // WebElement Methods

    public static void sendKeys(WebElement ele, String data) {
        ele.sendKeys(data);
    }

    public static void click(WebElement ele) {
        ele.click();
    }

    public static void clear(WebElement ele) {
        ele.clear();
    }
    
    public static String getText(WebElement ele) {
        return ele.getText();
    }
	
    // Alert Methods

    public static void acceptAlert() {
        a=driver.switchTo().alert();
        a.accept();
    }

    public static void dismissAlert() {
        a=driver.switchTo().alert();
        a.dismiss();
    }

    public static void sendKeysAlert(String data) {
        a=driver.switchTo().alert();
        a.sendKeys(data);
    }
	
    // Select Methods

    public static void selectByText(WebElement ele, String text) {
        s = new Select(ele);
        s.selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement ele, int index) {
        s = new Select(ele);
        s.selectByIndex(index);
    }

    public static void selectByValue(WebElement ele, String value) {
        s = new Select(ele);
        s.selectByValue(value);
    }

    public static void deselectByText(WebElement ele, String text) {
        s = new Select(ele);
        s.deselectByVisibleText(text);
    }

    public static void deselectByIndex(WebElement ele, int index) {
        s = new Select(ele);
        s.deselectByIndex(index);
    }

    public static void deselectByValue(WebElement ele, String value) {
        s = new Select(ele);
        s.deselectByValue(value);
    }

    public static void deselectAll(WebElement ele) {
        s = new Select(ele);
        s.deselectAll();
    }
    
    // Frame Methods

    public static void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public static void switchToFrame(String idOrName) {
        driver.switchTo().frame(idOrName);
    }

    public static void switchToFrame(WebElement ele) {
        driver.switchTo().frame(ele);
    }

    public static void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

	// Wait Methods

    public static void waitForVisibility(WebElement element, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickability(By locator, int seconds) {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    	 wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForInvisibility(By locator, int seconds) {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    	 wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForAlert(int seconds) {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    	wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void implicitWait(int seconds) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static void pageLoadTimeout(int seconds) {
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }
    
    public static void fluentWaitForVisibility(By locator, int seconds) {
        FluentWait<WebDriver> fw = new FluentWait<>(driver);
        fw.withTimeout(Duration.ofSeconds(seconds));
        fw.pollingEvery(Duration.ofSeconds(2));
        fw.ignoring(Throwable.class);

        fw.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void fluentWaitForClickability(By locator, int seconds) {
        FluentWait<WebDriver> fw = new FluentWait<>(driver);
        fw.withTimeout(Duration.ofSeconds(seconds));
        fw.pollingEvery(Duration.ofSeconds(2));
        fw.ignoring(Throwable.class);

        fw.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
	// Actions Methods

    public static void mouseHover(WebElement ele) {
    	act = new Actions(driver);
    	act.moveToElement(ele).perform();
    }

    public static void dragAndDrop(WebElement source, WebElement target) {
    	act = new Actions(driver);
    	act.dragAndDrop(source, target).perform();
    }

    public static void doubleClick(WebElement ele) {
    	act = new Actions(driver);
    	act.doubleClick(ele).perform();
    }

    public static void rightClick(WebElement ele) {
    	act = new Actions(driver);
    	act.contextClick(ele).perform();
    }

    public static void clickAndHold(WebElement ele) {
    	act = new Actions(driver);
    	act.clickAndHold(ele).perform();
    }

    public static void release(WebElement ele) {
    	act = new Actions(driver);
    	act.release(ele).perform();
    }

    public static void actionsSendKeys(String data) {
    	act = new Actions(driver);
    	act.sendKeys(data).perform();
    }
    
    // JavaScriptExecutor Methods

    public static void jsClick(WebElement ele) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", ele);
    }

    public static void scrollToElement(WebElement ele) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
    }

    public static void scrollDown() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }

    public static void scrollUp() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500)");
    }

    public static void scrollToBottom() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToTop() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }

    public static void jsSendKeys(WebElement ele, String data) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", ele, data);
    }
    public static String getAttribute(WebElement ele, String data) {
        js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].getAttribute(arguments[1])", ele, data);
    }
    
    // Screenshot Methods
    
    public static void takesSnap(String name) throws IOException {
    	TakesScreenshot t=(TakesScreenshot)driver;
        File temp = t.getScreenshotAs(OutputType.FILE);
        File target = new File("C:\\Users\\chelsi bell\\eclipse-workspace\\BellMaven\\Images"+name+".png");
        FileUtils.copyFile(temp, target);
    }
	
    //webHandling Methods
    public static String getWindowHandle () {
    	return driver.getWindowHandle();
    }
    
    public static Set<String> getWindowHangles(){
    	return driver.getWindowHandles();
    }
    
    public static void switchToWindow (String id) {
    	driver.switchTo().window(id);
    }
    
    //dataDriven Methods
    
    public static String getFromExcel (String sheetName,int r,int c) throws IOException {
    	File f=new File("C:\\Users\\chelsi bell\\eclipse-workspace\\TestNG\\ExcelFiles\\Adactin data1.xlsx");
    	FileInputStream file=new FileInputStream(f);
    	Workbook book = new XSSFWorkbook(file);
    	Sheet sht = book.getSheet(sheetName);
    	Row rw = sht.getRow(r);
    	Cell cl = rw.getCell(c);
    	int type = cl.getCellType();
    	
    	String value="";
    	if(type==1) {
    		value=cl.getStringCellValue();
    	}
    	else if(DateUtil.isCellDateFormatted(cl)) {
    		Date date=cl.getDateCellValue();
    		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
    		value=sdf.format(date);	
    	}
    	else {
    		double dd=cl.getNumericCellValue();
    		long l=(long)dd;
    		value =String.valueOf(1);
    	}
    	return value;
    	
    }
    
  //write data into Excel


    public static String writeToExcel(String sheetName, int r, int c, String data) throws IOException {

        File f = new File("C:\\Users\\chelsi bell\\eclipse-workspace\\TestNG\\ExcelFiles\\Adactin data1.xlsx");

        Workbook book = new XSSFWorkbook();

        Sheet sht = book.createSheet(sheetName);

        Row rw = sht.createRow(r);

        Cell cl = rw.createCell(c);

        cl.setCellValue(data);

        FileOutputStream fo = new FileOutputStream(f);

        book.write(fo);
        
		return data;

        
    }
    
    // update cell
    
    public static String updateExcel(String sheetName, int r, int c, String data) throws IOException {

        File f = new File("C:\\Users\\chelsi bell\\eclipse-workspace\\TestNG\\ExcelFiles\\Adactin data1.xlsx");

        FileInputStream fin = new FileInputStream(f);

        Workbook book = new XSSFWorkbook(fin);

        Sheet sht = book.getSheet(sheetName);

        Row rw = sht.getRow(r);

        Cell cl = rw.getCell(c);

        cl.setCellValue(data);

        FileOutputStream fo = new FileOutputStream(f);

        book.write(fo);
		return data;

    }
  
    
}
