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

	private Transaction(Builder builder) {
		this.transactionId = builder.transactionId;
		this.fromBankAccountNumber = builder.fromBankAccountNumber;
		this.toBankAccountNumber = builder.toBankAccountNumber;
		this.beneficiaryName = builder.beneficiaryName;
		this.transactionDate = builder.transactionDate;
		this.amount = builder.amount;
		this.transactionComment = builder.transactionComment;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public String getFromBankAccountNumber() {
		return fromBankAccountNumber;
	}

	public String getToBankAccountNumber() {
		return toBankAccountNumber;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public Long getAmount() {
		return amount;
	}

	public String getTransactionComment() {
		return transactionComment;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long transactionId;
		private String fromBankAccountNumber;
		private String toBankAccountNumber;
		private String beneficiaryName;
		private LocalDateTime transactionDate;
		private Long amount;
		private String transactionComment;

		private Builder() {
		}

		public Builder withTransactionId(Long transactionId) {
			this.transactionId = transactionId;
			return this;
		}

		public Builder withFromBankAccountNumber(String fromBankAccountNumber) {
			this.fromBankAccountNumber = fromBankAccountNumber;
			return this;
		}

		public Builder withToBankAccountNumber(String toBankAccountNumber) {
			this.toBankAccountNumber = toBankAccountNumber;
			return this;
		}

		public Builder withBeneficiaryName(String beneficiaryName) {
			this.beneficiaryName = beneficiaryName;
			return this;
		}

		public Builder withTransactionDate(LocalDateTime transactionDate) {
			this.transactionDate = transactionDate;
			return this;
		}

		public Builder withAmount(Long amount) {
			this.amount = amount;
			return this;
		}

		public Builder withTransactionComment(String transactionComment) {
			this.transactionComment = transactionComment;
			return this;
		}

		public Transaction build() {
			return new Transaction(this);
		}
	}

}
