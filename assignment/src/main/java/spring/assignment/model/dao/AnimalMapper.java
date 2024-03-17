package spring.assignment.model.dao;

import org.apache.ibatis.annotations.Mapper;
import spring.assignment.model.dto.AnimalDTO;
import spring.assignment.model.dto.AnimalLogDTO;
import spring.assignment.model.dto.CategoryDTO;
import spring.assignment.model.dto.StatusDTO;

import java.util.List;

@Mapper
public interface AnimalMapper {

    List<AnimalLogDTO> AllList();

    List<CategoryDTO> findCategoryList();
    List<StatusDTO> findStatusList();

    void insertAnimal(AnimalDTO ani);
    void insertAnimalLog(AnimalLogDTO aniLog);

}
