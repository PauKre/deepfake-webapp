import { html, LitElement, customElement } from 'lit-element';



@customElement('erkennedie-deepfakes-view')
export class ErkennedieDeepfakesView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
    return html`<div>Content placeholder</div>`;
  }
}
