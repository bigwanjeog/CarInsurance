<jsp:include page="header.jsp" />

<div class="jumbotron">
    Bonjour ${utilisateurTemp.nom}, le prix de votre assurance sera calculé après la sélection de votre voiture.<p/>
    <div class="help-block error">
        ${voitureNull}
    </div>
    <form action="app?page=dashboard" method="post">
        <fieldset>
            <legend>Votre voiture</legend>
            <div class="form-group">
                <label class="control-label">Constructeur</label>
                <select class="form-control" id="selectConstructeur"></select>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label class="control-label">Modèle</label>
                <select class="form-control" id="selectModele"></select>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label class="control-label">Voiture</label>
                <select class="form-control" id="selectVoiture" name="selectVoiture"></select>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary" id="btnVoiture" disabled>Envoyer</button>
            </div>
        </fieldset>
    </form>
</div>
<jsp:include page="footer.jsp" />