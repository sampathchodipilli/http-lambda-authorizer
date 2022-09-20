package com.auth.input.model;

import java.util.Map;

public class Input {

	private String routeArn;

	private Map<String, String> headers;

	private RequestContext requestContext;

	public Input() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Input(String routeArn, Map<String, String> headers, RequestContext requestContext) {
		super();
		this.routeArn = routeArn;
		this.headers = headers;
		this.requestContext = requestContext;
	}

	public String getRouteArn() {
		return routeArn;
	}

	public void setRouteArn(String routeArn) {
		this.routeArn = routeArn;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public RequestContext getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	@Override
	public String toString() {
		return "Input [routeArn=" + routeArn + ", headers=" + headers + ", requestContext=" + requestContext + "]";
	}

}
