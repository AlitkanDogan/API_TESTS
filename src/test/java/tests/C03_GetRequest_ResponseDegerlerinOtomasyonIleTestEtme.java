package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_GetRequest_ResponseDegerlerinOtomasyonIleTestEtme {

    @Test
    public void test02(){
        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
         */

        //1-Gereki body ve end point hazırla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2-Expected body hazırla

        //3- Request gönder ve dönen response'i kaydet
        Response response=given().when().get(url);

        //4-Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");
    }
}
