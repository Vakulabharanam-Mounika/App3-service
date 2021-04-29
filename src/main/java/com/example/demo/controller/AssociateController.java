package com.example.demo.controller;

import com.example.demo.model.Associate;
import com.example.demo.service.AssociateService;
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
    @Autowired
    public AssociateController(AssociateService associateService) {
        super();
        this.associateService = associateService;
    }

    @GetMapping("/list")
    public String getAssociates(Model model) {
        List<Associate> list = associateService.displayAllAssociate();
        model.addAttribute("associates", list);
        return "list-associates";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Associate a = new Associate();
        theModel.addAttribute("associate", a);
        return "associate-form";
    }

    @PostMapping("/save")
    public String saveAssociate(@ModelAttribute("associate") Associate associate) {
        // save the employee

        associateService.createAssociate(associate);
        // use a redirect to prevent duplicate submissions
        return "redirect:/associates/list";
    }
    @RequestMapping("/delete")
    public String deleteAssociateById(@RequestParam("associateId") int associateId, Model theModel) {

        // get the employee from the service

        Associate a =associateService.deleteByAssociateId(associateId);
        return "redirect:/associates/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("associateId") int associateId,
                                    Model theModel) {

        // get the employee from the service

        Associate associate=associateService.findByAssociateId(associateId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("associate", associate);

        // send over to our form
        return "associate-form";
    }


}
