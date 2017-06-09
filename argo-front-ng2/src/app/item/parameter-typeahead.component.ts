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
import { ParameterService } from './parameter.service';

@Component( {
    selector: 'app-parameter-typeahead'
    , template: `
<input type="text" class="form-control form-control-sm" [(ngModel)]="value" [ngbTypeahead]="search"
    [inputFormatter]="inputFormatter" [resultFormatter]="resultFormatter" [editable]="false" />
    `
    , providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: ParameterTypeaheadComponent,
        multi: true,
    }]
} )
export class ParameterTypeaheadComponent extends ValueAccessor<any> implements OnInit {
    @Input() public entityId: number;
    @Input() public portId: number;
    @Input() public date: any;

    @ViewChild( NgModel ) model: NgModel;

    constructor( private prmtService: ParameterService ) {
        super();
    }

    ngOnInit() {
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
