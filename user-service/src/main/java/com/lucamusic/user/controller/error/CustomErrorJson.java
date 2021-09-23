package com.lucamusic.user.controller.error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * CustomErrorJson
 * Json personalizado en el que se guarda la información de un error
 * 
 * @author Jose Antonio
 * @version 1.0 Septiembre 2021
 *
 */
@Data
public class CustomErrorJson {
	
	private String timestamp;
	private int status;
	private String error;
	private String trace;
	private List<String> message;
	private String path;
	private String jdk;
	
	public CustomErrorJson() {
		super();
		this.timestamp = "";
		this.status = 0;
		this.error = "";
		this.trace = "";
		this.message = new ArrayList<>();
		this.path = "";
		this.jdk = "ND";
	}
	
	public CustomErrorJson(Date timestamp, int status, String error, String trace, List<String> message, String path, String jdk) {
		super();
		this.timestamp=changeTimestamp(timestamp);
		this.status = status;
		this.error = error;
		this.trace = trace;
		this.message = message;
		this.path = path;
		this.jdk = jdk;
	}
	
	private String changeTimestamp(Date d) {
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dateFormat.format(d);
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = changeTimestamp(timestamp);
	}
	
	@Override
	public String toString() {
		return "ErrorMessage{" +
				"Timestamp='" + timestamp + '\'' +
				"Status='" + status + '\'' +
				"Error='" + error + '\'' +
				"Message='" + message + '\'' +
				"Path='" + path + '\'' +
				"Jdk='" + jdk + '\'' +
				'}';
				
	}
	
}
