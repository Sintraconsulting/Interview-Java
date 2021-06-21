package it.sintra.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
	private Integer code;
	String errorMessage;
	private T response;

	public ApiResponse(Integer code) {
		this.code = code;
		response = null;
		errorMessage = null;
	}

}
