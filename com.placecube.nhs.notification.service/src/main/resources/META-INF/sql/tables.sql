create table NHS_Notification_Notification (
	uuid_ VARCHAR(75) null,
	notificationId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	notificationType VARCHAR(75) null,
	summary VARCHAR(200) null,
	body STRING null,
	receiverUserIds STRING null
);

create table NHS_Notification_UserNotificationPreference (
	uuid_ VARCHAR(75) null,
	userId LONG not null,
	notificationType VARCHAR(75) not null,
	createDate DATE null,
	modifiedDate DATE null,
	enabled BOOLEAN,
	primary key (userId, notificationType)
);