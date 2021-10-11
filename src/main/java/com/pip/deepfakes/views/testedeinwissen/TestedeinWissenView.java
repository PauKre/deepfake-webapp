package com.pip.deepfakes.views.testedeinwissen;

import com.vaadin.cdi.annotation.UIScoped;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
//import com.vaadin.flow.component.charts.model.style.Style;
import javax.inject.Inject;
import java.util.*;
import java.io.*;

@PageTitle("Teste dein Wissen")
@Route(value = "quiz", layout = MainLayout.class)
@Tag("testedein-wissen-view")
@JsModule("./views/testedeinwissen/testedein-wissen-view.ts")

public class TestedeinWissenView extends LitTemplate {

    @Inject
    private MainLayout mainLayout;

    @Id("becomeExpert")
    private H2 becomeExpert;

    @Id("closer")
    private H3 closer;

    @Id("questionId")
    private H5 questionId;

    @Id("questionResId ")
    private CheckboxGroup questionResId;

    @Id("resultsheader")
    private H2 resultsHeader;

    @Id("resultsText")
    private H5 resultsText;

    @Id("learnButton")
    private Button learnButton;

    private ArrayList<Checkbox> checkboxes;

    //Map<String, String>, ArrayList<String>
    private ArrayList<HashMap<HashMap<String, String>, ArrayList<String>>> questionsDictionary = new ArrayList<HashMap<HashMap<String, String>, ArrayList<String>>>();
    private int[] answers = {2, 1, 2, 1, 3, 2, 1, 2, 3};
    private int nextQuest = 0;
    private int currentQuest = 0;
    private int correct_answers = 0;
    @Id("nextQuestBttnId")
    private Button nextQuestBttnId;
    @Id("checkResultBttnId")
    private Button checkResultBttnId;


    @Id("continueButton")
    private Button continueButton;

    /**
     * Creates a new TestedeinWissenView.
     */
    public TestedeinWissenView() {
        this.getQuestions();
        learnButton.addClickListener(event -> {
            learnButton.getUI().ifPresent(ui -> ui.navigate("learn"));
        });
        // You can initialise any data required for the connected UI components here.;
        //questionResId
        this.getQuestion(this.nextQuest);

        this.nextQuestBttnId.addClickListener(event -> handle_next_question());


        continueButton.setVisible(false);
        resultsText.setVisible(false);
        resultsHeader.setVisible(false);
        checkResultBttnId.setVisible(false);
    }

    private void showFinalResult() {
        this.showResult();
        if (check_for_answer(answers[currentQuest])) {
            correct_answers++;
            Notification notification = new Notification(
                    "Super! Das war die richtige Antwort!", 3000);
            notification.open();
        } else {
            Notification notification = new Notification(
                    "Schade, das war leider die falsche Antwort", 3000);
            notification.open();
        }
        questionResId.setVisible(false);
        questionId.setVisible(false);
        checkResultBttnId.setVisible(false);


        if (correct_answers == 9) {
            resultsText.setText("Du hast alle Fragen richtig beantwortet! Du bist bereit den nächsten Schritt zu machen!");
            resultsHeader.setText("Herzlichen Glückwunsch! Du hast es geschafft!");
            continueButton.addClickListener(event -> {
                mainLayout.tabs.setSelectedTab(mainLayout.tabs_instances.get(2));
                continueButton.getUI().ifPresent(ui -> ui.navigate("detect"));
                mainLayout.makeProgress(3);
            });
        } else {
            String textForDisplay = "Du hast " + correct_answers + " von 9 Fragen richtig beantwortet. Versuche es noch einmal!";
            resultsText.setText(textForDisplay);
            resultsHeader.setText("Schade! Du hast nicht alle Fragen richtig beantwortet.");
            continueButton.setText("Nochmal Versuchen");
            continueButton.addClickListener(event -> nextQuestBttnId.getUI().ifPresent(ui -> ui.navigate("learn")));

        }
        closer.setVisible(false);
        continueButton.setVisible(true);
        becomeExpert.setVisible(false);
        resultsText.setVisible(true);
        resultsHeader.setVisible(true);
    }

