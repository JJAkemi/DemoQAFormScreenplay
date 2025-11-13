package com.demoqa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DemoQAFormPage {

    public static final Target FIRST_NAME = Target.the("first name field").located(By.id("firstName"));
    public static final Target LAST_NAME = Target.the("last name field").located(By.id("lastName"));
    public static final Target EMAIL = Target.the("email field").located(By.id("userEmail"));

    public static final Target GENDER_MALE = Target.the("male gender").located(By.xpath("//label[@for='gender-radio-1']"));
    public static final Target GENDER_FEMALE = Target.the("female gender").located(By.xpath("//label[@for='gender-radio-2']"));
    public static final Target GENDER_OTHER = Target.the("other gender").located(By.xpath("//label[@for='gender-radio-3']"));

    public static final Target MOBILE = Target.the("mobile field").located(By.id("userNumber"));
    public static final Target DATE_OF_BIRTH = Target.the("date of birth field").located(By.id("dateOfBirthInput"));

    public static final Target SUBJECTS = Target.the("subjects input").located(By.id("subjectsInput"));

    public static final Target HOBBIES_SPORTS = Target.the("hobby sports").located(By.xpath("//label[@for='hobbies-checkbox-1']"));
    public static final Target HOBBIES_READING = Target.the("hobby reading").located(By.xpath("//label[@for='hobbies-checkbox-2']"));
    public static final Target HOBBIES_MUSIC = Target.the("hobby music").located(By.xpath("//label[@for='hobbies-checkbox-3']"));

    public static final Target ADDRESS = Target.the("address field").located(By.id("currentAddress"));
    public static final Target STATE = Target.the("state dropdown").located(By.id("react-select-3-input"));
    public static final Target CITY = Target.the("city dropdown").located(By.id("react-select-4-input"));

    public static final Target SUBMIT_BUTTON = Target.the("submit button").located(By.id("submit"));

    public static final Target CONFIRMATION_MODAL = Target.the("confirmation modal").located(By.id("example-modal-sizes-title-lg"));
}
