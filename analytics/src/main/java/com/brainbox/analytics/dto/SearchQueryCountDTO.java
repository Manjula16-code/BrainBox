package com.brainbox.analytics.dto;

public class SearchQueryCountDTO {
    private String searchQuery;
    private Long count;

    public SearchQueryCountDTO(String searchQuery, Long count) {
        this.searchQuery = searchQuery;
        this.count = count;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
