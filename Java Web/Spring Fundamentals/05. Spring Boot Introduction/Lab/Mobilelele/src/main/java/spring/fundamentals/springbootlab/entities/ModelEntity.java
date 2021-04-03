package spring.fundamentals.springbootlab.entities;

import spring.fundamentals.springbootlab.entities.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @Column(length = 512)
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    @ManyToOne
    private BrandEntity brandEntity;

    public ModelEntity() {
    }

    public ModelEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }
}
