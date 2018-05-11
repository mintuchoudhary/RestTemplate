package com.resttemplate;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class PaymentHistoryEntity implements Serializable {

	private Date pymtDate;
	private BigInteger amount;
	private String status;
	private String mode;

	public Date getPymtDate() {
		return pymtDate;
	}

	public void setPymtDate(Date pymtDate) {
		this.pymtDate = pymtDate;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
