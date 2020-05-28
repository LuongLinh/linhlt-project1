import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../modules/user';
import { Observable, Subject } from 'rxjs';

import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  constructor(private userservice: UserService) {}

  usersArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  users: Observable<User[]>;
  user: User = new User();
  deleteMessage = false;
  userlist: any;
  isupdated = false;

  ngOnInit() {
    this.isupdated = false;
    this.dtOptions = {
      pageLength: 6,
      stateSave: true,
      lengthMenu: [
        [10, 25, 50, 100, -1],
        [10, 25, 50, 100, 'All']
      ],
      processing: true
    };
    this.userservice.getUserList().subscribe(data => {
      this.users = data;
      this.dtTrigger.next();
    });
  }

  deleteUser(id: number) {
    this.userservice.deleteUser(id).subscribe(
      data => {
        console.log(data);
        this.deleteMessage = true;
        this.userservice.getUserList().subscribe(data => {
          this.users = data;
        });
      },
      error => console.log(error)
    );
  }

  updateUser(id: number) {
    this.userservice.getUser(id).subscribe(
      data => {
        this.userlist = data;
      },
      error => console.log(error)
    );
  }

    userupdateform = new FormGroup({
      user_id: new FormControl(),
      user_name: new FormControl(),
      user_address: new FormControl(),
      user_email: new FormControl(),

      user_password: new FormControl(),
      user_phone: new FormControl(),
      user_role: new FormControl()
    });


  updateU(updu) {
    this.user = new User();
    this.user.user_id = this.UserId.value;
    this.user.user_name = this.UserName.value;
    this.user.user_address = this.UserAddress.value;
    this.user.user_email = this.UserEmail.value;
    this.user.user_password = this.UserPassword.value,
    this.user.user_phone = this.UserPhone.value,
    this.user.user_role = this.UserRole.value,
      console.log(this.UserName.value);

    this.userservice
      .updateUser(this.user.user_id, this.user)
      .subscribe(
        _data => {
          this.isupdated = true;
          this.userservice.getUserList().subscribe(data => {
            this.users = data;
          });
        },
        error => console.log(error)
      );
  }


  get UserId() {
    return this.userupdateform.get('user_id');
  }

  get UserName() {
    return this.userupdateform.get('user_name');
  }

  get UserAddress() {
    return this.userupdateform.get('user_address');
  }

  get UserEmail() {
    return this.userupdateform.get('user_email');
  }

  get UserPassword() {
    return this.userupdateform.get('user_password');
  }

  get UserPhone() {
    return this.userupdateform.get('user_phone');
  }

  get UserRole() {
    return this.userupdateform.get('user_role');
  }

  changeisUpdate() {
    this.isupdated = false;
  }
}
