package it.sintra.user.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import it.sintra.user.common.exception.CorruptImageException;
import it.sintra.user.common.exception.DuplicateValueException;
import it.sintra.user.model.dto.ApiResponse;
import it.sintra.user.utility.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseErrorHandlerController {

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public final ResponseEntity<ApiResponse<?>> methodArgumentNotValidException(Exception ex, WebRequest webRequest) {
		log.debug(ex.getMessage(), ex);
		StringBuilder stringBuilderEroreMessage = new StringBuilder("");
		if (ex instanceof MethodArgumentNotValidException) {
			List<ObjectError> allErrors = ((BindException) ex).getBindingResult().getAllErrors();
			allErrors.forEach((b)->{
				stringBuilderEroreMessage.append(b.getDefaultMessage().toString());
				stringBuilderEroreMessage.append(" ");
			});
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse<WebRequest>(HttpStatus.BAD_REQUEST.value(),stringBuilderEroreMessage.toString(), null));
	}


	
	@ExceptionHandler({ Exception.class })
	public final ResponseEntity<ApiResponse<?>> defaultException(Exception ex, WebRequest webRequest) {
		log.debug(ex.getMessage(), ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<WebRequest>(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), Message.INTERNAL_SERVER_ERROR.toString(), null));
	}
	
	
	@ExceptionHandler(value = DuplicateValueException.class)
	public final ResponseEntity<ApiResponse<?>> handlerDuplicateValueException(Exception ex, WebRequest webRequest) {
		log.debug(ex.getMessage(), ex);
		StringBuilder stringBuilderEroreMessage = new StringBuilder(ex.getMessage().toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse<WebRequest>(HttpStatus.BAD_REQUEST.value(), stringBuilderEroreMessage.toString(), null));

	}
	
	@ExceptionHandler(value = CorruptImageException.class)
	public final ResponseEntity<ApiResponse<?>> corruptImageException(Exception ex, WebRequest webRequest) {
		log.debug(ex.getMessage(), ex);
		StringBuilder stringBuilderEroreMessage = new StringBuilder(ex.getMessage().toString());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse<WebRequest>(HttpStatus.INTERNAL_SERVER_ERROR.value(), stringBuilderEroreMessage.toString(), null));

	}
}
