package connect.oz.reservation.config;

import connect.oz.reservation.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "connect.oz.reservation.*.controller",
        "connect.oz.reservation.interceptor",
        "connect.oz.reservation.util",
        "connect.oz.reservation.exception"
})
public class ServletContextConfig extends WebMvcConfigurerAdapter {

    private LoginInterceptor loginInterceptor;

    @Autowired
    public ServletContextConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/myreservation")
                .addPathPatterns("/reservation/{reserveId:[\\d]+}")
                .addPathPatterns("/reviewWrite/{productId:[\\d]+}");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // webapp/resources 경로를 의미
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
