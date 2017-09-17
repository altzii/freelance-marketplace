package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.entity.User;
import com.itis.freelance_marketplace.entity.Vacancy;
import com.itis.freelance_marketplace.entity.VacancyComment;
import com.itis.freelance_marketplace.form.AddVacancyCommentForm;
import com.itis.freelance_marketplace.form.AddVacancyForm;
import com.itis.freelance_marketplace.security.CustomUserDetails;
import com.itis.freelance_marketplace.service.UserService;
import com.itis.freelance_marketplace.service.VacancyCommentService;
import com.itis.freelance_marketplace.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;

/**
 * Created by alt on 12.12.16.
 */
@Controller
public class VacancyController {
    @Autowired
    VacancyService vacancyService;

    @Autowired
    UserService userService;

    @Autowired
    VacancyCommentService vacancyCommentService;

    Authentication authentication;

    User currentUser;

    @RequestMapping(value = "/vacancies", method = RequestMethod.GET)
    public String getVacancies(ModelMap modelMap) {
        authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/error403";
        } else {
            modelMap.put("vacancies", vacancyService.findAll());
            return "vacancies";
        }
    }


    @RequestMapping(value = "/customer/vacancies/add", method = RequestMethod.GET)
    public String getAddVacancy(ModelMap modelMap) {
        authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/error403";
        } else {
            modelMap.put("vacancies", vacancyService.findAll());
            modelMap.put("add_vacancy_form", new AddVacancyForm());

            return "add_vacancy";
        }
    }


    @RequestMapping(value = "/customer/vacancies/add", method = RequestMethod.POST)
    public String addVacancy(@ModelAttribute("add_vacancy_form") @Valid AddVacancyForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "add_vacancy";
        }

        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        Vacancy vacancy = new Vacancy();
        vacancy.setTitle(form.getTitle());
        vacancy.setOrganization(form.getOrganization());
        vacancy.setDescription(form.getDescription());
        vacancy.setUser(currentUser);

        vacancyService.create(vacancy);

        return "redirect:/vacancies";
    }

    @RequestMapping(value = "/vacancies/{id:\\d+}", method = RequestMethod.GET)
    public String getVacancy(ModelMap modelMap, @PathVariable Long id) {
        Vacancy vacancy = vacancyService.findById(id);

        authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/error403";
        } else if (vacancy != null) {
            modelMap.put("vacancy", vacancy);
            modelMap.put("add_vacancy_comment_form", new AddVacancyCommentForm());
        } else {
            modelMap.put("not_found", true);
        }

        return "vacancy";
    }

    @RequestMapping(value = "/vacancies/add_comment/{id:\\d+}", method = RequestMethod.POST)
    public String addVacancyComment(ModelMap modelMap, @PathVariable Long id, @ModelAttribute("add_vacancy_comment_form") @Valid AddVacancyCommentForm form, BindingResult result) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        Vacancy vacancy = vacancyService.findById(id);

        if (result.hasErrors()) {
            modelMap.put("vacancy", vacancy);
            return "vacancy";
        }

        VacancyComment vacancyComment = new VacancyComment();
        vacancyComment.setUser(currentUser);
        vacancyComment.setDate(new Timestamp(System.currentTimeMillis()));
        vacancyComment.setText(form.getText());
        vacancyComment.setVacancy(vacancy);

        vacancyCommentService.create(vacancyComment);

        return "redirect:/vacancies/" + vacancy.getId();
    }

    @RequestMapping(value = "/vacancies/delete_comment/", method = RequestMethod.POST)
    public String deleteVacancyComment(@RequestParam Long id) {
        VacancyComment vacancyComment = vacancyCommentService.findById(id);

        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        if (vacancyComment.getUser().equals(currentUser)) {
            vacancyCommentService.delete(id);
        }
        return "redirect:/error403";
    }
}
