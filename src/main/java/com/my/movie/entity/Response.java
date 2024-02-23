package com.my.movie.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class Response {
	private Object data;
	private String message;
	private boolean error;
	public Response(Object data, String message, boolean error) {
		super();
		this.data = data;
		this.message = message;
		this.error = error;
	}

}
