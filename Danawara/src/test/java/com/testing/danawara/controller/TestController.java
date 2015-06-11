package com.testing.danawara.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;

import com.testing.danawara.requests.CheckRequest;
import com.testing.danawara.service.DanawaraService;
import com.testing.danawara.common.EnumSize;
import com.testing.danawara.common.EnumSocket;
import com.testing.danawara.common.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class TestController {
	
	@Autowired
	private WebApplicationContext wac;	
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testHomeController() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
	// 4-1 모든 부품 항목을 같은 규격으로 선택 후 확인
	@Test
	public void testCheckHomeController() throws Exception {
		CheckRequest request = new CheckRequest();
		request.setCpu(1);
		request.setMainBoard(1);
		request.setVga(1);
		request.setComputerCase(1);
		
		mockMvc.perform(post("/check").contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.msg1").value("CPU와 메인보드가 맞습니다."))
				.andExpect(jsonPath("$.msg2").value("메인보드와 케이스가 맞습니다."))
				.andExpect(jsonPath("$.msg3").value("vga와 케이스가 맞습니다."));
	}
	
	// 4-2 케이스의 규격이 다른 부품보다 큰 경우
	@Test
	public void testCheckHomeController1() throws Exception {
		// Mock Object
		CheckRequest request = new CheckRequest();
		request.setCpu(1);
		request.setMainBoard(1);
		request.setVga(2);
		request.setComputerCase(3);
		
		mockMvc.perform(post("/check").contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.msg1").value("CPU와 메인보드가 맞습니다."))
				.andExpect(jsonPath("$.msg2").value("메인보드와 케이스가 맞습니다."))
				.andExpect(jsonPath("$.msg3").value("vga와 케이스가 맞습니다."));
	}
	
	// 4-3 케이스 규격이 VGA보다 작은 경우
	@Test
	public void testCheckHomeController2() throws Exception {
		CheckRequest request = new CheckRequest();
		request.setCpu(1);
		request.setMainBoard(1);
		request.setVga(3);
		request.setComputerCase(1);
		
		mockMvc.perform(post("/check").contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.msg1").value("CPU와 메인보드가 맞습니다."))
				.andExpect(jsonPath("$.msg2").value("메인보드와 케이스가 맞습니다."))
				.andExpect(jsonPath("$.msg3").value("더 작은 vga를 선택하세요."));
	}
	
	// 4-4 케이스의 규격이 메인보드보다 작은 경우
	@Test
	public void testCheckHomeController3() throws Exception {
		CheckRequest request = new CheckRequest();
		request.setCpu(1);
		request.setMainBoard(3);
		request.setVga(1);
		request.setComputerCase(2);
		
		mockMvc.perform(post("/check").contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.msg1").value("CPU와 메인보드가 맞습니다."))
				.andExpect(jsonPath("$.msg2").value("더 작은 메인보드를 선택하거나, 더 큰 케이스를 선택하세요."))
				.andExpect(jsonPath("$.msg3").value("vga와 케이스가 맞습니다."));
	}
	
	// 6-1 CPU와 메인보드가 호환되지 않은 채로 확인
	@Test
	public void testCheckHomeController4() throws Exception {
		CheckRequest request = new CheckRequest();
		request.setCpu(1);
		request.setMainBoard(4);
		request.setVga(1);
		request.setComputerCase(2);
		
		mockMvc.perform(post("/check").contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.msg1").value("AMD CPU를 장착해주세요."))
				.andExpect(jsonPath("$.msg2").value("메인보드와 케이스가 맞습니다."))
				.andExpect(jsonPath("$.msg3").value("vga와 케이스가 맞습니다."));
	}
}