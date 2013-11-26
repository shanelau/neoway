package com.jsr.feedback;

import com.jsr.feedback.controller.FeedbackController;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:spring-servlet.xml"})
public class ControllerTestCase extends TestCase {

    protected MockMvc mockMvc;
    @Autowired
    @Qualifier("FeedbackController")
    FeedbackController feedbackController;

     @Before
     public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(feedbackController).build();
     }

    @Test
     public void testSave() throws Exception {
      ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/test/save.do")
        .accept(MediaType.APPLICATION_JSON).param("id", "1000").param("name", "test"));
      MvcResult mvcResult = resultActions.andReturn();
      ModelAndView modelAndView = mvcResult.getModelAndView();
      System.out.println(modelAndView.getViewName());
      assertEquals("redirect:null", modelAndView.getViewName());
     }

}