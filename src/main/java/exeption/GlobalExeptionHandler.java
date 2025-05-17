package exeption;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException e){
		Map<String, String> map=new HashMap<String, String>();
		e.getBindingResult().getFieldErrors().forEach(ex->
		map.put(ex.getField(), ex.getDefaultMessage())
				);	
		
		return ResponseEntity.badRequest().body(map);
	}
	
	public ResponseEntity<String> handleAll(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hata:"+e.getMessage());
	}

}
