package com.shoppinstore.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppinstore.app.model.Category;



public interface CatergoryRepository extends JpaRepository<Category, Long > {

}
