package com.pip.deepfakes.views.lerneetwasüberdeepfakes;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@PageTitle("Lerne etwas über Deepfakes")
@Route(value = "learn", layout = MainLayout.class)
@Tag("lerneetwasüber-deepfakes-view")
@JsModule("./views/lerneetwasüberdeepfakes/lerneetwasüber-deepfakes-view.ts")
public class LerneetwasüberDeepfakesView extends LitTemplate {

    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/

    public LerneetwasüberDeepfakesView() {
    }
}
