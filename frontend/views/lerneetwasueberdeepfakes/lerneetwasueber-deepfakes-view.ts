import { html, LitElement, customElement } from 'lit-element';



@customElement('lerneetwasueber-deepfakes-view')
export class LerneetwasueberDeepfakesView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {

    return html`<button>Content placeholder test123</button>`;
  }
}
