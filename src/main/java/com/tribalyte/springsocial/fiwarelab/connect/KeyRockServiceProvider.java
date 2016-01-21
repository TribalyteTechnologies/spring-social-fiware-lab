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
package com.tribalyte.springsocial.fiwarelab.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

import com.tribalyte.springsocial.fiwarelab.api.KeyRock;
import com.tribalyte.springsocial.fiwarelab.api.impl.KeyRockTemplate;

/**
 * Implementation of Identity Manager GE / KeyRock service provider
 * 
 * @author rbarriuso
 */
public class KeyRockServiceProvider extends AbstractOAuth2ServiceProvider<KeyRock> {

	public KeyRockServiceProvider(String appId, String appSecret) {
		super(getOAuth2Template(appId, appSecret));
	}
	
	private static OAuth2Template getOAuth2Template(String appId, String appSecret) {
		OAuth2Template oAuth2Template = new OAuth2Template(appId, appSecret,
				KeyRockTemplate.API_BASE_URL + "/oauth2/authorize",
				KeyRockTemplate.API_BASE_URL + "/oauth2/token");
		//False to send clientId and clientSecret in "Authentication" header rather than POST body when exchanging the code
		oAuth2Template.setUseParametersForClientAuthentication(false);
		return oAuth2Template;
	}

	public KeyRock getApi(String accessToken) {
		return new KeyRockTemplate(accessToken);
	}
}
