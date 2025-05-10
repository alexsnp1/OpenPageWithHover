import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class OpenPageWithHover {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void openPageWithHover() {
        open("https://github.com/");
        $$("ul li").findBy(Condition.text("Solutions")).hover();
        $$("ul a").findBy(Condition.text("Enterprises")).click();
    }

    @Test
    void dragDrop () {
        open ("https://the-internet.herokuapp.com/drag_and_drop");
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        //$("#column-a").dragAndDropTo($("#column-b"));

    }

}

