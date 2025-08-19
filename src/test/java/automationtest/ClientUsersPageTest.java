package automationtest;

import org.testng.annotations.Test;

public class ClientUsersPageTest extends BaseTest {

    private ClientUsersPage clientUsersPage;

    @Test(priority = 2)
    public void testCreateClientUser() {
        clientUsersPage = new ClientUsersPage(driver);
//        clientUsersPage.openCustomersMenu();
        // Mở trang Client Users và tạo user
        clientUsersPage.openClientUsersPage();
        clientUsersPage.deleteContactByEmail("v@gmail.com");
        clientUsersPage.createClientUser("Viet Company", "Viet", "Phan", "v@gmail.com");
        clientUsersPage.verifyClientUserCreated("v@gmail.com");
        System.out.println("✅ Tạo Client User thành công");
    }
}