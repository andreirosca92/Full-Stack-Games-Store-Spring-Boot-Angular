import { Component, OnInit } from '@angular/core';
import { GamesService } from 'src/app/services/games.service';
import { Condition, Games, Genre, Publisher} from 'src/app/models/Games';
import { Platform } from 'src/app/models/Games';


@Component({
  selector: 'app-create-books',
  templateUrl: './create-books.component.html',
  styleUrls: ['./create-books.component.css'],
  
  
})
export class CreateBooksComponent implements OnInit{
 
  
  genre:string[] = Object.keys(Genre).filter((value:any)=>isNaN(value));
  platform:string[] = Object.keys(Platform).filter((value:any)=>isNaN(value));
  condition: string[] =Object.keys(Condition).filter((value:any)=>isNaN(value));
  date: any;
  rating:number[]=[1,2,3,4,5,6,7,8,9,10];
  games:Games = {
    id:'',
    name: '',
    description:'',
    price: 0,
    rating: 0,
    genre: undefined,
    platform: undefined,
    condition: undefined,
    released: undefined,
    publisher: undefined,
    inventory: undefined
    

  };
  isGameAdded = false;
  
  constructor(private gamesService: GamesService){

  }
 
  ngOnInit(): void {
    this.date = new Date();
   }

  // Add New
  addGame(): void {
    const data ={
    name: this.games.name,
    description:this.games.description,
    price: this.games.price,
    rating: this.games.rating,
    genre: this.games.genre,
    platform: this.games.platform,
    condition: this.games.condition,
    released: this.date,
    publisher: this.games.publisher,
    }
    if (!data.name) {
      alert('Please add title!');
      return;
    }

    this.gamesService.create(data)
    .subscribe({
      next: (res) => {
        console.log(res);
        this.isGameAdded = true;
      },
      error: (e) => console.error(e)
    });
  }

  // Reset on adding new
  newGame(): void {
    this.isGameAdded = false;
    this.games = {
      id:'',
      name: '',
      description:'',
      price: 0,
      rating: 0,
      genre: undefined,
      platform: undefined,
      condition: undefined,
      released: undefined,
      publisher: undefined,
      inventory: undefined
      
  
    };
  }

}
