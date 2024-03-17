package spring.assignment.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import spring.assignment.AssignmentApplication;

@SpringBootTest
@ContextConfiguration(classes = { AssignmentApplication.class})
public class AnimalControllerTests {

    @Autowired
    private AnimalController animalController;
    private MockMvc mockMvc;

    @BeforeEach
    public void SetUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(animalController).build();
    }

    @Test
    public void 전체_동물_조회용_컨트롤러_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/animal/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("animal/list"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void 신규_동물_등록용_컨트롤러_테스트() throws Exception {

        //given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("animalGender", "수컷");
        params.add("animalColor", "흰색");
        params.add("animalAge", "모름");
        params.add("animalWeight", "모름");
        params.add("builtInChip", "Y");
        params.add("neuteringSurgery", "Y");
        params.add("animalCollar", "Y");
        params.add("rescueDate", "20240318");
        params.add("capturePlace", "테스트장소");
        params.add("healthCondition", "양호");
        params.add("categoryCode", "11");
        params.add("logDate", "20240318");
        params.add("logRemark", "");
        params.add("admissionStatus", "Y");
        params.add("statusCode", "1");
        params.add("animalCode", "1");



        mockMvc.perform(MockMvcRequestBuilders.post("/animal/insert").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/animal/list"))
                .andDo(MockMvcResultHandlers.print());

    }

}
