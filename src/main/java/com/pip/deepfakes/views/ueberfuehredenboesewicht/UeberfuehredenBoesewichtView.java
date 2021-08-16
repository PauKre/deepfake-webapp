package com.pip.deepfakes.views.ueberfuehredenboesewicht;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@PageTitle("Überführe den Bösewicht")
@Route(value = "solve", layout = MainLayout.class)
@Tag("ueberfuehreden-boesewicht-view")
@JsModule("./views/ueberfuehredenboesewicht/ueberfuehreden-boesewicht-view.ts")
public class UeberfuehredenBoesewichtView extends LitTemplate {

    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/

    public UeberfuehredenBoesewichtView() {
    }
}
