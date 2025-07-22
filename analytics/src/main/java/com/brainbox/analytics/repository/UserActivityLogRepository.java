package com.brainbox.analytics.repository;

import com.brainbox.analytics.dto.ContributorStatsDTO;
import com.brainbox.analytics.model.UserActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.brainbox.analytics.dto.ArticleActionCountDTO;

import java.util.List;

@Repository
public interface UserActivityLogRepository extends JpaRepository<UserActivityLog, Long> {
    // You can add custom query methods here later
    List<UserActivityLog> findByUserId(String userId);
    List<UserActivityLog> findByActionType(String actionType);

    @Query("SELECT new com.brainbox.analytics.dto.ArticleActionCountDTO(u.articleId, u.actionType, COUNT(u)) " +
            "FROM UserActivityLog u " +
            "WHERE u.actionType IN ('view', 'edit') AND u.articleId IS NOT NULL " +
            "GROUP BY u.articleId, u.actionType")
    List<ArticleActionCountDTO> countViewsAndEditsPerArticle();

    @Query("SELECT u.searchQuery, COUNT(u) FROM UserActivityLog u WHERE u.searchQuery IS NOT NULL GROUP BY u.searchQuery ORDER BY COUNT(u) DESC")
    List<Object[]> getPopularSearchQueries();

    @Query("SELECT new com.brainbox.analytics.dto.ContributorStatsDTO(u.userId, COUNT(u)) " +
            "FROM UserActivityLog u GROUP BY u.userId")
    List<ContributorStatsDTO> getContributorStats();

}
