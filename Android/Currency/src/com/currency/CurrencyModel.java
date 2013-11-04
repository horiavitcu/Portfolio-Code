package com.currency;

public class CurrencyModel {
	
	// for consideration only
//	<field name="name">USD/KRW</field>
//	<field name="price">1112.599976</field>
//	<field name="symbol">KRW=X</field>
//	<field name="ts">1375121240</field>
//	<field name="type">currency</field>
//	<field name="volume">0</field>
	// for consideration only
	
	private String field_name;
	private String field_symbol;
	
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getField_symbol() {
		return field_symbol;
	}
	public void setField_symbol(String field_symbol) {
		this.field_symbol = field_symbol;
	}
	@Override
	public String toString() {
		return field_name + ":" + " " + field_symbol;
	}
}
