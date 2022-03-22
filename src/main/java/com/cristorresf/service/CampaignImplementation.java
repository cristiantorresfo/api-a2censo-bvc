package com.cristorresf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristorresf.entity.Campaign;
import com.cristorresf.repository.CampaignRepository;

@Service
public class CampaignImplementation implements CampaignService{
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	@Override
	public List<Campaign> findAll(){
		return (List<Campaign>) campaignRepository.findAll();
	}
	
	@Override
	public Optional<Campaign> findById(Integer id){
		return campaignRepository.findById(id);
	}
	
	@Override
	public Campaign save(Campaign campaign){
		return campaignRepository.save(campaign);
	}
	
	@Override
	public void deleteById(Integer id){
		campaignRepository.deleteById(id);
	}

	
	
	
}