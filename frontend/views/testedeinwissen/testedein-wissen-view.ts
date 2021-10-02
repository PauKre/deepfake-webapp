import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox-group.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

@customElement('testedein-wissen-view')
export class TestedeinWissenView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-horizontal-layout class="content" style="width: 100%; align-items: flex-start; justify-content: center; background-color:white; height: 100%;">
 <vaadin-vertical-layout theme="spacing" style="align-self: flex-start; align-items: center; justify-content: flex-start; width: 15%;"></vaadin-vertical-layout>
 <vaadin-vertical-layout style="align-self: stretch; align-items: center; justify-content: flex-start; width: 70%; height: 97%; padding: var(--lumo-space-m);">
  <h2 style="color:#B02E0C; align-self: center; height: 3%;">Werde zum Deepfake Experten!</h2>
  <h3>Du bist schon einen Schritt n&auml;her, um dem Waschb&auml;r zu entlarven.<br style="height: 1%;">Beantworte die Fragen der Meisterin Foxi, um dein Wissen zu Testen.</h3>
  <vaadin-horizontal-layout style="align-items: flex-start; width: 100%; height: 60%; align-self: flex-start;">
   <vaadin-vertical-layout style="width: 40%; align-self: flex-start; align-items: flex-start; justify-content: flex-start; height: 100%;">
    <img id="squirrelImgId" style="width: 100%; height: 100%;" src="images/testedeinwissen/squirrel.png">
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" style="width: 60%; height: 100%;">
    <h5 id="questionId" style="align-self: center; color:#B02E0C;">Questionss ??</h5>
    <vaadin-checkbox-group id="questionResId " style="color:white; flex-grow: 0; flex-shrink: 1; height: 100%; align-self: center;" theme="vertical">
     <vaadin-checkbox id="vaadinCheckbox"  value="1">
       Answer 1 
     </vaadin-checkbox>
     <vaadin-checkbox  value="2">
       Answer 2 
     </vaadin-checkbox>
     <vaadin-checkbox  value="3">
       Answer 3 
     </vaadin-checkbox>
    </vaadin-checkbox-group>
    <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1; flex-shrink: 1; width: 100%; justify-content: space-around;">
     <vaadin-button id="prevQuestBttnId">
       Vorherige Frage
     </vaadin-button>
     <vaadin-button id="checkResultBttnId" >
       Ergebnis Überüfen 
     </vaadin-button>
     <vaadin-button id="nextQuestBttnId">
       N&auml;chste Frage 
     </vaadin-button>
    </vaadin-horizontal-layout>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="align-self: flex-start; align-items: center; justify-content: flex-start; width: 15%;"></vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
