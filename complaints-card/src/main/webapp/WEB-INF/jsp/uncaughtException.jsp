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

        Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");

        if (exception != null) {
            if (exception instanceof ServletException) {
                ServletException sex = (ServletException) exception;
                Throwable rootCause = sex.getRootCause();
                if (rootCause == null)
                    rootCause = sex;
                out.println("** Root cause is: "+ rootCause.getMessage());
                rootCause.printStackTrace(new java.io.PrintWriter(out));
            }
            else {
                exception.printStackTrace(new java.io.PrintWriter(out));
            }
        }
        else  {
            out.println("Информация об ошибке не доступна");
        }

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
