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
import com.testing.danawara.models.Mainboard;
import com.testing.danawara.models.Pc_case;
import com.testing.danawara.models.Vga;
import com.testing.danawara.responses.CheckResponse;
import com.testing.danawara.requests.CheckRequest;
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
	
	@RequestMapping(value = "/check", method = RequestMethod.POST, produces="application/json",
			consumes="application/json")
	public @ResponseBody CheckResponse check(@RequestBody CheckRequest requests) {
		Cpu cpu = (Cpu)this.service.getCpuById((int)requests.getCpu());
		Mainboard mainboard = (Mainboard) this.service.getMainboardById((int)requests.getMainboard());
		Pc_case pcCase = (Pc_case) this.service.getPc_caseById((int)requests.getComputerCase());
		Vga vga = (Vga) this.service.getVgaById((int)requests.getVga());
		
		String msg1 = this.checkCPUWithMainBoard((Cpu)cpu, (Mainboard)mainboard);
		String msg2 = this.checkMainBoardWithPcCase((int) mainboard.getSize(), (int) pcCase.getSize());
		String msg3 = this.checkVGAWithPcCase((int)vga.getSize(), (int) pcCase.getSize());
		
		return new CheckResponse(msg1, msg2, msg3);
	}
	
	public String checkCPUWithMainBoard(Cpu cpu, Mainboard mainboard){
		if(cpu.getSocket() == mainboard.getSocket()) {
			return "CPU와 메인보드가 맞습니다.";
		} else {
			return "CPU와 메인보드가 맞지 않습니다.";
		}
	}
	
	public String checkMainBoardWithPcCase(int mainboard_size, int pc_case_size){
		if(mainboard_size <= pc_case_size) {
			return "메인보드와 케이스가 맞습니다.";
		} else {
			return "메인보드와 케이스가 맞지 않습니다.";
		}
	}
	
	public String checkVGAWithPcCase(int vga_size, int pc_case_size){
		if(vga_size <= pc_case_size) {
			return "vga와 케이스가 맞습니다.";
		} else {
			return "vga와 케이스가 맞지 않습니다.";
		}
	}
}
