import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators} from '@angular/forms';
import { User } from '../modules/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userservice: UserService) { }

  user : User = new User();
  submitted = false;

  ngOnInit() {
    this.submitted = false;
  }

  usersaveform = new FormGroup({
    user_name: new FormControl('', [Validators.required]),
    user_email: new FormControl('', [Validators.required, Validators.email]),
    user_password: new FormControl('' , [Validators.required , Validators.minLength(4) ] ),
    user_address: new FormControl(),
    user_phone: new FormControl(),

  });

  saveUser(saveUser){
    this.user = new User();
    this.user.user_name = this.UserName.value;
    this.user.user_email = this.UserEmail.value;
    this.user.user_password = this.UserPassword.value;
    this.user.user_address = this.UserAddress.value;
    this.user.user_phone = this.UserPhone.value;

    this.submitted = true;
    this.save();
  }



  save() {
    this.userservice.createUser(this.user)
      .subscribe(data => console.log(data), error => console.log(error));
    this.user = new User();
  }

  get UserName(){
    return this.usersaveform.get('user_name');
  }

  get UserEmail(){
    return this.usersaveform.get('user_email');
  }

  get UserPassword(){
    return this.usersaveform.get('user_password');
  }


  get UserAddress(){
    return this.usersaveform.get('user_address');
  }


  get UserPhone(){
    return this.usersaveform.get('user_phone');
  }


  addUserForm(){
    this.submitted = false;
    this.usersaveform.reset();
  }
}

