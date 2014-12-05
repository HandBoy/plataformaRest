/**
 * 
 */
function getCookie() {
		console.log("getCookie!!!");
		var c_name = document.cookie; // listando o nome de todos os cookies
		if(c_name!=undefined || c_name.length > 0) // verificando se o mesmo existe
		{
			var posCookie = c_name.indexOf("Plataforma"); // checando se existe o cookieSeuNome 
			if (posCookie >= 0) //se existir o cookie mostra um alert no browser
			{
			console.log("Cookie Existe!!!");
			listarCookie();
			} else {
				console.log("Cookie não existe posCookie!!!");
				setCookie();  
			}
		}else{
			console.log("Cookie não existe =[ ");
		}
	}
	
function setCookie(){    //função universal para criar cookie
	var exdays = 10;
	var d = new Date();
	d.setTime(d.getTime() + (exdays*24*60*60*1000));
	var expires = "expires="+d.toUTCString();
	var biscoito = "Plataforma=1,UserId:1,IdSessao:1, IdUserName:Jogador; " + expires;	
	document.cookie = biscoito;	
	console.log("Cookie criado: ");
	listarCookie();
}

function eraseCookie(){ 	
	/*var d = new Date();
	d.setTime(d.getTime() + (-1*24*60*60*1000));
	var expires = "expires="+d.toUTCString();
	document.cookie = "plataforma=1; " + expires;
	console.log(document.cookie);*/
			
	var d = new Date();
	d.setTime(d.getTime() + (-1*24*60*60*1000));
	document.cookie="UserID";
	document.cookie = "expires=" + d.toUTCString() + ";"
	console.log(document.cookie);
}

function listarCookie(){
	console.log("Cookies: " + document.cookie);
}