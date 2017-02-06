<%-- 
    Document   : home
    Created on : 13 déc. 2016, 13:18:10
    Author     : RENAUD
--%>
<jsp:include page="header.jsp" />

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Connexion a Car Insurance</h3>
            </div>
            <div class="panel-body">
                <form role="form" method="post" action="app?page=dashboard">
                    <fieldset>
                        <div class="form-group aligna">
                            <input class="form-control" placeholder="E-mail" name="email" type="email" value="${emailCorrect}" autofocus>
                            <div class="help-block error">
                                ${emailErreur}
                            </div>
                        </div>
                        <div class="form-group aligna">
                            <input class="form-control" placeholder="Mot de passe" name="password" type="password" value="">
                            <div class="help-block error">
                                ${mdpErreur}
                            </div>
                        </div>
                        <div class="form-group aligna">
                            <div class="help-block error">
                                ${connexionErreur}
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" id="panel" class="btn btn-lg btn-primary btn-block">Login</button>
                        </div>
                        <div class="aligna">
                            <a href="app?page=formulaire" >Pas encore inscrit ?</a>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />