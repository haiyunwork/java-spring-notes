package com.haiyunwork.dao;

import com.haiyunwork.model.App;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wanghy
 *
 */
@Repository
public interface AppRepository extends JpaRepository<App, String> {
  Page<App> findByUserId(String userId, Pageable pageable);
}