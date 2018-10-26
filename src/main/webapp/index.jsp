<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <script>
        function GetRestPerson() {

            var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
            var s = window.location.origin + ctx + "/rest/person/get";
            window.open(s);

        }

        function PostRestPerson() {
            var xhr = new XMLHttpRequest();
            var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
            var url = window.location.origin + ctx + "/rest/person/add";

            xhr.open("POST", url, true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var json = JSON.parse(xhr.responseText);
                    y= document.getElementById("idOutput");
                    y.innerHtml=json.toString();
                }
            };
            var data = JSON.stringify([{"vorname": "Uli","nachname": "Hansen","geburtstag": "1968-02-24T00:00Z",
                                        "adresse":{
                                            "strasse": "Kornblumenweg 11",
                                            "plz": 50259,
                                            "ort": "Pulheim"
                                         }fff
                                        },
                                        {"vorname": "Acentic",
                                         "nachname": "GmbH",
                                         "geburtstag": "1970-02-24T00:00Z",
                                         "adresse":{
                                             "strasse": "Butzweilerhofallee 4",
                                             "plz": 50878,
                                             "ort": "Köln"
                                          }
                                      }]);
            xhr.send(data);

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
            <a id="myGetLink" title="navigate" href="javascript:void(0)" onclick="GetRestPerson();
                    return false;">HTTP-GET person</a>
            <br>   
            <a id="myPostLink" title="navigate" href="javascript:void(0)" onclick="PostRestPerson();
                    return false;">HTTP-POST person</a>


        </div>
        <div>
            <p id="idOutput"></p>
        </div>
    </body>
</html>
