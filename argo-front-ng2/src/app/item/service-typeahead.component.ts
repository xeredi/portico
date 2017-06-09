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
import { ServiceService } from './service.service';

@Component( {
    selector: 'app-service-typeahead'
    , template: `
<input type="text" class="form-control form-control-sm" [(ngModel)]="value" [ngbTypeahead]="search"
    [inputFormatter]="inputFormatter" [resultFormatter]="resultFormatter" [editable]="false" />
    `
    , providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: ServiceTypeaheadComponent,
        multi: true,
    }]
} )
export class ServiceTypeaheadComponent extends ValueAccessor<any> implements OnInit {
    @Input() public entityId: number;

    @ViewChild( NgModel ) model: NgModel;

    constructor( private srvcService: ServiceService ) {
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
                    , textoBusqueda: term
                };

                return this.srvcService.typeahead( search ).map(( response ) => response.resultList );
            } );
    }

    resultFormatter = ( result: any ) => result && result.etiqueta ? result.etiqueta : null;

    inputFormatter = ( result: any ) => result && result.etiqueta ? result.etiqueta : null;
}
