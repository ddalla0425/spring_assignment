package spring.assignment.model.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import spring.assignment.AssignmentApplication;
import spring.assignment.model.dto.AnimalDTO;
import spring.assignment.model.dto.AnimalLogDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = { AssignmentApplication.class })
public class AnimalMapperTests {

    @Autowired
    private AnimalMapper animalMapper;

    @Test
    public void 매퍼_인터페이스_의존성_주입_테스트() {
        assertNotNull(animalMapper);
    }

    @Test
    public void 전체_메뉴_조회_매퍼_테스트(){
        List<AnimalLogDTO> aniLogList = animalMapper.AllList();
        assertNotNull(aniLogList);
    }

    @Test
    @DisplayName("신규 동물이 잘 추가 되는지 매퍼 인터페이스의 메소드 확인")
    @Transactional
    public void testInsertAnimal(){
        AnimalLogDTO ani = new AnimalLogDTO();
        ani.setLogDate("20240309");
        ani.setLogRemark("");
        ani.setAdmissionStatus("Y");
        ani.setStatusCode(1);
        ani.setAnimalCode(1);

        //when & then
        assertDoesNotThrow(() -> animalMapper.insertAnimalLog(ani));
    }

}
