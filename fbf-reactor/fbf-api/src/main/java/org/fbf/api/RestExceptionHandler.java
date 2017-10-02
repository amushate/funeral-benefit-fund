package org.fbf.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  
  
   @ExceptionHandler(RuntimeException.class)
   protected ResponseEntity<Object> handleEntityNotFound(
		   RuntimeException ex) {
       ApiError apiError = new ApiError(HttpStatus.OK, ex.getMessage(), ex);
       return buildResponseEntity(apiError);
   }
   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
       return new ResponseEntity<>(apiError, apiError.getStatus());
   }
}