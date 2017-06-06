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
import { AspectService } from './aspect.service';

@Component( {
    selector: 'app-aspect-typeahead'
    , template: `
<input type="text" class="form-control form-control-sm" [(ngModel)]="value" [ngbTypeahead]="search"
    [inputFormatter]="inputFormatter" [resultFormatter]="resultFormatter" [editable]="false" />
    `
    , providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: AspectTypeaheadComponent,
        multi: true,
    }]
} )
export class AspectTypeaheadComponent extends ValueAccessor<any> implements OnInit {
    @Input() public srtpId: number;

    @ViewChild( NgModel ) model: NgModel;

    constructor( private aspcService: AspectService ) {
        super();
    }

    ngOnInit() {
    }

    search = ( text$: Observable<any> ) => {
        return text$
            .debounceTime( 200 )
            .distinctUntilChanged()
            .switchMap( term => {
                return this.aspcService.typeahead( { tpsrId: this.srtpId, textoBusqueda: term } )
                    .map(( response ) => response.resultList );
            } );
    }

    resultFormatter = ( result: any ) => result.etiqueta;

    inputFormatter = ( result: any ) => result.etiqueta;
}
