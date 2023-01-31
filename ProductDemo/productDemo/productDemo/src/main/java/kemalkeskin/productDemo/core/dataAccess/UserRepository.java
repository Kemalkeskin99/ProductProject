package kemalkeskin.productDemo.core.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.productDemo.core.entities.User;
public interface UserRepository extends JpaRepository<User, Integer> {
	 
	User findByEmail(String email);
}
