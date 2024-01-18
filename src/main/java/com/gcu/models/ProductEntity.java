package com.gcu.models;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class ProductEntity {
    @Id
    @Column("ID")
    private int id;

    @Column("GADGET_NAME")
    private String gadgetName;

    @Column("DATE_OF_ORIGIN")
    private Date dateOfOrigin;

    @Column("LETHALITY_RATING")
    private int lethalityRating;

    @Column("PHOTO_FILE_NAME")
    private String photoFileName;

    @Column("INSTRUCTIONS")
    private String instructions;

    @Column("DESCRIPTION")
    private String description;

    @Column("PRICE")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGadgetName() {
        return gadgetName;
    }

    public void setGadgetName(String gadgetName) {
        this.gadgetName = gadgetName;
    }

    public Date getDateOfOrigin() {
        return dateOfOrigin;
    }

    public void setDateOfOrigin(Date dateOfOrigin) {
        this.dateOfOrigin = dateOfOrigin;
    }

    public int getLethalityRating() {
        return lethalityRating;
    }

    public void setLethalityRating(int lethalityRating) {
        this.lethalityRating = lethalityRating;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
