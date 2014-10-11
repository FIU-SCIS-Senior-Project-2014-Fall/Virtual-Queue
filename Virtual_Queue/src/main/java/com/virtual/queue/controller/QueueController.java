package com.virtual.queue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.virtual.queue.beans.User;
import com.virtual.queue.service.VirtualQueueService;

@Controller
@RequestMapping("/queue")
public class QueueController {

	@Autowired
	VirtualQueueService queueService;
	
	@RequestMapping(value = "/removeFromQueue/{barcode}", method = RequestMethod.GET)
	public @ResponseBody Boolean getUserByUserName(
			@PathVariable("barcode") String barcode) {
		
		//TODO add validation to barcode value to be a number
		if(barcode ==null){
			
			return false;
		}
		
		return queueService.pullfromQueue(barcode);
	
	
	
	}
	
	
	
	
	
}
