package net.shoppingstore.supplyitemsapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.shoppingstore.supplyitemsapi.exception.ResourceNotFoundException;
import net.shoppingstore.supplyitemsapi.model.Buyer;
import net.shoppingstore.supplyitemsapi.repository.BuyerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class BuyerController {

    @Autowired
    private BuyerRepository buyerRepository;

    //get all buyers
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/buyers")
    public List<Buyer> getAllBuyers(){
        return buyerRepository.findAll();
    }

    //get buyer by id rest api
    @GetMapping("/buyers/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable Long id) {
        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer not exist with id:" +id));
        return ResponseEntity.ok(buyer);
    }

    //update buyer rest api
    @PutMapping("/buyers/{id}")
    public ResponseEntity<Buyer> updateBuyer(@PathVariable Long id, @RequestBody Buyer buyerDetails){
        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer not exist with id:" +id));
        buyer.setBuyerName(buyerDetails.getBuyerName());
        buyer.setBuyerEmail(buyerDetails.getBuyerEmail());
        buyer.setBuyerMobile(buyerDetails.getBuyerMobile());
        buyer.setBuyerAddress(buyerDetails.getBuyerAddress());

        Buyer updatedBuyer = buyerRepository.save(buyer);
        return ResponseEntity.ok(updatedBuyer);
    }

    //delete buyer rest api
    @DeleteMapping("buyers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBuyer(@PathVariable Long id){
        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer not exist with id:" +id));

        buyerRepository.delete(buyer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}