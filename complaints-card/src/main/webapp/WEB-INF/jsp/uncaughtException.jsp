<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h2/>Внутренняя ошибка</h2>
<p/><hr>

<%
    try {
        // The Servlet spec guarantees this attribute will be available
        Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");

        if (exception != null) {
            if (exception instanceof ServletException) {
                // It's a ServletException: we should extract the root cause
                ServletException sex = (ServletException) exception;
                Throwable rootCause = sex.getRootCause();
                if (rootCause == null)
                    rootCause = sex;
                out.println("** Root cause is: "+ rootCause.getMessage());
                rootCause.printStackTrace(new java.io.PrintWriter(out));
            }
            else {
                // It's not a ServletException, so we'll just show it
                exception.printStackTrace(new java.io.PrintWriter(out));
            }
        }
        else  {
            out.println("No error information available");
        }

        // Display cookies
        out.println("\nCookies:\n");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                out.println(cookies[i].getName() + "=[" + cookies[i].getValue() + "]");
            }
        }

    } catch (Exception ex) {
        ex.printStackTrace(new java.io.PrintWriter(out));
    }
%>

<p/>
<br/>


<%@ include file="/WEB-INF/jsp/footer.jsp" %>
