package com.pip.deepfakes.views.dankeschoen;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@PageTitle("Dankeschön")
@Route(value = "thankyou", layout = MainLayout.class)
@Tag("dankeschoen-view")
@JsModule("./views/dankeschoen/dankeschoen-view.ts")
public class DankeschoenView extends LitTemplate {

    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/

    public DankeschoenView() {
    }
}
