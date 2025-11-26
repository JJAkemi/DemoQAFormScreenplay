package com.demoqa.stepdefinitions;

import com.demoqa.models.UserForm;
import com.demoqa.questions.ConfirmationModal;
import com.demoqa.tasks.FillForm;
import com.demoqa.utils.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class FormStepDefinitions {

    @Given("that the user opens the DemoQA practice form")
    public void openDemoQAForm() {
        theActorInTheSpotlight().attemptsTo(
                Open.url("https://demoqa.com/automation-practice-form")
        );
    }

    @When("the user fills the form with Excel data row {int}")
    public void fillFormWithExcelData(int rowNumber) {
        String excelPath = "src/test/resources/data/demoqa/users.xlsx";
        List<UserForm> users = ExcelReader.readUsersFromExcel(excelPath);

        UserForm user = users.get(rowNumber - 1);

        theActorInTheSpotlight().attemptsTo(
                FillForm.withData(user)
        );
    }

    @Then("the confirmation modal should be displayed")
    public void confirmationModalDisplays(){
        theActorInTheSpotlight().should(
                seeThat("El modal de confirmación del registro es visible", ConfirmationModal.isVisible(),equalTo(true))
        );
    }
}
