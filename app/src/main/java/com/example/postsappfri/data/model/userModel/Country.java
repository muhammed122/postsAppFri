package com.example.postsappfri.data.model.userModel;

import com.google.gson.annotations.SerializedName;

public class Country{

	@SerializedName("code")
	private String code;

	@SerializedName("flag")
	private String flag;

	@SerializedName("vat_enabled")
	private boolean vatEnabled;

	@SerializedName("day_to_return_product")
	private int dayToReturnProduct;

	@SerializedName("name")
	private String name;

	@SerializedName("currency")
	private Currency currency;

	@SerializedName("id")
	private int id;

	@SerializedName("bank_account_digits")
	private int bankAccountDigits;

	@SerializedName("transfer_limit")
	private int transferLimit;

	@SerializedName("mobile_digits")
	private int mobileDigits;

	@SerializedName("min_audience_users_count")
	private int minAudienceUsersCount;

	public String getCode(){
		return code;
	}

	public String getFlag(){
		return flag;
	}

	public boolean isVatEnabled(){
		return vatEnabled;
	}

	public int getDayToReturnProduct(){
		return dayToReturnProduct;
	}

	public String getName(){
		return name;
	}

	public Currency getCurrency(){
		return currency;
	}

	public int getId(){
		return id;
	}

	public int getBankAccountDigits(){
		return bankAccountDigits;
	}

	public int getTransferLimit(){
		return transferLimit;
	}

	public int getMobileDigits(){
		return mobileDigits;
	}

	public int getMinAudienceUsersCount(){
		return minAudienceUsersCount;
	}
}