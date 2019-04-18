package com.haiyunwork.service;

import com.haiyunwork.model.App;

/**
 * @author wanghy
 *
 */
public interface AppService {
  App createApp(App app);
  App updateApp(App app);
  App findAppById(String appId);
}
