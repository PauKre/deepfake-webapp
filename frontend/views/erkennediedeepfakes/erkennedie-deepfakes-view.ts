import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-button/src/vaadin-button.js';

@customElement('erkennedie-deepfakes-view')
export class ErkennedieDeepfakesView extends LitElement {
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
 <vaadin-vertical-layout theme="spacing" style="align-self: flex-start; align-items: center; justify-content: flex-start; width: 5%;"></vaadin-vertical-layout>
 <vaadin-vertical-layout style="align-self: center; align-items: center; justify-content: center; width: 70%; height: 100%; padding: var(--lumo-space-m);">
  <h2 style="color:#B02E0C; align-self: center; height: 3%;">Werde zum Deepfake Experten!</h2>
  <h3 style="color:#B02E0C; align-self: center; flex-grow: 0; height: 6%;">Trainiere deine Fähigkeit Deepfakes zu erkennen!</h3>
  <img id="imageId" style="width: 60%; height: 60%; align-self: center;">
  <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1; flex-shrink: 1; width: 100%; justify-content: center; height: 10%;">
   <vaadin-button id="prevImgBttnId" >
     Vorherige Frage 
   </vaadin-button>
   <vaadin-button id="fakeBttnId" >
     Fake 
   </vaadin-button>
   <vaadin-button id="echtBttnId" >
     Echt 
   </vaadin-button>
   <vaadin-button  id="nextImgBttnId">
     N&auml;chste Frage
   </vaadin-button>
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
