package OlympicsMedals;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
	
		  WebDriver driver;

		  @BeforeClass
		  public void setUp() {
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();

		  }

		  @Test
		  public void SortTest() {
		    String url = "https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table";
		    driver.navigate().to(url);
		    List<WebElement> firstColumn = driver.findElements(
		        By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]"));
		    List<Integer> actualRanking = new ArrayList();

		    for (int i = 0; i < firstColumn.size() - 1; i++) {
		      actualRanking.add(Integer.parseInt(firstColumn.get(i).getText()));
		    }

		    List<Integer> expectedRanking = new ArrayList<Integer>(actualRanking);
		    Collections.sort(expectedRanking);

		    assertEquals(actualRanking, expectedRanking);

		    driver.findElement(By.xpath("//table/thead/tr//th[.='NOC']")).click();

		    List<WebElement> nOC = driver.findElements(
		        By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
		    List<String> actualNOCRanking = new ArrayList<String>();

		    for (WebElement webElement : nOC) {
		      actualNOCRanking.add(webElement.getText());
		    }

		    List<String> expectedNOCRanking = new ArrayList<String>(actualNOCRanking);
		    Collections.sort(expectedNOCRanking);

		    assertEquals(actualNOCRanking, expectedNOCRanking);

		    firstColumn = driver.findElements(
		        By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]"));
		    actualRanking = new ArrayList();

		    for (int i = 0; i < firstColumn.size() - 1; i++) {
		      actualRanking.add(Integer.parseInt(firstColumn.get(i).getText()));
		    }

		    expectedRanking = new ArrayList<Integer>(actualRanking);
		    Collections.sort(expectedRanking);

		    assertNotEquals(actualRanking, expectedRanking);
		  }

		  @Test
		  public void TheMost() throws InterruptedException {
		    String url = "https://en.wikipedia.org/wiki/2016_Summer_Olympics";
		    driver.get(url);
		    System.out.println("Country with Most Gold Medals: " + goldMedals());
		    System.out.println("Country with Most Silver Medals: " + silverMedals());
		    System.out.println("Country with Most Bronze Medals: " + bronzeMedals());
		    System.out.println("Country with Most Medals Overall: " + mostMedalsOverall());

		    assertEquals(goldMedals(), " United States (USA)");
		    assertEquals(silverMedals(), " United States (USA)");
		    assertEquals(bronzeMedals(), " United States (USA)");
		    assertEquals(mostMedalsOverall(), " United States (USA)");
		  }

		  @Test
		  public void COUNTRY_BY_MEDAL() throws InterruptedException {
		    driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics");
		    
		    assertTrue(silverEqual18());
		  }
		  
		  @Test
		  public void GET_INDEX() throws InterruptedException {
		    String url = "https://en.wikipedia.org/wiki/2016_Summer_Olympics";
		    driver.get(url);
		  String actual=  returnRowCol(" Japan (JPN)");
		  String expected="(6,2)";
		  assertEquals(actual, expected);
		  }
		  
		  
		  @Test
		  public void GET_SUM() {
		    
		  }

		  @AfterClass
		  public void tearDown() {
		    driver.close();
		  }

		  public String goldMedals() throws InterruptedException {

		    Thread.sleep(1000);

		    List<WebElement> actualGold = driver.findElements(
		        By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr)/td[2]"));
		    List<WebElement> names = driver.findElements(
		        By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));

		    WebElement max;

		    if (!actualGold.isEmpty())
		      max = actualGold.get(0);
		    else
		      return null;

		    for (int i = 0; i < actualGold.size() - 1; i++) {
		      WebElement each = actualGold.get(i);

		      if (Integer.parseInt(each.getText().trim()) > Integer.parseInt(max.getText().trim())) {
		        max = each;
		      }
		    }

		    int maxi = actualGold.indexOf(max);
		    System.out.println("Gold: " + max.getText() + " ");

		    return names.get(maxi).getText();

		  }

		  public String silverMedals() throws InterruptedException {

		    Thread.sleep(1000);

		    List<WebElement> actualGold = driver.findElements(
		        By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr)/td[3]"));
		    List<WebElement> names = driver.findElements(
		        By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));

		    WebElement max;

		    if (!actualGold.isEmpty())
		      max = actualGold.get(0);
		    else
		      return null;

		    for (int i = 0; i < actualGold.size() - 1; i++) {
		      WebElement each = actualGold.get(i);

		      if (Integer.parseInt(each.getText().trim()) > Integer.parseInt(max.getText().trim())) {
		        max = each;
		      }
		    }

		    int maxi = actualGold.indexOf(max);

		    System.out.println("Silver: " + max.getText() + " ");
		    return names.get(maxi).getText();

		  }

		  public String bronzeMedals() throws InterruptedException {

		    Thread.sleep(1000);

		    List<WebElement> actualGold = driver.findElements(
		        By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr)/td[4]"));
		    List<WebElement> names = driver.findElements(
		        By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));

		    WebElement max;

		    if (!actualGold.isEmpty())
		      max = actualGold.get(0);
		    else
		      return null;

		    for (int i = 0; i < actualGold.size() - 1; i++) {
		      WebElement each = actualGold.get(i);

		      if (Integer.parseInt(each.getText().trim()) > Integer.parseInt(max.getText().trim())) {
		        max = each;
		      }
		    }

		    int maxi = actualGold.indexOf(max);
		    System.out.println("Bronze: " + max.getText() + " ");

		    return names.get(maxi).getText();

		  }

		  public String mostMedalsOverall() throws InterruptedException {
		    Thread.sleep(1000);

		    List<WebElement> actualGold = driver.findElements(
		        By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr)/td[5]"));
		    List<WebElement> names = driver.findElements(
		        By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));

		    WebElement max;

		    if (!actualGold.isEmpty())
		      max = actualGold.get(0);
		    else
		      return null;

		    for (int i = 0; i < actualGold.size() - 1; i++) {
		      WebElement each = actualGold.get(i);

		      if (Integer.parseInt(each.getText().trim()) > Integer.parseInt(max.getText().trim())) {
		        max = each;
		      }
		    }

		    int maxi = actualGold.indexOf(max);
		    System.out.println("Overall: " + max.getText() + " ");

		    return names.get(maxi).getText();

		  }

		  public boolean silverEqual18() throws InterruptedException {
		    Thread.sleep(1000);

		    List<WebElement> actualGold = driver.findElements(
		        By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr)/td[3]"));
		    List<WebElement> names = driver.findElements(
		        By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
		    List<String> result = new ArrayList<String>();

		    WebElement max;

		    for (int i = 0; i < actualGold.size() - 1; i++) {
		      WebElement each = actualGold.get(i);

		      if (Integer.parseInt(each.getText().trim()) == 18) {
		        result.add(names.get(actualGold.indexOf(each)).getText());
		      }
		    }
		    
		    List<String> expected = Arrays.asList(" China (CHN)", " France (FRA)");
		    for (int i = 0; i < result.size(); i++) {
		      if (!result.get(i).equals(expected.get(i))) {
		        return false;
		      }
		    }
		    return true;

		  }
		  
		  public String returnRowCol(String temp) throws InterruptedException{
		    Thread.sleep(1000);
		    List <WebElement> list=driver.findElements(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th)"));
		    
		    for (int i=0; i<list.size();i++) {
		      if(list.get(i).getText().equals(temp))
		    return "("+(i+1)+",2)";
		    }
		    return null;
		  }
		  
//		  public List<String> bronzeSum18(){
//		    Thread.sleep(1000);
//
//		    List<WebElement> actualGold = driver.findElements(
//		        By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr)/td[4]"));
//		    List<WebElement> names = driver.findElements(
//		        By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
//		    List<String> result = new ArrayList<String>();
//
//		    WebElement max;
//
//		    for (int i = 0; i < actualGold.size() - 1; i++) {
//		      WebElement each = actualGold.get(i);
//		      
//		      for (int j= 1; j < actualGold.size() - 1; j++) {
//		        WebElement each2 = actualGold.get(j);
//		        if (Integer.parseInt(each.getText().trim()) == 18) {
//		        result.add(names.get(actualGold.indexOf(each)).getText());
//		      }
//		    }}
//		    
//		    List<String> expected = Arrays.asList(" China (CHN)", " France (FRA)");
//		    for (int i = 0; i < result.size(); i++) {
//		      if (!result.get(i).equals(expected.get(i))) {
//		        return false;
//		      }
//		    }
//		    return true;    
//		  }
//		  
//		}


}
