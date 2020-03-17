create table NHS_Privacy_UserPrivacy (
	uuid_ VARCHAR(75) null,
	userPrivacyId LONG not null primary key,
	companyId LONG,
	userId LONG,
	fieldId VARCHAR(500) null,
	roleIds VARCHAR(500) null,
	createDate DATE null,
	modifiedDate DATE null
);