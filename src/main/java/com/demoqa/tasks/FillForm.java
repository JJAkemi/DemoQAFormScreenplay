package com.demoqa.tasks;

import com.demoqa.models.UserForm;
import com.demoqa.ui.DemoQAFormPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillForm {

    public static Performable withData(UserForm user) {
        return Task.where("{0} fills the DemoQA form with Excel data",
                actor -> actor.attemptsTo(
                        // Corregido: Usar isCurrentlyEnabled() en todos los campos de entrada
                        WaitUntil.the(DemoQAFormPage.FIRST_NAME, isCurrentlyEnabled()).forNoMoreThan(15).seconds(),
                        Enter.theValue(user.getFirstName()).into(DemoQAFormPage.FIRST_NAME),

                        WaitUntil.the(DemoQAFormPage.LAST_NAME, isCurrentlyEnabled()).forNoMoreThan(15).seconds(),
                        Enter.theValue(user.getLastName()).into(DemoQAFormPage.LAST_NAME),

                        // ⬅️ CORRECCIÓN CLAVE AQUÍ: EMAIL
                        WaitUntil.the(DemoQAFormPage.EMAIL, isCurrentlyEnabled()).forNoMoreThan(15).seconds(),
                        Enter.theValue(user.getEmail()).into(DemoQAFormPage.EMAIL),

                        selectGender(user.getGender()),

                        WaitUntil.the(DemoQAFormPage.MOBILE, isCurrentlyEnabled()).forNoMoreThan(15).seconds(),
                        Enter.theValue(user.getMobile()).into(DemoQAFormPage.MOBILE),

                        //setDateOfBirth(user.getDateOfBirth())

                        // Este ya estaba correcto:
                        WaitUntil.the(DemoQAFormPage.SUBJECTS, isCurrentlyEnabled()).forNoMoreThan(10).seconds(),
                        Enter.theValue(user.getSubject()).into(DemoQAFormPage.SUBJECTS).thenHit(Keys.ENTER),

                        selectHobbie(user.getHobbie()),

                        WaitUntil.the(DemoQAFormPage.ADDRESS, isCurrentlyEnabled()).forNoMoreThan(15).seconds(),
                        Enter.theValue(user.getAddress()).into(DemoQAFormPage.ADDRESS),

                        // Los campos de STATE/CITY (autocompletado) requieren ENTER
                        WaitUntil.the(DemoQAFormPage.STATE, isCurrentlyEnabled()).forNoMoreThan(15).seconds(),
                        Enter.theValue(user.getState()).into(DemoQAFormPage.STATE).thenHit(Keys.ENTER),

                        WaitUntil.the(DemoQAFormPage.CITY, isCurrentlyEnabled()).forNoMoreThan(15).seconds(),
                        Enter.theValue(user.getCity()).into(DemoQAFormPage.CITY).thenHit(Keys.ENTER),

                        WaitUntil.the(DemoQAFormPage.SUBMIT_BUTTON, isVisible()).forNoMoreThan(15).seconds(),
                        Scroll.to(DemoQAFormPage.SUBMIT_BUTTON), // Mantener Scroll para asegurar que el botón esté en vista
                        Click.on(DemoQAFormPage.SUBMIT_BUTTON)
                ));
    }

    private static Performable selectGender(String gender) {
        return Task.where("{0} selects gender " + gender,
                actor -> {
                    switch (gender.toLowerCase()) {
                        case "male" -> actor.attemptsTo(Click.on(DemoQAFormPage.GENDER_MALE));
                        case "female" -> actor.attemptsTo(Click.on(DemoQAFormPage.GENDER_FEMALE));
                        case "other" -> actor.attemptsTo(Click.on(DemoQAFormPage.GENDER_OTHER));
                        default -> actor.attemptsTo(Click.on(DemoQAFormPage.GENDER_MALE));
                    }
                });
    }

    private static Performable selectHobbie(String hobbie) {
        return Task.where("{0} selects hobbie " + hobbie,
                actor -> {
                    switch (hobbie.toLowerCase()) {
                        case "sports" -> actor.attemptsTo(Click.on(DemoQAFormPage.HOBBIES_SPORTS));
                        case "reading" -> actor.attemptsTo(Click.on(DemoQAFormPage.HOBBIES_READING));
                        case "music" -> actor.attemptsTo(Click.on(DemoQAFormPage.HOBBIES_MUSIC));
                        default -> actor.attemptsTo(Click.on(DemoQAFormPage.HOBBIES_SPORTS));
                    }
                });
    }

    private static Performable setDateOfBirth(String dob) {
        return Task.where("{0} sets date of birth " + dob,
                actor -> {
                    actor.attemptsTo(
                            WaitUntil.the(DemoQAFormPage.DATE_OF_BIRTH, isVisible()).forNoMoreThan(20).seconds(),
                            Scroll.to(DemoQAFormPage.DATE_OF_BIRTH),
                            Click.on(DemoQAFormPage.DATE_OF_BIRTH),
                            Clear.field(DemoQAFormPage.DATE_OF_BIRTH),
                            Enter.theValue(dob).into(DemoQAFormPage.DATE_OF_BIRTH).thenHit(Keys.ENTER)
                    );
                });
    }
}
