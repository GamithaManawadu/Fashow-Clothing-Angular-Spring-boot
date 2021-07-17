import { Component, OnInit } from '@angular/core';
import { Item } from '../../model/item';
import { ItemService } from '../../service/item.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent implements OnInit {

  id!: number
  item!: Item
  constructor(private itemService: ItemService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.item = new Item();
    this.itemService.getItemById(this.id).subscribe( data => {
      this.item = data;
    },
    error => console.log(error));
  }

}
