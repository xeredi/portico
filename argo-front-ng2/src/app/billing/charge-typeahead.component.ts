import {
    Component,
    Optional,
    Inject,
    Input,
    ViewChild,
    OnInit
} from '@angular/core';

import {
    NgModel,
    NG_VALUE_ACCESSOR,
    NG_VALIDATORS,
    NG_ASYNC_VALIDATORS,
} from '@angular/forms';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import { ChargeService } from './charge.service';

@Component( {
    selector: 'app-charge-typeahead',
    templateUrl: './charge-typeahead.component.html',
    providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: ChargeTypeaheadComponent,
        multi: true,
    }]
} )
export class ChargeTypeaheadComponent implements OnInit {
    @Input() public tpsrId: number;

    @ViewChild( NgModel ) model: NgModel;

    private innerValue: any;
    private changed = new Array<(value: any) => void>();
    private touched = new Array<() => void>();

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
                        return response.resultList;
                    } );
            } );
    }

    resultFormatter = ( result: any ) => result.etiqueta;

    inputFormatter = ( result: any ) => result.etiqueta;

    get value(): any {
        return this.innerValue;
    }

    set value( value: any ) {
        if ( this.innerValue !== value ) {
            this.innerValue = value;
            this.changed.forEach( f => f( value ) );
        }
    }

    writeValue( value: any ) {
        this.innerValue = value;
    }

    registerOnChange( fn: ( value: any ) => void ) {
        this.changed.push( fn );
    }

    registerOnTouched( fn: () => void ) {
        this.touched.push( fn );
    }

    touch() {
        this.touched.forEach( f => f() );
    }
}
