package app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PagamentoServiceTest {

    @Autowired
    private PagamentoService pagamentoService;
    
    @Test
    public void testCheckValuePayment() {
        boolean flag = pagamentoService.checkValuePayment(10);
        		
        assertEquals(false, flag);
    }
}