import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateBooksComponent } from './components/create-books/create-books.component';
import { DetailsComponent } from './components/details/details.component';
import { ListComponent } from './components/list/list.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { ReactiveFormsModule } from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';

import {NgFor} from '@angular/common';
import {MatSelectModule} from '@angular/material/select';

import {MatGridListModule} from '@angular/material/grid-list';

import {MatListModule} from '@angular/material/list';
import { LoginComponent } from './components/login/login.component';
import { LayoutComponent } from './components/layout/layout.component';
import { FooterComponent } from './components/footer/footer.component';
import { RegisterComponent } from './components/register/register.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FlexModule } from '@angular/flex-layout';
import {MatCardModule} from '@angular/material/card';
import { FileUploadComponent } from './components/file-upload/file-upload.component';

import {MatDividerModule} from '@angular/material/divider';
import {MatButton, MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {AutosizeModule} from 'ngx-autosize';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome'

import {MatCheckboxModule} from '@angular/material/checkbox';
import { CartComponent } from './components/cart/cart.component';
import { ClickDirectiveDirective } from './components/directive/click-directive.directive';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { ProductsComponent } from './components/products/products.component';
@NgModule({
  declarations: [
    
    AppComponent,
    CreateBooksComponent,
    DetailsComponent,
    ListComponent,
    NavbarComponent,
    PagenotfoundComponent,
    LoginComponent,
    LayoutComponent,
    FooterComponent,
    RegisterComponent,
    FileUploadComponent,
    LayoutComponent,
    CartComponent,
    ClickDirectiveDirective,
    ProductsComponent
  ],
  imports: [
    MatCheckboxModule,
    FontAwesomeModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
    AutosizeModule,
    MatDatepickerModule,
    MatInputModule,
    MatFormFieldModule,
    MatNativeDateModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    BrowserAnimationsModule,
    MatFormFieldModule, MatSelectModule, NgFor, MatInputModule, FormsModule,
    MatGridListModule, MatListModule, MatDividerModule,
    FlexModule,
    FlexLayoutModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule
  
    
  ],
  providers: [
    {provide: MAT_DATE_LOCALE, useValue: 'it-IT'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
