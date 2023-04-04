<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta charset="UTF-8" http-equiv="Content-Type">
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/style.css"/>
		<title>Comptes</title>
	</head>
	<body>
		<div class="container col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-3 spacer" align="center">
			<div class="panel panel-info">
				<div class="panel-heading">Formulaire d'ajout de comptes</div><br><br>
				<div class="panel-body">
					<form method="post" action="comptes">
						<div class="form-group">
							<label class="control-label">Nom</label>
							<input class="form-control" type="text" name="username" id="username"/>
						</div>
						<div class="form-group">
							<label class="control-label">Password</label>
							<input class="form-control" type="password" name="password" id="password"/>
						</div>
						<div>
							<input class="btn btn-success" type="submit" name="valider" id="Envoyer"/>
							<input class="btn btn-warning" type="reset" name="annuler" id="Annuler"/>
						</div>
					</form>
				</div>
			</div>
	  </div>
	  <div class="container spacer" align="center">
			<div class="panel panel-info">
				<div class="panel-heading">Liste des comptes</div><br><br>
				<div class="panel-body">
					<table class="table table-bordered table-striped">
						<tr>
							<th>ID</th>
							<th>Nom</th>
							<th>Password</th>
						</tr>
						<c:forEach items="${comptes}" var="comptes">
							<tr>
								<td>${comptes.id}</td>
								<td>${comptes.username}</td>
								<td>${comptes.password}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
	  </div>
	</body>
</html>

