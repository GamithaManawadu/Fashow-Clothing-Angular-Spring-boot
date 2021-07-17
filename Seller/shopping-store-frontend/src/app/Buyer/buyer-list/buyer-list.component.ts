import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Buyer } from '../../model/buyer';
import { BuyerService } from '../../service/buyer.service';

@Component({
  selector: 'app-buyer-list',
  templateUrl: './buyer-list.component.html',
  styleUrls: ['./buyer-list.component.css']
})
export class BuyerListComponent implements OnInit {

  buyers!: Buyer[];

  constructor(private buyerService: BuyerService,
              private router: Router) { }

  ngOnInit(): void {
    this.getBuyers();

  }

  private getBuyers(){
    this.buyerService.getBuyersList().subscribe(data => {
      this.buyers = data;
    });
  }

  buyerDetails(id: number){
    this.router.navigate(['buyer-details', id]);
  }


  updateBuyer(id: number){
    this.router.navigate(['update-buyer', id]);
  }

  deleteBuyer(id: number){
    var result = confirm("Are you sure you want to Delete this buyer?");
    if (result) {
      this.buyerService.deleteBuyer(id).subscribe( data => {
        console.log(data);
        this.getBuyers();

      });
    }
  }

}
