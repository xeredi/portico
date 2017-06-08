import { Component, Input, OnInit } from '@angular/core';

@Component( {
    selector: 'app-item-filter-fragment',
    templateUrl: './item-filter-fragment.component.html'
} )
export class ItemFilterFragmentComponent implements OnInit {
    @Input() itdtMap: any;
    @Input() enti: any;

    ngOnInit() {
    }
}
