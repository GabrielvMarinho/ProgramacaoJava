import org.example.EmailServiceStub;
import org.example.NotificationServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testNotificationServiceTest {



    @Test
    public void testNotifyUserSucess(){
        EmailServiceStub emailServiceStub = new EmailServiceStub();
        NotificationServiceStub notificationServiceStub = new NotificationServiceStub(emailServiceStub);
        boolean result = notificationServiceStub.notifyUser("user@example.com", "Você tem um ");
        assertTrue(result, "A notificação deveria ser enviada com sucesso");
    }
    @Test
    public void testNotifyUserFailure(){
        EmailServiceStub emailServiceStub = new EmailServiceStub();
        NotificationServiceStub notificationServiceStub = new NotificationServiceStub(emailServiceStub);

        boolean result = notificationServiceStub.notifyUser(null, "Você tem uma notificação");
        assertFalse(result, "A notificação deveria falhar com destinatário inválido");
    }

}
