package com.pip.deepfakes.views.wirbrauchendeinehilfe;

import com.vaadin.cdi.annotation.UIScoped;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.button.Button;
import org.apache.deltaspike.core.api.resourceloader.InjectableResource;
import org.springframework.beans.factory.BeanFactory;

import javax.inject.Inject;

@PageTitle("Wir brauchen deine Hilfe")
@Route(value = "help", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Tag("wirbrauchendeine-hilfe-view")
@JsModule("./views/wirbrauchendeinehilfe/wirbrauchendeine-hilfe-view.ts")

public class WirbrauchendeineHilfeView extends LitTemplate {

    @Id("StartId")
    private Button startButton;

    @Inject
    private MainLayout mainLayout;


    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/
	public WirbrauchendeineHilfeView() {
        startButton.addClickListener(event -> {
            startButton.getUI().ifPresent(ui -> ui.navigate("learn"));
            mainLayout.makeProgress(1);
        });

}
}
