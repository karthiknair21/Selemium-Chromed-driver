import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RnGAutomation {
	public WebDriver driver;
	@Test
	public void Experiment() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Desktop\\KAutomation\\ExeFiles\\chromedriver.exe");
		WebDriver x=new ChromeDriver();
		x.get("https://www.random.org/integers/");
		x.manage().window().maximize();
		
		x.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[1]/input")).clear();//clearing existing value
		x.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[1]/input")).sendKeys("10");//Sending new value		
		x.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[2]/input[1]")).clear();//clearing existing value
		x.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[2]/input[1]")).sendKeys("1");//Sending new value		
		x.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[2]/input[2]")).clear();//clearing existing value
		x.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[2]/input[2]")).sendKeys("100");//Sending new value		
		x.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[3]/input")).clear();//clearing existing value
		x.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[3]/input")).sendKeys("10");//Sending new value		
		x.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[5]/input[1]")).click();//Generating the random numbers		
		List<WebElement> select = x.findElements(By.xpath("//*[@id=\"invisible\"]/pre")); //Selecting the random numbers
		
		for(int i= 0;i<select.size();i++)
				{
					String out=select.get(i).getText();								
					String[] integer = out.split(" "); // Splits each spaced integer into a String SArray.
					int[] num = new int[integer.length]; // Creates the integer SArray.
				
				for (int k = 0; k < num.length; k++)
				{
				    num[k] = Integer.parseInt(integer[k]); //Parses the integer for each string.		
				}				
				System.out.print("The sequence of random numbers is given by:\n "); //Printing the sequence of random numbers
			    for(int l=0; l<num.length; l++)
				{
			    	System.out.print(" " +num[l]);
				}					
				int[] SArray = new int[num.length];
				int temp;
				for (int j = 0; j <= num.length; j++) //sorting
				{
					for (int k = j+1; k < num.length; k++)
					{
						if (num[j] > num[k]) 
						{
							temp = num[j];
							num[j] = num[k];
							num[k] = temp;
							SArray = num;
						}
					}
				}
				System.out.print("\nThe sorted array is given by:\n ");	//Printing the array after sorting in an array
				for(int l=0; l<SArray.length; l++)
				{
					System.out.print(" " +SArray[l]);
				}
				System.out.print("\n");
				}
		try {
			Thread.sleep(3000);		//closing the web browser after 3 seconds
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		x.quit();
		}
	}
