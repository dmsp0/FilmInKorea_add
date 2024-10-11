package filminkorea.fik.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // 프론트엔드 도메인 허용
public class GoogleApiController {

    // application.properties에서 API 키를 가져옴
    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    // 구글 지도가 사용되는 프론트 쪽에 API 키 넘겨주는 로직
    @GetMapping("/api/google-maps-api-key")
    @Operation(summary = "Get Google Maps API key", description = "Retrieve the Google Maps API key to be used by the frontend for map-related functionalities.")
    public String getGoogleMapsApiKey() {
        System.out.println("Google Maps API Key: " + googleMapsApiKey);  // 로그 출력
        return googleMapsApiKey;
    }
}
