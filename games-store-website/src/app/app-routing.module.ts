import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './components/list/list.component';
import { DetailsComponent } from './components/details/details.component';
import { CreateBooksComponent } from './components/create-books/create-books.component';
import { AboutComponent } from './components/about/about.component';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { HomeComponent } from './components/home/home.component';
import { CartComponent } from './components/cart/cart.component';
import { ProductsComponent } from './components/products/products.component';
const routes: Routes = [
{ path: '', redirectTo: 'home', pathMatch: 'full' },
{path: 'home', component: HomeComponent,
  children: [
    {path: 'en', component: HomeComponent},
    {path: 'it', component: HomeComponent}
]
},
{ path: 'games', component: ListComponent },
{path: 'products', component:ProductsComponent},
{ path: 'games/:id', component: DetailsComponent },
{ path: 'add', component: CreateBooksComponent },
{path: 'about', component: AboutComponent},
{path: 'login', component: LoginComponent},
{path: 'register',component: RegisterComponent},
{path: 'cart', component:CartComponent},
{ path: '**', pathMatch:'full', component: PagenotfoundComponent}, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
