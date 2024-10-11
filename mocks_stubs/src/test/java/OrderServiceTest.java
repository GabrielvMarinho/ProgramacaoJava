import org.example.InvoiceService;
import org.example.OrderService;
import org.example.PaymentService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    @Test
    public void testProcessorOrderSuccess(){
        PaymentService paymentServicemock = mock(PaymentService.class);
        InvoiceService invoiceServiceStub = new InvoiceService();

        when(paymentServicemock.processPayment("12345", 100.0)).thenReturn(true);
        OrderService orderService = new OrderService(paymentServicemock, invoiceServiceStub);

        boolean result = orderService.processOrder("12345", 100.0, "user@example.com");

        assertTrue(result, "O pedido deveria ser processado com sucesso");

        verify(paymentServicemock).processPayment("12345", 100.0);
    }
    @Test
    public void testProcessOrderFailurePayment(){
        PaymentService paymentServicemock = mock(PaymentService.class);
        InvoiceService invoiceServicestub = new InvoiceService();
        when(paymentServicemock.processPayment("12345", 100.0)).thenReturn(false);
        OrderService orderService = new OrderService(paymentServicemock, invoiceServicestub);
        boolean result = orderService.processOrder("12345", 100.0, "user@example.com");
        assertFalse(result, "O pedido deveria fahar devido á falha no pagamento");

        verify(paymentServicemock).processPayment("12345", 100.0);

        verifyNoMoreInteractions(paymentServicemock);
    }

}
