package com.example.postsappfri.data.model.userModel;

import com.google.gson.annotations.SerializedName;

public class Notifications{

	@SerializedName("unread_notification_count")
	private int unreadNotificationCount;

	@SerializedName("unread_group_notification_count")
	private int unreadGroupNotificationCount;

	public int getUnreadNotificationCount(){
		return unreadNotificationCount;
	}

	public int getUnreadGroupNotificationCount(){
		return unreadGroupNotificationCount;
	}
}