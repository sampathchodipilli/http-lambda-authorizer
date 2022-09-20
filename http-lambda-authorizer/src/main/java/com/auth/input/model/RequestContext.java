package com.auth.input.model;

public class RequestContext {
	private String accountId;
	private String apiId;
	private Http http;
	private String stage;

	public RequestContext() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestContext(String accountId, String apiId, Http http, String stage) {
		super();
		this.accountId = accountId;
		this.apiId = apiId;
		this.http = http;
		this.stage = stage;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public Http getHttp() {
		return http;
	}

	public void setHttp(Http http) {
		this.http = http;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	@Override
	public String toString() {
		return "RequestContext [accountId=" + accountId + ", apiId=" + apiId + ", http=" + http + ", stage=" + stage
				+ "]";
	}

}
