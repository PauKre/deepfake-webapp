import { html, LitElement, customElement } from 'lit-element';



@customElement('wirbrauchendeine-hilfe-view')
export class WirbrauchendeineHilfeView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
    return html`<div>Content placeholder</div>`;
  }
}
