import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {ActionService} from '../../action.service';
import {Type} from '../../Type';
@Component({
  selector: 'app-typedetail',
  templateUrl: './typedetail.component.html',
  styleUrls: ['./typedetail.component.css']
})
export class TypedetailComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private actionService: ActionService,
              private location: Location) { }

  type: Type;
  ngOnInit(): void {
    this.type = new Type();
    const id = this.route.snapshot.paramMap.get('id');
    this.actionService.simplesearch('isbn', id).subscribe(
      (data) => {
        this.type = data[0];
        console.log(data);
      }
    );
  }



}
