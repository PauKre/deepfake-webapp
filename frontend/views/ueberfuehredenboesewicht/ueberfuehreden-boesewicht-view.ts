import { html, LitElement, customElement } from 'lit-element';



@customElement('ueberfuehreden-boesewicht-view')
export class UeberfuehredenBoesewichtView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  render() {
    return html`
        <vaadin-horizontal-layout class="content" style="width: 100%; align-items: flex-start; justify-content: center; height: 100%;">
            <vaadin-vertical-layout theme="spacing" style="align-self: flex-start; align-items: center; justify-content: flex-start; width: 5%;"></vaadin-vertical-layout>
            <vaadin-vertical-layout style="align-self: center; align-items: center; justify-content: center; width: 70%; height: 100%; padding: var(--lumo-space-m);">
                <h2>Überführe den Bösewicht</h2>
                <h3>Jetzt wird es ernst! Wir haben ein Bild des Bösewichts schießen können, auf dem seine Deepfake Software nicht richtig funktioniert hat. Dadurch sind einzelne Merkmale des Bösewichts erkennbar. Tipp: Achte auf Aspekte wie die Haar- oder Augenfarbe.</h3>
              <img id="corruptedImg" style="width: 50%; align-self: flex-start;" src="images/ueberfuehre_den_boesewicht/corrupted.png">
                <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1; flex-shrink: 1; width: 100%; justify-content: center; height: 10%;">
                  <img id="corruptedImg" style="width: 50%; align-self: flex-start;" src="images/ueberfuehre_den_boesewicht/corrupted.png">
                    <vaadin-button id="fakeBttnId" >
                        Fake
                    </vaadin-button>
                    <vaadin-button id="echtBttnId" >
                        Echt
                    </vaadin-button>
                    <vaadin-button  id="nextImgBttnId">
                        N&auml;chste Frage
                    </vaadin-button>
                </vaadin-horizontal-layout>
            </vaadin-vertical-layout>
            <vaadin-vertical-layout theme="spacing" style="align-self: flex-start; align-items: center; justify-content: flex-start; width: 15%;"></vaadin-vertical-layout>
        </vaadin-horizontal-layout>
    `;
  }
}
