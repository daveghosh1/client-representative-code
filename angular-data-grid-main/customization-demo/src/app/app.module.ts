import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { AgGridModule } from 'ag-grid-angular';
import { AppComponent } from 'src/app/app.component';
import { NumberFormatterComponent } from './number-formatter.component';
import { NumericEditorComponent } from './numeric-editor.component';
import { RangeFilterComponent } from './range-filter.component';

@NgModule({
  declarations: [
    AppComponent,
    NumberFormatterComponent,
    NumericEditorComponent,
    RangeFilterComponent
  ],
  imports: [
    BrowserModule,
    AgGridModule,
    CommonModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA , NO_ERRORS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
