import {
    Component, Input, OnChanges, SimpleChanges
} from '@angular/core';

import {
    NgModel, NG_VALUE_ACCESSOR
} from '@angular/forms';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import { ValueAccessor } from '../shared/value-accessor';
import { ParameterService } from './parameter.service';

@Component( {
    selector: 'app-parameter-typeahead'
    , template: `
<input type="text" class="form-control form-control-sm" [(ngModel)]="value" [ngbTypeahead]="search"
    [inputFormatter]="inputFormatter" [resultFormatter]="resultFormatter" [editable]="false" [readonly]="readonly" />
    `
    , providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: ParameterTypeaheadComponent,
        multi: true,
    }]
} )
export class ParameterTypeaheadComponent extends ValueAccessor<any> implements OnChanges {
    @Input() entityId: number;
    @Input() date: any;
    @Input() readonly: boolean;
    @Input() portId: number;

    value: any;

    //    @ViewChild( NgModel ) model: NgModel;

    constructor( private prmtService: ParameterService ) {
        super();
    }

    ngOnChanges( changes: SimpleChanges ) {
        this.value = {};
    }

    search = ( text$: Observable<any> ) => {
        return text$
            .debounceTime( 200 )
            .distinctUntilChanged()
            .switchMap( term => {
                var search = {
                    entiId: this.entityId
                    , fechaVigencia: this.date
                    , prto: { id: this.portId }
                    , textoBusqueda: term
                };

                return this.prmtService.typeahead( search ).map(( response ) => response.resultList );
            } );
    }

    resultFormatter = ( result: any ) => result && result.etiqueta ? result.etiqueta : null;

    inputFormatter = ( result: any ) => result && result.etiqueta ? result.etiqueta : null;
}
