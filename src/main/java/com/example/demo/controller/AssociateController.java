package com.example.demo.controller;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repo.AssociateRepo;
import com.example.demo.repo.SkillRepo;
import com.example.demo.service.AssociateService;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/associates")
public class AssociateController {

    private AssociateService associateService;
    private SkillRepo skillRepo;
    private AssociateRepo associateRepo;
    private SkillService skillService;
    @Autowired
    public AssociateController(AssociateService associateService, SkillRepo skillRepo,AssociateRepo associateRepo, SkillService skillService) {
        super();
        this.associateService = associateService;
        this.skillRepo=skillRepo;
        this.associateRepo=associateRepo;
        this.skillService=skillService;
    }

    @GetMapping("/list")
    public String getAssociates(Model model, String keyword)
    {
        List<Associate> list=associateService.getAllAssociate();

        if(keyword!=null){
            model.addAttribute("associates", associateService.findByKeyword(keyword));
        }
        else {
            model.addAttribute("associates", list);

        }
        return "list-associates";
    }

    @GetMapping("/list/{associateId}")
    public ResponseEntity<Associate> getByAssociateId(@PathVariable("associateId") int associateId) {

       Associate a=associateService.findByAssociateId(associateId);
        return ResponseEntity.ok(a);
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Associate a = new Associate();
        Skill theSkill=new Skill();

        theModel.addAttribute("skills",theSkill);
        theModel.addAttribute("associate", a);
        return "associate-form1";
    }

    @PostMapping("/save")
    public String saveAssociate(@ModelAttribute("associate") Associate associate, @ModelAttribute("skill") Skill theSkill) {

        associateService.createAssociate(associate);

        skillRepo.save(theSkill);
        return "redirect:/associates/list";
    }

    @RequestMapping("/delete")
    public String deleteAssociateById(@RequestParam("associateId") int associateId, Model theModel) {

        Associate a =associateService.deleteByAssociateId(associateId);
        theModel.addAttribute("associates", a);
        return "redirect:/associates/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("associateId") int associateId,
                                    Model theModel) {

        Associate associate=associateService.findByAssociateId(associateId);

        theModel.addAttribute("associate", associate);

        return "associate-form";
    }

    @GetMapping("/showFormForAddSkill")
    public String showFormForAddSkill(@RequestParam("associateId") int associateId,
                                    Model theModel) {

        Associate associate=associateService.findByAssociateId(associateId);
        Skill b = new Skill();
        theModel.addAttribute("skill", b);

        theModel.addAttribute("associate", associate);

        return "skill-form";
    }




}
