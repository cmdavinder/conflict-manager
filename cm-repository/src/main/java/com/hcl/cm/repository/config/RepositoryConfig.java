package com.hcl.cm.repository.config;

import com.hcl.cm.entities.ConfigurationItem;
import com.hcl.cm.entities.Environment;
import com.hcl.cm.entities.Project;
import com.hcl.cm.entities.ReleaseCycle;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Project.class);
        config.exposeIdsFor(Environment.class);
        config.exposeIdsFor(ReleaseCycle.class);
        config.exposeIdsFor(ConfigurationItem.class);
    }
}

