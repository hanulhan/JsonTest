<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <script>
        function NavigateRestWeatherBahamas() {

            var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
            var s = window.location.origin + ctx + "/rest/weather/AEXX0004";
            window.open(s);

        }

        function NavigateRestWeatherCologne() {

            var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
            var s = window.location.origin + ctx + "/rest/weather/GMXX0018";
            window.open(s);

        }


        function NavigateRestWeatherlocations() {

            var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
            var s = window.location.origin + ctx + "/rest/weatherlocations";
            window.open(s);

        }   // CopyToClipboard()
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
            <a id="myLink" title="navigate" href="javascript:void(0)" onclick="NavigateRestWeatherCologne();return false;">Rest call for weather Cologne</a>
            <br>   
            <a id="myLink" title="navigate" href="javascript:void(0)" onclick="NavigateRestWeatherBahamas();return false;">Rest call for weather Bahamas</a>
            <br>   
            <a id="myLink" title="navigate" href="javascript:void(0)" onclick="NavigateRestWeatherlocations();
                    return false;">Rest call for weather locations</a>
            <br>



        </div>
    </body>
</html>
