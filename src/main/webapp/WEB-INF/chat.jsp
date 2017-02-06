<jsp:include page="header.jsp" />

<div class="jumbotron">
    <div  class="chat" id="chatDiv">
        <table class="table table-striped table-hover" id="tableChat">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr class="danger">
                    <td class="pseudo">Admin</td>
                    <td>Keep calm and write code</td>
                </tr>
            </tbody>
        </table> 
    </div>
    <div class="form-group">
        <input type="text" class="form-control" id="inputChat" placeholder="Entrez votre message...">
    </div>
    <div class="form-group">
        <button class="btn btn-primary" id="btnChat">Envoyer</button>
    </div>
</div>
<jsp:include page="footer.jsp" />