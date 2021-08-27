import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

@customElement('dankeschoen-view')
export class DankeschoenView extends LitElement {
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
<vaadin-horizontal-layout class="content" style="width: 100%; justify-content: center; align-items: flex-start; background-color:white; height: 100%;">
 <vaadin-vertical-layout theme="spacing" style="width: 15%;"></vaadin-vertical-layout>
 <vaadin-vertical-layout style="align-self: stretch; align-items: center; justify-content: flex-start; width: 70%; padding: var(--lumo-space-m); height: 100%;">
  <h2 style="color:#B02E0C; align-self: center; height: 3%;">Danke!</h2>
  <h3 style="color:#B02E0C; flex-grow: 0; align-self: center; height: 9%;">Du hast den Waschbär überführt und das Filmstudio gerettet!<br style="height: 1%;"> Du bist jetzt ein Deepfake Experte!</h3>
  <vaadin-horizontal-layout theme="spacing" style="width: 100%; align-items: flex-start; align-self: flex-start; flex-shrink: 1; flex-grow: 0; height: 60%;">
   <img id="catImgId" style="width: 50%; align-self: flex-start; height: 100%;" src="images/testedeinwissen/squirrel.png">
   <img id="porkImgId" style="width: 50%; align-self: flex-start; height: 100%;" src="images/wirbrauchendeinehilfe/pork.png">
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="width: 15%;"></vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
