package com.mecalux.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorDTO {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String code;
	private String message;

	public ApiErrorDTO(HttpStatus status, String code, String message) {
		this.timestamp = LocalDateTime.now();
		this.status = status.value();
		this.error = status.name();
		this.code = code;
		this.message = message;
	}
}
