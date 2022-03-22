package com.cristorresf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristorresf.entity.Campaign;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Integer>{

}
