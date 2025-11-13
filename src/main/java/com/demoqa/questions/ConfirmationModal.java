package com.demoqa.questions;

import com.demoqa.ui.DemoQAFormPage;
import net.serenitybdd.screenplay.Question;

public class ConfirmationModal {
    public static Question<Boolean> isVisible(){
        return actor-> DemoQAFormPage.CONFIRMATION_MODAL.resolveFor(actor).isVisible();
    }
}
