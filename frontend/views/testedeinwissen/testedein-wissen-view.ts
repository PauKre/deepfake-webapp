import { html, LitElement, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';

@customElement('testedein-wissen-view')
export class TestedeinWissenView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
    return html`
<vaadin-horizontal-layout class="content" style=" background-color:white; width: 100%; height: 100%;">
 <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="width: 15%;"></vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout1" style="width: 70%;">
<div >
  <h2 responsive plain-text style="color:#B02E0C; margin: var(--lumo-space-m); flex-shrink: 1;">Werde zum Deepfake Experten!
</h2>
<h3 responsive plain-text style="color:#B02E0C; margin: var(--lumo-space-m); flex-shrink: 1;">
Du bist schon einen Schritt näher, um dem Waschbär zu entlarven. </br> 
Beantworte die Fragen der Meisterin Foxi, um dein Wissen zu Testen.
</h3>
</div>
  <vaadin-horizontal-layout spacing="false" responsive :middle :center id="vaadinHorizontalLayout1">
   <img id="catImgId" src="images/testedeinwissen/squirrel.png" responsive style=" width: 50%; height: 60%;">
   <vaadin-vertical-layout spacing="false" responsive size-auto margin="false" :right>
    <vaadin-label plain-text :center>
      Label 
    </vaadin-label>
    <vaadin-select value="Item one">
     <template>
      <vaadin-list-box selected="0">
       <vaadin-item selected>
         Item one 
       </vaadin-item>
       <vaadin-item>
         Item two 
       </vaadin-item>
       <vaadin-item>
         Item three 
       </vaadin-item>
      </vaadin-list-box>
     </template>
    </vaadin-select>
    <vaadin-horizontal-layout>
     <vaadin-button responsive id="checkResultBttnId" plain-text>
       Check Result 
     </vaadin-button>
     <vaadin-button responsive id="nextQuestBttnId" plain-text :right>
       Next 
     </vaadin-button>
    </vaadin-horizontal-layout>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="width: 15%;"></vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }
}
