package edu.cibertec.pe.repository;

import edu.cibertec.pe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
	/*
	 * public User getUserById(int id); public List<User> getUserList(); public User
	 * addUser(User user); public void deleteUser(int id); public User
	 * updateUser(User user);
	 */
	User findByEmail(String email);
}
