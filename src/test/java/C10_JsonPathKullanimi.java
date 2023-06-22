import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test
    public void test() {


        //İçerden dışarı doğru oluşturmak daha anlaşılır. Bu nedenle obje,
        // ve arrayleri içerden dışarı doğru oluşturdum(dgn)

        JSONObject cepTelefonuObj = new JSONObject();
        cepTelefonuObj.put("type", "iPhone");
        cepTelefonuObj.put("number", "0123-4567-8888");

        JSONObject evTelefonuObj = new JSONObject();
        evTelefonuObj.put("type", "home");
        evTelefonuObj.put("number", "0123-4567-8910");

        JSONArray phoneNummersArr = new JSONArray();
        phoneNummersArr.put(cepTelefonuObj);
        phoneNummersArr.put(evTelefonuObj);

        JSONObject addressBilgileriObj = new JSONObject();
        addressBilgileriObj.put("streetAddress", "naist street");
        addressBilgileriObj.put("city", "Nara");
        addressBilgileriObj.put("postalCode", "630-0192");

        JSONObject kisiBilgileriObj = new JSONObject();
        kisiBilgileriObj.put("firstName", "John");
        kisiBilgileriObj.put("lastName", "Doe");
        kisiBilgileriObj.put("age", 26);
        kisiBilgileriObj.put("address", addressBilgileriObj);
        kisiBilgileriObj.put("phoneNumbers", phoneNummersArr);

        System.out.println(kisiBilgileriObj);
        System.out.println("======================================================");

        System.out.println("first name      : " + kisiBilgileriObj.get("firstName"));
        System.out.println("lastName        : " + kisiBilgileriObj.get("lastName"));
        System.out.println("age             : " + kisiBilgileriObj.get("age"));
        System.out.println("streetAddress   : " + kisiBilgileriObj.getJSONObject("address").get("streetAddress"));
        System.out.println("city            : " + kisiBilgileriObj.getJSONObject("address").get("city"));
        System.out.println("postalCode      : " + kisiBilgileriObj.getJSONObject("address").get("postalCode"));
        System.out.println("cepTelNumber    : " + kisiBilgileriObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("evTelNumber     : " + kisiBilgileriObj.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));


    }


}
