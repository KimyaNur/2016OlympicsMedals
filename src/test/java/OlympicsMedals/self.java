 package OlympicsMedals;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class self {

	//hello 
	
	WebDriver driver;
	Map<String,Integer> map=new HashMap<>();
	int max=0;
	

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void setUpMethod() {
		driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics");
	}

	@Test(priority = 1)
	public void sortTest() {
		driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");
		List<WebElement> original = driver.findElements(
				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[1]"));
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < original.size() - 1; i++) {
			list.add(Integer.parseInt(original.get(i).getText()));}

		SortedSet<Integer> expected = new TreeSet<>(list);
		assertEquals(list, expected);

		driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead/tr/th[2]")).click();

		List<WebElement> names = driver.findElements(
				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th/a"));
		List<String> name = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			name.add(names.get(i).getText());}

		SortedSet<String> expectedName = new TreeSet<>(name);
		assertEquals(name, expectedName);

		List<WebElement> newRank = driver.findElements(
				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[1]"));
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < newRank.size() - 1; i++) {
			list.add(Integer.parseInt(newRank.get(i).getText()));}
		assertNotEquals(list, list2);
	}

	@Test(priority = 2)
	public void theMost() {
       System.out.println("gold "+goldMost());
       System.out.println("silver "+silverMost());
       System.out.println("bronze "+bronzeMost());
       System.out.println("the most "+TheMost());
       
       String s=driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th//a[1]")).getText();
       assertEquals(s, goldMost());
       assertEquals(s, silverMost());
       assertEquals(s, bronzeMost());
       assertEquals(s, TheMost());
	}
	
	@Test(priority = 3)
	public void silverEqual18() {
		System.out.println(silver18());
		String s=driver.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th//a)[3]")).getText();
		String s2=driver.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th//a)[7]")).getText();
		assertEquals(s+" "+s2, silver18());
		
	}
	@Test(priority = 4)
	public void rowColumn() {
		System.out.println(rowCol("Japan"));
		assertEquals("6 2",rowCol("Japan"));
	}

	@Test(priority = 5)
	public void bronzeEqual18() {
		System.out.println(bronze18());
		assertEquals( "Italy Australia",bronze18());
	}

	public String goldMost() {
		  
		List<WebElement> gold=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[2]"));
		List<WebElement> names = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th/a"));
		for(int i=0; i<gold.size()-1; i++) {
			map.put( names.get(i).getText(),Integer.parseInt(gold.get(i).getText()));
		}
		String str="";
		System.out.println(map);
		max=Collections.max(map.values());
		for (Entry<String, Integer> each : map.entrySet()) {
			if (each.getValue() == max) {
				str = each.getKey();
			}
		}
		return str;
	}

	public String silverMost() {
		List<WebElement> silver=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[3]"));
		List<WebElement> names = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th/a"));
		for(int i=0; i<silver.size()-1; i++) {
			map.put( names.get(i).getText(),Integer.parseInt(silver.get(i).getText()));
		}String str="";
		System.out.println(map);
		max=Collections.max(map.values());
		for (Entry<String, Integer> each : map.entrySet()) {
			if (each.getValue() == max) {
				str = each.getKey();
			}
		}
		return str;
	}

	public String bronzeMost() {
		List<WebElement> bronze=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[4]"));
		List<WebElement> names = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th/a"));
		for(int i=0; i<bronze.size()-1; i++) {
			map.put( names.get(i).getText(),Integer.parseInt(bronze.get(i).getText()));
		}String str="";
		System.out.println(map);
		max=Collections.max(map.values());
		for (Entry<String, Integer> each : map.entrySet()) {
			if (each.getValue() == max) {
				str = each.getKey();
			}
		}
		return str;
	}
	
	public String TheMost() {
		List<WebElement> most=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[4]"));
		List<WebElement> names = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th/a"));
		for(int i=0; i<most.size()-1; i++) {
			map.put( names.get(i).getText(),Integer.parseInt(most.get(i).getText()));
		}String str="";
		System.out.println(map);
		max=Collections.max(map.values());
		for (Entry<String, Integer> each : map.entrySet()) {
			if (each.getValue() == max) {
				str = each.getKey();
			}
		}
		return str;
	}
	
	public String silver18() {
		List<WebElement> gold=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[3]"));
		List<WebElement> names = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th/a"));
		for(int i=0; i<gold.size()-1; i++) {
			map.put( names.get(i).getText(),Integer.parseInt(gold.get(i).getText()));
		}
		String s="";
		for (Entry<String, Integer> each : map.entrySet()) {
			if (each.getValue() == 18) {
				s =s+" "+each.getKey();
			}
		}
		return s.substring(1);
	}
	
	public String rowCol(String temp) {
		List<WebElement> original = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[1]"));
		List<WebElement> names = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th/a"));
		for(int i=0; i<names.size()-1; i++) {
			map.put( names.get(i).getText(),Integer.parseInt(original.get(i).getText()));
		}
	    if(map.containsKey(temp))  return map.get(temp)+" 2";
	 return null;
	}
	
	public String bronze18() {
		List<WebElement> bronze=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[4]"));
		List<WebElement> names = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th/a"));
		for(int i=0; i<bronze.size()-1; i++) {
			map.put( names.get(i).getText(),Integer.parseInt(bronze.get(i).getText()));
		}		
		String st="";
		for (Entry<String, Integer> each : map.entrySet()) {
			for (Entry<String, Integer> each2 : map.entrySet()) {
			     if (each.getValue() + each2.getValue()==18 && each.getValue() != each2.getValue()) {
				      if(!st.contains(each.getKey())) {
			    	 st += (each.getKey()+" "+each2.getKey());}
			}
		}
		}
		return st;
	}
	
}
