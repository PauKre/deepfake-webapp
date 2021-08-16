package com.pip.deepfakes.views.dankeschön;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@PageTitle("Dankeschön")
@Route(value = "thankyou", layout = MainLayout.class)
@Tag("dankeschön-view")
@JsModule("./views/dankeschön/dankeschön-view.ts")
public class DankeschönView extends LitTemplate {

    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/

    public DankeschönView() {
    }
}
