package com.auth;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.auth.input.model.Input;
import com.auth.output.model.AuthPolicy;
import com.auth.output.model.AuthPolicy.HttpMethod;

public class HttpAuthorizerHandler implements RequestHandler<Input, AuthPolicy> {
	
	private Logger logger = LogManager.getLogger(HttpAuthorizerHandler.class);

	@Override
	public AuthPolicy handleRequest(Input input, Context context) {

		logger.info("Input Context :: " + input.toString());

		// Splitting the routeArn to get accountid and other details ex format of
		// routearn
		// arn:aws:execute-api:<region>:<account-id>:<api-id>/<stage>/<http-method>/<path>
		String[] split = input.getRouteArn().split(":");
		
		String region = split[3];
		
		// Cors Configuration
		Map<String, String> cors = new HashMap<>();
		cors.put("Access-Control-Allow-Origin", "*");

		try {
			// the Headers received as part of the request by lambda
			Map<String, String> headers = input.getHeaders();

			// The resource that the client is trying to access
			String urlPath = input.getRequestContext().getHttp().getPath();

			String authToken = headers.get("authorization");
			// Logic to verify the authorization token goes here the token comes as part of
			// headers and the key name is authorization for http api gateways
			//
			// Code goes here
			//
			//

			// If the auth token is successfully verified then generate a allow iam policay
			// and return it.

			return new AuthPolicy(region,
					AuthPolicy.PolicyDocument.getAllowOnePolicy(region, input.getRequestContext().getAccountId(),
							input.getRequestContext().getApiId(), input.getRequestContext().getStage(),
							HttpMethod.valueOf(input.getRequestContext().getHttp().getMethod()),
							input.getRequestContext().getHttp().getPath())).withHeaders(cors).withStatusCode(200);

		} catch (Exception e) {
			
			logger.error("Error :: ",e);
			
			return new AuthPolicy(region, AuthPolicy.PolicyDocument.getDenyOnePolicy(region, input.getRequestContext().getAccountId(),
					input.getRequestContext().getApiId(), input.getRequestContext().getStage(),
					HttpMethod.valueOf(input.getRequestContext().getHttp().getMethod()),
					input.getRequestContext().getHttp().getPath())).withStatusCode(403).withHeaders(cors);
			
		}
	}

}
