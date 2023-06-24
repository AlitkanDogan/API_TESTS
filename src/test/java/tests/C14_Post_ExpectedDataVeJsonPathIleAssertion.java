package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
            https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
        gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
        POST REQUEST, RESPONSE BODY BILGILERINI
        ASSERT YAPARKEN JSONPATH KULLANMA
        Response Body
        {
        "bookingid": 24,
        "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
                "checkin": "2021-06-01",
                "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
        }
        }
        Request body
        {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
        },
        "additionalneeds" : "wi-fi"
}
     */

    @Test
    public void test() {

        //1-end point ve request body oluşturulur

        String url= "https://restful-booker.herokuapp.com/booking";

        JSONObject rezTarihleriJson = new JSONObject();
        rezTarihleriJson.put("checkin", "2021-06-01");
        rezTarihleriJson.put("checkout", "2021-06-10");

        JSONObject requestBody = new JSONObject();

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezTarihleriJson);
        requestBody.put("additionalneeds", "wi-fi");

        //2-Expected data olusturulur

         JSONObject expectedData=new JSONObject();
        expectedData.put("bookingid",2581);
       expectedData.put("booking", requestBody);

        System.out.println(expectedData.toString());
//
        //3-Requst gönderilir ve dönen responce'i kaydedilir
        Response response=given().contentType(ContentType.JSON).when().body(requestBody.toString()).post(url);
        response.prettyPrint();

        //4-Assertion
        JsonPath responceJsonPath=response.jsonPath();
        //Assert.assertEquals(expectedData.get("bookingid"), responceJsonPath.get("bookingid"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("firstname"),
                            responceJsonPath.get("booking.firstname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("lastname"),
                            responceJsonPath.get("booking.lastname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
                            responceJsonPath.get("booking.totalprice"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
                            responceJsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                            responceJsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                            responceJsonPath.get("booking.bookingdates.checkout"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                            responceJsonPath.get("booking.additionalneeds"));


    }
}
