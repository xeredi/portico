import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { environment } from './environments/environment';

import { AppModule } from './app/app.module';
import { SharedModule } from './app/shared/shared.module';
import { SecurityModule } from './app/security/security.module';

if ( environment.production ) {
    enableProdMode();
}

platformBrowserDynamic().bootstrapModule( AppModule );
