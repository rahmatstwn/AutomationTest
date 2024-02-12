package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.getRandomEmail;

//buat hit api pakai restassured
public class Models {
    private static RequestSpecification request;
    public static void setupHeaders(){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer fa782217f2035a1c2f636b8b18ac9e008f17beb17020245f521ee938ab068adb");
    }
    public static void setupHeadersUnValidToken(){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer abcdefghijklmng");
    }

    public static Response getListUsers(String endpoint){
        setupHeaders();
        return request.when().get(endpoint);
    }
    public static Response postCreateUser(String endpoint){
        String name = "JayJay";
        String gender = "male";
        String status = "active";
        String email = getRandomEmail();
        JSONObject data = new JSONObject();
        data.put("name", name);
        data.put("gender", gender);
        data.put("status", status);
        data.put("email", email);
        setupHeaders();
        return request.body(data.toString()).when().post(endpoint);
    }
    public static Response deleteUser(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }
    public static Response updateUser(String endpoint, String user_id){
        String name = "JayJay Edit";
        String gender = "male";
        String status = "active";
        String email = getRandomEmail();

        JSONObject data = new JSONObject();
        data.put("name", name);
        data.put("gender", gender);
        data.put("status", status);
        data.put("email", email);

        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(data.toString()).when().patch(finalEndpoint);
    }
    public static Response hitAPIcreateBlankEmail(String endpoint){
        String name = "Jay Jay";
        String gender = "male";
        String status = "active";
        String email = "";
        JSONObject data = new JSONObject();
        data.put("name", name);
        data.put("gender", gender);
        data.put("status", status);
        data.put("email", email);
        setupHeaders();
        return request.body(data.toString()).when().post(endpoint);
    }
    public static Response getSpecifiedUser(String endpoint){
        setupHeadersUnValidToken();
        return request.when().get(endpoint);
    }
    public static Response createUserMorethan200(String endpoint){
        String name = "JayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJayJay";
        String gender = "male";
        String status = "active";
        String email = getRandomEmail();
        JSONObject data = new JSONObject();
        data.put("name", name);
        data.put("gender", gender);
        data.put("status", status);
        data.put("email", email);
        setupHeaders();
        return request.body(data.toString()).when().post(endpoint);
    }
}
