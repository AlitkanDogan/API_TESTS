import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class C11_Post_JsonPathIleBodyTesti {

    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2023-01-10",
"checkout" : "2023-01-20"
},
"additionalneeds" : "wi-fi"
}
POST REQUEST, RESPONSE BODY BILGILERINI
ASSERT YAPARKEN JSONPATH KULLANMA
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in,"Ahmet",
ve "lastname“in, "Bulut",
ve "totalprice“in,500,
ve "depositpaid“in,false,
ve "checkin" tarihinin 2023-01-10
ve "checkout" tarihinin 2023-01-20
ve "additionalneeds“in,"wi-fi"
oldugunu test edin
     */
    @Test
    public void test() {
        //1-End point ve request body oluşturulur
        String url = "https://restful-booker.herokuapp.com/booking";
        //2-Expected Data oluştur


        JSONObject requestBodyObj = new JSONObject();
        JSONObject bookingDatesObj = new JSONObject();

        bookingDatesObj.put("checkin", "2023-01-10");
        bookingDatesObj.put("checkout", "2023-01-20");

        requestBodyObj.put("firstname", "Ahmet");
        requestBodyObj.put("lastname", "Bulut");
        requestBodyObj.put("totalprice", 500);
        requestBodyObj.put("depositpaid", false);
        requestBodyObj.put("bookingdates", bookingDatesObj);
        requestBodyObj.put("additionalneeds", "wi-fi");


        //3-Requels gönderilir ve dönen response'i kaydedilir
        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBodyObj.toString())
                .post(url);

        response.prettyPrint();

        //4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Ahmet")
                        , "booking.lastname", equalTo("Bulut")
                        , "booking.totalprice", equalTo(500)
                        , "booking.depositpaid", equalTo(false)
                        , "booking.bookingdates.checkin", equalTo("2023-01-10")
                        , "booking.bookingdates.checkout", equalTo("2023-01-20")
                        , "booking.additionalneeds", equalTo("wi-fi"));
    }
}
