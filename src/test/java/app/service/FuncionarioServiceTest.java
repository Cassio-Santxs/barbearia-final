package app.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FuncionarioServiceTest {
	
	
	@Autowired
	FuncionarioService service;
	
//	@Test
//	@DisplayName("teste unitario para confirmar se o email é real")
//	void TestarEmail() {
//		
//		String dsEmail = service.getdsEmail();
//		assertTrue(dsEmail.contains("@"));
//				
//		
//	}
}