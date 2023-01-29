package qa.guru;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsAnnotation {
    @Step("Открыть github")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("В поисковой строке прописать: {key} и нажать Enter")
    public void searchForRepository(String key) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(key);
        $(".header-search-input").submit();
    }

    @Step("Кликнуть по первой ссылке: {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить, что на странице есть элемент с названием {issue}")
    public void shouldSeeIssueWithNumber(String issue) {
        $(withText(issue)).should(Condition.exist);
    }
}
