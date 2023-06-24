package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_ResponseBodyTesti {


    @Test
    public void test(){



        /*
        https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
gonderdigimizde
{
"title":"API",
"body":"API ogrenmek ne guzel",
"userId":10,
}
donen Response’un,
status code’unun 201,
ve content type’inin application/json
ve Response Body'sindeki,
"title"'in "API" oldugunu
"userId" degerinin 100'den kucuk oldugunu
"body" nin "API" kelimesi icerdigini
test edin.
         */

        // 1-end point ve requels body oluşturulur
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject requelsBody=new JSONObject();
        requelsBody.put("title","API");
        requelsBody.put("body","API ogrenmek ne guzel");
        requelsBody.put("userId",10);

        // 2- expected data oluşturulur
        //3- dönen responce'i kaydedilir
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(requelsBody.toString())
                .post(url);

        response.prettyPrint();

        //4- assertion

        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", Matchers.equalTo("API"))
                .body("userId", Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));




    }
}
