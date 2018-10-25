<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <script>
        function NavigateRestPerson() {

            var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
            var s = window.location.origin + ctx + "/rest/person";
            window.open(s);

        }

    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weather-Rest ServicesJSP Page</title>
    </head>
    <body>
        <h1>Weather Rest Services</h1>
        <div id="inputPanel">
            <br>
            <br>   
            <a id="myLink" title="navigate" href="javascript:void(0)" onclick="NavigateRestPerson();return false;">Rest call for person</a>
            <br>   



        </div>
    </body>
</html>
