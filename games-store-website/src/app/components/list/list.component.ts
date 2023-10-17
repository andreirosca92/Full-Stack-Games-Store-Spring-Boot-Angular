import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Games, Publisher } from 'src/app/models/Games';
import { GamesService } from 'src/app/services/games.service';
import { Router } from '@angular/router';

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
  
  constructor(private gamesService: GamesService, private router: Router) { }

  ngOnInit(): void {
    this.getAllGames();
   
  }
  // getAllGames_():any{
  //   this.gamesService.All()
  //   .subscribe(
  //     (g: Games[])=>{
  //               this.games_ = g;
  //             },
  //             (error: any)=>{
  //               console.log(error);
  //             }
  //             )
  // }
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
  goGameDetails(id:string | undefined):any{
    return this.router.navigate([`games/${id}`]);
  }
}
