package spring.assignment.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.assignment.model.dao.AnimalMapper;
import spring.assignment.model.dto.AnimalDTO;
import spring.assignment.model.dto.AnimalLogDTO;
import spring.assignment.model.dto.CategoryDTO;
import spring.assignment.model.dto.StatusDTO;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalMapper animalMapper;
    public AnimalService(AnimalMapper animalMapper) {
        this.animalMapper = animalMapper;
    }


    public List<AnimalLogDTO> AllList() {
        return animalMapper.AllList();
    }


    @Transactional(readOnly = true)
    public List<CategoryDTO> finCategoryList() { return animalMapper.findCategoryList(); }
    @Transactional(readOnly = true)
    public List<StatusDTO> finStatusList() { return animalMapper.findStatusList(); }


    @Transactional
    public void insertAnimal(AnimalDTO ani) { animalMapper.insertAnimal(ani); }
    @Transactional
    public void insertAnimalLog(AnimalLogDTO aniLog) { animalMapper.insertAnimalLog(aniLog); }
}
