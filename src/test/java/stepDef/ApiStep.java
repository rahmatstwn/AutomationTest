package stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {
    ApiPage apiPage;
    public ApiStep(){
        apiPage = new ApiPage();
    }

    @Given("prepare url valid for {string}")
    public void prepareUrlValidFor(String url) {
        apiPage.prepareUrlValidFor(url);
    }

    @And("hit api get list user")
    public void hitApiGetListUser() {
        apiPage.hitApiGetListUser();
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostCreateNewUser();
    }

    @Then("validation status code is equals to {int}")
    public void validationStatusCodeIsEqualsTo(int status_code) {
        apiPage.validationStatusCodeIsEqualsTo(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }


    @Then("validation response body create user")
    public void validationResponseBodyCreateUser() {
        apiPage.validationResponseBodyCreateUser();
    }

    @And("hit api delete user")
    public void hitApiDeleteUser() {
        apiPage.hitApiDeleteUser();
    }

    @And("hit api update user")
    public void hitApiUpdateUser() {
        apiPage.hitApiUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }

    @And("hit api post create new user blank email")
    public void hitApiPostCreateNewUserBlankEmail() {
        apiPage.hitApiPostCreateNewUserBlankEmail();
    }

    @And("hit api get specified user")
    public void hitApiGetSpecifiedUser() {
        apiPage.hitApiGetSpecifiedUser();
    }

    @And("hit api create user with more than two hundreds char of name")
    public void hitApiCreateUserWithMoreThanTwoHundredsCharOfName() {
        apiPage.hitApiCreateUserWithMoreThanTwoHundredsCharOfName();
    }
}