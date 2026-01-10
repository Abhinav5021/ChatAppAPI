

package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chatRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameAndPassword(String userName, String password);

}
	