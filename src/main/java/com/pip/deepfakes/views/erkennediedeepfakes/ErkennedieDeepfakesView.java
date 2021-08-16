package com.pip.deepfakes.views.erkennediedeepfakes;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@PageTitle("Erkenne die Deepfakes")
@Route(value = "detect", layout = MainLayout.class)
@Tag("erkennedie-deepfakes-view")
@JsModule("./views/erkennediedeepfakes/erkennedie-deepfakes-view.ts")
public class ErkennedieDeepfakesView extends LitTemplate {

    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/

    public ErkennedieDeepfakesView() {
    }
}
