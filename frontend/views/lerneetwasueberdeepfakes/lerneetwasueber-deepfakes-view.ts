import { html, LitElement, customElement } from 'lit-element';



@customElement('lerneetwasueber-deepfakes-view')
export class LerneetwasueberDeepfakesView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {

    return html`
      <vaadin-horizontal-layout class="content" style="width: 100%; justify-content: center; align-items: flex-start; background-color:white;">
      <vaadin-vertical-layout theme="spacing" style="width: 50%; margin: var(--lumo-space-m); align-self: flex-start; justify-content: flex-start; align-items: center;">
      <iframe id="prezi" src="https://prezi.com/view/0JLhl8gpxRfqSZFixkFN/embed?&amp;wmode=opaque" width="900" height="600" allowfullscreen="allowfullscreen"></iframe>
          <vaadin-button theme="icon" id="ContinueId">
              Weiter
              <iron-icon icon="lumo:arrow-right"></iron-icon>
          </vaadin-button>
      </vaadin-vertical-layout>
      </vaadin-horizontal-layout>
      `;
  }
}
