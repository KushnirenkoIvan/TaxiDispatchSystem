<%@ page import="java.util.Date" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Operator_dashboard
    </title>
    <link href="/css/taxi_style.css" rel="stylesheet" type="text/css">
    <link href="/css/ajax.css" rel="stylesheet" type="text/css">
    <script src="/js/taxiScript.js"></script>
    <script src="/js/ajax.js"></script>
</head>
<body onload="digitalWatch()">
<div id="rootDiv" class="dashboard">
    <table style="width: 100%; height: 30px; font-weight: bold">
        <td style="font-size: 14px" align="center">Welcome
            <text style="font-size: 16px"><%=SecurityContextHolder.getContext().getAuthentication().getName()%>
            </text>
            .
        </td>
        <td style="font-size: 14px" align="center">Today is:
            <%
                SimpleDateFormat smp = new SimpleDateFormat("dd.MM.YY");
                Date date = new Date();
                out.println(smp.format(date));
            %>
        </td>
        <td align="right" valign="middle">
            <text id="digital_watch"
                  style="color: red; vertical-align: middle; font-weight: bold; border-color:black; border-radius: 3px 3px 3px 3px; border-style: solid; border-width: 1px; padding: 3px; margin-right: 30px"></text>
            <button style="width: 100px; height: 25px;"><a style="text-decoration: none"
                                                           href="<c:url value="/logout"/>"><img
                    align="left" src="/resources/buttons/lgt.png">Logout</a>
            </button>
        </td>
    </table>
    <table id="listContent" style="width: 100%; height: 82%;">
        <td id="td">
            <button style="width: 100px; height: 20px" onclick="showOrders()">show orders</button>
        </td>
    </table>
    <table style="width: 100%; height: 40px;">
        <td align="center" valign="middle">
            <button value="Add Driver" style="width: 120px ; height: 40px;"
                    onclick="openDriverForm()"><img align="left"
                                                    style="vert-align: middle"
                                                    src="/resources/buttons/add.png"/>Add
                driver
            </button>
        </td>
        <td align="center" valign="middle">
            <button value="Add Orderr" style="width: 140px ; height: 50px;"
                    onclick="openOrderForm()"><img align="left"
                                                   style="vert-align: middle"
                                                   src="/resources/buttons/add.png"/>ADD
                ORDER
            </button>
        </td>
        <td align="center" valign="middle">
            <button value="Add Client" style="width: 120px ; height: 40px;"
                    onclick="openClientForm()"><img align="left"
                                                    style="vert-align: middle"
                                                    src="/resources/buttons/add.png"/>Add
                client
            </button>
        </td>
    </table>

</div>
<a href="<c:url value="/logout"/>"></a>


<sec:authorize access="hasRole('ROLE_ADMIN')">
    <!-- HTML CHUNK TO BE SECURED -->
</sec:authorize>
</body>
</html>
