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
package org.springframework.social.fiwarelab.api;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class containing a KeyRock user's profile information.
 * 
 * @author rbarriuso
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	
	public static class Role{
		
		@JsonProperty
		private String id;
		
		@JsonProperty
		private String name;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Role [id=" + id + ", name=" + name + "]";
		}
	}
	
	public static class Organization{
		
		@JsonProperty
		private String id;
		
		@JsonProperty
		private String name;
		
		@JsonProperty
		private String description;
		
		@JsonProperty
		private String website;
		
		@JsonProperty
		private String domain_id;
		
		@JsonProperty
		private Boolean is_cloud_project;
		
		@JsonProperty
		private Boolean enabled;
		
		@JsonProperty
		private List<Role> roles;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getWebsite() {
			return website;
		}

		public void setWebsite(String website) {
			this.website = website;
		}

		public String getDomain_id() {
			return domain_id;
		}

		public void setDomain_id(String domain_id) {
			this.domain_id = domain_id;
		}

		public Boolean getIs_cloud_project() {
			return is_cloud_project;
		}

		public void setIs_cloud_project(Boolean is_cloud_project) {
			this.is_cloud_project = is_cloud_project;
		}

		public Boolean getEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}

		public List<Role> getRoles() {
			return roles;
		}

		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}

		@Override
		public String toString() {
			return "Organization [id=" + id + ", name=" + name
					+ ", description=" + description + ", website=" + website
					+ ", domain_id=" + domain_id + ", is_cloud_project="
					+ is_cloud_project + ", enabled=" + enabled + ", roles="
					+ roles + "]";
		}
	}

	@JsonProperty
	private String id;
	
	@JsonProperty
	private String displayName;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	private List<Role> roles;
	
	@JsonProperty
	private List<Organization> organizations;
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", displayName=" + displayName + ", email="
				+ email + ", roles=" + roles + ", organizations="
				+ organizations + "]";
	}
	
}
