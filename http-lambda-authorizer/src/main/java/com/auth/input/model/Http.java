package com.auth.input.model;

public class Http {
	private String method;
	private String path;

	public Http() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Http(String method, String path) {
		super();
		this.method = method;
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Http [method=" + method + ", path=" + path + "]";
	}

}
