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
package com.tribalyte.springsocial.fiwarelab.api.impl;

import org.springframework.web.client.RestTemplate;

import com.tribalyte.springsocial.fiwarelab.api.User;
import com.tribalyte.springsocial.fiwarelab.api.UserOperations;

/**
 * Implementation of KeyRock UserOperations 
 * 
 * @author rbarriuso
 */
public class UserOperationsTemplate implements UserOperations{
	
	private final RestTemplate restTemplate;
	
	public UserOperationsTemplate(RestTemplate template){
		restTemplate = template;
	}

	@Override
	public User getUserProfile() {
		return restTemplate.getForObject(KeyRockTemplate.API_BASE_URL + "/user", User.class);
	}
	

}
