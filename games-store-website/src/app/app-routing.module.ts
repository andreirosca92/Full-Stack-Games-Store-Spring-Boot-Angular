import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './components/list/list.component';
import { DetailsComponent } from './components/details/details.component';
import { CreateBooksComponent } from './components/create-books/create-books.component';
import { AboutComponent } from './components/about/about.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { NavbarComponent } from './components/navbar/navbar.component';
const routes: Routes = [
{ path: '', redirectTo: 'home', pathMatch: 'full' },
{ path: 'books', component: ListComponent },
{ path: 'book/:id', component: DetailsComponent },
{ path: 'add', component: CreateBooksComponent },
{path: 'about', component: AboutComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
