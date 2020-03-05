/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.placecube.nhs.userprofile.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ProfessionalBody service. Represents a row in the &quot;NHS_ProfessionalBody&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalBodyModel
 * @generated
 */
@ImplementationClassName(
	"com.placecube.nhs.userprofile.model.impl.ProfessionalBodyImpl"
)
@ProviderType
public interface ProfessionalBody
	extends PersistedModel, ProfessionalBodyModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.placecube.nhs.userprofile.model.impl.ProfessionalBodyImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProfessionalBody, Long>
		PROFESSIONAL_BODY_ID_ACCESSOR = new Accessor<ProfessionalBody, Long>() {

			@Override
			public Long get(ProfessionalBody professionalBody) {
				return professionalBody.getProfessionalBodyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProfessionalBody> getTypeClass() {
				return ProfessionalBody.class;
			}

		};

}