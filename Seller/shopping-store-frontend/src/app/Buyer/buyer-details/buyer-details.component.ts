import { Component, OnInit } from '@angular/core';
import { Buyer } from '../../model/buyer';
import { BuyerService } from '../../service/buyer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-buyer-details',
  templateUrl: './buyer-details.component.html',
  styleUrls: ['./buyer-details.component.css']
})
export class BuyerDetailsComponent implements OnInit {

  id!: number
  buyer!: Buyer
  constructor(private buyerService: BuyerService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.buyer = new Buyer();
    this.buyerService.getBuyerById(this.id).subscribe( data => {
        this.buyer = data;
      },
      error => console.log(error));
  }

}
