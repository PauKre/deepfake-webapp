package com.pip.deepfakes.views.testedeinwissen;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextArea;
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
import java.io.*;  
import java.net.URL;


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
		String[] respomse_list = respomse.split("\\|");
		
		TextArea t = new TextArea();
		t.setWidth("400px");
		t.getStyle().set("background-color", "white");
		t.getStyle().set("color", "#B02E0C");
		t.setValue(respomse_list[0] + "\n" + respomse_list[1]);
		dialog.add(t);
		
		//String result = "<div>" + respomse_list[0] + "<br>" + respomse_list[1] + "</div>";  
        //Html html = new Html(result);
        //dialog.add(html);
		
		
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
			vaadinCheckbox.getStyle().set("background-color", "#B02E0C");
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
    	
		try {
			
			String file_path = new File(".").getCanonicalPath();
			file_path  = file_path  + "\\src\\main\\java\\com\\pip\\deepfakes\\views\\testedeinwissen\\testedeinwissenquestions.txt";
			file_path = file_path.replace("\\", "/");
			
			File file=new File(file_path);    //creates a new file instance  
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
			String line;  
			
			String question="";
			HashMap<String, String> quesResp = new HashMap<>();
	    	ArrayList<String> posssibleResp = new ArrayList<String>();
			
			while((line=br.readLine())!=null)  
			{  
				if (line.contains("?")) {
					question = line;
				}
				else {
					if (line.contains("Next-Question")) {
						HashMap<HashMap<String, String>, ArrayList<String>> questionsDictionary
						=new HashMap <HashMap<String, String>, ArrayList<String>>();
						questionsDictionary.put(quesResp, posssibleResp);
						
						this.questionsDictionary.add(questionsDictionary);
						
						quesResp = new HashMap<>();
						posssibleResp = new ArrayList<String>();
					}
					else {
						if (line.contains("Antwort")) {
							quesResp.put(question, line);
						}
						else {
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
