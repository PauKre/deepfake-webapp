package com.pip.deepfakes.views.erkennediedeepfakes;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import java.util.*;
import java.io.*;

@PageTitle("Erkenne die Deepfakes")
@Route(value = "detect", layout = MainLayout.class)
@Tag("erkennedie-deepfakes-view")
@JsModule("./views/erkennediedeepfakes/erkennedie-deepfakes-view.ts")
public class ErkennedieDeepfakesView extends LitTemplate {
    ArrayList<HashMap<HashMap<String, Boolean>,  String>> imasgesDictionary = new ArrayList< HashMap <HashMap<String, Boolean>, String>>();
	//private ArrayList<HashMap<String, Boolean>> imasgesDictionary = new ArrayList<HashMap<String, Boolean>>();
    private int nextImg = 0;
    private int currentImg = 0;
    @Id("imageId")
    private Image imageId;
    @Id("nextImgBttnId")
    private Button nextImgBttnId;
    @Id("prevImgBttnId")
    private Button prevImgBttnId;
    @Id("fakeBttnId")
    private Button fakeBttnId;
    @Id("echtBttnId")
    private Button echtBttnId;

    /**
     * Creates a new ErkennedieDeepfakesView.
     */
    public ErkennedieDeepfakesView() {
        this.getImages();
        
        this.getImg(this.nextImg);
        this.nextImgBttnId.addClickListener(event -> this.getImg(this.nextImg));
        this.prevImgBttnId.addClickListener(event -> this.getImg(this.currentImg-1));
        this.fakeBttnId.addClickListener(event -> this.showResult(true));
        this.echtBttnId.addClickListener(event -> this.showResult(false));
    }

    private void showResult(Boolean choice){

        HashMap<HashMap<String, Boolean>, String> currentImgDictionary = this.imasgesDictionary.get(this.currentImg);
        HashMap<String, Boolean> imgResp = currentImgDictionary.keySet().iterator().next();
        String imgName = imgResp.keySet().iterator().next();
        Boolean respomse = imgResp.values().iterator().next();
        String raison = currentImgDictionary.values().iterator().next();
        
        //String result = "<div>" + String.valueOf(respomse.equals(choice)) + "<br>" + raison + "</div>";  
        //Html html = new Html(result);
        
        Dialog dialog = new Dialog();
        //dialog.add(html);
        
        //dialog.getElement().getStyle().set("justify-content", "center");
        
        TextArea t = new TextArea();
		t.setWidth("400px");
		t.getStyle().set("background-color", "white");
		t.getStyle().set("color", "#B02E0C");
		if (respomse.equals(choice)) {
			t.setValue("Richtig" + "\n" + raison);
		}else {
			t.setValue("Falsche" + "\n" + raison);
		}
		
		dialog.add(t);
        
        //dialog.getElement().getStyle().set("margin", "var(--lumo-space-s)");
        
        dialog.open();
    }

    private void getImg(int indx){
        if (indx >= this.imasgesDictionary.size() || indx < 0 ){
            indx = 0;
        }

        this.nextImg = indx + 1;
        this.currentImg = indx;

        HashMap<HashMap<String, Boolean>, String> nextImgDictionary = this.imasgesDictionary.get(indx);
        HashMap<String, Boolean> imgResp = nextImgDictionary.keySet().iterator().next();
        String imgName = imgResp.keySet().iterator().next();
        this.imageId.getElement().setAttribute("src", imgName);
    }

    // generate a dictionary of possibles images: true: the image is facke , false: the image is echt
    private void getImages() {
    	
        try {
			
			String file_path = new File(".").getCanonicalPath();
			file_path  = file_path  + "\\src\\main\\java\\com\\pip\\deepfakes\\views\\erkennediedeepfakes\\erkennediedeepfakesquestions.txt";
			file_path = file_path.replace("\\", "/");
			
			File file=new File(file_path);    //creates a new file instance  
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
			String line;  
			
			
			HashMap<String, Boolean> imgResp = new HashMap<>();
			String raison="";
			
			while((line=br.readLine())!=null)  
			{  
				if (line.contains(".jpg") || line.contains(".png") || line.contains(".jpeg") || line.contains(".JPG") ) {
					String images_files= "images/erkennediedeepfakes/"+line;
					if (line.contains("real")) {
						imgResp.put(images_files, false);
					}else {
						imgResp.put(images_files, true);
					}
				}
				else {
					if (line.contains("Next-Question")) {
						HashMap<HashMap<String, Boolean>,  String> imageDictionary
		                =new HashMap<HashMap<String, Boolean>,  String>();
						imageDictionary.put(imgResp, raison);
						
						this.imasgesDictionary.add(imageDictionary);
						
						imgResp = new HashMap<>();
					}
					else {
						raison = line;
					}
				}
			}
			
			fr.close();    //closes the stream and release the resources  
			Collections.shuffle(this.imasgesDictionary);
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
