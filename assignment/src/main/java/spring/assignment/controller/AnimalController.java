package spring.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.assignment.model.dto.AnimalDTO;
import spring.assignment.model.dto.AnimalLogDTO;
import spring.assignment.model.dto.CategoryDTO;
import spring.assignment.model.dto.StatusDTO;
import spring.assignment.model.service.AnimalService;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);
    private final AnimalService animalService;
    private final MessageSource messageSource;


    public AnimalController(AnimalService animalService, MessageSource messageSource) {
        this.animalService = animalService;
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public String AnimalList(Model model){

        List<AnimalLogDTO> animalLogList = animalService.AllList();
        model.addAttribute("logList", animalLogList);

        return "animal/list";
    }

    @GetMapping("/insert")
    public void AnimalInsert(Model model){
        AnimalLogDTO aniLog = new AnimalLogDTO();
        model.addAttribute("aniLog", aniLog);
    }

    @GetMapping("/category")
    public @ResponseBody List<CategoryDTO> findCategory() {
        return animalService.finCategoryList();
    }

    @GetMapping("/status")
    public @ResponseBody List<StatusDTO> findStatus() {
        return animalService.finStatusList();
    }

    @PostMapping("/insert")
    public String insertAnimal(@ModelAttribute AnimalDTO ani, @ModelAttribute AnimalLogDTO aniLog, RedirectAttributes rttr, Locale locale) {

        animalService.insertAnimal(ani);
        int lastInsertAnimalCode = ani.getAnimalCode();
        aniLog.setAnimalCode(lastInsertAnimalCode);

        animalService.insertAnimalLog(aniLog);
        rttr.addFlashAttribute("successMessage",messageSource.getMessage("insertAnimal", null, locale));
        return "redirect:/animal/list";
    }

}//AnimalController.java
