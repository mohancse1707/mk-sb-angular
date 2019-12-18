import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';
// require("expose-loader?$!./app/content/js/navbar.min.js");

platformBrowserDynamic().bootstrapModule(AppModule);
