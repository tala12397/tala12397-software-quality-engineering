package hellocucumber;

import io.cucumber.java.en.*;

import java_code.MoodleActuator;
import org.apache.http.util.Asserts;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {
    private static MoodleActuator moodle;
    private static MoodleActuator userMoodle;

    private static List<MoodleActuator> allMoodles;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "\\C:\\Users\\roiha\\Documents\\SISE\\3rd year\\QA\\sqe-hw3-main\\sqe-hw3-main\\Selenium\\chromedriver.exe\\";
    public void moodleInit(int flag) {
        System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
        if(allMoodles == null){
            allMoodles = new ArrayList<>();
        }
        if (flag == 0) {
            moodle = new MoodleActuator();
            moodle.initSession(webDriver, path);
        }
        else if (flag == 1) {
            userMoodle = new MoodleActuator();
            userMoodle.initSession(webDriver, path);
        }
        else{
            userMoodle = new MoodleActuator();
            moodle = new MoodleActuator();
            moodle.initSession(webDriver, path);
            userMoodle.initSession(webDriver,path);
        }

    }
    @Given("^User in Home page$")
    public void init() {
        moodleInit(1);
    }

    @When("^user navigate to login page$")
    public void userNavigateToLoginPage() {
        userMoodle.goToLogin();
    }
    @And("User enters UserName {string} and Password {string}")
    public void userEntersUserNameAndPassword(String userName,String password) {
        userMoodle.enterLoginInfo(userName,password);

    }
    @And("user navigate to course page {string}")
    public void userNavigateToCoursePage(String COURSE_NAME) {
        userMoodle.goToCoursePage(COURSE_NAME);
    }

    @And("^user navigate to forum page$")
    public void userNavigateToForumPage() {
        userMoodle.goToForum();
    }
    @And("user navigate to search bar and search a query {string}")
    public void userNavigateToSearchBar(String query) {

        userMoodle.goToSearchBar(query);


    }

    @Then("^all the relevant results display$")
    public void allTheRelevantResultsDisplay() {
        userMoodle.checkResult();
    }


    @Given("^teacher in Home page$")
    public void teacherInHomePage() {moodleInit(0);

    }

    @When("^teacher navigate to login page$")
    public void teacherNavigateToLoginPage() {
        moodle.goToLogin();

    }

    @And("teacher enters UserName {string} and Password {string}")
    public void teacherEntersUserNameAndPassword(String userName , String password) {
        moodle.enterLoginInfo(userName,password);
    }


    @And("teacher navigate to course page {string}")
    public void teacherNavigateToCoursePage(String COURSE_NAME) {
        moodle.goToCoursePage(COURSE_NAME);
    }

    @And("^teacher navigate to forum page$")
    public void teacherNavigateToForumPage() {
        moodle.goToForum();

    }

    @And("teacher navigate to search bar and search a query {string}")
    public void teacherNavigateToSearchBarAndSearchAQuery(String query) {
        moodle.goToSearchBar(query);
    }

    @And("teacher clicks on the delete button")
    public void teacherClicksOnTheDeleteButton() {
        moodle.clickDelete();

    }

    @And("teacher confirm the deletion by clicking on confirm")
    public void teacherConfirmTheDeletionByClickingOnConfirm() {
        moodle.confirmDelete();

    }

    @Then("the comment should be deleted from the forum")
    public void theCommentShouldBeDeletedFromTheForum() {
        moodle.checkResultDelete();
    }

    @Given("teacher and user in Home page")
    public void teacherAndUserInHomePage() {moodleInit(2);

    }
}
