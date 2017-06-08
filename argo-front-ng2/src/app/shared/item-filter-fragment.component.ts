import { Component, Input, OnInit } from '@angular/core';

@Component( {
    selector: 'app-item-filter-fragment',
    templateUrl: './item-filter-fragment.component.html'
} )
export class ItemFilterFragmentComponent implements OnInit {
    @Input() itdtMap: any;
    @Input() enti: any;
    @Input() labelValuesMap: any;
    @Input() port: any;

    entdFilterList: number[];

    ngOnInit() {
        if ( !this.itdtMap ) {
            this.itdtMap = {};
        }

        this.entdFilterList = [];

        this.enti.entdList.map( tpdtId => {
            if ( this.enti.entdMap[tpdtId].filtrable ) {
                this.itdtMap[tpdtId] = this.itdtMap[tpdtId] ? this.itdtMap[tpdtId] : {};
                this.entdFilterList.push( tpdtId );
            }
        } );
    }
}
