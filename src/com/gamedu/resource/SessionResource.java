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









import com.gamedu.model.Session;
 
@Path("/session")
public class SessionResource {
 
    private final static String FIRST_NAME = "firstName";
    private final static String LAST_NAME = "lastName";
    private final static String EMAIL = "email";
    
    // vamos utilizar um Map estático para
 	// "simular" uma base de dados
    private List<Session> sessionList;
    
    //int sessionid, int aulaId, int gameId, int userId,   int type
    private Session session  = new Session(1, 1, 18, 1, 3);
    private Session session2 = new Session(2, 1, 18, 1, 3);
    private Session session3 = new Session(3, 1, 18, 1, 3);
    private Session session4 = new Session(4, 1, 18, 1, 3);
    private Session session5 = new Session(5, 1, 18, 1, 3);
    
    private List<String> fixedNumbers; 
	private List<String> missingNumbers;
    

	
    
    public SessionResource() {
		super();
		// TODO Auto-generated constructor stub
		this.sessionList = new ArrayList<Session>();
		
		this.fixedNumbers = new ArrayList<String>(Arrays.asList("0","2","3","5","6","7","8"));
		this.missingNumbers = new ArrayList<String>(Arrays.asList("1","9"));
		this.session.setFixedNumbers(this.fixedNumbers);
		this.session.setMissingNumbers(this.missingNumbers);
		
		this.fixedNumbers = new ArrayList<String>(Arrays.asList("0","1","3","5","6","7","9"));
		this.missingNumbers = new ArrayList<String>(Arrays.asList("2"));
		this.session2.setFixedNumbers(this.fixedNumbers);
		this.session2.setMissingNumbers(this.missingNumbers);
		
		this.fixedNumbers = new ArrayList<String>(Arrays.asList("0","2","3","5","6","8"));
		this.missingNumbers = new ArrayList<String>(Arrays.asList("4"));
		this.session3.setFixedNumbers(this.fixedNumbers);
		this.session3.setMissingNumbers(this.missingNumbers);
		
		this.fixedNumbers = new ArrayList<String>(Arrays.asList("0","2","3","5","6","7","8","9"));
		this.missingNumbers = new ArrayList<String>();
		this.session4.setFixedNumbers(this.fixedNumbers);
		this.session4.setMissingNumbers(this.missingNumbers);
		
		this.fixedNumbers = new ArrayList<String>(Arrays.asList("0","1","2","3","5","6","7","8"));
		this.missingNumbers = new ArrayList<String>();
		this.session5.setFixedNumbers(this.fixedNumbers);
		this.session5.setMissingNumbers(this.missingNumbers);
		
		this.sessionList.add(this.session);
		this.sessionList.add(this.session2);
		this.sessionList.add(this.session3);
		this.sessionList.add(this.session4);
		this.sessionList.add(this.session5);
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
	public List<Session> getAllPersons() {
		return this.sessionList;
	}
         
    
   
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Session getSessionById(@PathParam("id") int id) {
    	Session s = sessionList.get(id);
    	System.out.println("Returning person by id: " + s.getSessionid() + " " + s.getGameId());    	
    	return s;
    }
    
    @GET
    @Path("{aula_id}/{person_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Session> getSessionByPerson(@PathParam("aula_id") int aulaId, 
    		@PathParam("person_id") int personId) {
    	List<Session> sessionByPerson = new ArrayList<Session>();
    	for (Session s : sessionList) {
			if(s.getAulaId() == aulaId && s.getUserId() == personId ){				
				sessionByPerson.add(s);				
			}
			
		}    	
    	
    	return sessionByPerson;
    }
    
       
}