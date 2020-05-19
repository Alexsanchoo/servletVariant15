<%@page contentType="text/html; charset=UTF-8" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculates</title>
    </head>

    <style>

        h1
        {
            font-family: 'Calibri';
        }

    </style>


    <form action="servlet" method="post" id="form1">
        <hr width = 65%>
        <table align = "center">
            <tr>
            <center>
            Menu<br>
            1. Smallest common multiple<br>
            2. Greatest common divisor<br>
            3. Min value<br>
            4. Max value<br>
            5. Avg value<br><br>
            </center>
            </tr>
            <tr>
                <td>
                    <b>Enter int values: </b>
                    <input id="arr" type="text" name="Arr"><br><br>
                    <b>Enter choice menu: </b>
                    <input id="choice" type="text" name="Choice">
                </td>
            </tr>
        </table>
        <hr width = 65%>
        <center><input type="submit" value="Send"></center>
    </form>
</html>
