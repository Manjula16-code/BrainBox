package com.brainbox.analytics.dto;

public class ArticleActionCountDTO {
    private Long articleId;
    private String actionType; // "view" or "edit"
    private Long count;

    // Constructor
    public ArticleActionCountDTO(Long articleId, String actionType, Long count) {
        this.articleId = articleId;
        this.actionType = actionType;
        this.count = count;
    }

    // Getters
    public Long getArticleId() {
        return articleId;
    }

    public String getActionType() {
        return actionType;
    }

    public Long getCount() {
        return count;
    }

    // Setters
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
