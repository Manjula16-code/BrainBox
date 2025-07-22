package com.brainbox.analytics.model;

import jakarta.persistence.*;
        import java.time.LocalDateTime;

@Entity
public class UserActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String actionType;   // view / edit / search
    @Column(nullable = true)
    private Long articleId;      // nullable for search
    @Column(nullable = true)
    private String searchQuery;  // only used if action is search

    private LocalDateTime timestamp = LocalDateTime.now();

    // --- Constructors ---
    public UserActivityLog() {}

    public UserActivityLog(String userId, String actionType, Long articleId, String searchQuery) {
        this.userId = userId;
        this.actionType = actionType;
        this.articleId = articleId;
        this.searchQuery = searchQuery;
        this.timestamp = LocalDateTime.now();
    }

    // --- Getters & Setters (generate these using IntelliJ shortcut: Alt + Insert) ---

    public Long getId() { return id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }

    public Long getArticleId() { return articleId; }
    public void setArticleId(Long articleId) { this.articleId = articleId; }

    public String getSearchQuery() { return searchQuery; }
    public void setSearchQuery(String searchQuery) { this.searchQuery = searchQuery; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
