import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class OpenPageWithHover {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void openPageWithHoverTest() {
        open("https://github.com/");
        //Открываем страницы через всплывающие окна
        $$("ul li").findBy(text("Solutions")).hover();
        $$("ul a").findBy(text("Enterprises")).click();
        //роверка что мы на нужной странице
        $("#hero-section-brand-heading").shouldHave(text("The AAAI-powered"));
    }

    @Test
    void dragDropTest () {
        open ("https://the-internet.herokuapp.com/drag_and_drop");
        //проверка перед тестом
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        //перетаскиваем элемент к другому элементу
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        //проверка после теста
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        //$("#column-a").dragAndDropTo($("#column-b"));

    }

}

