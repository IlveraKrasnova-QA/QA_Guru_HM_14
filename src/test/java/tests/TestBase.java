package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
        @BeforeAll
        static void beforeAll(){
        Configuration.baseUrl = "https://www.avito.ru/";
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
    }
}
