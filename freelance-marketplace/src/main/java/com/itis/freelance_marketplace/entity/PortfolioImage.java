package com.itis.freelance_marketplace.entity;

import javax.persistence.*;

/**
 * Created by alt on 22.11.16.
 */
@Entity
@Table(name = "portfolio_images", schema = "public")
public class PortfolioImage {
    private Long id;
    private String description;
    private String url;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortfolioImage portfolioImage = (PortfolioImage) o;

        if (id != null ? !id.equals(portfolioImage.id) : portfolioImage.id != null) return false;
        if (description != null ? !description.equals(portfolioImage.description) : portfolioImage.description != null) return false;
        if (url != null ? !url.equals(portfolioImage.url) : portfolioImage.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
