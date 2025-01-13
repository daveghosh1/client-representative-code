import {BrowserModule} from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA} from '@angular/core';

import {AppComponent} from './app.component';
import {AgGridModule} from 'ag-grid-angular';
import {NumberFormatterComponent} from './number-formatter.component';
import {NumericEditorComponent} from './numeric-editor.component';
import {RangeFilterComponent} from './range-filter.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NumberFormatterComponent,
    NumericEditorComponent,
    RangeFilterComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AgGridModule
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA,
    NO_ERRORS_SCHEMA
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
