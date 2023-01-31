package kemalkeskin.productDemo.webApi;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kemalkeskin.productDemo.business.abstracts.UserService;
import kemalkeskin.productDemo.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/api/users/")
@Data
@AllArgsConstructor
public class UsersController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	//? anlamı burda işlemının ne sonuç verecegını bılmedıgımız için sen sonucuna gore bır deger ver dıyoruz hata verırse hata ver çalışırsa doğru ver gıbı.
	@GetMapping()
	public ResponseEntity<User> findByEmail(@PathVariable String email){
		
		User user=userService.findByEmail(email);
		
		if(Objects.isNull(user)) {
			return ResponseEntity.notFound().build();
		}
		
		return  ResponseEntity.ok(this.userService.findByEmail(email));
		
	}
	
	
	// bu method global yanı burdaki tum methodları kontrol etmek için yazdık yanı her alan(emial,şifre,isim vb..) için  
	//hata yakalama(boş geçme ugun krıkterler dısında) ayıklama  yapmak yerine spring bootun bır fonksiyondan yararlandık
	//bu methodu her methoda kullandırabılırz.
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		//  email için yazdık
		Map<String, String>validationErrors=new HashMap<String,String>();
		//ilk string  emailin tipini, 2 string ise hata metnı değişkeni
		
		for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return (List<Object>) validationErrors;
	}
}
