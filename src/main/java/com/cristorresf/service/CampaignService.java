package com.cristorresf.service;

import java.util.List;
import java.util.Optional;

import com.cristorresf.entity.Campaign;

public interface CampaignService {

		public List<Campaign> findAll();
		
		public Optional<Campaign> findById(Integer id);
		
		public Campaign save(Campaign campaign);
		
		public void deleteById(Integer id);

		
}
