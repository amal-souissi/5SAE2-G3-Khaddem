package tn.esprit.spring.khaddem.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo").description("TP étude de cas").contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("zaineb bachouch").email("zaineb.bachouch@esprit.tn").url("https://www.linkedin.com/in/zaineb-bachouch-7b41aa197/");
        return contact;
    }
}

