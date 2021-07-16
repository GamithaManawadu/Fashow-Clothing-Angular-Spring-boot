package com.shoppinstore.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppinstore.app.model.User;

public interface UserRepository extends JpaRepository<User, Long > {
	
	Optional<User> findByMobile(String mobile);

}
