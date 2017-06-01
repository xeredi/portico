import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'i18nMessageFilter'
})
export class I18nMessageFilterPipe implements PipeTransform {

    transform( itemList: any[], filter: any ): any[] {
        if ( !itemList || !filter ) {
            return itemList;
        }

        return itemList.filter( item => item.indexOf( filter ) !== -1 );
    }
}
