<jsp:include page="header.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="jumbotron">
    <c:choose>
        <c:when test="${utilisateur == null}">
            Bonjour ${utilisateurTemp.nom}, le prix de votre assurance sera calculé après la sélection de votre voiture.<p/>
        </c:when>
        <c:otherwise>
            <c:set var="actionForm" value="&status=update"/>
            Vous possédez actuellement une <strong>${utilisateur.voiture.modele.constructeur.nom} ${utilisateur.voiture.modele.nom}</strong> et payez <strong>${utilisateur.prix}&euro;</strong> par mois, le prix de votre assurance sera recalculé après le changement de voiture.<p/>
        </c:otherwise>
    </c:choose>
    <div class="help-block error">
        ${voitureNull}
    </div>
    <form action="app?page=dashboard${actionForm}" method="post">
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
                <c:if test="${utilisateur != null}">
                    <a href="app?page=dashboard"><button type="button" class="btn btn-danger">Annuler</button></a>
                </c:if>
            </div>
        </fieldset>
    </form>
</div>
<jsp:include page="footer.jsp" />