<%@ include file="/announcements-banner/init.jsp" %>

<c:if test="${not empty announcements}">
	
	<c:forEach items="${announcements}" var="entry">
		<%@ include file="/announcements-banner/view-entry.jspf" %>
	</c:forEach>
	
	<aui:script use="announcements-banner">
		A.AnnouncementsBanner.init();
	</aui:script>
	
</c:if>	

