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
<vaadin-horizontal-layout class="content" style="width: 100%; justify-content: center; align-items: flex-start; height: 100%;">
 <vaadin-vertical-layout theme="spacing" style="width: 15%;"></vaadin-vertical-layout>
 <vaadin-vertical-layout style="align-self: stretch; align-items: center; justify-content: flex-start; width: 70%; padding: var(--lumo-space-m); height: 100%;">
  <h2>Danke!</h2>
  <h3>Du hast den Waschb&auml;r überführt und das Filmstudio gerettet!<br style="height: 1%;"> Du bist jetzt ein Deepfake Experte!</h3>
  <vaadin-horizontal-layout theme="spacing" style="align-items: center; align-self: center; flex-shrink: 1; flex-grow: 0; height: 60%;">
      <iframe width="560" height="315" src="https://www.youtube.com/embed/gJefCI8jdZs?controls=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
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
