import org.json.JSONObject;
import org.junit.Test;

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
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject rezervasyonObj = new JSONObject();
        rezervasyonObj.put("checkin", "2021-06-01");
        rezervasyonObj.put("checkout", "2021-06-10");

        JSONObject requestBody = new JSONObject();

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates", requestBody);
        requestBody.put("additionalneeds", "wi-fi");

        //2-Expected data olusturulur

         JSONObject expectedData=new JSONObject();
        expectedData.put("bookingid",24);
       expectedData.put("booking", requestBody);

        System.out.println(expectedData.toString());
//
        //3-Requst gönderilir ve dönen responce'i kaydedilir
        //Response response=given().contentType(ContentType.JSON).when().body(requestBody.toString()).post(url);



        //4-Assertion


    }
}