    private void handle_next_question() {

        if (check_for_answer(answers[currentQuest])) {
            correct_answers++;
            Notification notification = new Notification(
                    "Super! Das war die richtige Antwort!", 3000);
            notification.open();
        } else {
            Notification notification = new Notification(
                    "Schade, das war leider die falsche Antwort", 3000);
            notification.open();
        }
        if (this.currentQuest == 7) {
            this.nextQuestBttnId.setVisible(false);
            this.checkResultBttnId.setVisible(true);
            this.checkResultBttnId.addClickListener(event -> this.showFinalResult());
        }
        this.showResult();
        this.getQuestion(this.nextQuest);

    }

    private boolean check_for_answer(int answer) {
        answer--;
        for (int i = 0; i < 3; i++) {
            if (i == answer && !checkboxes.get(i).getValue() || (i != answer && checkboxes.get(i).getValue())) {
                return false;
            }
        }
        return true;
    }

    private void showResult() {
        HashMap<HashMap<String, String>, ArrayList<String>> currentQuestionsDictionary = this.questionsDictionary.get(this.currentQuest);
        HashMap<String, String> questi_response = currentQuestionsDictionary.keySet().iterator().next();
        String respomse = questi_response.values().iterator().next();

        Dialog dialog = new Dialog();
        String[] response_list = respomse.split("\\|");
        TextArea t = new TextArea();
        t.setEnabled(false);
        t.setWidth("400px");
        t.setValue(response_list[1]);
        dialog.add(t);


        dialog.open();
    }

    private void getQuestion(int indx) {
        if (indx >= this.questionsDictionary.size() || indx < 0) {
            indx = 0;
        }

        this.nextQuest = indx + 1;
        this.currentQuest = indx;

        HashMap<HashMap<String, String>, ArrayList<String>> nextQuestionsDictionary = this.questionsDictionary.get(indx);
        HashMap<String, String> quesResp = nextQuestionsDictionary.keySet().iterator().next();

        this.questionId.setText(String.valueOf(indx + 1) + ". " + quesResp.keySet().iterator().next());
        this.questionResId.removeAll();

        checkboxes = new ArrayList<>();
        checkboxes.add(new Checkbox());
        checkboxes.add(new Checkbox());
        checkboxes.add(new Checkbox());

        ArrayList<String> posssibleResponses = nextQuestionsDictionary.get(quesResp);
        for (int i = 0; i < 3; i++) {
            checkboxes.get(i).setLabel(posssibleResponses.get(i));
            checkboxes.get(i).getStyle().set("value", posssibleResponses.get(i));
            checkboxes.get(i).getElement().setAttribute("value", posssibleResponses.get(i));
            questionResId.add(checkboxes.get(i));
        }

    }

    private void getQuestions() {

        try {

            String file_path = new File(".").getCanonicalPath();
            file_path = file_path + "\\src\\main\\java\\com\\pip\\deepfakes\\views\\testedeinwissen\\testedeinwissenquestions.txt";
            file_path = file_path.replace("\\", "/");

            File file = new File(file_path);    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;

            String question = "";
            HashMap<String, String> quesResp = new HashMap<>();
            ArrayList<String> posssibleResp = new ArrayList<String>();

            while ((line = br.readLine()) != null) {
                if (line.contains("?")) {
                    question = line;
                } else {
                    if (line.contains("Next-Question")) {
                        HashMap<HashMap<String, String>, ArrayList<String>> questionsDictionary
                                = new HashMap<HashMap<String, String>, ArrayList<String>>();
                        questionsDictionary.put(quesResp, posssibleResp);

                        this.questionsDictionary.add(questionsDictionary);

                        quesResp = new HashMap<>();
                        posssibleResp = new ArrayList<String>();
                    } else {
                        if (line.contains("Antwort")) {
                            quesResp.put(question, line);
                        } else {
                            posssibleResp.add(line);
                        }
                    }
                }
            }

            fr.close();    //closes the stream and release the resources
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   //reads the file
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
