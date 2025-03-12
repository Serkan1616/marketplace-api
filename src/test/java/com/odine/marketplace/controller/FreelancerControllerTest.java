package com.odine.marketplace.controller;

import com.odine.marketplace.model.Freelancer;
import com.odine.marketplace.service.FreelancerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class FreelancerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FreelancerService freelancerService;

    @InjectMocks
    private FreelancerController freelancerController;

    @Test
    public void shouldReturnFreelancers() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(freelancerController).build();

        Mockito.when(freelancerService.getAllFreelancers()).thenReturn(
                Arrays.asList(new Freelancer())
        );

        mockMvc.perform(get("/api/freelancers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
