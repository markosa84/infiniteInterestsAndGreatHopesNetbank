package hu.ak_akademia.iigh.db.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import hu.ak_akademia.iigh.Role;
import hu.ak_akademia.iigh.UserStatus;

public class User {

	private String loginName;
	private String passwordHash;
	private String firstName;
	private String lastName;
	private Role role;
	private String postalAddress;
	private String phone;
	private String email;
	private Boolean newsletter;
	private LocalDate dateOfBirth;
	private LocalDateTime registrationDate;
	private LocalDateTime lastLoginDate;
	private UserStatus userStatus;

	public User(String loginName, String passwordHash) {
		this.loginName = loginName;
		this.passwordHash = passwordHash;
	}

	public User(String loginName, String passwordHash, String firstName, String lastName, Role role, String postalAddress, String phone, String email, Boolean newsletter, LocalDate dateOfBirth,
			LocalDateTime registrationDate, LocalDateTime lastLoginDate, UserStatus userStatus) {
		this.loginName = loginName;
		this.passwordHash = passwordHash;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.postalAddress = postalAddress;
		this.phone = phone;
		this.email = email;
		this.newsletter = newsletter;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.lastLoginDate = lastLoginDate;
		this.userStatus = userStatus;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(Boolean newsletter) {
		this.newsletter = newsletter;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [loginName=");
		builder.append(loginName);
		builder.append(", passwordHash=");
		builder.append(passwordHash);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", role=");
		builder.append(role);
		builder.append(", postalAddress=");
		builder.append(postalAddress);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", newsletter=");
		builder.append(newsletter);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", registrationDate=");
		builder.append(registrationDate);
		builder.append(", lastLoginDate=");
		builder.append(lastLoginDate);
		builder.append(", userStatus=");
		builder.append(userStatus);
		builder.append("]");
		return builder.toString();
	}

}
