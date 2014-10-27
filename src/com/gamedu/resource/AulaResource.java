package com.gamedu.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Request;












import com.gamedu.model.Aula;
import com.gamedu.model.Person;
import com.gamedu.model.Session;
 
@Path("/aula")
public class AulaResource {
    
    // vamos utilizar um Map estático para
 	// "simular" uma base de dados
   
    private Person person = new Person(1, "Jill", "Person", "jilln@jerseyrest.com"); 
    private Person person2 = new Person(2, "Eve", "Person", "eve@jerseyrest.com"); 
    private Person person3 = new Person(3, "Jackson", "Person", "jackson@jerseyrest.com"); 
    private Person person4 = new Person(4, "Bill", "Person", "billn@jerseyrest.com"); 
    
    private Aula aula;
    
    private List<Person> personList;     
    private List<Aula> aulaList; 
	
    

	
    
    public AulaResource() {
		super();
		// TODO Auto-generated constructor stub
		this.personList = new ArrayList<Person>();
		this.personList.add(this.person);
		this.personList.add(this.person2);
		this.personList.add(this.person3);
		this.personList.add(this.person4);
		
		this.aula = new Aula(1, 18, new Date(), this.personList);
		
		this.aulaList = new ArrayList<Aula>();
		this.aulaList.add(aula);
		
	}
    
     
    // The @Context annotation allows us to have certain contextual objects
    // injected into this class.
    // UriInfo object allows us to get URI information (no kidding).
	@Context
    UriInfo uriInfo;
 
    // Another "injected" object. This allows us to use the information that's
    // part of any incoming request.
    // We could, for example, get header information, or the requestor's address.
    @Context
    Request request;
     
    // Basic "is the service running" test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String respondAsReady() {
        return "Demo service is ready!";
    }
 
    
    @GET
    @Path("all")
	//@Produces("text/xml")
    @Produces(MediaType.APPLICATION_JSON)
	public Aula getAula() {
		return this.aula;
	}
         
   
   
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Aula getAula(@PathParam("id") int id) {
    	
    	for (Aula aula : aulaList) {
			if(aula.getAulaId() == id){
				System.out.println("achou");
				return aula;
			}
		}    	
   	
    	return null;
    }
    
       
}