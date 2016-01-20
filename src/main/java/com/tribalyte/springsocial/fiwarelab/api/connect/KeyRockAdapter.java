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
package com.tribalyte.springsocial.fiwarelab.api.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

import com.tribalyte.springsocial.fiwarelab.api.KeyRock;
import com.tribalyte.springsocial.fiwarelab.api.User;

/**
 * KeyRock ApiAdapter implementation.
 * 
 * @author rbarriuso
 */
public class KeyRockAdapter implements ApiAdapter<KeyRock> {

	@Override
	public boolean test(KeyRock keyRock) {
		boolean res = false;
		try {
			keyRock.userOperations().getUserProfile();
			res = true;
		} catch (ApiException e) {
		}
		return res;
	}

	@Override
	public void setConnectionValues(KeyRock keyRock, ConnectionValues values) {
		User profile = keyRock.userOperations().getUserProfile();
		values.setProviderUserId(profile.getId());
		values.setDisplayName(profile.getDisplayName());
		//TODO: implement setImageUrl, setProfileUrl
	}

	@Override
	public UserProfile fetchUserProfile(KeyRock keyRock) {
		User profile = keyRock.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getDisplayName()).setEmail(profile.getEmail()).build();
	}

	@Override
	public void updateStatus(KeyRock keyRock, String message) {
		//Noop
	}

}
