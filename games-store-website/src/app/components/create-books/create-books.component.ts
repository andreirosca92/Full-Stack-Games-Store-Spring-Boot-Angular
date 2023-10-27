import { Component, OnInit } from '@angular/core';
import { GamesService } from 'src/app/services/games.service';
import { Condition, Genre} from 'src/app/models/Games';
import { Platform } from 'src/app/models/Games';
import { Input } from '@angular/core';

import { Observable } from 'rxjs';

import { ArrayValidators } from '../helpers/minLengthArray';
import { Games } from 'src/app/models/Games';
import { FormGroup, FormArray, Validators, FormBuilder } from '@angular/forms';
@Component({
  selector: 'app-create-books',
  templateUrl: './create-books.component.html',
  styleUrls: ['./create-books.component.css'],
  
  
})
export class CreateBooksComponent implements OnInit{
 
  @Input() addAfter:any;
  generies:string[] = Object.keys(Genre).filter((value:any)=>isNaN(value));
  platforms:string[] = Object.keys(Platform).filter((value:any)=>isNaN(value));
  conditions: string[] =Object.keys(Condition).filter((value:any)=>isNaN(value));
  date: any;
  ratings:number[]=[1,2,3,4,5,6,7,8,9,10];

  
  GamesForm = {} as FormGroup;
	isValidFormSubmitted: boolean | null = null;
	allGames: Observable<any[]>;


  isGameAdded = false;
  
  constructor(private gamesService: GamesService , private formBuilder: FormBuilder){
    this.allGames = gamesService.list();
 
  }
 
  
 
  ngOnInit(){
    this.GamesForm = this.formBuilder.group({
			name: ['', Validators.required],
      description: ['', Validators.required],
      price: ['', Validators.required],
      rating: ['', Validators.required],
      released: ['', Validators.required],
      image: ['', Validators.required],
      genre: ['', Validators.required],
      condition: ['', Validators.required],
      platform: ['', Validators.required],
      inventory: this.formBuilder.group({
        snew: ['', Validators.required],
        sused: ['', Validators.required]
      }),
      publisher: this.formBuilder.group({
        name: ['', Validators.required]
      }),
			developer: this.formBuilder.array(
				[this.createDevFormGroup()],
				[Validators.required,  ArrayValidators.maxLength(2)])
		});
    

   }
  createDevFormGroup() {
    
      return this.formBuilder.group({
        company_name: ['', [Validators.required]]
      })
    
   
  }

  get name() {
		return this.GamesForm.get('name');
	}
  get description(){
    return this.GamesForm.get('description');
  }
  get genre(){
    return this.GamesForm.get('genre');
  }
  get price(){
    return this.GamesForm.get('price');
  }
  get image(){
    return this.GamesForm.get('image');
  }
  get released(){
    return this.GamesForm.get('released');
  }
  get rating(){
    return this.GamesForm.get('rating');
  }
  get platform(){
    return this.GamesForm.get('platform');
  }
  get condition(){
    return this.GamesForm.get('condition');
  }
  get publisher_name(){
    return this.GamesForm.get('publisher')?.get('name');
  }
	get developer(): FormArray {
		return this.GamesForm.get('developer') as FormArray;
	}
	addDeveloper() :void{
      if(!(this.developer.hasError('maxLength'))){
        let devForm = this.createDevFormGroup();
      this.developer.push(devForm);
     
      }
      return
	}
	deleteDeveloper(idx: number) {
		this.developer.removeAt(idx);
	}
	onFormSubmit() {
		this.isValidFormSubmitted = false;
		if (this.GamesForm.invalid) {
			return;
		}
		this.isValidFormSubmitted = true;
		let games: Games = this.GamesForm.value;
		this.addGame(games);
		this.GamesForm.reset();
	}
	resetGamesForm() {
		(document.querySelector("form") as HTMLFormElement).reset();
	}
   

  

  // Add New
  addGame(games: Games): void {
    
    if (!games.name) {
      alert('Please add title!');
      return;
    }

    this.gamesService.create(games)
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
    
}

}
