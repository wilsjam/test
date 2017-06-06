package com.ri.analytic.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Realtor_tbl")
public class Realtor {
	@Id 
	private long ri_id;
	private long realtor_no;
	private long realtor_unique_identifier;
	private long realtor_branch_no;

	private String realtor_verification_status;
	private String realtor_transaction;
	private String realtor_transaction_type;
	private String realtor_transaction_symbol;



	private long realtor_transaction_amount;
	private long realtor_transaction_qty;
	private long realtor_transaction_total_amt;

	private String realtor_submission_date;
	
	
	public Realtor( ) {
	 
		 
	}
	
	public Realtor(long ri_id, long realtor_no, long realtor_unique_identifier, long realtor_branch_no,
			String realtor_verification_status, String realtor_transaction, String realtor_transaction_type,
			String realtor_transaction_symbol, long realtor_transaction_amount, long realtor_transaction_qty,
			long realtor_transaction_total_amt, String realtor_submission_date) {
	 
		this.ri_id = ri_id;
		this.realtor_no = realtor_no;
		this.realtor_unique_identifier = realtor_unique_identifier;
		this.realtor_branch_no = realtor_branch_no;
		this.realtor_verification_status = realtor_verification_status;
		this.realtor_transaction = realtor_transaction;
		this.realtor_transaction_type = realtor_transaction_type;
		this.realtor_transaction_symbol = realtor_transaction_symbol;
		this.realtor_transaction_amount = realtor_transaction_amount;
		this.realtor_transaction_qty = realtor_transaction_qty;
		this.realtor_transaction_total_amt = realtor_transaction_total_amt;
		this.realtor_submission_date = realtor_submission_date;
	}


	public long getRi_id() {
		return ri_id;
	}


	public void setRi_id(long ri_id) {
		this.ri_id = ri_id;
	}


	public long getRealtor_no() {
		return realtor_no;
	}


	public void setRealtor_no(long realtor_no) {
		this.realtor_no = realtor_no;
	}


	public long getRealtor_unique_identifier() {
		return realtor_unique_identifier;
	}


	public void setRealtor_unique_identifier(long realtor_unique_identifier) {
		this.realtor_unique_identifier = realtor_unique_identifier;
	}


	public long getRealtor_branch_no() {
		return realtor_branch_no;
	}


	public void setRealtor_branch_no(long realtor_branch_no) {
		this.realtor_branch_no = realtor_branch_no;
	}


	public String getRealtor_verification_status() {
		return realtor_verification_status;
	}


	public void setRealtor_verification_status(String realtor_verification_status) {
		this.realtor_verification_status = realtor_verification_status;
	}


	public String getRealtor_transaction() {
		return realtor_transaction;
	}


	public void setRealtor_transaction(String realtor_transaction) {
		this.realtor_transaction = realtor_transaction;
	}


	public String getRealtor_transaction_type() {
		return realtor_transaction_type;
	}


	public void setRealtor_transaction_type(String realtor_transaction_type) {
		this.realtor_transaction_type = realtor_transaction_type;
	}


	public String getRealtor_transaction_symbol() {
		return realtor_transaction_symbol;
	}


	public void setRealtor_transaction_symbol(String realtor_transaction_symbol) {
		this.realtor_transaction_symbol = realtor_transaction_symbol;
	}


	public long getRealtor_transaction_amount() {
		return realtor_transaction_amount;
	}


	public void setRealtor_transaction_amount(long realtor_transaction_amount) {
		this.realtor_transaction_amount = realtor_transaction_amount;
	}


	public long getRealtor_transaction_qty() {
		return realtor_transaction_qty;
	}


	public void setRealtor_transaction_qty(long realtor_transaction_qty) {
		this.realtor_transaction_qty = realtor_transaction_qty;
	}


	public long getRealtor_transaction_total_amt() {
		return realtor_transaction_total_amt;
	}


	public void setRealtor_transaction_total_amt(long realtor_transaction_total_amt) {
		this.realtor_transaction_total_amt = realtor_transaction_total_amt;
	}


	public String getRealtor_submission_date() {
		return realtor_submission_date;
	}


	public void setRealtor_submission_date(String realtor_submission_date) {
		this.realtor_submission_date = realtor_submission_date;
	}

	@Override
	public String toString() {
		return "Realtor [ri_id=" + ri_id + ", realtor_no=" + realtor_no + ", realtor_unique_identifier="
				+ realtor_unique_identifier + ", realtor_branch_no=" + realtor_branch_no
				+ ", realtor_verification_status=" + realtor_verification_status + ", realtor_transaction="
				+ realtor_transaction + ", realtor_transaction_type=" + realtor_transaction_type
				+ ", realtor_transaction_symbol=" + realtor_transaction_symbol + ", realtor_transaction_amount="
				+ realtor_transaction_amount + ", realtor_transaction_qty=" + realtor_transaction_qty
				+ ", realtor_transaction_total_amt=" + realtor_transaction_total_amt + ", realtor_submission_date="
				+ realtor_submission_date + "]";
	}
	
	
	


}
