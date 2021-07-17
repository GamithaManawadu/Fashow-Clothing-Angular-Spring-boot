import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Seller } from '../../model/seller';
import { SellerService } from '../../service/seller.service';

@Component({
  selector: 'app-seller-list',
  templateUrl: './seller-list.component.html',
  styleUrls: ['./seller-list.component.css']
})
export class SellerListComponent implements OnInit {

  sellers!: Seller[];

  constructor(private sellerService: SellerService,
              private router: Router) { }

  ngOnInit(): void {
    this.getSellers();

  }

  private getSellers(){
    this.sellerService.getSellersList().subscribe(data => {
      this.sellers = data;
    });
  }

  sellerDetails(id: number){
    this.router.navigate(['seller-details', id]);
  }


  updateSeller(id: number){
    this.router.navigate(['update-seller', id]);
  }

  deleteSeller(id: number){
    var result = confirm("Are you sure you want to Delete this seller?");
    if (result) {
      this.sellerService.deleteSeller(id).subscribe( data => {
        console.log(data);
        this.getSellers();

      });
    }
  }

}
