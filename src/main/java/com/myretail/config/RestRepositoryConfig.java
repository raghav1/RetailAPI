package com.myretail.config;

import javax.annotation.PostConstruct;

import com.myretail.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@Configuration
public class RestRepositoryConfig {

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    @PostConstruct
    public void init() {
        repositoryRestConfiguration.setBasePath("/");
        repositoryRestConfiguration.exposeIdsFor(Product.class);
    }

}
