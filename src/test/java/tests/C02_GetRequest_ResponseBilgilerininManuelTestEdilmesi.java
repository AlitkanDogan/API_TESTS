package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgilerininManuelTestEdilmesi {

    @Test
    public void test01() {
        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
gonderdigimizde donen Response’un,
status code’unun 200,
ve content type’inin application/json; charset=utf-8,
ve Server isimli Header’in degerinin Cowboy,
ve status Line’in HTTP/1.1 200 OK
ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

        //1-Gereki body ve end point hazırla

        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Expected body hazırla

        //3- Request gönder ve dönen response'i kaydet

        Response response=given().when().get(url);

        System.out.println( "\n Statüs kodu      : "+ response.statusCode()+
                            "\n Contebt Type     : "+response.getContentType()+
                            "\n Header değeri    : "+ response.getHeader("Server")+
                            "\n Statüs Line      : "+ response.getStatusLine()+
                            "\n Response Süresi  : "+response.getTime()+" ms.");
        System.out.println("================================================");

        System.out.println(response.getBody()); //io.restassured.internal.RestAssuredResponseImpl@36b310aa

        System.out.println("================================================");

        response.prettyPrint();

        //4-Assertion


    }
}
