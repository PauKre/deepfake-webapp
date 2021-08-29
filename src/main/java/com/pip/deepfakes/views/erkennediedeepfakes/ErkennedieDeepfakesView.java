package com.pip.deepfakes.views.erkennediedeepfakes;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.pip.deepfakes.views.MainLayout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import java.util.*;

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
        
        String result = "<div>" + String.valueOf(respomse.equals(choice)) + "<br>" + raison + "</div>";  
        Html html = new Html(result);
        
        Dialog dialog = new Dialog();
        dialog.add(html);
        
        dialog.getElement().getStyle().set("justify-content", "center");
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

        // image 1
        HashMap<String, Boolean> imgResp1 = new HashMap<>();
        imgResp1.put("images/erkennediedeepfakes/squirrel.png", true);
        String raison1 = "Raison1";
        HashMap<HashMap<String, Boolean>,  String> imageDictionary1
                =new HashMap<HashMap<String, Boolean>,  String>();
        imageDictionary1.put(imgResp1, raison1);

        // image 2
        HashMap<String, Boolean> imgResp2 = new HashMap<>();
        imgResp2.put("images/erkennediedeepfakes/cat.png", false);
        String raison2 = "Raison2";
        HashMap<HashMap<String, Boolean>,  String> imageDictionary2
                =new HashMap<HashMap<String, Boolean>,  String>();
        imageDictionary2.put(imgResp2, raison2);

        // image 3
        HashMap<String, Boolean> imgResp3 = new HashMap<>();
        imgResp3.put("images/erkennediedeepfakes/pork.png", true);
        String raison3 = "Raison3";
        HashMap<HashMap<String, Boolean>,  String> imageDictionary3
                =new HashMap<HashMap<String, Boolean>,  String>();
        imageDictionary3.put(imgResp3, raison3);


//    	HashMap<HashMap<String, String>, ArrayList<String>> questionsDictionary = new HashMap <HashMap<String, String>, ArrayList<String>>();

        this.imasgesDictionary.add(imageDictionary1);
        this.imasgesDictionary.add(imageDictionary2);
        this.imasgesDictionary.add(imageDictionary3);

        Collections.shuffle(imasgesDictionary);
    }

}
