package com.itis.freelance_marketplace.controller;

import com.itis.freelance_marketplace.entity.User;
import com.itis.freelance_marketplace.entity.Vacancy;
import com.itis.freelance_marketplace.entity.VacancyComment;
import com.itis.freelance_marketplace.form.AddVacancyCommentForm;
import com.itis.freelance_marketplace.form.AddVacancyForm;
import com.itis.freelance_marketplace.service.UserService;
import com.itis.freelance_marketplace.service.VacancyCommentService;
import com.itis.freelance_marketplace.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/vacancies", method = RequestMethod.GET)
    public String getVacancies(ModelMap modelMap){
        modelMap.put("vacancies", vacancyService.findAll());
        modelMap.put("add_vacancy_form", new AddVacancyForm());

        return "vacancies";
    }

    @RequestMapping(value = "/consumer/vacancies/add", method = RequestMethod.POST)
    public String addVacancy(ModelMap modelMap, @ModelAttribute("add_vacancy_form") @Valid AddVacancyForm form, BindingResult result) {
        if (result.hasErrors()) {
            modelMap.put("vacancies", vacancyService.findAll());
            return "vacancies";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User user = userService.findByLogin(login);

        Vacancy vacancy = new Vacancy();
        vacancy.setTitle(form.getTitle());
        vacancy.setOrganization(form.getOrganization());
        vacancy.setDescription(form.getDescription());
        vacancy.setUser(user);

        vacancyService.create(vacancy);

        return "redirect:/vacancies";
    }

    @RequestMapping(value = "/vacancies/{id:\\d+}", method = RequestMethod.GET)
    public String getVacancy(ModelMap modelMap, @PathVariable Long id) {
        Vacancy vacancy = vacancyService.findById(id);

        if (vacancy != null) {
            modelMap.put("vacancy", vacancy);
            modelMap.put("add_vacancy_comment_form", new AddVacancyCommentForm());
        } else {
            modelMap.put("not_found", true);
        }

        return "vacancy";
    }

    @RequestMapping(value = "/vacancies/add_comment/{id:\\d+}", method = RequestMethod.POST)
    public String addVacancyComment(ModelMap modelMap, @PathVariable Long id, @ModelAttribute("add_vacancy_comment_form") @Valid AddVacancyCommentForm form, BindingResult result) {
        Vacancy vacancy = vacancyService.findById(id);

        if (result.hasErrors()) {
            modelMap.put("vacancy", vacancy);
            return "vacancy";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User user = userService.findByLogin(login);

        VacancyComment vacancyComment = new VacancyComment();
        vacancyComment.setUser(user);
        vacancyComment.setDate(new Timestamp(System.currentTimeMillis()));
        vacancyComment.setText(form.getText());
        vacancyComment.setVacancy(vacancy);

        vacancyCommentService.create(vacancyComment);

        return "redirect:/vacancies/" + vacancy.getId();
    }

}
