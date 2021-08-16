package com.pip.deepfakes.views.testedeinwissen;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@PageTitle("Teste dein Wissen")
@Route(value = "quiz", layout = MainLayout.class)
@Tag("testedein-wissen-view")
@JsModule("./views/testedeinwissen/testedein-wissen-view.ts")
public class TestedeinWissenView extends LitTemplate {

    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/

    public TestedeinWissenView() {
    }
}
