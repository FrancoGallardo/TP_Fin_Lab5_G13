function agregar(NombreTabla,Fila,event){
	event.preventDefault();
	var Tabla=document.getElementById(NombreTabla);
	var Filas=Tabla.rows[Fila+1];
	console.log(Filas)
	console.log(Filas.cells[1]);
	console.log(Filas.cells[1].children[0].value);
	var formContainer = document.getElementByClassName('account-form');
	document.getElementById('txtUsuario').value = "0";
	formContainer.style.display = "block";
}