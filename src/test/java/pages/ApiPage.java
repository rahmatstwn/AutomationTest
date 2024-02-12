package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {
    String setURL, global_id;
    Response res;

    public void prepareUrlValidFor(String url){
        switch (url){
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_USER":
                setURL = Endpoint.CREATE_USER;
                break;
            case "DELETE_USER":
                setURL = Endpoint.DELETE_USER;
                break;
            case "GET_USER_BY_ID":
                setURL = Endpoint.GET_USER_BY_ID;
                break;
            default:
                System.out.println("input right URL");
        }
        //System.out.println("endpoint siap pakai adalah : " + setURL);
    }
    public void hitApiGetListUser(){
        res = getListUsers(setURL);
        //System.out.println(res.getBody().asString());
    }
    public void hitApiPostCreateNewUser(){
        res = postCreateUser(setURL);
    }
    public void hitApiPostCreateNewUserBlankEmail() {
        res = hitAPIcreateBlankEmail(setURL);
    }
    public void validationStatusCodeIsEqualsTo(int status_code){
        assertThat(res.getStatusCode()).isEqualTo(status_code);
    }
    public void validationResponseBodyGetListUsers(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("male", "female");
        assertThat(status.get(0)).isIn("active", "inactive");
    }
    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONSchemaFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONSchemaFile));
    }
    public void validationResponseBodyCreateUser(){
        JsonPath jsonPath = res.jsonPath();
        Integer id = jsonPath.getInt("id");
        String name = jsonPath.getString("name");
        String email = jsonPath.getString("email");
        String gender = jsonPath.getString("gender");
        String status = jsonPath.getString("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("male", "female");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }

    public void hitApiDeleteUser(){
        res = deleteUser(setURL, global_id);
    }

    public void hitApiUpdateUser(){
        res = updateUser(setURL, global_id);
    }
    public void validationResponseBodyUpdateUser(){
        JsonPath jsonPath = res.jsonPath();
        Integer id = jsonPath.getInt("id");
        String name = jsonPath.getString("name");
        String email = jsonPath.getString("email");
        String gender = jsonPath.getString("gender");
        String status = jsonPath.getString("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("male", "female");
        assertThat(status).isIn("active", "inactive");

    }
    public void hitApiGetSpecifiedUser(){
        res = getSpecifiedUser(setURL);
    }

    public void hitApiCreateUserWithMoreThanTwoHundredsCharOfName(){
        res = createUserMorethan200(setURL);
    }
}
