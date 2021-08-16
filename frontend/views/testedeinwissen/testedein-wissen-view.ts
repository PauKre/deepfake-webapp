import { html, LitElement, customElement } from 'lit-element';



@customElement('testedein-wissen-view')
export class TestedeinWissenView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
    return html`<div>Content placeholder</div>`;
  }
}
