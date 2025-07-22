// ContributorStatsDTO.java
package com.brainbox.analytics.dto;

public class ContributorStatsDTO {
    private String userId;
    private Long totalActions;

    public ContributorStatsDTO(String userId, Long totalActions) {
        this.userId = userId;
        this.totalActions = totalActions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTotalActions() {
        return totalActions;
    }

    public void setTotalActions(Long totalActions) {
        this.totalActions = totalActions;
    }
}
