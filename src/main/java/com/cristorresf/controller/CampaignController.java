package com.cristorresf.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristorresf.entity.Campaign;
import com.cristorresf.service.CampaignService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("api/Campaigns")
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;
	
	@ApiOperation(value = "Create a new Campaign")	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Successfully campaign created"), @ApiResponse(code = 400, message = "Missing or invalid parameter"), @ApiResponse(code = 500, message = "Internal error")})

	@PostMapping
	public ResponseEntity<?> create (@RequestBody Campaign campaign){
		return ResponseEntity.status(HttpStatus.CREATED).body(campaignService.save(campaign));
	}
	
	@ApiOperation(value = "Get a campaign by its id" , notes= "Type the campaign id.")	
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully campaign found"), @ApiResponse(code = 404, message = "Campaign not found"), @ApiResponse(code = 400, message = "Missing or invalid id"), @ApiResponse(code = 500, message = "Internal error")})
	@GetMapping(value="/{id}")
	public ResponseEntity<?> readById (@ApiParam(value="Campaign Id" , required = true, type ="integer")@PathVariable("id") Integer id){
		Optional<Campaign> oCampaign = campaignService.findById(id);
		
		if(!oCampaign.isPresent()) {
			return ResponseEntity.notFound().build();
		} 		
		return ResponseEntity.ok(oCampaign);
	}	
	
	@ApiOperation(value = "Get all campaigns")
	@GetMapping
	public ResponseEntity<?> readAll (){
		List<Campaign> campaigns = campaignService.findAll();				
		return ResponseEntity.ok(campaigns);
	}
	
	@ApiOperation(value = "Get the campaigns by criterion and sort type", notes="Criteria allowed(amount/requestedAmount) - Types allowed (ascending/descending)")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully campaigns found"), @ApiResponse(code = 404, message = "Campaigns not found"), @ApiResponse(code = 400, message = "Missing or invalid parameters"), @ApiResponse(code = 500, message = "Internal error")})

	@GetMapping(value="/{criterion}/{type}")
	public ResponseEntity<?> sortByCriteria (@ApiParam(value="Sort criterion" , allowableValues="amount,requestedAmount", required = true)@PathVariable("criterion") String criterion, @ApiParam(value="Sort Type" , allowableValues="ascending,descending" ,required = true)@PathVariable("type")String type ){
		List<Campaign> campaigns = campaignService.findAll();

	   if(criterion.contentEquals("amount")  && type.contentEquals("ascending")) {
			Comparator<Campaign> amountComparator = Comparator.comparing(Campaign::getAmount);
			Collections.sort(campaigns, amountComparator);
			return ResponseEntity.ok(campaigns);
		} else if (criterion.contentEquals("amount") && type.contentEquals("descending")) {
			Comparator<Campaign> amountComparator = Comparator.comparing(Campaign::getAmount);
			Collections.sort(campaigns, amountComparator.reversed());
			return ResponseEntity.ok(campaigns);
		} else if (criterion.contentEquals("requestedAmount") && type.contentEquals("ascending")) {
			Comparator<Campaign> reqAmountComparator = Comparator.comparing(Campaign::getRequestedAmount);
			Collections.sort(campaigns, reqAmountComparator);
			return ResponseEntity.ok(campaigns);
		} else if (criterion.contentEquals("requestedAmount") && type.contentEquals("descending")) {
			Comparator<Campaign> reqAmountComparator = Comparator.comparing(Campaign::getRequestedAmount);
			Collections.sort(campaigns, reqAmountComparator.reversed());
			return ResponseEntity.ok(campaigns);
		} else {
			return ResponseEntity.notFound().build();
		}

	}	
	
	@ApiOperation(value = "Update a campaign by its id")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Successfully updated campaign"), @ApiResponse(code = 404, message = "Campaign not found"), @ApiResponse(code = 400, message = "Missing or invalid id"), @ApiResponse(code = 500, message = "Internal error")})
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update (@RequestBody Campaign campaignUpdated, @PathVariable("id") Integer id) {
		Optional<Campaign> campaign = campaignService.findById(id);
		
		if(!campaign.isPresent()) {
			return ResponseEntity.notFound().build();			
		}		
		campaign.get().setName(campaignUpdated.getName());
		campaign.get().setAmount(campaignUpdated.getAmount());
		campaign.get().setRequestedAmount(campaignUpdated.getRequestedAmount());
		campaign.get().setAdminRate(campaignUpdated.getAdminRate());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(campaignService.save(campaign.get()));
	
	}
	@ApiOperation(value = "Delete a campaign by its id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully campaign deleted"), @ApiResponse(code = 404, message = "Campaign not found"), @ApiResponse(code = 400, message = "Missing or invalid id"), @ApiResponse(code = 500, message = "Internal error")})
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deleteById (@PathVariable("id") Integer id){
		if(!campaignService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		campaignService.deleteById(id);		
		return ResponseEntity.ok().build();
	}
}
