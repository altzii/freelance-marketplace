package com.itis.freelance_marketplace.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alt on 12.12.16.
 */
@Entity
@Table(name = "vacancies", schema = "public")
public class Vacancy {
    private Long id;
    private String title;
    private String organization;
    private String description;
    private User user;
    private List<VacancyComment> vacancyComments;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "organization")
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="vacancy_id")
    public List<VacancyComment> getVacancyComments() {
        return vacancyComments;
    }

    public void setVacancyComments(List<VacancyComment> vacancyComments) {
        this.vacancyComments = vacancyComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy = (Vacancy) o;

        if (id != null ? !id.equals(vacancy.id) : vacancy.id != null) return false;
        if (title != null ? !title.equals(vacancy.title) : vacancy.title != null) return false;
        if (organization != null ? !organization.equals(vacancy.organization) : vacancy.organization != null)
            return false;
        if (description != null ? !description.equals(vacancy.description) : vacancy.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
