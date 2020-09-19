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

	public BankAccount(String loginName) {
		this.loginName = loginName;
	}

	public BankAccount(String bankAccountNumber, String aliasName, String loginName, Long currentBalance, String currencyType, BankAccountStatus bankAccountStatus, BankAccountType bankAccountType) {
		this.bankAccountNumber = bankAccountNumber;
		this.aliasName = aliasName;
		this.loginName = loginName;
		this.currentBalance = currentBalance;
		this.currencyType = currencyType;
		this.bankAccountStatus = bankAccountStatus;
		this.bankAccountType = bankAccountType;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public BankAccountStatus getBankAccountStatus() {
		return bankAccountStatus;
	}

	public void setBankAccountStatus(BankAccountStatus bankAccountStatus) {
		this.bankAccountStatus = bankAccountStatus;
	}

	public BankAccountType getBankAccountType() {
		return bankAccountType;
	}

	public void setBankAccountType(BankAccountType bankAccountType) {
		this.bankAccountType = bankAccountType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BankAccount [bankAccountNumber=");
		builder.append(bankAccountNumber);
		builder.append(", aliasName=");
		builder.append(aliasName);
		builder.append(", loginName=");
		builder.append(loginName);
		builder.append(", currentBalance=");
		builder.append(currentBalance);
		builder.append(", currencyType=");
		builder.append(currencyType);
		builder.append(", bankAccountStatus=");
		builder.append(bankAccountStatus);
		builder.append(", bankAccountType=");
		builder.append(bankAccountType);
		builder.append("]");
		return builder.toString();
	}

}
