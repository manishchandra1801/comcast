package com.manish.codingexcersice;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces({"application/json","application/xml"})
public interface CampaignService {

	@GET
	@Path("/ad/{id}/")
	Campaign getCampaign(@PathParam("id") String id);

	@POST
	@Path("/ad/")
	Response addCampaign(Campaign campaign);

}