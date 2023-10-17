import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent{
//   form!: FormGroup;
//     loading = false;
//     submitted = false;

//     constructor(
//         private formBuilder: FormBuilder,
//         private route: ActivatedRoute,
//         private router: Router,
//         private accountService: AccountService,
//         private alertService: AlertService
//     ) { }

//     ngOnInit() {
//         this.form = this.formBuilder.group({
//             firstName: ['', Validators.required],
//             lastName: ['', Validators.required],
//             email: ['', Validators.required, Validators.email],
//             username: ['', Validators.required],
//             password: ['', [Validators.required, Validators.minLength(6)]]
//         });
//     }

//     // convenience getter for easy access to form fields
//     get f() { return this.form.controls; }

//     onSubmit() {
//         this.submitted = true;

//         // reset alerts on submit
//         this.alertService.clear();

//         // stop here if form is invalid
//         if (this.form.invalid) {
//             return;
//         }

//         this.loading = true;
//         this.accountService.register(this.form.value)
//             .pipe(first())
//             .subscribe({
//                 next: () => {
//                     this.alertService.success('Registration successful', { keepAfterRouteChange: true });
//                     this.router.navigate(['../login'], { relativeTo: this.route });
//                 },
//                 error: (error:Error)=> {
//                     this.alertService.error(error);
//                     this.loading = false;
//                 }
//             });
//     }
}
