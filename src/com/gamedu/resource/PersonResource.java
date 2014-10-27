package com.gamedu.resource;

import java.util.ArrayList;
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






import com.gamedu.model.Person;
 
@Path("/person")
public class PersonResource {
 
    private final static String FIRST_NAME = "firstName";
    private final static String LAST_NAME = "lastName";
    private final static String EMAIL = "email";
    
    // vamos utilizar um Map estático para
 	// "simular" uma base de dados
    private Map<Integer, Person> personMap;
    
    private Person person = new Person(1, "Jill", "Person", "jilln@jerseyrest.com"); 
    private Person person2 = new Person(2, "Eve", "Person", "eve@jerseyrest.com"); 
    private Person person3 = new Person(3, "Jackson", "Person", "jackson@jerseyrest.com"); 
    private Person person4 = new Person(4, "Bill", "Person", "billn@jerseyrest.com"); 
    

	
    
    public PersonResource() {
		super();
		// TODO Auto-generated constructor stub
		personMap = new HashMap<Integer, Person>();
		personMap.put(person.getId(), person);
		personMap.put(person2.getId(), person2);
		personMap.put(person3.getId(), person3);
		personMap.put(person4.getId(), person4);
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
    @Path("sample")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getSamplePerson() {
         
        System.out.println("Returning sample person: " + person.getFirstName() + " " + person.getLastName());
         
        return person;
    }
    
    @GET
    @Path("all")
	//@Produces("text/xml")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersons() {
		return new ArrayList<Person>(personMap.values());
	}
         
    
   
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getBanda(@PathParam("id") int id) {
    	Person p = personMap.get(id);
    	System.out.println("Returning person by id: " + p.getFirstName() + " " + p.getLastName());
    	
    	return p;
    }
    
    // Use data from the client source to edit a Person object, returned a text. 
    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public String personMap(@PathParam("firstName") String nome, @PathParam("id") int id) {
    	Person atual = personMap.get(id);
    	atual.setFirstName(nome);
    	return atual.getFirstName() + " atualizada.";
    }

    // Use data from the client source to delete a Person object, returned a text. 
    @Path("{id}")
    @DELETE
    @Produces("text/plain")
    public String removeBanda(@PathParam("id") int id) {
    	personMap.remove(id);
    	return "Pessoa removida. " + personMap.size();
    }
    
    // Use data from the client source to create a new Person object, returned in JSON format. 
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPerson(MultivaluedMap<String, String> personParams) {
         
        String firstName = personParams.getFirst(FIRST_NAME);
        String lastName = personParams.getFirst(LAST_NAME);
        String email = personParams.getFirst(EMAIL);
         
        System.out.println("Storing posted " + firstName + " " + lastName + "  " + email);
        
        Person p = new Person();
         
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setEmail(email);
        p.setId(personMap.size()+1);
        
        personMap.put(p.getId(), p);
         
        System.out.println("person info: " + p.getFirstName() + " " + p.getLastName() + " " + p.getEmail());
         
        return p;
                         
    }
}