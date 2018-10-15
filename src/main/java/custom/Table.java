package custom;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Class contains custom methods for the table.
 */
public class Table extends WebComponent {
    /**
     * Search rows by tag.
     */
    @FindBy(tagName = "tr")
    private List<Row> rows;

    /**
     * This method returns the row number.
     * @param row it is the number of row
     * @return number of row
     */
    public Row getRow(int row) {
        return rows.get(row - 1);
    }
    /**
     * This method returns the table size.
     * @return numbers of lines
     */
    public int getTableSize() {
        return rows.size();
    }

    /**
     * Nested class for table cell.
     */
    public static class Row extends WebComponent {
        /**
         * Search columns by tag.
         */
        @FindBy(tagName = "td")
        private List<WebElement> columns;

        /**
         * This method returns the cell of the table.
         * @param column number of the table
         * @return cell
         */
        public WebElement getCell(int column) {
            return columns.get(column - 1);
        }
    }
}


