

function loadData(aulaId) {

	var getUrl = 'http://localhost:8080/RestWebServices/rest/aula/'+1;	

	$.getJSON(getUrl, function(data) {
		
		for(i=0; i< data.alunosList.length; i++ ){
			getSessions( data.aulaId, data.alunosList[i].id);
		}
	}) 
	/*.done(function() {
		console.log( "loadData success" );
	})
	.fail(function() {
		console.log( "error" );
	});*/

}



function getSessions(aulaId, alunoId) {
	var getUrl = 'http://localhost:8080/RestWebServices/rest/session/'+aulaId+"/"+alunoId;
	$.getJSON(getUrl, function(data){
		getDadosSession(data);

	});

}


function getDadosSession(data){
	
		var fixed = 0;
		var miss = 0;
		var total = 10 * data.session.length;
		var corretas = total - fixed - miss;



		for(i=0; i< data.session.length; i++ ){

			if (data.session[i].fixedNumbers != undefined) {        		
				console.log(data.session[i].missingNumbers);
				fixed += data.session[i].fixedNumbers.length;
			}

			if (data.session[i].missingNumbers != undefined) {        		
				console.log(data.session[i].missingNumbers);
				miss += data.session[i].missingNumbers.length;
			} 

			console.log("fixed " + fixed + " missing " + miss);

		} 

		document.getElementById("header").innerHTML= "fixed " + fixed + " missing " + miss;


}


