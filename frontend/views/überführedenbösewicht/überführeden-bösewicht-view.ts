import { html, LitElement, customElement } from 'lit-element';



@customElement('überführeden-bösewicht-view')
export class ÜberführedenBösewichtView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
    return html`<div>Content placeholder</div>`;
  }
}
