<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client_add_Form</title>
    <link href="/css/form_style.css" rel="stylesheet" type="text/css">
    <script src="/js/taxiScript.js"></script>
</head>
<body class="client">
<fieldset class="form">
    <legend style="font-weight: bold">Add new Client</legend>
    <form id="driver_form" action="/addDriver" method="post">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" id="c_id" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" id="c_name" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" id="c_phone" width="50px" height="20px"></td>
            </tr>
            <td style="padding-top: 25px">
                <p>
                    <button type="submit" style="width: 90px" onclick="sendDriverData()"><img align="left"
                                                                                              style="vert-align: middle"
                                                                                              src="/resources/buttons/snd.png"/>SEND
                    </button>
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
