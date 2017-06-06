import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import { ChargeService } from './charge.service';

@Component( {
    selector: 'app-charge-typeahead',
    templateUrl: './charge-typeahead.component.html'
} )
export class ChargeTypeaheadComponent implements OnInit {
    @Input() public tpsrId: number;

    public model: any;

    constructor( private chrgService: ChargeService ) { }

    ngOnInit() {
    }

    search = ( text$: Observable<any> ) => {
        return text$
            .debounceTime( 200 )
            .distinctUntilChanged()
            .switchMap( term => {
                return this.chrgService.typeahead( { tpsrId: this.tpsrId, textoBusqueda: term } )
                    .map(( response ) => {
                        console.log( "Search OK!!: " + JSON.stringify( response.resultList ) );

                        return response.resultList;
                    } );
            } );
    }

    resultFormatter = ( result: any ) => result.etiqueta;

    inputFormatter = ( result: any ) => result.etiqueta;

}
