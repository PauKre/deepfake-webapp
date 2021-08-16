import { html, LitElement, customElement } from 'lit-element';



@customElement('dankeschoen-view')
export class DankeschoenView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
    return html`<div>Content placeholder</div>`;
  }
}
