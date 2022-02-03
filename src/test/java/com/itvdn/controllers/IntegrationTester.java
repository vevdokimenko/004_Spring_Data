package com.itvdn.controllers;

import com.itvdn.persistence.model.Car;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-simple-ctx.xml"})
@WebAppConfiguration
@FixMethodOrder
public class IntegrationTester {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testController() throws Exception {
        mockMvc.perform(get("/car"))
                .andExpect(view().name("views/car/index"))
                .andDo(print());
    }

    @Test
    public void testController2() throws Exception {
        mockMvc.perform(get("/car/findByMark")
                        .param("mark", "Opel"))
                .andExpect(status().isOk())
                .andExpect(view().name("/views/car/search-results"))
                .andDo(print());
    }

    @Test
    public void testController3() throws Exception {
        mockMvc.perform(post("/car/add")
                        .param("model", "Mercedes")
                        .param("mark", "Vito")
                        .param("engine", "2.0")
                        .param("price", "15000")
                        .param("speed", "180")
                        .flashAttr("car", new Car()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/car"))
                .andDo(print());
    }
}
