import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

@customElement('wirbrauchendeine-hilfe-view')
export class WirbrauchendeineHilfeView extends LitElement {
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
<vaadin-horizontal-layout class="content" style="width: 100%; justify-content: center; align-items: flex-start; background-color:white;">
 <vaadin-vertical-layout theme="spacing" style="width: 25%;"></vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="width: 50%; margin: var(--lumo-space-m); align-self: flex-start; justify-content: flex-start; align-items: center;">
  <div style="align-self: center;">
   <h2 style="color:#B02E0C; align-self: center; flex-grow: 0; flex-shrink: 1; padding: var(--lumo-space-m );">Werde zum Deepfake Experten!</h2>
  </div>
  <vaadin-horizontal-layout theme="spacing" style="width: 100%; align-items: flex-start; justify-content: center; align-self: center; flex-shrink: 1; flex-grow: 0;">
   <iframe width="560" height="315" src="https://www.youtube.com/embed/nt308HZ4cuo?controls=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
   <vaadin-vertical-layout theme="spacing" style="width: 25%;"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" style="width: 50%; align-self: flex-start;">
    <vaadin-button theme="icon" id="StartId">
      Start 
     <iron-icon icon="lumo:arrow-right"></iron-icon>
    </vaadin-button>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" style="width: 25%;"></vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="width: 25%;"></vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }
  
  
  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }

}
