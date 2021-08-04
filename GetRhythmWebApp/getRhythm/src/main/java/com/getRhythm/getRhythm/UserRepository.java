package com.getRhythm.getRhythm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.CrudRepository; 

//import com.getRhythm.getRhythm.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);

    
    public boolean existsUserByUsername(String username);

	public boolean existsUserByEmail(String email);

    
}


