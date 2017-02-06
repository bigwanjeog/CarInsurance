<jsp:include page="header.jsp" />

<div class="jumbotron">
    <form data-toggle="validator" role="form" action="app?page=voiture" method="post">
        <fieldset>
            <legend>Formulaire d'inscription</legend>
            <div class="form-group">
                <div class="form-inline row">
                    <div class="form-group col-md-6">
                        <label for="inputDefault" class="control-label">Nom</label>
                        <input value="${signInNom}" type="text" pattern="^[^0-9]+" data-minlength="2" class="inputWidth form-control" id="inputNom" name="inputNom" placeholder="Nom" data-error="Nom invalide" required>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputDefault" class="control-label">Prénom</label>
                        <input value="${signInPrenom}" type="text" pattern="^[^0-9]+" data-minlength="2" class="inputWidth form-control" id="inputPrenom" name="inputPrenom" placeholder="Prénom" data-error="Prénom invalide" required>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="inputDefault" class="control-label">Adresse</label>
                <input value="${signInAdresse}" type="text" data-minlength="5" class="form-control" id="inputAdresse" name="inputAdresse" placeholder="Adresse" data-error="Minimum de 5 caractères" required>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label for="inputDefault" class="control-label">Ville</label>
                <input value="${signInVille}" type="text" pattern="^[^0-9]+" data-minlength="2" class="form-control" id="inputVille" name="inputVille" placeholder="Ville" data-error="Ville invalide" required>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <div class="form-inline row">
                    <div class="form-group col-md-6">
                        <label for="inputDefault" class="control-label">Code Postal</label>
                        <input value="${signInCp}" type="text" pattern="^[0-9]{5}" class="inputWidth form-control" id="inputCP" name="inputCP" placeholder="Code Postal" data-error="Code postal uniquement 5 chiffres" required>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputDefault" class="control-label">Date Naissance</label>
                        <input value="${signInDateNaissance}" type="text" pattern="^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$" class="inputWidth form-control" id="inputDateNaissance" name="inputDateNaissance" placeholder="Date de naissance" data-error="Date invalide (format dd/mm/yyyy)" required>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="control-label">Email</label>
                <input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email" data-error="Email invalide" required>
                <div class="help-block with-errors error">${errorEmail}</div>
            </div>
            <div class="form-group">
                <div class="form-inline row">
                    <div class="form-group col-md-6">
                        <label for="inputPassword" class="control-label">Mot de passe</label>
                        <input value="${signInMdp}" type="password" data-minlength="4" class="inputWidth form-control" id="inputPassword" name="inputPassword" placeholder="Mot de passe" required>
                        <div class="help-block">Minimum de 4 caractères</div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword" class="control-label">Confirmation mot de passe</label>
                        <input value="${signInConfirmation}" type="password" class="inputWidth form-control" id="inputPasswordConfirm" name="inputConfirmation" data-match="#inputPassword" data-match-error="Les mots de passes ne sont pas identique" placeholder="Confirmation mot de passe" required>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <button type="reset" class="btn btn-default" id="btnReset">Reset</button>
                <button type="submit" class="btn btn-primary">Envoyer</button>
            </div>
        </fieldset>
    </form>
</div>
<jsp:include page="footer.jsp" />