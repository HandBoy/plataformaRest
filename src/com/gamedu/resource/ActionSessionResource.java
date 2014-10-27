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
import com.gamedu.model.ActionSession;
import com.gamedu.model.Data;
 
@Path("/actionsession")
public class ActionSessionResource {
     
    // vamos utilizar um Map estático para
 	// "simular" uma base de dados
    private List<Data> listData;	  
    private List<ActionSession> listAcSession;	
    private ActionSession acSession  = new ActionSession(1, 18, 1, 1);
    private ActionSession acSession2 = new ActionSession(1, 18, 1, 1);
    private ActionSession acSession3 = new ActionSession(1, 18, 1, 1);
    private ActionSession acSession4 = new ActionSession(1, 18, 1, 0);
    private ActionSession acSession5 = new ActionSession(1, 18, 1, 0);
    private ActionSession acSession6 = new ActionSession(1, 18, 1, 0);
    

	
    
    public ActionSessionResource() {
		super();
		// TODO Auto-generated constructor stub
		this.listData = new ArrayList<Data>(Arrays.asList(new Data("Wagon 9", "Number 1")));
		this.acSession.setListData(listData);
		this.listData = new ArrayList<Data>(Arrays.asList(new Data("Wagon 4", "Number 1")));
		this.acSession2.setListData(listData);
		this.listData = new ArrayList<Data>(Arrays.asList(new Data("Wagon 9", "Number 4")));
		this.acSession3.setListData(listData);
		this.listData = new ArrayList<Data>(Arrays.asList(new Data("Number 1", null)));
		this.acSession4.setListData(listData);
		this.listData = new ArrayList<Data>(Arrays.asList(new Data("Number 4", null)));
		this.acSession5.setListData(listData);
		this.listData = new ArrayList<Data>(Arrays.asList(new Data("Number 9", null)));
		this.acSession6.setListData(listData);
		
		this.listAcSession = new ArrayList<ActionSession>();
		
		this.listAcSession.add(acSession);
		this.listAcSession.add(acSession2);
		this.listAcSession.add(acSession3);
		this.listAcSession.add(acSession4);
		this.listAcSession.add(acSession5);
		this.listAcSession.add(acSession6);
		
		//fixedNumbers = new ArrayList<String>(Arrays.asList("2","3","5","6","7","8"));
		//missingNumbers = new ArrayList<String>(Arrays.asList("1","9")); 4 certo
		
		
		
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
	public List<ActionSession> getAllPersons() {
		//return this.listAcSession;
    	return this.listAcSession;
	}      
       
}