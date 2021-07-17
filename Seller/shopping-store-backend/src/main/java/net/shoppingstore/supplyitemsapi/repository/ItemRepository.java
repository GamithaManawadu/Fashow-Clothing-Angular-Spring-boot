package net.shoppingstore.supplyitemsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.shoppingstore.supplyitemsapi.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
