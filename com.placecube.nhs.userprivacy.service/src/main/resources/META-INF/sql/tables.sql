create table NHS_Privacy_UserPrivacy (
	uuid_ VARCHAR(75) null,
	userId LONG not null,
	fieldId VARCHAR(150) not null,
	companyId LONG,
	roleIds VARCHAR(500) null,
	createDate DATE null,
	modifiedDate DATE null,
	primary key (userId, fieldId)
);