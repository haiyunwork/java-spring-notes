package com.haiyunwork.web;

import com.haiyunwork.model.App;
import com.haiyunwork.service.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghy
 */
@RestController
@RequestMapping(value = "/apps")
public class AppController {

  private final AppService appService;

  public AppController(
      AppService appService) {
    this.appService = appService;
  }

  @PostMapping
  public App createApp(@RequestBody App app) {
    return appService.createApp(app);
  }

  @GetMapping("/{appId}")
  public App findAppById(@PathVariable String appId) {
    return appService.findAppById(appId);
  }

  @PostMapping("/{appId}")
  public App updateApp(@RequestBody App app) {
    return appService.updateApp(app);
  }
}
