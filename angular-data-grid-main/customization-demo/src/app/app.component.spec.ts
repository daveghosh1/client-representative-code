import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { ComponentFixture, TestBed, async, waitForAsync } from '@angular/core/testing';
import { AppComponent } from './app.component';
let component: AppComponent;
let fixture: ComponentFixture<AppComponent>;
describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
      imports: [HttpClientTestingModule],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));
  beforeEach(() => 
    {  
      fixture = TestBed.createComponent(AppComponent);  
      component = fixture.componentInstance;  
      fixture.detectChanges();
    });

    it('should create the app', waitForAsync(() => {
      const fixture = TestBed.createComponent(AppComponent);
      const app = fixture.debugElement.componentInstance;
      expect(app).toBeTruthy();
    }));
  
    it(`should have as title 'my-angular-app'`, waitForAsync(() => {
      const fixture = TestBed.createComponent(AppComponent);
      const app = fixture.debugElement.componentInstance;
      expect(app.title).toEqual('my-angular-app');
    }));
    it('should render title in a h1 tag', waitForAsync(() => {
      const fixture = TestBed.createComponent(AppComponent);
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelector('h1').textContent).toContain('Welcome to my-angular-app!');
    }));
  
});
