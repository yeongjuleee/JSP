	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		
		for(int i=1; i<10; i++) {
			out.print(num1 + " * " + i +" = " + (num1*i) );
			out.println("<br>");
		}
	%>