package com.brainbox.analytics.service;

import com.brainbox.analytics.dto.ContributorStatsDTO;
import com.brainbox.analytics.dto.SearchQueryCountDTO;
import com.brainbox.analytics.model.UserActivityLog;
import com.brainbox.analytics.dto.ArticleActionCountDTO;
import java.util.List;

public interface UserActivityLogService {
    UserActivityLog saveLog(UserActivityLog log);
    List<UserActivityLog> getAllLogs();
    List<UserActivityLog> getLogsByUserId(String userId);
    List<UserActivityLog> getLogsByActionType(String actionType);
    List<ArticleActionCountDTO> getViewsAndEditsPerArticle();
    List<SearchQueryCountDTO> getPopularSearchQueries();
    List<ContributorStatsDTO> getContributorStats();

}
