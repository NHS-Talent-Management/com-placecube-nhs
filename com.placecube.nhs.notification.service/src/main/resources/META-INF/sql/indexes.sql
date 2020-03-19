create index IX_96A7A693 on NHS_Notification_Notification (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_FEB0DFF9 on NHS_Notification_UserNotificationPreference (userId, notificationType, enabled);
create index IX_625F30CF on NHS_Notification_UserNotificationPreference (uuid_[$COLUMN_LENGTH:75$]);