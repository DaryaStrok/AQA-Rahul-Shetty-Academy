import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class StaticDropdown {
    public static void main(String[] args) throws InterruptedException {
        StaticDropdown test1 = new StaticDropdown();
        test1.ChooseStaticDropdown();
        //test1.SpiceJet();
        //test1.Assignment();
        //test1.AssignmentVerificarion();
    }

    @Test
    public void ChooseStaticDropdown() throws InterruptedException {
        //Create driver object
        System.setProperty("webdriver.chrome.driver", "//Users//Darya//Documents//Education//Udemy//QAAutomation//chromedriver");
        WebDriver myDriver = new ChromeDriver();
        myDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //choose currency

        WebElement myStaticDropDownCur = myDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select mySelectDropDown = new Select(myStaticDropDownCur);

        mySelectDropDown.selectByValue("INR");
        String checkDropDownValue = mySelectDropDown.getFirstSelectedOption().getText();
        System.out.println(checkDropDownValue);

        mySelectDropDown.selectByIndex(3);
        checkDropDownValue = mySelectDropDown.getFirstSelectedOption().getText();
        System.out.println(checkDropDownValue);

        //choose passengers

        WebElement myStaticDropDownPass = myDriver.findElement(By.id("divpaxinfo"));
        myStaticDropDownPass.click();

        WebDriverWait wait = new WebDriverWait(myDriver, 30);

        WebElement myStaticDropDownPassAdult = myDriver.findElement(By.id("hrefIncAdt"));
        wait.until(ExpectedConditions.elementToBeClickable(myStaticDropDownPassAdult));

        for (int i=1; i<3; i++)
        {
            myStaticDropDownPassAdult.click();
        }

        System.out.println(myDriver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(myDriver.findElement(By.id("divpaxinfo")).getText(),"3 Adult");

        //choose destination

        myDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        myDriver.findElement(By.xpath("//a[@value = 'PNQ']")).click();
        myDriver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        //WebElement myDDTo = myDriver.findElement(By.xpath("(//a[@value = 'BOM'])[2]"));
        WebElement myDDTo = myDriver.findElement(By.xpath("//div[@id = 'ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value = 'BOM']"));
        wait.until(ExpectedConditions.elementToBeClickable(myDDTo)).click();

        //choose country
        myDriver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> chooseCountryList =  myDriver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        //System.out.println(chooseCountryList);
        for (WebElement temp:chooseCountryList)
        {

            if(temp.getText().equalsIgnoreCase("India"))
            {
                //System.out.println(temp.getText());
                temp.click();
                break;
            }
        }

    }

    @Test
    public void SpiceJet()
    {
        //Create driver object
        System.setProperty("webdriver.chrome.driver", "//Users//Darya//Downloads//chromedriver");
        WebDriver myDriver = new ChromeDriver();
        myDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement CheckBox = myDriver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]"));
        Assert.assertFalse(CheckBox.isSelected());
        CheckBox.click();
        Assert.assertTrue(CheckBox.isSelected());
        /*if (CheckBox.isSelected())
        {
            System.out.println("Selected");
        }*/


    }
    @Test
    public void Assignment()
    {
        //Create driver object
        System.setProperty("webdriver.chrome.driver", "//Users//Darya//Downloads//chromedriver");
        WebDriver myDriver = new ChromeDriver();
        myDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement CheckBox1 = myDriver.findElement(By.xpath("//input[contains(@id,'checkBoxOption1')]"));
        CheckBox1.click();
        Assert.assertTrue(CheckBox1.isSelected());
        CheckBox1.click();
        Assert.assertFalse(CheckBox1.isSelected());
        List CheckBoxes = myDriver.findElements(By.xpath("//input[contains(@id,'checkBoxOption')]"));
        System.out.println(CheckBoxes.stream().count());
        /*if (CheckBox.isSelected())
        {
            System.out.println("Selected");
        }*/


    }
    @Test
    public void AssignmentVerificarion()
    {
        //Create driver object
        System.setProperty("webdriver.chrome.driver", "//Users//Darya//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[value='option1']")).click();
        boolean chckBox= driver.findElement(By.cssSelector("input[value='option1']")).isSelected();
        Assert.assertTrue(chckBox);
        driver.findElement(By.cssSelector("input[value='option1']")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());


    }

}
