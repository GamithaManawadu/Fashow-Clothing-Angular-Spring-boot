package net.shoppingstore.supplyitemsapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.shoppingstore.supplyitemsapi.exception.ResourceNotFoundException;
import net.shoppingstore.supplyitemsapi.model.Seller;
import net.shoppingstore.supplyitemsapi.repository.SellerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SellerController {


    @Autowired
    private SellerRepository sellerRepository;

    //get all sellers
    @GetMapping("/sellers")
    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }

    //get seller by id rest api
    @GetMapping("/sellers/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not exist with id:" +id));
        return ResponseEntity.ok(seller);
    }

    //delete seller rest api
    @DeleteMapping("sellers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSeller(@PathVariable Long id){
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not exist with id:" +id));

        sellerRepository.delete(seller);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}