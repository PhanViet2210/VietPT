package automationtest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClientUsersPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ClientUsersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    /*public void openCustomersMenu() {
        // Tìm <li> chứa menu Customers
        WebElement customersMenuLi = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[@data-modular-id='main_menu_team_clients']")
        ));

        // Lấy thẻ <a> bên trong <li>
        WebElement customersMenuLink = customersMenuLi.findElement(
                By.xpath(".//a[contains(@class,'has-arrow') and .//span[text()='Customers']]")
        );

        // Lấy giá trị attribute aria-expanded
        String expanded = customersMenuLink.getAttribute("aria-expanded");

        if ("false".equals(expanded)) {
            // Nếu menu chưa mở, click vào <a> để mở
            customersMenuLink.click();
            System.out.println("✅ Mở menu Customers");
        } else {
            // Nếu menu đã mở thì không làm gì
            System.out.println("⚠️ Menu Customers đã mở, không click");
        }
    }*/

    public void openClientUsersPage() {
        WebElement customersMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Customers')]"))
        );
        customersMenu.click();

        WebElement clientUsersMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/users' and normalize-space()='Client Users']")
        ));
        clientUsersMenu.click();
        System.out.println("📂 Đã mở trang Client Users");
    }

    public void deleteContactByEmail(String email) {
        // Tìm tất cả record có email
        List<WebElement> records = driver.findElements(
                By.xpath("//tr[td[@class='contacts_col_email' and normalize-space()='" + email + "']]")
        );

        if (!records.isEmpty()) {
            // Lấy row đầu tiên
            WebElement row = records.get(0);

            // Scroll row vào giữa màn hình
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", row
            );
            System.out.println("🔎 Đã tìm thấy record với email: " + email);

            // Click nút Delete (button chứa icon thùng rác)
            WebElement deleteButton = row.findElement(
                    By.xpath(".//button[.//i[contains(@class,'sl-icon-trash')]]")
            );
            deleteButton.click();
            System.out.println("🗑️ Đã click Delete cho record có email: " + email);

            // Click nút Continue trong popup confirm
            WebElement continueButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(@class,'btn-outline-danger') and normalize-space()='Continue']")
                    )
            );
            continueButton.click();
            System.out.println("✅ Đã xác nhận xóa record có email: " + email);

        } else {
            System.out.println("⚠️ Không tìm thấy record nào với email: " + email);
        }
    }

    public void createClientUser(String companyName, String firstName, String lastName, String email) {
        // Click nút Add User (click button cha, không click vào <i>)
        WebElement addUserBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class,'btn-add-circle')]")
        ));
        addUserBtn.click();
        System.out.println("➕ Đã click nút Add User");

        // Chọn Company
        // Click vào dropdown
        WebElement clientDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(@class,'select2-selection--single') and contains(@class,'js-select2-basic-search-modal')]")
        ));
        clientDropdown.click();
        System.out.println("✅ Đã click vào dropdown Client");


        // Tìm ô input search
        WebElement companyInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']")
        ));
        // Nhập "Viet Company" vào ô input
        companyInput.sendKeys("Viet Company");

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(@class,'select2-results__option') and text()='Viet Company']")
        ));
        option.click();

        // Nhập First Name
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("first_name")
        ));
        firstNameInput.clear();
        firstNameInput.sendKeys("Viet");

        // Nhập Last Name
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("last_name")
        ));
        lastNameInput.clear();
        lastNameInput.sendKeys("Viet");

        // Nhập Email
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("email")
        ));
        emailInput.clear();
        emailInput.sendKeys("v@gmail.com");

        // Click Submit
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("commonModalSubmitButton")
        ));
        submitButton.click();
    }

    public void verifyClientUserCreated(String email) {
        // Tìm record có email
        List<WebElement> records = driver.findElements(
                By.xpath("//tr[td[@class='contacts_col_email' and normalize-space()='" + email + "']]")
        );
        // Lấy row đầu tiên
        WebElement row = records.get(0);

        // Scroll row vào giữa màn hình
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", row
        );
        if (!records.isEmpty()) {
            System.out.println("✅ Đã tạo Client User thành công với email: " + email);
        } else {
            System.out.println("❌ Không tìm thấy Client User với email: " + email);
        }
    }
}