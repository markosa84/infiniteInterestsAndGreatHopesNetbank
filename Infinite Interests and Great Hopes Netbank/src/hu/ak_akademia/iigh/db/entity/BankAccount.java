package hu.ak_akademia.iigh.db.entity;

import hu.ak_akademia.iigh.BankAccountStatus;
import hu.ak_akademia.iigh.BankAccountType;

public class BankAccount {

	private String bankAccountNumber;
	private String aliasName;
	private String loginName;
	private Long currentBalance;
	private String currencyType;
	private BankAccountStatus bankAccountStatus;
	private BankAccountType bankAccountType;

	private BankAccount(Builder builder) {
		this.bankAccountNumber = builder.bankAccountNumber;
		this.aliasName = builder.aliasName;
		this.loginName = builder.loginName;
		this.currentBalance = builder.currentBalance;
		this.currencyType = builder.currencyType;
		this.bankAccountStatus = builder.bankAccountStatus;
		this.bankAccountType = builder.bankAccountType;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public String getAliasName() {
		return aliasName;
	}

	public String getLoginName() {
		return loginName;
	}

	public Long getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Long currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public BankAccountStatus getBankAccountStatus() {
		return bankAccountStatus;
	}

	public BankAccountType getBankAccountType() {
		return bankAccountType;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String bankAccountNumber;
		private String aliasName;
		private String loginName;
		private Long currentBalance;
		private String currencyType;
		private BankAccountStatus bankAccountStatus;
		private BankAccountType bankAccountType;

		private Builder() {
		}

		public Builder withBankAccountNumber(String bankAccountNumber) {
			this.bankAccountNumber = bankAccountNumber;
			return this;
		}

		public Builder withAliasName(String aliasName) {
			this.aliasName = aliasName;
			return this;
		}

		public Builder withLoginName(String loginName) {
			this.loginName = loginName;
			return this;
		}

		public Builder withCurrentBalance(Long currentBalance) {
			this.currentBalance = currentBalance;
			return this;
		}

		public Builder withCurrencyType(String currencyType) {
			this.currencyType = currencyType;
			return this;
		}

		public Builder withBankAccountStatus(BankAccountStatus bankAccountStatus) {
			this.bankAccountStatus = bankAccountStatus;
			return this;
		}

		public Builder withBankAccountType(BankAccountType bankAccountType) {
			this.bankAccountType = bankAccountType;
			return this;
		}

		public BankAccount build() {
			return new BankAccount(this);
		}
	}

}
