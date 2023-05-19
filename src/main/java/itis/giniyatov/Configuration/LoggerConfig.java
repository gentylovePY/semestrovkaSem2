package itis.giniyatov.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
 class LoggerConfig {

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
