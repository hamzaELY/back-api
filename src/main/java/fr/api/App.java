package fr.api;

import fr.api.config.BackApiProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;

@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties(BackApiProperties.class)
public class App implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    @Value("${spring.profiles.active}")
    protected String springProfilesActive;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.info("=======================================");
        LOG.info("App running with active profiles: {}", springProfilesActive);
        LOG.info("=======================================");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
