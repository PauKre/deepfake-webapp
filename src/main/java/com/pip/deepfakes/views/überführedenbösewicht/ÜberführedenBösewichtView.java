package com.pip.deepfakes.views.überführedenbösewicht;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@PageTitle("Überführe den Bösewicht")
@Route(value = "solve", layout = MainLayout.class)
@Tag("überführeden-bösewicht-view")
@JsModule("./views/überführedenbösewicht/überführeden-bösewicht-view.ts")
public class ÜberführedenBösewichtView extends LitTemplate {

    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/

    public ÜberführedenBösewichtView() {
    }
}
