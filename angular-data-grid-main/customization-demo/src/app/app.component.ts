import { Component, OnInit } from '@angular/core';
import { NumberFormatterComponent } from './number-formatter.component';
import { NumericEditorComponent } from './numeric-editor.component';
import { RangeFilterComponent } from './range-filter.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  defaultColDef = {
    sortable: true,
    filter: true
  };

  columnDefs = [
    {headerName: 'Make', field: 'make'},
    {headerName: 'Model', field: 'model'},
    {headerName: 'Test123', field: 'test123'},
    {
      headerName: 'Price',
      field: 'price',
      editable: true,
      cellRenderer: 'numberFormatterComponent',
      cellEditor: 'numericEditorComponent',
      filter: 'rangeFilterComponent'
    }
  ];

  rowData = [];

  frameworkComponents = {
    numericEditorComponent: NumericEditorComponent,
    numberFormatterComponent: NumberFormatterComponent,
    rangeFilterComponent: RangeFilterComponent
  };

  ngOnInit() {
    fetch('https://www.ag-grid.com/example-assets/row-data.json')
      .then(result => result.json())
      .then(rowData => this.rowData = rowData);
      this.columnDefs;
  }
}
