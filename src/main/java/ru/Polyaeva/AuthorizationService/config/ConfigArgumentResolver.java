package ru.Polyaeva.AuthorizationService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import ru.Polyaeva.AuthorizationService.controller.UserArgumentResolver;

import java.util.List;

@Configuration
public class ConfigArgumentResolver extends WebMvcConfigurationSupport {

    private final UserArgumentResolver userArgumentResolver = new UserArgumentResolver();

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(userArgumentResolver);
    }
}