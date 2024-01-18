package com.gcu.models;

public class SearchModel {
    private String searchTerm;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public SearchModel(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public SearchModel()
    {
        
    }


}
