create table NHS_TalentSearch_TalentSearch (
	uuid_ VARCHAR(75) null,
	talentSearchId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(200) null,
	typeId LONG,
	categoryId LONG,
	queryFilter STRING null
);