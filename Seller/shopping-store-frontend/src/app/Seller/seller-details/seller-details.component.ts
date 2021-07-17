import { Component, OnInit } from '@angular/core';
import { Seller } from '../../model/seller';
import { SellerService } from '../../service/seller.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-seller-details',
  templateUrl: './seller-details.component.html',
  styleUrls: ['./seller-details.component.css']
})
export class SellerDetailsComponent implements OnInit {

  id!: number;
  seller!: Seller;
  constructor(private sellerService: SellerService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.seller = new Seller();
    this.sellerService.getSellerById(this.id).subscribe( data => {
        this.seller = data;
      },
      error => console.log(error));
  }

}
