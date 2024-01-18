package com.gcu.models;

import java.util.Date;

public class ProductModel {
    
    private int id;
    private String gadgetName;
    private Date dateOfOrigin;
    private int lethalityRating;
    private String photoFileName;
    private String instructions;
    private String description;
    private double price;
    
    public ProductModel(int id, String gadgetName, Date dateOfOrigin, int lethalityRating, String photoFileName, String instructions, String description, double price)
    {
        this.id = id;
        this.gadgetName = gadgetName;
        this.dateOfOrigin = dateOfOrigin;
        this.photoFileName = photoFileName;
        this.instructions = instructions;
        this.description = description;
        this.price = price;
        //Allows for checking if it's over 10 or under 0
        setLethalityRating(lethalityRating);
    }

    public ProductModel()
    {
        
    }

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

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getInstructions() {
        return instructions;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLethalityRating(int lethalityRating)
    {
        //Check if the rating is greater then 10 or less then 0
        if(lethalityRating > 10)
        {
            lethalityRating = 10;
        }
        else if(lethalityRating < 0)
        {
            lethalityRating = 0;
        }
        this.lethalityRating = lethalityRating;
    }

    public int getLethalityRating()
    {
        return this.lethalityRating;
    }
}
