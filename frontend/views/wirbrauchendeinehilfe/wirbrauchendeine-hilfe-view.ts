import { html, LitElement, customElement } from 'lit-element';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

@customElement('wirbrauchendeine-hilfe-view')
export class WirbrauchendeineHilfeView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
  return html`
<vaadin-horizontal-layout theme="spacing" style="background-color:white; width: 100%; height: 100%;" id="vaadinHorizontalLayout">
 <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="width: 25%; height: 25%;"></vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout1" style="width: 50%; height: 50%;">
  <vaadin-horizontal-layout spacing="false" responsive :middle :center id="vaadinHorizontalLayout1">
   <img id="catImgId" src="images/wirbrauchendeinehilfe/cat.png" responsive style="width: 50%; height: 50%;">
   <img id="porkImgId" src="images/wirbrauchendeinehilfe/pork.png" responsive style="width: 50%; height: 50%;">
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout spacing="false" responsive :middle :center id="vaadinHorizontalLayout2" style="width: 100%; height: 100%;">
   <vaadin-vertical-layout theme="spacing" id="vVerticalLayout1" style="width: 25%; height: 25%;"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="bVerticalLayout12" style="width: 50%; height: 50%;">
    <vaadin-button id="startButtonId" onClick="location.href='learn'" icon="" responsive plain-text :middle :center style="color:white ;background-color:#B02E0C; width: 100%; height: 100%;">
     <iron-icon icon="lumo:arrow-right" slot="suffix" id="ironIcon" style="color:white;"></iron-icon> Start 
    </vaadin-button>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="vVerticalLayout12" style="width: 25%; height: 25%;"></vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout2" style="width: 25%; height: 25%;"></vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }
}