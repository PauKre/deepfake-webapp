package com.pip.deepfakes.views.ueberfuehredenboesewicht;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.polymertemplate.Id;
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

    @Id("taeter1")
    private Image tater1;

    @Id("taeter2")
    private Image tater2;

    @Id("taeter3")
    private Image tater3;

    @Id("taeter4")
    private Image tater4;

    @Id("readyButton")
    private Button readyButton;

    @Id("textarea")
    private H3 textArea;

    @Id("header")
    private H2 header;

    @Id("corruptedImg")
    private Image corrupted;


    public UeberfuehredenBoesewichtView() {
        reset();
    }

    private void setUpDecision() {
        readyButton.setVisible(false);
        textArea.setVisible(false);
        corrupted.setVisible(true);
        tater1.setVisible(true);
        tater2.setVisible(true);
        tater3.setVisible(true);
        tater4.setVisible(true);
        tater2.addClickListener(event -> {
//            MainLayout.tabs.setSelectedTab(MainLayout.tabs_instances.get(4));
            tater2.getUI().ifPresent(ui -> ui.navigate("thankyou"));
//            MainLayout.makeProgress(5);
        });
        tater1.addClickListener(imageClickEvent -> handleWrongDecision());
        tater3.addClickListener(imageClickEvent -> handleWrongDecision());
        tater4.addClickListener(imageClickEvent -> handleWrongDecision());
    }

    private void handleWrongDecision() {
        corrupted.setVisible(false);
        tater1.setVisible(false);
        tater2.setVisible(false);
        tater3.setVisible(false);
        tater4.setVisible(false);
        textArea.setVisible(true);
        readyButton.setVisible(true);
        header.setText("Schade");
        textArea.setText("Das war leider nicht der Täter. Versuche es nochmal! Tipp: Achte auf Aspekte wie die Haar- T-shirt- oder Augenfarbe.");
        readyButton.setText("Nochmal versuchen");
        readyButton.addClickListener(event -> {
            readyButton.getUI().ifPresent(ui -> reset() );
        });
    }

    private void reset() {
        header.setText("Überführe den Bösewicht");
        textArea.setVisible(true);
        textArea.setText("Jetzt wird es ernst! Wir haben ein Bild des Bösewichts schießen können, auf dem seine Deepfake Software nicht richtig funktioniert hat. Dadurch sind einzelne Merkmale des Bösewichts erkennbar.");
        readyButton.setVisible(true);
        readyButton.setText("Ich bin bereit");
        readyButton.addClickListener(event -> setUpDecision());
        corrupted.setVisible(false);
        tater1.setVisible(false);
        tater2.setVisible(false);
        tater3.setVisible(false);
        tater4.setVisible(false);
    }
}
