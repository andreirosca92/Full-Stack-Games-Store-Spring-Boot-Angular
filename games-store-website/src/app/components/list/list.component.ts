import { Component, OnInit } from '@angular/core';
import { Games } from 'src/app/models/Games';
import { GamesService } from 'src/app/services/games.service';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  games:Games[]=[];
  
  currentGame:any;
  currentIndex = -1;
  searchName = '';

  constructor(private gamesService: GamesService) { }

  ngOnInit(): void {
    this.getAllGames();
  }

  // Get list
  getAllGames(): any {
    this.gamesService.list()
      .subscribe(
        (games: any) => {
          this.games = games;
        },
        (error: any) => {
          console.log(error);
        });
  }

  // Delete action
  deleteGame(id:string | any): any{
    this.gamesService.delete(id)
    .subscribe(
      response => {
        this.getAllGames();
      },
      error => {
        console.log(error);
      });
  }

  // Search items
  searchByName(): any{
    this.gamesService.filterByName(this.searchName)
      .subscribe(
        (games:any) => {
          this.games = games;
        },
        error => {
          console.log(error);
        });
  }
}
