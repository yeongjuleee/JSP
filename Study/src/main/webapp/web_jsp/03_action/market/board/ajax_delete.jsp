<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvc.model.RippleDTO" %>
<%@ page import="mvc.model.RippleDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="../inc/dbconn.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	int rippleId = Integer.parseInt(request.getParameter("rippleId"));
	
	RippleDAO dao = RippleDAO.getInstance();
	RippleDTO ripple = new RippleDTO();
	ripple.setRippleId(rippleId);
	if (dao.deleteRipple(ripple)) { %>
	<%-- deleteRipple을 실행하면  --%>
{"result" : "true" }
<%
	}
	else { %>
{"result" : "false" }
<%
	}
%>
