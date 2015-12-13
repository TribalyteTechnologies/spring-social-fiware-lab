/*
 * The MIT License (http://www.opensource.org/licenses/mit-license.html)
 * 
 * Copyright (c) 2015 Tribalyte Technologies S.L. (http://www.tribalyte.com/)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE. 
 */
package com.tribalyte.fiware.spring_social_keyrock.api.impl;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.web.client.RestTemplate;

import com.tribalyte.fiware.spring_social_keyrock.api.KeyRock;
import com.tribalyte.fiware.spring_social_keyrock.api.UserOperations;

/**
 * This is the central class for interacting with KeyStone.
 * 
 * @author rbarriuso
 */
public class KeyRockTemplate extends AbstractOAuth2ApiBinding implements KeyRock {
	
	public static final String API_BASE_URL = "https://account.lab.fiware.org";
	
	private UserOperations userOperations = null;
	
	public KeyRockTemplate(String accessToken){
		//Use ACCESS_TOKEN_PARAMETER token strategy to send the access token as a query parameter
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		initialize();
	}
	
	@Override
	public UserOperations userOperations() {
		return userOperations;
	}
	
	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		//TODO: implement restTemplate.setErrorHandler?
		super.configureRestTemplate(restTemplate);
	}
	
	private void initialize() {
		userOperations = new UserOperationsTemplate(getRestTemplate());
	}

}
