package java_code;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoodleActuator {
    private WebDriver driver;
    private WebDriverWait wait;


    public void initSession(String webDriver, String path) {

        System.setProperty(webDriver, path);

        // new chrome driver object
        this.driver = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.wait = new WebDriverWait(driver, 15);

        // launch website -> localhost
        driver.get("http://localhost/");

        // maximize the window - some web apps look different in different sizes
        driver.manage().window().maximize();
        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    public void goToLogin() {

        driver.findElement(By.linkText("Log in")).click();
    }
    public void enterLoginInfo(String userName, String password) {
        // locate the username input box and enter username

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(userName);

        // locate the password input box and enter password

         WebElement webElement = driver.findElement(By.xpath("//*[@id='password']"));
         webElement.sendKeys(password);

        // locate Log in button and press

        driver.findElement(By.id("loginbtn")).click();

    }
    public void myCoursesTab(){

        WebElement myCoursesTab = driver.findElement(By.xpath("//*[contains(text(),'My courses') and @role='menuitem']"));
        myCoursesTab.click();
    }
    public void goToCoursePage(String COURSE_NAME) {
        myCoursesTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='multiline' and contains(text(),'" + COURSE_NAME + "')]"))).click();

    }
    public void goToForum() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"module-1\"]/div/div[1]/div/div[1]/div/div[2]/div[2]"))).click();

    }



    public void goToSearchBar(String query) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search"))).sendKeys(query);
        driver.findElement(By.xpath("//*[@id=\"region-main\"]/div[2]/div[1]/div/div[1]/div/form/div/div/button")).click();
    }


    public void clickDelete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete"))).click();
    }

    public void confirmDelete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn btn-primary']"))).click();
    }

    public void checkResult() {
//        boolean flag = true;
        boolean flag = true;
        try {
//        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yui_3_17_2_1_1673266595593_48\"]/div[2]/div/a[1]")));
        driver.findElement(By.xpath("//*[@id=\"yui_3_17_2_1_1673266595593_48\"]/div[2]/div/a[1]"));
        }
        catch (Exception e) {
            flag = false;
        }
        Assert.assertTrue("not found error",flag);

    }

    public void checkResultDelete() {
        boolean flag = true;
        try{
//           driver.findElement(By.xpath( "//*[@id=\"user-notifications\"]div"));
            driver.findElement(By.linkText("abcd"));
            flag = false;
        }catch (Exception e){
            flag = true;
        }
        Assert.assertTrue("not deleted successfully ",flag);
    }
}
