package connect.oz.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

@ComponentScan(basePackages = {
        "connect.oz.reservation.category.dao",
        "connect.oz.reservation.category.service",

        "connect.oz.reservation.product.dao",
        "connect.oz.reservation.product.service",

        "connect.oz.reservation.file.dao",
        "connect.oz.reservation.file.service",

        "connect.oz.reservation.comment.dao",
        "connect.oz.reservation.comment.service",

        "connect.oz.reservation.login.dao",
        "connect.oz.reservation.login.service",

        "connect.oz.reservation.reservation.dao",
        "connect.oz.reservation.reservation.service"
})

@Import({DbConfig.class})
public class RootApplicationContextConfig {

}
