package com.artu.keycloak;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

// import java.net.http.HttpHeaders;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.http.HttpHeaders;
// import static org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", user.clientId());
        formData.add("username", user.username());
        formData.add("password", user.password());
        formData.add("grant_type", user.grantType());


        HttpEntity<MultiValueMap<String, String>> entity = 
            new HttpEntity<MultiValueMap<String, String>>(formData, headers);

        return restTemplate.postForEntity(
            "http://localhost:9090/realms/Study/protocol/openid-connect/token",
            entity,
            String.class
        );
    }
}
