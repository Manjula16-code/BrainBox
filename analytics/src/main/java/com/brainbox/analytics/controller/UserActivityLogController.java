package com.brainbox.analytics.controller;

import com.brainbox.analytics.dto.ContributorStatsDTO;
import com.brainbox.analytics.model.UserActivityLog;
import com.brainbox.analytics.service.UserActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.brainbox.analytics.dto.ArticleActionCountDTO;
import com.brainbox.analytics.dto.SearchQueryCountDTO;


import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class UserActivityLogController {

    @Autowired
    private UserActivityLogService userActivityLogService;

    // POST: Save a new activity log
    @PostMapping
    public UserActivityLog saveActivity(@RequestBody UserActivityLog activityLog) {
        return userActivityLogService.saveLog(activityLog);
    }

    // GET: Get all activity logs
    @GetMapping
    public List<UserActivityLog> getAllActivities() {
        return userActivityLogService.getAllLogs();
    }
    @GetMapping("/user/{userId}")
    public List<UserActivityLog> getLogsByUserId(@PathVariable String userId) {
        return userActivityLogService.getLogsByUserId(userId);
    }

    @GetMapping("/action/{actionType}")
    public List<UserActivityLog> getLogsByActionType(@PathVariable String actionType) {
        return userActivityLogService.getLogsByActionType(actionType);
    }

    @GetMapping("/article-action-count")
    public List<ArticleActionCountDTO> getArticleActionCounts() {
        return userActivityLogService.getViewsAndEditsPerArticle();
    }

    @GetMapping("/popular-searches")
    public List<SearchQueryCountDTO> getPopularSearches() {
        return userActivityLogService.getPopularSearchQueries();
    }

    @GetMapping("/contributor-stats")
    public List<ContributorStatsDTO> getContributorStats() {
        return userActivityLogService.getContributorStats();
    }
}
