package com.haiyunwork.config;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.helper.ConditionalHelpers;
import com.github.jknack.handlebars.helper.StringHelpers;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanghy

 * created at 2019/2/28
 */
@Configuration
@ConditionalOnClass({Handlebars.class})
public class HandlebarsConfig {

  @Bean
  public Handlebars getHandlebars() {
    Handlebars ghandlebars = new Handlebars();
    ghandlebars.registerHelpers(ConditionalHelpers.class);
    StringHelpers.register(ghandlebars);
    return ghandlebars;
  }
}