<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Driver_add_Form</title>
    <link href="/css/form_style.css" rel="stylesheet" type="text/css">
    <script src="/js/taxiScript.js"></script>
</head>
<body class="driver">
<fieldset class="form">
    <legend style="font-weight: bold">Add new Driver</legend>
    <form id="driver_form" action="/addDriver" method="post">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="d_id " id="d_id" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" id="d_name" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" id="d_phone" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Car number:</td>
                <td><input type="text" id="d_c_number" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Car model:</td>
                <td><input type="text" id="d_c_mobel" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td style="padding-top: 25px">
                    <p>
                        <%--<button type="submit" style="width: 90px" onclick="sendDriverData()"><img align="left"--%>
                        <%--style="vert-align: middle"--%>
                        <%--src="/resources/buttons/snd.png"/>SEND--%>
                        <%--</button>--%>
                        <input type="submit" value="Login" style="width: 65px"/>
                    </p>
                </td>
                <td style="padding-top: 25px" align="right">
                    <p>
                        <button style="width: 90px" onclick="window.close()"><img align="left"
                                                                                  style="vert-align: middle"
                                                                                  src="/resources/buttons/abrt.png"/>ABORT
                        </button>
                    </p>
                </td>
                <br>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
