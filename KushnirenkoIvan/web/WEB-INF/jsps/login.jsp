<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 13.08.15
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi login form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
    <link href="/css/taxi_style.css" rel="stylesheet" type="text/css">

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Taxi_login_form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <link href="/css/taxi_style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <div class="login" align="center" style="vertical-align: middle">
        <fieldset class="form">
            <legend align="center" class="form">
                <code>Authentication:</code></legend>
            <table>
                <form action="/j_spring_security_check" method="post">
                    <tr>
                        <td>
                            <code style="font-size: 13px">Date: </code>
                        </td>
                        <td>
                            <text style="font-size: 14px; font-style: italic"><%
                                SimpleDateFormat smp = new SimpleDateFormat("dd.MM.YY");
                                Date date = new Date();
                                out.println(smp.format(date));
                            %></text>
                        </td>
                    </tr>
                    <tr>
                        <td><code style="font-size: 13px"><label for="j_username">Login:</label></code></td>
                        <td><input id="j_username" name="j_username" type="text"/><br/></td>
                    </tr>
                    <tr>
                        <td><code style="font-size: 13px"><label for="j_password">Password:</label></code></td>
                        <td><input id="j_password" name="j_password" type="password"/><br/></td>
                    </tr>
                    <tr>
                        <td class="outer">
                            <p>
                                <input type="submit" value="Login" style="width: 65px"/>
                            </p>
                        </td>
                        <td><code><p class="message" style="vertical-align: middle; horiz-align: center; color: red">
                            ${message}
                        </p>
                        </code></td>
                    </tr>
                </form>
            </table>
        </fieldset>
    </div>

    </body>
    </html>
