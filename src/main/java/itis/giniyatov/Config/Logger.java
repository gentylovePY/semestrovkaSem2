package itis.giniyatov.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
 class Logger {

@Bean
    public CommonsRequestLoggingFilter commonsRequestLoggingFilter(){
    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
    loggingFilter.setIncludeHeaders(true);
    loggingFilter.setIncludeClientInfo(true);
    loggingFilter.setIncludePayload(true);
    loggingFilter.setMaxPayloadLength(6500);
    loggingFilter.setIncludeQueryString(true);
    return loggingFilter;

}}
