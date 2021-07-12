function agregar(NombreTabla,Fila,event){
	event.preventDefault();
	var Tabla=document.getElementById(NombreTabla);
	var Filas=Tabla.rows[Fila+1];
	var dni = Filas.cells[0].innerHTML;
	// console.log(Filas)
	var formContainer = document.getElementsByClassName('account-form');
	document.getElementById('txtUsuario').value = dni;
	formContainer[0].style.display = "block";
}