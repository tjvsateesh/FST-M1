package activity;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {
	 WebDriver driver;
	 
	    @BeforeClass
	    public void setUp() {

	        driver = new FirefoxDriver();
	        driver.get(" https://training-support.net/webelements/simple-form");
	        
	    }
	    
		
	    @DataProvider(name = "Events")
	    public static Object[][] signUpInfo() {
	        String filePath = "src/test/resources/Activity10_Data.xlsx";
	        List<List<String>> data = readExcel(filePath);
	        return new Object[][] { 
	            { data.get(1) },
	            { data.get(2) },
	            { data.get(3) }
	        };
	    }
	    
	    @Test(dataProvider = "Events")
	    public void registerTest(List<String> rows) throws InterruptedException {
	    	String name = rows.get(0);
	    	String email = rows.get(1);
	    	String date = rows.get(2).replaceAll("\"", "");
	    	String details = rows.get(3);
	    	
	        driver.findElement(By.id("full-name")).sendKeys(name);
	        driver.findElement(By.id("email")).sendKeys(email);
	        driver.findElement(By.name("event-date")).sendKeys(date);
	        driver.findElement(By.id("additional-details")).sendKeys(details);

	        driver.findElement(By.xpath("//button[text()='Submit']")).click();

	        String message = driver.findElement(By.id("action-confirmation")).getText();
	        assertEquals(message, "Your event has been scheduled!");

	        driver.navigate().refresh();
	    }
	    
		
	    public static List<List<String>> readExcel(String filePath) {
	        List<List<String>> data = new ArrayList<List<String>>();
	        try {
	            FileInputStream file = new FileInputStream(filePath);
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	            XSSFSheet sheet = workbook.getSheet("Data");
	            for (Row cells : sheet) {
	                List<String> rowData = new ArrayList<>();
	                for (Cell cell : cells) {
	                    rowData.add(cell.getStringCellValue());
	                }
	                data.add(rowData);
	            }
	            file.close();
	            workbook.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return data;
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        driver.close();
	    }
}
