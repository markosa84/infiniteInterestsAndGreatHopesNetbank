package hu.ak_akademia.iigh.db.entity;

import java.time.LocalDateTime;

public class Transaction {

	private Long transactionId;
	private String fromBankAccountNumber;
	private String toBankAccountNumber;
	private String beneficiaryName;
	private LocalDateTime transactionDate;
	private Long amount;
	private String transactionComment;

	public Transaction(Long transactionId, String fromBankAccountNumber, String toBankAccountNumber, String beneficiaryName, LocalDateTime transactionDate, Long amount, String transactionComment) {
		this.transactionId = transactionId;
		this.fromBankAccountNumber = fromBankAccountNumber;
		this.toBankAccountNumber = toBankAccountNumber;
		this.beneficiaryName = beneficiaryName;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionComment = transactionComment;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromBankAccountNumber() {
		return fromBankAccountNumber;
	}

	public void setFromBankAccountNumber(String fromBankAccountNumber) {
		this.fromBankAccountNumber = fromBankAccountNumber;
	}

	public String getToBankAccountNumber() {
		return toBankAccountNumber;
	}

	public void setToBankAccountNumber(String toBankAccountNumber) {
		this.toBankAccountNumber = toBankAccountNumber;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getTransactionComment() {
		return transactionComment;
	}

	public void setTransactionComment(String transactionComment) {
		this.transactionComment = transactionComment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [transactionId=");
		builder.append(transactionId);
		builder.append(", fromBankAccountNumber=");
		builder.append(fromBankAccountNumber);
		builder.append(", toBankAccountNumber=");
		builder.append(toBankAccountNumber);
		builder.append(", beneficiaryName=");
		builder.append(beneficiaryName);
		builder.append(", transactionDate=");
		builder.append(transactionDate);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", transactionComment=");
		builder.append(transactionComment);
		builder.append("]");
		return builder.toString();
	}

}
