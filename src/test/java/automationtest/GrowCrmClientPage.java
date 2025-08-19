package automationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class GrowCrmClientPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public GrowCrmClientPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void login(String email, String password) {
        driver.get("https://demo.growcrm.io/login");

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }

    public void openClientsPage() {
//        WebElement menuIcon = wait.until(
//                ExpectedConditions.elementToBeClickable(By.cssSelector("i.sl-icon-menu"))
//        );
//        menuIcon.click();

        WebElement customersMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Customers')]"))
        );
        customersMenu.click();

        WebElement clientsLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/clients' and contains(text(),'Clients')]"))
        );
        clientsLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Clients')]")));
    }


    public void deleteClientIfExists(String fullName) {
        // Tìm tất cả các <a> chứa text và class đúng
        List<WebElement> records = driver.findElements(
                By.xpath("//a[contains(@class,'edit-add-modal-button') and normalize-space()='" + fullName + "']")
        );

        if (!records.isEmpty()) {
            // Lấy row của record đầu tiên
            WebElement row = records.get(0).findElement(By.xpath("./ancestor::tr"));

            // Scroll record vào giữa màn hình
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", records.get(0)
            );

            // Click nút Delete trong row
            WebElement deleteBtn = row.findElement(By.xpath(".//i[contains(@class,'sl-icon-trash')]"));
            deleteBtn.click();

            // Chờ nút Continue hiện lên và click
            WebElement continueBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[@type='button' and contains(@class,'btn-outline-danger') and normalize-space()='Continue']")
                    )
            );
            continueBtn.click();

            System.out.println("✅ Đã xoá record " + fullName);
        } else {
            System.out.println("ℹ️ Không tìm thấy record " + fullName + ", bỏ qua bước xóa");
        }
    }

    public void addClient(String companyName, String firstName, String lastName, String email) {
        // Refresh trang trước khi thao tác
        driver.navigate().refresh();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        // Click nút Add Client
        WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class,'btn-add-circle')]")
        ));
        addButton.click();

        System.out.println("➕ Đã click nút Add Client");

        // Nhập thông tin client
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client_company_name"))).sendKeys(companyName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name"))).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);

        // Chọn Category
        WebElement categoryDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("select2-client_categoryid-container"))
        );
        categoryDropdown.click();

        WebElement defaultOption = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Default')]"))
        );
        defaultOption.click();

        // Click Submit
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("commonModalSubmitButton")));
        submitBtn.click();
    }

    public boolean isClientCreated(String fullName, String companyName) {
        WebElement contactName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'" + fullName + "')]")
        ));
        WebElement company = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'" + companyName + "')]")
        ));
        return contactName.isDisplayed() && company.isDisplayed();
    }
}