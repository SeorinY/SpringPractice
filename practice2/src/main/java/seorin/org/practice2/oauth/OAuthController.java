package seorin.org.practice2.oauth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

    @GetMapping("/test")
    public String test(@RequestParam String code) {
        // Authorization code 받음

        System.out.println("OAuthController.test");

        // Authorization code 로 Access token 을 받으려고 요청을 만들고 보내고, response 를 파싱하는 과정
        RestTemplate rt = new RestTemplate();

        // header 만듦
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // body 만듦
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "234ae807b9524d4bdd2bc96b81cec308");
        params.add("redirect_uri", "http://localhost:8080/oauth/test");
        params.add("code", code);

        // 요청 만듦
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
        // 요청 보내서 response 받음.
        ResponseEntity<String> response = rt.postForEntity(
                "https://kauth.kakao.com/oauth/token",
                kakaoTokenRequest,
                String.class);

        // response 파싱하기
        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = null;
        try {
            oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }


        //  --  - - -
        RestTemplate rt2 = new RestTemplate();

        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization", "Bearer " + oAuthToken.getAccess_token());
        headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers2);

        ResponseEntity<String> response2 = rt2.postForEntity(
                "https://kapi.kakao.com/v2/user/me",
                kakaoProfileRequest,
                String.class);

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(response2.getBody());

        JsonObject kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
        long id = element.getAsJsonObject().get("id").getAsLong();
        String email = kakaoAccount.getAsJsonObject().get("email").getAsString();

        System.out.println("id = " + id);
        System.out.println("email = " + email);

        return response2.getBody();
    }
}
