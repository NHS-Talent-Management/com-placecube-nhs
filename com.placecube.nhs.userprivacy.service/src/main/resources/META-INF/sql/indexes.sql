create index IX_2DC26EA3 on NHS_Privacy_UserPrivacy (companyId, fieldId[$COLUMN_LENGTH:500$]);
create index IX_9DA4BD60 on NHS_Privacy_UserPrivacy (userId);
create index IX_541A2F9A on NHS_Privacy_UserPrivacy (uuid_[$COLUMN_LENGTH:75$], companyId);