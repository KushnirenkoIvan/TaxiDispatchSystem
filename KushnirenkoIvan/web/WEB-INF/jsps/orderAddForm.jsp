<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order_add_Form</title>
    <link href="/css/form_style.css" rel="stylesheet" type="text/css">
    <script src="/js/taxiScript.js"></script>
</head>
<body class="order">
<fieldset class="form">
    <legend style="font-weight: bold">Add new Order</legend>
    <form id="order_form" action="/addDriver" method="post">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" id="o_id" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Move from:</td>
                <td><input type="text" id="o_form" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Move to:</td>
                <td><input type="text" id="o_to" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" id="o_price" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Client:</td>
                <td><input type="text" id="c_client" width="50px" height="20px"></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td><input type="text" id="o_operator" width="50px" height="20px"></td>
            </tr>
            <tr>
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
