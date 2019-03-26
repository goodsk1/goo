<%--
<%@ page language="Java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"
         import="java.util.Date"
         import="java.io.StringWriter"
         import="java.io.PrintWriter"

%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LUCKY后台管理系统</title>
</head>
<style type="text/css">
    <!--
    div.layout_page {
        width:98%;
        margin: 10px 0px 30px 25px;
    }

    .table_line_complex {
        background-color: #D0D0D0;
    }

    .table_padding {
        height: 22px;
        padding: 2px 2px 1px 3px;
        background-color: #FFF
    }

    .table_header_complex_d{
        background-color: #ECE8EE;
        text-align: right;
        font-family: "Tahoma";
        font-size: 11px;
        color:#555;
        font-weight:bold;
        padding: 1px 6px 1px 2px;
    }

    .table_line_complex {
        background-color: #D0D0D0;
    }

    -->
</style>
<body>
<c:choose>
    <c:when test="${fn:containsIgnoreCase(pageContext.request.contextPath,'test')}">
        <div style="text-align: center; margin-top: 100px;">
            <img src="${nginx_luckystatic_MA}/common/images/error/error_500.png"/>
            <div style="font-size: 20px; line-height: 50px;">噢！貌似报了个错。</div>
        </div>
    </c:when>
    <c:otherwise>
        <%
            Throwable throwable = (Throwable)request.getAttribute("Exception");
            StringWriter sw = null;
            if (throwable != null) {
                java.text.SimpleDateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String host    = request.getServerName() + ":" + request.getServerPort();
                String client  = request.getRemoteAddr();
                String date    = df.format(new Date());
                String url     = (String)request.getAttribute("url");
                Object status  = "500 (unexpected error)";
                Object type    = throwable.getClass().getName();
                String message = StringUtils.checkEmpty(throwable.getMessage(),"");
        %>
        <div id="idDiv" width="100%" class="table_layout">
            <table width="100%" border="0" cellspacing="1" cellpadding="0"  class="table_line_complex">
                <colgroup>
                    <col width="100"/>
                    <col width="295"/>
                    <col width="100"/>
                    <col width="295"/> <!-- 295 -->
                </colgroup>
                <tr>
                    <td class="table_header_complex_d">Server</td>
                    <td class="table_padding"><%=host%></td>
                    <td class="table_header_complex_d">Client</td>
                    <td class="table_padding"><%=client%></td>
                </tr>
                <tr>
                    <td class="table_header_complex_d">Status Code</td>
                    <td class="table_padding"><%=status%></td>
                    <td class="table_header_complex_d">Date & Time</td>
                    <td class="table_padding"><%=date%></td>
                </tr>
                <tr>
                    <td class="table_header_complex_d">Access URL</td>
                    <td class="table_padding" colspan="3"><%=url%></td>
                </tr>
                <tr>
                    <td class="table_header_complex_d">Exception Type</td>
                    <td class="table_padding" colspan="3"><%=type%></td>
                </tr>
                <tr>
                    <td class="table_header_complex_d">Message</td>
                    <td class="table_padding" colspan="3"><%=message%></td>
                </tr>
                <tr>
                    <td class="table_padding" colspan="4">
                        <%
                            if (throwable!=null){
                                sw = new StringWriter();
                                PrintWriter pw = new PrintWriter(sw);
                                throwable.printStackTrace(pw);
                            }
                        %>
                        <pre ID=oStackTrace STYLE="background-color:#EAEAEA;width: 900px;height: 230px; overflow: scroll;"><%= throwable!=null?sw.getBuffer().toString():"" %></pre>
                    </td>
                </tr>
            </table>
            <% } %>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>--%>
