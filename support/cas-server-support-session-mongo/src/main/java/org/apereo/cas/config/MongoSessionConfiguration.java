package org.apereo.cas.config;

import org.apereo.cas.configuration.CasConfigurationProperties;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.mongo.JdkMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;

import java.time.Duration;

/**
 * This is {@link MongoSessionConfiguration}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@Configuration(value = "MongoSessionConfiguration", proxyBeanMethods = false)
@EnableConfigurationProperties(CasConfigurationProperties.class)
@ImportAutoConfiguration({MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableMongoHttpSession
public class MongoSessionConfiguration {
    private static final int DURATION_MINUTES = 15;

    @Bean
    public JdkMongoSessionConverter jdkMongoSessionConverter() {
        return new JdkMongoSessionConverter(Duration.ofMinutes(DURATION_MINUTES));
    }
}
