

function loadData(aulaId) {

	var getUrl = 'http://localhost:8080/RestWebServices/rest/aula/'+1;	

	$.getJSON(getUrl, function(data) {
		
		console.log("loadData " +data.alunosList.length);
		
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


//Pega as sessões de um aluno a partir de uma aula
function getSessions(aulaId, alunoId) {
	var getUrl = 'http://localhost:8080/RestWebServices/rest/session/'+aulaId+"/"+alunoId;
	$.getJSON(getUrl, function(data){
		console.log("getSessions " +  aulaId + " " + alunoId + " JSON " + data);
		getDadosSession(data);

	});

}


function getDadosSession(data){
	
		var fixed = 0;
		var miss = 0;
		var total = 10 * data.session.length;
		

		for(i=0; i< data.session.length; i++ ){

			if (data.session[i].fixedNumbers != undefined) {        		
				fixed += data.session[i].fixedNumbers.length;
			}

			if (data.session[i].missingNumbers != undefined) {        		
				miss += data.session[i].missingNumbers.length;
			} 

			console.log("id " + data.session[i].userId +" fixed " + fixed + " missing " + miss);

		} 
		
		var corretas = total - fixed - miss;
		
		var percert = Math.round((100 * corretas)/ (corretas + miss));

		document.getElementById("header").innerHTML= "fixed " + fixed + " missing " + miss + " corretas " + percert;
		

    	
		createLineUser(data.session[1].userId, percert, data.session.length);


}

function createLineUser(userId, percert, length) {
	var table = document.getElementById("GuideTable");
    var row = table.insertRow(-1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    cell1.innerHTML = '<a href="url">' + userId +"</a>";
    cell2.innerHTML += '<div class="CorrectBar"	style="width: 60%;"> <div class="percentBar"> '+ percert +'% </div></div>';
    cell2.innerHTML += '<div class="WrongBar" style="width: 20%;"></div>';
    cell2.innerHTML += '<div style="float: left; height: 0.7cm; margin-left: 15px;"> ' + length + '</div>';
}


