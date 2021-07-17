import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from '../../model/item';
import { ItemService } from '../../service/item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  item: Item = new Item();
  constructor(private itemService: ItemService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveItem(){
    this.itemService.addItem(this.item).subscribe( data =>{
      console.log(data);
      this.goToItemList();
    },
    error => console.log(error));
  }

  goToItemList(){
    this.router.navigate(['/items']);
  }

  onSubmit(){
    console.log(this.item);
    this.saveItem();
  }

}
