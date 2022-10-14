package com.example.postsappfri.data.model.userModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("country")
	private Country country;

	@SerializedName("addresses")
	private List<Object> addresses;

	@SerializedName("gender")
	private String gender;

	@SerializedName("city")
	private Object city;

	@SerializedName("about")
	private String about;

	@SerializedName("type")
	private String type;

	@SerializedName("uuid")
	private String uuid;

	@SerializedName("shares_count")
	private int sharesCount;

	@SerializedName("mobile_verified")
	private boolean mobileVerified;

	@SerializedName("mobile_country")
	private MobileCountry mobileCountry;

	@SerializedName("governorate")
	private Object governorate;

	@SerializedName("fcm_token")
	private Object fcmToken;

	@SerializedName("id")
	private String id;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	@SerializedName("job_title")
	private Object jobTitle;

	@SerializedName("slug")
	private String slug;

	@SerializedName("email")
	private String email;

	@SerializedName("post_filters")
	private Object postFilters;

	@SerializedName("has_password")
	private boolean hasPassword;

	@SerializedName("image")
	private String image;

	@SerializedName("cart_products_count")
	private int cartProductsCount;

	@SerializedName("email_verified")
	private boolean emailVerified;

	@SerializedName("followers_count_formatted")
	private String followersCountFormatted;

	@SerializedName("ele_district")
	private Object eleDistrict;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("service_country")
	private ServiceCountry serviceCountry;

	@SerializedName("store")
	private Object store;

	@SerializedName("following_count_formatted")
	private String followingCountFormatted;

	@SerializedName("social_login")
	private boolean socialLogin;

	@SerializedName("profile_completion_percent")
	private int profileCompletionPercent;

	@SerializedName("following_count")
	private int followingCount;

	@SerializedName("dob")
	private String dob;

	@SerializedName("can_share_posts")
	private boolean canSharePosts;

	@SerializedName("followers_count")
	private int followersCount;

	@SerializedName("name")
	private String name;

	@SerializedName("has_cart")
	private boolean hasCart;

	@SerializedName("location")
	private Location location;

	@SerializedName("mobile_verified_via")
	private Object mobileVerifiedVia;

	@SerializedName("is_following")
	private boolean isFollowing;

	@SerializedName("job_category")
	private JobCategory jobCategory;

	@SerializedName("notifications")
	private Notifications notifications;

	@SerializedName("shares_count_formatted")
	private String sharesCountFormatted;

	public Country getCountry(){
		return country;
	}

	public List<Object> getAddresses(){
		return addresses;
	}

	public String getGender(){
		return gender;
	}

	public Object getCity(){
		return city;
	}

	public String getAbout(){
		return about;
	}

	public String getType(){
		return type;
	}

	public String getUuid(){
		return uuid;
	}

	public int getSharesCount(){
		return sharesCount;
	}

	public boolean isMobileVerified(){
		return mobileVerified;
	}

	public MobileCountry getMobileCountry(){
		return mobileCountry;
	}

	public Object getGovernorate(){
		return governorate;
	}

	public Object getFcmToken(){
		return fcmToken;
	}

	public String getId(){
		return id;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public Object getJobTitle(){
		return jobTitle;
	}

	public String getSlug(){
		return slug;
	}

	public String getEmail(){
		return email;
	}

	public Object getPostFilters(){
		return postFilters;
	}

	public boolean isHasPassword(){
		return hasPassword;
	}

	public String getImage(){
		return image;
	}

	public int getCartProductsCount(){
		return cartProductsCount;
	}

	public boolean isEmailVerified(){
		return emailVerified;
	}

	public String getFollowersCountFormatted(){
		return followersCountFormatted;
	}

	public Object getEleDistrict(){
		return eleDistrict;
	}

	public String getMobile(){
		return mobile;
	}

	public ServiceCountry getServiceCountry(){
		return serviceCountry;
	}

	public Object getStore(){
		return store;
	}

	public String getFollowingCountFormatted(){
		return followingCountFormatted;
	}

	public boolean isSocialLogin(){
		return socialLogin;
	}

	public int getProfileCompletionPercent(){
		return profileCompletionPercent;
	}

	public int getFollowingCount(){
		return followingCount;
	}

	public String getDob(){
		return dob;
	}

	public boolean isCanSharePosts(){
		return canSharePosts;
	}

	public int getFollowersCount(){
		return followersCount;
	}

	public String getName(){
		return name;
	}

	public boolean isHasCart(){
		return hasCart;
	}

	public Location getLocation(){
		return location;
	}

	public Object getMobileVerifiedVia(){
		return mobileVerifiedVia;
	}

	public boolean isIsFollowing(){
		return isFollowing;
	}

	public JobCategory getJobCategory(){
		return jobCategory;
	}

	public Notifications getNotifications(){
		return notifications;
	}

	public String getSharesCountFormatted(){
		return sharesCountFormatted;
	}
}