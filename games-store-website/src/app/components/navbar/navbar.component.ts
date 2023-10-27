
import  { faShoppingCart } from '@fortawesome/free-solid-svg-icons';
import { faFlag } from '@fortawesome/free-regular-svg-icons';
import { faCheck } from '@fortawesome/free-solid-svg-icons';
import { faFlagUsa } from '@fortawesome/free-solid-svg-icons';
import { Component, ElementRef, HostListener, OnInit, ViewChild } from '@angular/core';
import { map } from 'rxjs/operators';
import { Language } from '../helpers/Language';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
   faShoppingCart=faShoppingCart;
   faFlag = faFlag;
   faCheck = faCheck;
   faFlagUsa = faFlagUsa;
   private storageKey = 'savedLanguageAndFlag';
   menuOpen: boolean = false;
  @ViewChild('listElem') listElem: ElementRef<HTMLElement>= {} as ElementRef;
  listElems: any[] = [{flag:'fi fi-us',language:'US'} ,{flag: 'fi fi-ro', language: 'RO'}, {flag:'fi fi-it', language:'IT'},  {flag: 'fi fi-de', language: 'DE'}];
  language:any[] =this.listElems.map((object:any)=> Object.keys(object)).flat();
  flags:any[] = this.listElems.map((object:any)=> Object.values(object)).flat();
  
  res : Language[]=[];
  selectedValueFlag: string = 'fi fi-us';
  selectedValueLanguage: string  = 'US';
  ngOnInit(): void {
    const langJson = JSON.parse(localStorage.getItem(this.storageKey)!);
    this.selectedValueFlag = langJson[0].flag;
    this.selectedValueLanguage = langJson[0].language;
    

  }
  toggleMenu() {
    this.menuOpen = !this.menuOpen;
    this.listElem.nativeElement.classList.toggle('show-menu');
  }

  clickHandler(item:any) {
    this.selectedValueLanguage = item.language;
    this.selectedValueFlag = item.flag;
    this.res.push({flag: item.flag, language: item.language})
    localStorage.setItem(this.storageKey, JSON.stringify(this.res));
    this.toggleMenu();
  }

  @HostListener('click') hostClick() {
    console.log('interacted with menu...');
  }
}
