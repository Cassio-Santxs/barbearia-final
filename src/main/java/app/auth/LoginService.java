package app.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class LoginService {

    public String logar(LoginModel user) {
    	
    	HttpHeaders headers = new HttpHeaders();
    	RestTemplate rg = new RestTemplate();
    	
    	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    	
    	MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
    	
    	formData.add("client_id", user.getClientId());
    	formData.add("username", user.getUsername());
    	formData.add("password", user.getPassword());
    	formData.add("grant_type", user.getGrantType());
        formData.add("client_secret", user.getClientSecret());
        
        String url = "http://192.168.56.10:8080/realms/alpine2/protocol/openid-connect/token";
        
        HttpEntity<MultiValueMap<String, String>> entity
		= new HttpEntity<>(formData, headers);
        
        String result = rg.postForEntity(url, entity, String.class).getBody();
        return result;
    	
//    	HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formData, headers);
//    	
//    	return rg.postForEntity("http://192.168.56.13:8080/realms/alpine2/protocol/openid-connect/token", entity, String.class).getBody();
    	
    }
}



