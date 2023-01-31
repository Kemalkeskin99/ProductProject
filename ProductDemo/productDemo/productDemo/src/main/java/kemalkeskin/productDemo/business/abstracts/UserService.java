package kemalkeskin.productDemo.business.abstracts;

import kemalkeskin.productDemo.core.entities.User;

public interface UserService {

	User add(User user);
	
	User findByEmail(String email);
}
