package com.example.demo.controller;
import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repo.AssociateRepo;
import com.example.demo.repo.SkillRepo;
import com.example.demo.service.AssociateService;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/skills")
public class SkillController {
    private AssociateService associateService;
    private SkillService skillService;
    private AssociateRepo associateRepo;
    private SkillRepo skillRepo;
    @Autowired
    public SkillController(SkillService skillService, AssociateService associateService,AssociateRepo associateRepo,SkillRepo skillRepo) {
        this.skillService = skillService;
        this.associateService=associateService;
        this.associateRepo=associateRepo;
        this.skillRepo=skillRepo;
    }

    @GetMapping("/list")
    public String getSkills(Model model) {
        List<Skill> list = skillService.getAllSkill();
        model.addAttribute("skills", list);
        return "list-skills";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Associate a=new Associate();
        Skill b = new Skill();
        b.setAssociates(a);
        theModel.addAttribute("skill", b);
        return "skill-form";
    }

    @PostMapping("/save")
    public String saveSkill(@ModelAttribute("skill") Skill skill,@ModelAttribute("associate") Associate associate) {


        skillService.createSkill(skill);
        Associate a=new Associate();
        associateRepo.save(associate);
        skillRepo.save(skill);
        skill.setAssociates(a);

        return "redirect:/skills/list";
    }
}
