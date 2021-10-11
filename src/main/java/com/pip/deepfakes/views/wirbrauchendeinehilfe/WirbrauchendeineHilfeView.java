package com.pip.deepfakes.views.wirbrauchendeinehilfe;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.progressbar.ProgressBarVariant;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.button.Button;

@PageTitle("Wir brauchen deine Hilfe")
@Route(value = "help", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Tag("wirbrauchendeine-hilfe-view")
@JsModule("./views/wirbrauchendeinehilfe/wirbrauchendeine-hilfe-view.ts")
public class WirbrauchendeineHilfeView extends LitTemplate {

    @Id("StartId")
    private Button startButton;

//    @Id("Progress")
//    public ProgressBar learnprogress = new ProgressBar(0.0, 6.0, 1.0);
    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/
	public WirbrauchendeineHilfeView() {
//        learnprogress.addThemeVariants(ProgressBarVariant.LUMO_SUCCESS);
        startButton.addClickListener(event -> {
            startButton.getUI().ifPresent(ui -> ui.navigate("learn"));
//            MainLayout.makeProgress(1);
        });

}
}
