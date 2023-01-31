package kemalkeskin.productDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kemalkeskin.productDemo.business.abstracts.UserService;
import kemalkeskin.productDemo.core.dataAccess.UserRepository;
import kemalkeskin.productDemo.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class UserManager implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User add(User user) {
		
		return this.userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		
		return this.userRepository.findByEmail(email);
	}
	



}
