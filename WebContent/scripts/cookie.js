/**
 * 
 */
function getCookie() {
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
	var biscoito = "Plataforma=1,UserId:1,IdSessao:1,IdUserName:Jogador,IdJogo:1; " + expires+";";	
	document.cookie = biscoito;	
	console.log("Cookie criado: ");
	listarCookie();
}

function eraseCookie(){ 	
	document.cookie = "Plataforma=1;expires=Thu, 01 Jan 1970 00:00:01 GMT;";
	console.log(document.cookie);
}

function readCookie(){
   var allcookies = document.cookie;
   console.log("All Cookies : " + allcookies );

   // Get all the cookies pairs in an array
   cookiearray  = allcookies.split(';');

   // Now take key value pair out of this array
   for(var i=0; i<cookiearray.length; i++){
      //name = cookiearray[i].split('=')[0];
      //value = cookiearray[i].split('=')[1];
      //console.log("Key is : " + name + " and Value is : " + value);
      valueCookie = value.split(',');
      for(var i=0; i<valueCookie.length; i++){	  
          name = valueCookie[i].split(':')[0];
          value = valueCookie[i].split(':')[1];
          console.log("Key is : " + name + " and Value is : " + value);    	  
    	  
      }      
   }
}

function listarCookie(){
	console.log("Cookies: " + document.cookie);
}