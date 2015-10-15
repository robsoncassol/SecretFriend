package com.cassol.controller.errorHadler;

import java.util.ArrayList;
import java.util.List;

public class ErrorsList {
	
	List<String> erros = new ArrayList<>();

	public void addFieldError(String field, String errorMessage) {
		erros.add(field+":"+errorMessage);
	}

}
