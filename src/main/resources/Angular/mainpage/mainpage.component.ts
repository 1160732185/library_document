import { Component, OnInit } from '@angular/core';
import {ActionService} from '../../action.service';
import {Type} from '../../Type';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {

  constructor(private actionservice: ActionService) { }
  title = 'documentsearch';
  searchoption = 'title';
  searchcontent: string;
  types: Type[];
  htmlele: any;
  optionchange(): void {
    this.htmlele = document.getElementById('edit-field');
    this.searchoption = this.htmlele.value;
    console.log(this.searchoption);
  }
  search(searchoption: string, searchcontent: string): void {
    console.log(this.searchoption + this.searchcontent);
    this.actionservice.simplesearch(searchoption, searchcontent).subscribe(
      (data) => {
        this.types = data;
        console.log(data);
        console.log(this.types);
      }
    );
  }

  ngOnInit() {
  }

}
