<%@ include file="HeaderAdmin.jsp"%>
<div class="main-container">
	<div class="container content-container">
		<div class="row">
			<div class="col-sm-12">
				<div class="title-container" id="titulo">
					<h1 class="title">Lista de Usuario</h1>
				</div>
				<table id="bankTable">
					<thead>
						<tr>
							<th>Id Usuario</th>
	                        <th>Nombre de Usuario</th>
	                        <th>Contraseña</th>
	                        <th>Tipo de Usuario</th>
	                        <th>Estado</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${lstUsuarios}" var="user">
						<c:choose>
						 <c:when test = "${user.getTipoUsuario() != 'administrador'}">
						<tr>
							<td>${user.getIdUsuario()}</td>
							<td>${user.getUsername()}</td>
							<td>${user.getPassword()}</td>
							<td>${user.getTipoUsuario()}</td>
							<td>${user.getEstado()}</td>
						</tr>
						</c:when>    
						</c:choose>
					</c:forEach>
					</tbody>
				</table>
				${Msg}
			</div>
		</div>
	</div>
</div>
<%@ include file="FooterMenu.jsp"%>