package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

public class C09_Get_BodyTekrarlardanKurtulma {

    @Test
    public void test01() {
        /*
         https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
            "firstname“in, "Eric",
            ve "lastname“in, "Smith",
            ve "totalprice“in, 1000 den az olduğunu,
            ve "depositpaid“in, true,
            ve "additionalneeds“in, boş olmadığını
            oldugunu test edin
         */
        //1- End point ve request oluşturulur
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2- Expected data oluşturulur
        //3- Request gönderilir ve dönen responce'i ksydedilir
        Response response = given().when().get(url);
        response.prettyPrint();

        //Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Mary"),
                        "lastname", equalTo("Smith"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds", notNullValue());


    }
}
