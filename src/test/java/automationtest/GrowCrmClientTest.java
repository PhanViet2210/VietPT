package automationtest;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GrowCrmClientTest extends BaseTest {

    private GrowCrmClientPage clientPage;

    @Test(priority = 1)
    public void testCreateClient() {
        clientPage = new GrowCrmClientPage(driver);

        // Đăng nhập
        clientPage.login("admin@example.com", "growcrm");

        // Mở trang Clients và thao tác
        clientPage.openClientsPage();
        clientPage.deleteClientIfExists("Viet Phan");
        clientPage.addClient("Viet Company", "Viet", "Phan", "vietpt@gmail.com");

        assertTrue(clientPage.isClientCreated("Viet Phan", "Viet Company"),
                "❌ Không tìm thấy Client sau khi submit");
        System.out.println("✅ Tạo Client thành công: thấy cả Viet Phan và Viet Company");
    }
}