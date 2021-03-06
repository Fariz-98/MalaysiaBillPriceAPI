package malaysia.bill.price.MalaysiaBillPrice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BillRestExceptionHandler {

	// Add exception handling using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<BillErrorResponse> handleException(BillNotFoundException exc) {
		
		// Create a StudentErrorResponse
		BillErrorResponse error = new BillErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<BillErrorResponse> handleException(Exception exc) {
		
		BillErrorResponse error = new BillErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
