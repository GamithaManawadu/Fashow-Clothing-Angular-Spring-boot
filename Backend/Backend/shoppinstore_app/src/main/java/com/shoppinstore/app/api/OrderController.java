package com.shoppinstore.app.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppinstore.app.Configuration.ShoppingConfiguration;
import com.shoppinstore.app.api.RequestPojo.ApiResponse;
import com.shoppinstore.app.model.AddtoCart;
import com.shoppinstore.app.model.CheckoutCart;
import com.shoppinstore.app.model.Products;
import com.shoppinstore.app.service.CartService.CartService;
import com.shoppinstore.app.service.ProductService.ProductServices;

@RestController
@RequestMapping("api/order")
public class OrderController {
	@Autowired
	CartService cartService;
	ProductServices proService;
	@RequestMapping("checkout_order")
  	public ResponseEntity<?> checkout_order(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"userId","total_price","pay_type","deliveryAddress","creditcardNumber","amount","cvcNumber","cardholderName"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
				
				
			}
			long user_Id = Long.parseLong(addCartRequest.get("userId"));
			double total_amt = Double.parseDouble(addCartRequest.get("total_price"));
			double amount = Double.parseDouble(addCartRequest.get("amount"));
			//checkout and payment fields for the userid
			if(cartService.checkTotalAmountAgainstCart(total_amt,user_Id)) {
				List<AddtoCart> cartItems = cartService.getCartByUserId(user_Id);
				List<CheckoutCart> tmp = new ArrayList<CheckoutCart>();
				for(AddtoCart addCart : cartItems) {
					String orderId = ""+getOrderId();
					CheckoutCart cart = new CheckoutCart();
					cart.setPayment_type(addCartRequest.get("pay_type"));
					cart.setPrice(total_amt);
					cart.setUser_id(user_Id);
					cart.setOrder_id(orderId);
					cart.setProduct(addCart.getProduct());
					cart.setQty(addCart.getQty());
					cart.setDelivery_address(addCartRequest.get("deliveryAddress"));
					cart.setCredit_card_number(addCartRequest.get("credicardNumber"));
					cart.setAmount(addCartRequest.get("amount"));
					cart.setCvc_number(addCartRequest.get("cvcNumber"));
					cart.setCard_holder_name(addCartRequest.get("cardholderName"));
					tmp.add(cart);
				}
				cartService.saveProductsForCheckout(tmp);
				return ResponseEntity.ok(new ApiResponse("Order placed successfully", ""));
			}else {
				throw new Exception("Total amount is mismatch");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	public int getOrderId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	@RequestMapping("getOrdersByUserId")
		public ResponseEntity<?> getOrdersByUserId(@RequestBody HashMap<String,String> ordersRequest) {
		try {
			String keys[] = {"userId"};	
			return ResponseEntity.ok(new ApiResponse("Order placed successfully", ""));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
		
	}
}
