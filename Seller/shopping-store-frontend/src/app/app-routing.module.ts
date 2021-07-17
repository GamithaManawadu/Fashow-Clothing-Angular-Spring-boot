import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddItemComponent } from './Item/add-item/add-item.component';
import { ItemDetailsComponent } from './Item/item-details/item-details.component';
import { ItemListComponent } from './Item/item-list/item-list.component';
import { UpdateItemComponent } from './Item/update-item/update-item.component';
import {BuyerListComponent} from './Buyer/buyer-list/buyer-list.component';
import {UpdateBuyerComponent} from './Buyer/update-buyer/update-buyer.component';
import {BuyerDetailsComponent} from './Buyer/buyer-details/buyer-details.component';
import {SellerListComponent} from './Seller/seller-list/seller-list.component';
import {SellerDetailsComponent} from './Seller/seller-details/seller-details.component';

const routes: Routes = [

  {path: 'items', component: ItemListComponent},
  {path: 'add-item', component: AddItemComponent},
  {path: '', redirectTo: 'items', pathMatch: 'full'},
  {path: 'update-item/:id', component: UpdateItemComponent},
  {path: 'item-details/:id', component: ItemDetailsComponent},
  {path: 'buyers', component: BuyerListComponent},
  {path: '', redirectTo: 'buyers', pathMatch: 'full'},
  {path: 'update-buyer/:id', component: UpdateBuyerComponent},
  {path: 'buyer-details/:id', component: BuyerDetailsComponent},
  {path: 'sellers', component: SellerListComponent},
  {path: '', redirectTo: 'sellers', pathMatch: 'full'},
  {path: 'seller-details/:id', component: SellerDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
