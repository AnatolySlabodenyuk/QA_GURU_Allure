package qa.guru;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepsTest {

    private static final String key = "allure";
    private static final String REPOSITORY = "allure-framework/allure2";
    private static final String IssueText  = "Nested describes are hidden in Allure report";

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsAnnotation steps = new StepsAnnotation();

        steps.openMainPage();
        steps.searchForRepository(key);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(IssueText);
    }
}