package quru.qa.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static final String URL = "https://github.com";
    public static final String SEARCH = "selenide";
    public static final String REPOSITORY = "a[href='/selenide/selenide']";
    public static final int ISSUE = 2395;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
}
