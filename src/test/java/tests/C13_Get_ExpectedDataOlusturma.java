package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataOlusturma {

    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
um mollitia molestiae aut atque rem suscipitnam impedit esse"
}
     */

    @Test
    public void test(){

        //1-end point ve request body oluşturulur
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2-expected data oluşturulur

        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //3- request gönderilir responce'i kaydedilir
        Response response=given().when().get(url);
        response.prettyPrint();

        //4-Assertion

        JsonPath responceJSONPath=response.jsonPath();

        Assert.assertEquals(expectedData.get("userId"),responceJSONPath.get("userId"));
        Assert.assertEquals(expectedData.get("id"),responceJSONPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),responceJSONPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responceJSONPath.get("body"));
    }
}
