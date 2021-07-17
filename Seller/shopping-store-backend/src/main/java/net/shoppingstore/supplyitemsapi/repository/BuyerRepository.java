package net.shoppingstore.supplyitemsapi.repository;

import net.shoppingstore.supplyitemsapi.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
