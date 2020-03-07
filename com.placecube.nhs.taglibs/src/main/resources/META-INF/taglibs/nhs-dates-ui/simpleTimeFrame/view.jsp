<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<c:choose>
	<c:when test="${not empty endDate}">
		<fmt:formatDate value="${startDate}" pattern="${format}" /> - <fmt:formatDate value="${endDate}" pattern="${format}" /> 
	</c:when>
	<c:otherwise>
		<fmt:formatDate value="${startDate}" pattern="${format}" /> - <liferay-ui:message key="present"/>
	</c:otherwise>
</c:choose>
