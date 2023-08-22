package quru.qa.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    @Test
    public void testAnnotatedStep2() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps step = new WebSteps();

        step.openMainPage(TestBase.URL);
        step.searchRepository(TestBase.SEARCH);
        step.clickOnRepository(TestBase.REPOSITORY);
        step.openIssuesTab();
        step.shouldSeeIssueWithNumber(TestBase.ISSUE);
    }
}


