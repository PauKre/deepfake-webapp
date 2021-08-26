import { html, LitElement, customElement } from 'lit-element';



@customElement('lerneetwasueber-deepfakes-view')
export class LerneetwasueberDeepfakesView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {

    return html`<iframe id="prezi" src="https://prezi.com/view/0JLhl8gpxRfqSZFixkFN/embed?&amp;wmode=opaque" width="900" height="600" allowfullscreen="allowfullscreen"></iframe>`;
  }
}
