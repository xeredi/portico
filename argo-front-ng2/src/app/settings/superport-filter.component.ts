import { Component, Input } from '@angular/core';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component( {
    selector: 'app-superport-filter',
    templateUrl: './superport-filter.component.html'
} )
export class SuperportFilterComponent {
    @Input() name;

    constructor( public activeModal: NgbActiveModal ) { }
}