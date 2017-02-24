package com.manish.codingexcersice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.manish.codingexcersiceex.exceptions.SomeBusinessException;





public class CampaignServiceImpl implements CampaignService {
	private int currentId = 1;
	Map<String, List<Campaign>> campaigns = new HashMap<String, List<Campaign>>();

	@Override
	public Campaign getCampaign(String id) {
		Campaign camp = null;
		System.out.println("...invoking getCampaign, partnerid is... " + id);
		for (int i = 0; i < campaigns.get(id).size(); i++) {
			if (campaigns.get(id).get(i).isActive() == true) {
				camp = campaigns.get(id).get(i);
			} else {
				throw new SomeBusinessException("No active campaign");
			}
		}

		return camp;
	}
	@Override
	public Response addCampaign(Campaign campaign) {
		System.out.println("...invoking addCampaign, partnerid is... " + campaign.getPartner_id());
		campaign.setCreation_time(Calendar.getInstance());
		campaign.setCampaign_id(currentId++);

		if (campaigns.get(campaign.getPartner_id()) == null) {
			ArrayList<Campaign> camplist = new ArrayList<Campaign>();
			camplist.add(campaign);
			campaigns.put(campaign.getPartner_id(), camplist);
		} else {
			for (int i = 0; i < campaigns.get(campaign.getPartner_id()).size(); i++) {
				if (campaigns.get(campaign.getPartner_id()).get(i).isActive() == true) {
					throw new SomeBusinessException("Already have an active campaign");
				} else {
					campaigns.get(campaign.getPartner_id()).add(campaign);
				}
			}

		}

		return Response.ok(campaign).build();
	}
}