package com.testing.danawara.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testing.danawara.models.Cpu;
import com.testing.danawara.requests.CheckRequest;
import com.testing.danawara.responses.CheckResponse;
import com.testing.danawara.service.DanawaraService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	private DanawaraService service;
	
	@Autowired(required=true)
    @Qualifier(value="danawaraService")
    public void setDanawaraService(DanawaraService ds){
        this.service= ds;
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
        model.addAttribute("listCpus", this.service.listCpu());
        model.addAttribute("listMainboards", this.service.listMainboard());
        model.addAttribute("listPc_cases", this.service.listPc_case());
        model.addAttribute("listVgas", this.service.listVga());
		return "home";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST, 
			produces="application/json",
			consumes="application/json")
	public @ResponseBody CheckResponse check(@RequestBody CheckRequest requests) {
			return new CheckResponse(false);
	}
}
