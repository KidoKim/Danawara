package com.testing.danawara.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	@Mock
	DanawaraService danawaraService;
	@InjectMocks
	private HomeController homeController;
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
	}
	
	@Test
	public void testHomeController() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void testCheckHomeController() throws Exception {
		CheckRequest request = new CheckRequest();
		request.setComputerCase(1);
		request.setCpu(1);
		request.setMainBoard(1);
		request.setVga(1);

		mockMvc.perform(post("/check").contentType(MediaType.APPLICATION_JSON)
		.content(TestUtil.convertObjectToJsonBytes(request)));
	}
}