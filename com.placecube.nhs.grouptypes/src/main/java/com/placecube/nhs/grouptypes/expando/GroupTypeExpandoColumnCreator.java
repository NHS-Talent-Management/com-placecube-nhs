package com.placecube.nhs.grouptypes.expando;

import java.io.InputStream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.pfiks.expando.creator.ExpandoColumnCreator;
import com.pfiks.expando.creator.ExpandoColumnCreatorInputStreamService;
import com.pfiks.expando.exception.ExpandoColumnCreationException;
import com.placecube.nhs.grouptypes.constants.GroupTypeExpando;

@Component(immediate = true, property = { "expandocolumn.creator=group.grouptype" }, service = ExpandoColumnCreator.class)
public class GroupTypeExpandoColumnCreator implements ExpandoColumnCreator {

	@Reference
	private ExpandoColumnCreatorInputStreamService expandoColumnCreatorInputStreamService;

	@Override
	public ExpandoColumn create(Company company) throws ExpandoColumnCreationException {
		InputStream inputStream = GroupTypeExpandoColumnCreator.class.getClassLoader().getResourceAsStream("com/placecube/nhs/grouptypes/dependencies/expando/" + GroupTypeExpando.FIELD_NAME + ".xml");
		return expandoColumnCreatorInputStreamService.createExpandoColumn(company, Group.class.getName(), inputStream);
	}

}
