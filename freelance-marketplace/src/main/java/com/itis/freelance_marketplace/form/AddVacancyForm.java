package com.itis.freelance_marketplace.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by alt on 12.12.16.
 */
public class AddVacancyForm {
    @NotEmpty(message = "Заголовок вакансии не должно быть пустым")
    private String title;

    private String organization;

    @NotEmpty(message = "Описание вакансии не должно быть пустым")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
