package com.haiyunwork.service;

import com.haiyunwork.dao.AppRepository;
import com.haiyunwork.model.App;
import java.util.Date;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author wanghy
 *
 */

@Service
public class DefaultAppService implements AppService {

  private final AppRepository appRepository;

  public DefaultAppService(
      AppRepository appRepository) {
    this.appRepository = appRepository;
  }

  @Override
  @Transactional
  public App createApp(App app) {

    String appId = UUID.randomUUID().toString();
    app.setId(appId);
    Date date = new Date();
    app.setCreateTime(date);
    app.setUpdateTime(date);

    appRepository.save(app);
    return findAppById(appId);
  }

  @Override
  @Transactional
  public App updateApp(App app) {
    App oldApp = findAppById(app.getId());

    app.setUpdateTime(new Date());
    appRepository.save(app);

    return findAppById(app.getId());
  }

  @Override
  public App findAppById(String appId) {
    App app = appRepository.findById(appId).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "未找到App"));
    return app;
  }

}
