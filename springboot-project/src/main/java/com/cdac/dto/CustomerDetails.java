package com.cdac.dto;

import org.springframework.web.multipart.MultipartFile;

import com.cdac.entity.Address;

public class CustomerDetails {

	private int id;
	private String name;
	private String email;
	private String password;

	private MultipartFile profilePic;
	
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
