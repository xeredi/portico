import { Component, Input } from '@angular/core';

@Component( {
    selector: 'argo-process-message-grid-fragment',
    templateUrl: './process-message-grid-fragment.component.html'
} )
export class ProcessMessageGridFragmentComponent {
    @Input() itemList: any[];

    constructor() { }
}
