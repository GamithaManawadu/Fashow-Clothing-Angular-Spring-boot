import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from '../../model/item';
import { ItemService } from '../../service/item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items!: Item[];

  constructor(private itemService: ItemService,
    private router: Router) { }

  ngOnInit(): void {
    this.getItems();

  }

  private getItems(){
    this.itemService.getItemsList().subscribe(data => {
      this.items = data;
    });
  }

  itemDetails(id: number){
    this.router.navigate(['item-details', id]);
  }


  updateItem(id: number){
    this.router.navigate(['update-item', id]);
  }

  deleteItem(id: number){
    var result = confirm("Are you sure you want to Delete this item?");
      if (result) {
        this.itemService.deleteItem(id).subscribe( data => {
          console.log(data);
          this.getItems();

       });
     }
  }

}
