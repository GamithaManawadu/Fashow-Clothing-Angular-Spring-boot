import { Component, OnInit } from '@angular/core';
import {Buyer} from '../../model/buyer';
import {BuyerService} from '../../service/buyer.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-update-buyer',
  templateUrl: './update-buyer.component.html',
  styleUrls: ['./update-buyer.component.css']
})
export class UpdateBuyerComponent implements OnInit {

  id!: number;
  buyer: Buyer = new Buyer();
  constructor(private buyerService: BuyerService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.buyerService.getBuyerById(this.id).subscribe(data => {
        this.buyer = data;
      },
      error => console.log(error));
  }
  onSubmit(){
    this.buyerService.updateBuyer(this.id, this.buyer).subscribe(data =>{
        this.goToBuyerList();
      },
      error => console.log(error));

  }

  goToBuyerList(){
    this.router.navigate(['/buyers']);
  }


}

