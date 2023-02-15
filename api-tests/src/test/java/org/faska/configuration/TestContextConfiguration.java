package org.faska.configuration;

import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties")
})
// don't forget to add all packages, that contain any spring components
@ComponentScan(basePackages = {"org.faska.domain", "org.faska.api"})
public class TestContextConfiguration {

}
