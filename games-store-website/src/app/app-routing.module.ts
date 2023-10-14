import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './components/list/list.component';
import { DetailsComponent } from './components/details/details.component';
import { CreateBooksComponent } from './components/create-books/create-books.component';
import { AboutComponent } from './components/about/about.component';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
const routes: Routes = [
{ path: '', redirectTo: 'home', pathMatch: 'full' },
{ path: 'games', component: ListComponent },
{ path: 'games/:id', component: DetailsComponent },
{ path: 'add', component: CreateBooksComponent },
{path: 'about', component: AboutComponent},
{path: 'login', component: LoginComponent},
{path: 'register',component: RegisterComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
