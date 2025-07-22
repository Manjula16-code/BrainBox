package com.brainbox.analytics.service;

import com.brainbox.analytics.model.UserActivityLog;
import com.brainbox.analytics.repository.UserActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brainbox.analytics.dto.ArticleActionCountDTO;
import com.brainbox.analytics.dto.SearchQueryCountDTO;
import com.brainbox.analytics.dto.ContributorStatsDTO;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserActivityLogServiceImpl implements UserActivityLogService {

    @Autowired
    private UserActivityLogRepository repository;

    @Override
    public UserActivityLog saveLog(UserActivityLog log) {
        return repository.save(log);
    }

    @Override
    public List<UserActivityLog> getAllLogs() {
        return repository.findAll();
    }

    @Override
    public List<UserActivityLog> getLogsByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<UserActivityLog> getLogsByActionType(String actionType) {
        return repository.findByActionType(actionType);
    }

    @Override
    public List<ArticleActionCountDTO> getViewsAndEditsPerArticle() {
        return repository.countViewsAndEditsPerArticle();
    }

    @Override
    public List<SearchQueryCountDTO> getPopularSearchQueries() {
        List<Object[]> results = repository.getPopularSearchQueries();
        List<SearchQueryCountDTO> dtos = new ArrayList<>();
        for (Object[] row : results) {
            String query = (String) row[0];
            Long count = (Long) row[1];
            dtos.add(new SearchQueryCountDTO(query, count));
        }
        return dtos;
    }

    @Override
    public List<ContributorStatsDTO> getContributorStats() {
        return repository.getContributorStats();
    }


}
