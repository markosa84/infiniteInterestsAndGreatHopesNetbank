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

	private User(Builder builder) {
		this.loginName = builder.loginName;
		this.passwordHash = builder.passwordHash;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.role = builder.role;
		this.postalAddress = builder.postalAddress;
		this.phone = builder.phone;
		this.email = builder.email;
		this.newsletter = builder.newsletter;
		this.dateOfBirth = builder.dateOfBirth;
		this.registrationDate = builder.registrationDate;
		this.lastLoginDate = builder.lastLoginDate;
		this.userStatus = builder.userStatus;
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

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
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

		private Builder() {
		}

		public Builder withLoginName(String loginName) {
			this.loginName = loginName;
			return this;
		}

		public Builder withPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withRole(Role role) {
			this.role = role;
			return this;
		}

		public Builder withPostalAddress(String postalAddress) {
			this.postalAddress = postalAddress;
			return this;
		}

		public Builder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withNewsletter(Boolean newsletter) {
			this.newsletter = newsletter;
			return this;
		}

		public Builder withDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder withRegistrationDate(LocalDateTime registrationDate) {
			this.registrationDate = registrationDate;
			return this;
		}

		public Builder withLastLoginDate(LocalDateTime lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
			return this;
		}

		public Builder withUserStatus(UserStatus userStatus) {
			this.userStatus = userStatus;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

}