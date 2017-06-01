import { Pipe, PipeTransform } from '@angular/core';

@Pipe( {
    name: 'configurationFilter'
} )
export class ConfigurationFilterPipe implements PipeTransform {

    transform( itemList: any[], filter: any ): any[] {
        if ( !itemList || !filter ) {
            return itemList;
        }

        return itemList.filter( item => item.key.indexOf( filter ) !== -1 );
    }
}
