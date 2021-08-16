import { html, LitElement, customElement } from 'lit-element';



@customElement('Ueberfuehreden-boesewicht-view')
export class UeberfuehredenBoesewichtView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
    return html`<div>Content placeholder</div>`;
  }
}
