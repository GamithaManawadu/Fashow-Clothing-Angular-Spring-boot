import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemListComponent } from './Item/item-list/item-list.component';
import { AddItemComponent } from './Item/add-item/add-item.component';
import { FormsModule } from '@angular/forms';
import { UpdateItemComponent } from './Item/update-item/update-item.component';
import { ItemDetailsComponent } from './Item/item-details/item-details.component';
import { SellerDetailsComponent } from './Seller/seller-details/seller-details.component';
import { SellerListComponent } from './Seller/seller-list/seller-list.component';
import { BuyerDetailsComponent } from './Buyer/buyer-details/buyer-details.component';
import { BuyerListComponent } from './Buyer/buyer-list/buyer-list.component';
import { UpdateBuyerComponent } from './Buyer/update-buyer/update-buyer.component';

@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    AddItemComponent,
    UpdateItemComponent,
    ItemDetailsComponent,
    SellerDetailsComponent,
    SellerListComponent,
    BuyerDetailsComponent,
    BuyerListComponent,
    UpdateBuyerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
