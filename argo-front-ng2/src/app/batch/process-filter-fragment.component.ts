import { Component, Input, Output, EventEmitter } from '@angular/core';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ProcessService } from './process.service';

@Component( {
    selector: 'argo-process-filter-fragment',
    templateUrl: './process-filter-fragment.component.html'
} )
export class ProcessFilterFragmentComponent {
    @Input() model: any[];
    @Output() onSearch = new EventEmitter<any>();
    @Output() onReset = new EventEmitter<any>();

    procesoEstados: any[];
    procesoModulos: any[];
    procesoTipos: any[];

    constructor(
        private procService: ProcessService
        , private modalService: NgbModal
    ) {
    }

    edit( filter ) {
        this.procService.filter( this.model ).subscribe( resp => {
            this.procesoEstados = resp.procesoEstados;
            this.procesoModulos = resp.procesoModulos;
            this.procesoTipos = resp.procesoTipos;

            this.modalService.open( filter, { size: "lg" } );
        } );
    }

    search() {
        this.onSearch.emit();
    }

    reset() {
        this.onReset.emit();
    }
}
