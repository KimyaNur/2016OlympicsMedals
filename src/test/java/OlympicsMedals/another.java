package OlympicsMedals;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class another {

	
	public class SummerOlympics {
		WebDriver driver;

		@BeforeClass // runs once for all tests
		public void setUp() {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			// driver.manage().window().maximize();
		}
		//11111111
		//naptin yaaa
		//add a comment
		//hello hiiii
		//naber
		
		@Test
		public void theMost() {
			driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics");
			System.out.println("Country with most golden medals: " + CoutryWithMostGolderMedals());
			System.out.println("Country with most silver medals: " + CoutryWithMostSilverMedals());
			System.out.println("Country with most bronze medals: " + CoutryWithMostBronzeMedals());
			System.out.println("Country with most medals: " + CoutryWithMostMedals());
			System.out.println("Country with 18 silver medals: " + CountryByMedal());

		}

		@Test
		public void SortTest() {
			driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
			List<WebElement> ranks = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]"));
			List<Integer> ranksInt = new ArrayList<Integer>();
			for (int i = 0; i < 10; i++) {
				ranksInt.add(Integer.parseInt(ranks.get(i).getText()));
			}
			// System.out.println(ranksInt);
			List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			assertEquals(expected, ranksInt);

			driver.findElement(By.xpath(
					"//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[.='NOC']"))
					.click();

			List<WebElement> countriesEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));

			List<String> countries = new ArrayList<String>();
			for (int i = 0; i < countriesEl.size(); i++) {
				countries.add(countriesEl.get(i).getText());
			}
			// System.out.println(countries);
			Set<String> expectedC = new TreeSet<String>(countries);
			assertEquals(expectedC, countries);
			// System.out.println(expectedC);

			ranks = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]"));
			ranksInt = new ArrayList<Integer>();
			for (int i = 0; i < 10; i++) {
				ranksInt.add(Integer.parseInt(ranks.get(i).getText()));
			}
			assertNotEquals(expected, ranksInt);
		}

		

		public String CoutryWithMostGolderMedals() {
			List<WebElement> countriesEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
			List<String> countries = new ArrayList<String>();
			for (int i = 0; i < 10; i++) {
				countries.add(countriesEl.get(i).getText());
			}

			List<WebElement> goldMedalsEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[2]"));

			List<Integer> goldMedals = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				goldMedals.add(Integer.parseInt(goldMedalsEl.get(i).getText()));
			}
			Map<String, Integer> countMed = new HashMap<>();
			for (int i = 0; i < goldMedals.size(); i++) {
				countMed.put(countries.get(i), goldMedals.get(i));
			}
			int max = Collections.max(countMed.values());

			String str = null;
			for (Entry<String, Integer> entry : countMed.entrySet()) {
				if (entry.getValue() == max) {
					str = entry.getKey();
				}
			}

			return str;
		}

		public String CoutryWithMostSilverMedals() {
			List<WebElement> countriesEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
			List<String> countries = new ArrayList<String>();
			for (int i = 0; i < 10; i++) {
				countries.add(countriesEl.get(i).getText());
			}

			List<WebElement> goldMedalsEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[2]"));

			List<Integer> goldMedals = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				goldMedals.add(Integer.parseInt(goldMedalsEl.get(i).getText()));
			}
			Map<String, Integer> countMed = new HashMap<>();
			for (int i = 0; i < goldMedals.size(); i++) {
				countMed.put(countries.get(i), goldMedals.get(i));
			}
			int max = Collections.max(countMed.values());

			String str = null;
			for (Entry<String, Integer> entry : countMed.entrySet()) {
				if (entry.getValue() == max) {
					str = entry.getKey();
				}
			}

			return str;
		}

		public String CoutryWithMostBronzeMedals() {
			List<WebElement> countriesEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
			List<String> countries = new ArrayList<String>();
			for (int i = 0; i < 10; i++) {
				countries.add(countriesEl.get(i).getText());
			}

			List<WebElement> goldMedalsEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[4]"));

			List<Integer> goldMedals = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				goldMedals.add(Integer.parseInt(goldMedalsEl.get(i).getText()));
			}
			Map<String, Integer> countMed = new HashMap<>();
			for (int i = 0; i < goldMedals.size(); i++) {
				countMed.put(countries.get(i), goldMedals.get(i));
			}
			int max = Collections.max(countMed.values());

			String str = null;
			for (Entry<String, Integer> entry : countMed.entrySet()) {
				if (entry.getValue() == max) {
					str = entry.getKey();
				}
			}

			return str;
		}

		public String CoutryWithMostMedals() {
			List<WebElement> countriesEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
			List<String> countries = new ArrayList<String>();
			for (int i = 0; i < 10; i++) {
				countries.add(countriesEl.get(i).getText());
			}

			List<WebElement> goldMedalsEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[5]"));

			List<Integer> goldMedals = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				goldMedals.add(Integer.parseInt(goldMedalsEl.get(i).getText()));
			}
			Map<String, Integer> countMed = new HashMap<>();
			for (int i = 0; i < goldMedals.size(); i++) {
				countMed.put(countries.get(i), goldMedals.get(i));
			}
			int max = Collections.max(countMed.values());

			String str = null;
			for (Entry<String, Integer> entry : countMed.entrySet()) {
				if (entry.getValue() == max) {
					str = entry.getKey();
				}
			}

			return str;
		}

		public String CountryByMedal() {
			List<WebElement> countriesEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
			List<String> countries = new ArrayList<String>();
			for (int i = 0; i < 10; i++) {
				countries.add(countriesEl.get(i).getText());
			}

			List<WebElement> goldMedalsEl = driver.findElements(
					By.xpath("//table[@class = 'wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3]"));

			List<Integer> goldMedals = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				goldMedals.add(Integer.parseInt(goldMedalsEl.get(i).getText()));
			}
			Map<String, Integer> countMed = new HashMap<>();
			for (int i = 0; i < goldMedals.size(); i++) {
				countMed.put(countries.get(i), goldMedals.get(i));
			}

			List<String> str = new ArrayList<>();
			for (Entry<String, Integer> entry : countMed.entrySet()) {
				if (entry.getValue() == 18) {
					str.add(entry.getKey());
				}
			}

			return str.toString() + " has " + 18 + " silver medals";
		}

	}
}
