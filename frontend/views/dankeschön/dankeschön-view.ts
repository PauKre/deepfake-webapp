import { html, LitElement, customElement } from 'lit-element';



@customElement('dankeschön-view')
export class DankeschönView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
    return html`<div>Content placeholder</div>`;
  }
}
