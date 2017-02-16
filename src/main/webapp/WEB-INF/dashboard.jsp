<jsp:include page="header.jsp" />
<div class="jumbotron">
    <p>Information de votre compte</p>
    Vous payez <strong>${utilisateur.prix}&euro;</strong> par mois.
    <br/><br/>
    <div class="row">
        <div class="col-lg-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Votre voiture</h3>
                </div>
                <div class="panel-body">
                    <ul>
                        <li>Constructeur : <strong>${utilisateur.voiture.modele.constructeur.nom}</strong></li>
                        <li>Modèle : <strong>${utilisateur.voiture.modele.nom}</strong></li>
                        <li>Chevaux : <strong>${utilisateur.voiture.chevaux}</strong></li>
                        <li>Année : <strong>${utilisateur.voiture.annee}</strong></li>
                        <li>Carburant : <strong>${utilisateur.voiture.carburant}</strong></li>
                    </ul>
                    <a href="app?page=voiture&status=update" class="btn btn-default btn-block">Modifier votre voiture</a>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Vos informations personnelles</h3>
                </div>
                <div class="panel-body">
                    <ul>
                        <li>Nom : <strong>${utilisateur.nom}</strong></li>
                        <li>Prénom : <strong>${utilisateur.prenom}</strong></li>
                        <li>Adresse : <strong>${utilisateur.adresse}</strong></li>
                        <li>Code postal : <strong>${utilisateur.cp}</strong></li>
                        <li>Ville : <strong>${utilisateur.ville}</strong></li>
                        <li>Date de naissance : <strong>${utilisateur.dateNaissance}</strong></li>
                        <li>Email : <strong>${utilisateur.email}</strong></li>
                    </ul>
                    <a href="app?page=formulaire&status=update" class="btn btn-default btn-block">Modifier vos informations personnelles</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <a href="app?page=chat" class="btn btn-primary btn-block">Chat</a>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />