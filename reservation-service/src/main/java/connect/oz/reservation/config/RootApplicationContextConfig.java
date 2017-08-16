package connect.oz.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {
        "connect.oz.reservation.*.dao",
        "connect.oz.reservation.*.service"
})

@Import({DbConfig.class})
public class RootApplicationContextConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
