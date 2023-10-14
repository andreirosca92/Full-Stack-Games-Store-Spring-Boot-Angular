import { Component, OnInit } from '@angular/core';
import { GamesService } from 'src/app/services/games.service';
import { Condition, Games, Genre} from 'src/app/models/Games';
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

  game:Games = {
    
    name: '',
    description: '',
    genre: undefined,
    platform: undefined,
    image: '',
    rating: 0,
    price: 0,
    released: undefined,
    condition: undefined,
    inventory: undefined,
    publisher: [],

  };
  isGameAdded = false;
  
  constructor(private gamesService: GamesService){

  }
 
  ngOnInit(): void {
    this.date = new Date();
   }

  // Add New
  addGame(): void {
    const data = {
      name: this.game.name,
    description: this.game.description,
    genre: this.game.genre,
    platform: this.game.platform,
    image: this.game.image,
    rating: this.game.rating,
    price: this.game.price,
    released: this.game.released,
    condition: this.game.condition,
   
    
    };
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
    this.game = {
      name: '',
    description: '',
    genre: undefined,
    platform: undefined,
    image: '',
    rating: 0,
    price: 0,
    released: undefined,
    condition: undefined,
    inventory: undefined,
    publisher: [],
    };
  }

}
