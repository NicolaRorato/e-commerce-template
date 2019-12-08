function checkRegistrazione(){
	var nome = document.getElementById('nome');
	var username = document.getElementById('username');
	var password = document.getElementById('password');
	var flag = 0;
	if(checkNome(nome))
		flag += 1;
	if(checkUsername(username))
		flag += 1;
	if(checkPassword(password))
		flag += 1;
	if(flag == 3)
		return true;
	else 
		return false;
}

function checkLogin(){
	var username = document.getElementById('username');
	var password = document.getElementById('password');
	var flag = 0;
	if(checkUsername(username))
		flag += 1;
	if(checkPassword(password))
		flag += 1;
	if(flag == 2)
		return true;
	else 
		return false; 
}

function checkNome(elem){
	var nome = document.getElementById('infoNome');
	var regExp = /^[a-zA-Z ,.'-]{2,30}$/;
	if(elem.value.match(regExp)){
		nome.innerHTML = ""; 
		return true;
	} else {
		nome.innerHTML = "Inserire solo lettere per il nome. Max 30 char";
		return false;
	}
}

function checkUsername(elem){
	var username = document.getElementById('infoUsername');
	var regExp = /^[a-zA-Z0-9]{4,10}$/;
	if(elem.value.match(regExp)){
		username.innerHTML = ""; 
		return true;
	} else {
		username.innerHTML = "Inserire da 4 a 10 caratteri, numeri inclusi";
		return false;
	}
}

function checkPassword(elem){
	var password = document.getElementById('infoPassword');
	var regExp = 
		/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z0-9]{4,10}$/;
	if(elem.value.match(regExp)){
		password.innerHTML = ""; 
		return true;
	} else {
		password.innerHTML = "Almeno un carattere minuscolo, uno maiuscolo e uno numerico";
		return false;
	}
}


