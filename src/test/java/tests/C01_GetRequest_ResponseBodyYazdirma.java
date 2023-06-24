package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBodyYazdirma {

    @Test
    public void get01() {
        //https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
        //donen Response’u yazdirin.


        // 1-Request body ve end-point hazırlama

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2-Expected data hazırla

        // 3- Request gönderip, donen response'i kaydetme

        Response response= given().when().get(url);
        response.prettyPrint();

        // 4-Assertion

    }

}
