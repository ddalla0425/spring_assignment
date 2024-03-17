package spring.assignment.model.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import spring.assignment.AssignmentApplication;
import spring.assignment.model.dto.AnimalDTO;
import spring.assignment.model.dto.AnimalLogDTO;
import spring.assignment.model.dto.CategoryDTO;
import spring.assignment.model.dto.StatusDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = { AssignmentApplication.class })
public class AnimalServiceTests {

    @Autowired
    private AnimalService animalService;

    @Test
    public void testAllList() {
        List<AnimalLogDTO> animalLogList = animalService.AllList();
        assertNotNull(animalLogList);
    }

    @Test
    public void testFindCategoryList() {
        List<CategoryDTO> categoryList = animalService.finCategoryList();
        assertNotNull(categoryList);
    }

    @Test
    public void testFindStatusList() {
        List<StatusDTO> statusList = animalService.finStatusList();
        assertNotNull(statusList);
    }

    @Test
    public void testInsertAnimal() {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setAnimalGender("암컷");
        animalDTO.setAnimalColor("흰색");
        animalDTO.setAnimalAge("모름");
        animalDTO.setAnimalWeight("모름");
        animalDTO.setBuiltInChip("모름");
        animalDTO.setNeuteringSurgery("모름");
        animalDTO.setAnimalCollar("모름");
        animalDTO.setRescueDate("20240318");
        animalDTO.setCapturePlace("테스트장소");
        animalDTO.setHealthCondition("양호");
        animalDTO.setCategoryCode(11);
        animalService.insertAnimal(animalDTO);
    }

    @Test
    public void testInsertAnimalLog() {
        AnimalLogDTO animalLogDTO = new AnimalLogDTO();
        animalLogDTO.setLogDate("20240318");
        animalLogDTO.setLogRemark("테스트 로그");
        animalLogDTO.setAdmissionStatus("Y");
        animalLogDTO.setStatusCode(1);
        animalLogDTO.setAnimalCode(1);
        animalService.insertAnimalLog(animalLogDTO);
    }

}
