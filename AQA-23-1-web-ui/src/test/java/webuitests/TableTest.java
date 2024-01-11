package webuitests;

import base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.pages.myPages.BookStoreTablePage;
import org.pages.myPages.HomePage;

public class TableTest extends BaseTest {
    HomePage homePage = new HomePage(driver);
    BookStoreTablePage bookStore = new BookStoreTablePage(driver);

    @Test
    public void bookStoreGetRow() {
        homePage.clickBookStoreTile();
//        bookStore.getCellValue(3, 1);
        assertTrue(bookStore.getCellValue(3, 1).contains("Speaking"));
          bookStore.findRowIndexByContent("Designing", bookStore.getTitleColumnIndex());
    }

    @AfterEach
    public void deleteAllWrites() {
        
    }
}