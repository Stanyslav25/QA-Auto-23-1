package pages.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class BookStoreTablePage extends BasePage {
    public BookStoreTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".rt-table")
    WebElement table;
    @FindBy(css = ".rt-tr-group .rt-tr")
    static List<WebElement> rows;
    @FindBy(css=".rt-thead .rt-th")
    List<WebElement> headerCells;

    public String getCellValue(int row, int column) {
        WebElement targetRow = rows.get(row);
        String result = targetRow.findElement(getCellBy(column)).getText();
        System.out.println("CELL VALUE: "+result);
        return result;
    }
    public int getTitleColumnIndex() {
        return getHeaderIndex("Title");
    }
    public int getAuthorColumnIndex() {
        return getHeaderIndex("Author");
    }
    public By getCellBy(int column) {
        return By.cssSelector(".rt-td:nth-child(" + (column + 1) + ")");
    }
    public static int findRowIndexByContent(String targetContent, int column) {
        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            WebElement targetRow = rows.get(rowIndex);
            List<WebElement> cells = targetRow.findElements(By.cssSelector(".rt-td"));
            if (column < cells.size()) {
                WebElement targetCell = cells.get(column);
                if (targetCell.getText().trim().contains(targetContent.trim())) {
                    System.out.println("ROW index: " + rowIndex);
                    return rowIndex;
                }
            }
        }
        return -1; // Return -1 if the content is not found in the specified column
    }

    public int getHeaderIndex(String expectedHeader) {
        for (int columnIndex = 0; columnIndex < headerCells.size(); columnIndex++) {
            String actualHeader = headerCells.get(columnIndex).getText().trim();
            if (actualHeader.equals(expectedHeader)){
                System.out.println("COLUMN INDEX: " + columnIndex);
                return columnIndex;
            }
        } return -1;
    }
}
