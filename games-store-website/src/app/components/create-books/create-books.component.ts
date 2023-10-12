import { Component, OnInit } from '@angular/core';
import { GamesService } from 'src/app/services/games.service';
import { Games } from 'src/app/models/Games';
@Component({
  selector: 'app-create-books',
  templateUrl: './create-books.component.html',
  styleUrls: ['./create-books.component.css']
})
export class CreateBooksComponent implements OnInit{

  game:Games = {
    
    name: '',
    description: '',
    genre: undefined,
    platform: undefined,
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
 
  ngOnInit(): void { }

  // Add New
  addGame(): void {
    const data = {
      name: this.game.name,
    description: this.game.description,
    genre: this.game.genre,
    platform: this.game.platform,
    rating: this.game.rating,
    price: this.game.price,
    released: this.game.released,
    condition: this.game.condition,
    inventory: this.game.inventory,
    publisher: this.game.publisher,
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
    rating: 0,
    price: 0,
    released: undefined,
    condition: undefined,
    inventory: undefined,
    publisher: [],
    };
  }

}
