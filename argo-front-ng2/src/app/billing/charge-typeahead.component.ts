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
    NG_VALUE_ACCESSOR
} from '@angular/forms';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import { ValueAccessor } from '../shared/value-accessor';
import { ChargeService } from './charge.service';

@Component( {
    selector: 'app-charge-typeahead'
    , template: `
<input type="text" class="form-control form-control-sm" [(ngModel)]="value" [ngbTypeahead]="search"
    [inputFormatter]="inputFormatter" [resultFormatter]="resultFormatter" [editable]="false" />
    `
    , providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: ChargeTypeaheadComponent,
        multi: true,
    }]
} )
export class ChargeTypeaheadComponent extends ValueAccessor<any> implements OnInit {
    @Input() public tpsrId: number;

    @ViewChild( NgModel ) model: NgModel;

    constructor( private chrgService: ChargeService ) {
        super();
    }

    ngOnInit() {
    }

    search = ( text$: Observable<any> ) => {
        return text$
            .debounceTime( 200 )
            .distinctUntilChanged()
            .switchMap( term => {
                return this.chrgService.typeahead( { tpsrId: this.tpsrId, textoBusqueda: term } )
                    .map(( response ) => response.resultList );
            } );
    }

    resultFormatter = ( result: any ) => result.etiqueta;

    inputFormatter = ( result: any ) => result.etiqueta;
}
