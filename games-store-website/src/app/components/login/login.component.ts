import { Component } from '@angular/core';
import { faGoogle } from '@fortawesome/free-brands-svg-icons';
import { faFacebook } from '@fortawesome/free-brands-svg-icons';
import { faGithub } from '@fortawesome/free-brands-svg-icons';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  // impor icons
  faGoogle = faGoogle;
  faFacebook = faFacebook;
  faGithub = faGithub;
  // check for visible password
  hide: boolean = true;

  // test , I will fix 
  username : string ="";
  password : string ="";
  show: boolean= false;
  submit(){
  console.log("user name is " + this.username)
  this.clear();
  }
  clear(){
  this.username ="";
  this.password = "";
  this.show = true;
  }
  
}
