create index IX_DC85C5B0 on NHS_Experience (userId);
create index IX_DAC913EA on NHS_Experience (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_86612D6F on NHS_ProfessionalBody (userId);
create index IX_497118E9 on NHS_ProfessionalBody (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_F9D5C4A9 on NHS_Qualification (userId);
create index IX_9D256FA3 on NHS_Qualification (uuid_[$COLUMN_LENGTH:75$], companyId);