package com.pip.deepfakes.views.testedeinwissen;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.PropertyDescriptors;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
//import com.vaadin.flow.component.charts.model.style.Style;
import java.util.*;


import javax.validation.OverridesAttribute;

@PageTitle("Teste dein Wissen")
@Route(value = "quiz", layout = MainLayout.class)
@Tag("testedein-wissen-view")
@JsModule("./views/testedeinwissen/testedein-wissen-view.ts")
public class TestedeinWissenView extends LitTemplate {

    @Id("questionId")
    private H5 questionId;
    @Id("questionResId ")
    private CheckboxGroup questionResId;

	//Map<String, String>, ArrayList<String>
    private ArrayList<HashMap<HashMap<String, String>, ArrayList<String>>> questionsDictionary = new ArrayList< HashMap <HashMap<String, String>, ArrayList<String>>>();
	private int nextQuest = 0;
	private int currentQuest = 0;
	
	@Id("nextQuestBttnId")
	private Button nextQuestBttnId;
	@Id("checkResultBttnId")
	private Button checkResultBttnId;
	@Id("prevQuestBttnId")
	private Button prevQuestBttnId;

	/**
     * Creates a new TestedeinWissenView.
     */
    public TestedeinWissenView() {
		this.getQuestions();

        // You can initialise any data required for the connected UI components here.;
		//questionResId
		this.getQuestion(this.nextQuest);
		this.nextQuestBttnId.addClickListener(event -> this.getQuestion(this.nextQuest));
		this.prevQuestBttnId.addClickListener(event -> this.getQuestion(this.currentQuest-1));
		this.checkResultBttnId.addClickListener(event -> this.showResult());

    }
	private void showResult(){
		HashMap<HashMap<String, String>, ArrayList<String>> currentQuestionsDictionary = this.questionsDictionary.get(this.currentQuest);
		HashMap<String, String> questi_response = currentQuestionsDictionary.keySet().iterator().next();
		String respomse = questi_response .values().iterator().next();
				
		Dialog dialog = new Dialog();
		dialog.add(respomse);
		//dialog.setWidth("400px");
		//dialog.setHeight("150px");
		dialog.open();
	}

//private HashMap<HashMap<String, String>, ArrayList<String>> getNext()
	private void getQuestion(int indx){
		if (indx >= this.questionsDictionary.size() || indx < 0 ){
			indx = 0;
		}
		
		this.nextQuest = indx + 1;
		this.currentQuest = indx;
		
		HashMap<HashMap<String, String>, ArrayList<String>> nextQuestionsDictionary = this.questionsDictionary.get(indx);
		HashMap<String, String> quesResp = nextQuestionsDictionary.keySet().iterator().next();

		this.questionId.setText(quesResp.keySet().iterator().next());
		this.questionResId.removeAll();

		ArrayList<String> posssibleResponses = nextQuestionsDictionary.get(quesResp);
		for (String response : posssibleResponses) {
			Checkbox vaadinCheckbox =new Checkbox();
			vaadinCheckbox.setLabel(response);
			vaadinCheckbox.getStyle().set("background-color", "#8EB1C7");
			vaadinCheckbox.getStyle().set("flex-grow", "0");
			vaadinCheckbox.getStyle().set("flex-shrink", "1");
			vaadinCheckbox.getStyle().set("margin", "var(--lumo-space-s)");
			vaadinCheckbox.getStyle().set("value", response);
			//PropertyDescriptor<String, String> VALUE = PropertyDescriptors.attributeWithDefault("value", response);
			//vaadinCheckbox.set(PropertyDescriptors.attributeWithDefault("value",response),  response);
			vaadinCheckbox.getElement().setAttribute("value", response);
			questionResId.add(vaadinCheckbox);
			//questionResId.setItems(posssibleResponses);
		}

		//return result;
	}

    //HashMap<HashMap<String, String>, ArrayList<String>>
	// generate a dictionary of possibles questions
    private void getQuestions() {
    	
    	// question 1
    	HashMap<String, String> quesResp1 = new HashMap<>();
    	ArrayList<String> posssibleResp1 = new ArrayList<String>();
    	quesResp1.put("question1", "Ansuwer1");
    	posssibleResp1.add(quesResp1.get("question1"));
    	posssibleResp1.add("Ansuwer2");
    	posssibleResp1.add("Ansuwer3");
    	Collections.shuffle(posssibleResp1);
		HashMap<HashMap<String, String>, ArrayList<String>> questionsDictionary1
				=new HashMap <HashMap<String, String>, ArrayList<String>>();
		questionsDictionary1.put(quesResp1, posssibleResp1);
    	
    	
    	
    	// question 2    	
    	HashMap<String, String> quesResp2 = new HashMap<>();
    	ArrayList<String> posssibleResp2 = new ArrayList<String>();
    	quesResp2.put("question2", "Ansuwer2");
    	posssibleResp2.add(quesResp2.get("question2"));
    	posssibleResp2.add("Ansuwer2");
    	posssibleResp2.add("Ansuwer3");
    	Collections.shuffle(posssibleResp2);
		HashMap<HashMap<String, String>, ArrayList<String>> questionsDictionary2
				=new HashMap <HashMap<String, String>, ArrayList<String>>();
		questionsDictionary2.put(quesResp2, posssibleResp2);
    	
    	
    	// question 3    	
    	HashMap<String, String> quesResp3 = new HashMap<>();
    	ArrayList<String> posssibleResp3 = new ArrayList<String>();
    	quesResp3.put("question3", "Ansuwer3");
    	posssibleResp3.add(quesResp3.get("question3"));
    	posssibleResp3.add("Ansuwer2");
    	posssibleResp3.add("Ansuwer3");
    	Collections.shuffle(posssibleResp3);
		HashMap<HashMap<String, String>, ArrayList<String>> questionsDictionary3
				=new HashMap <HashMap<String, String>, ArrayList<String>>();
		questionsDictionary3.put(quesResp3, posssibleResp3);
    	
    	
    	
//    	HashMap<HashMap<String, String>, ArrayList<String>> questionsDictionary = new HashMap <HashMap<String, String>, ArrayList<String>>();

    	this.questionsDictionary.add(questionsDictionary1);
		this.questionsDictionary.add(questionsDictionary2);
		this.questionsDictionary.add(questionsDictionary3);

    	//return questionsDictionary;
	}

}
