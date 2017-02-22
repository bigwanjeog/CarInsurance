<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Car insurance</title>
        <link rel="icon" href="img/favico.ico">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jquery-ui.css" rel="stylesheet">
        <link href="css/jquery-ui.structure.css" rel="stylesheet">
        <link href="css/jquery-ui.theme.css" rel="stylesheet">
        <link href="css/tools.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">                
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="app">Assurance voiture</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Tools<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="http://getbootstrap.com/components/" target="_blank">Bootstrap</a></li>
                                <li><a href="https://bootswatch.com/darkly/" target="_blank">Bootswatch</a></li>
                                <li><a href="https://1000hz.github.io/bootstrap-validator/" target="_blank">Bootstrap Validator</a></li>
                                <li class="divider"></li>
                                <li><a href="https://jqueryui.com/" target="_blank">Jquery UI</a></li>
                                <li><a href="http://www.w3schools.com/" target="_blank">W3Schools</a></li>
                                <li class="divider"></li>
                                <li><a href="https://regex101.com/" target="_blank">Regex test</a></li>
                                <li class="divider"></li>
                                <li><a href="https://openclassrooms.com/courses/creez-votre-application-web-avec-java-ee/" target="_blank">Tuto OpenClassRoom Java EE</a></li>
                            </ul>
                        </li>
                    </ul>
                    <c:if test="${utilisateur != null}">
                        <ul class="nav navbar-nav navbar-right">
                            <li> <a href="logout"><i class="glyphicon glyphicon-log-out"></i> Logout</a> </li>
                        </ul>
                    </c:if>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="panel panel-danger">
                <div class="panel-body" id="wsAds">
                    TODO PUBLICITÉ
                </div>
            </div>
        </div>
        <div class="container">
