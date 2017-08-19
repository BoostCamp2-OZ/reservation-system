package connect.oz.reservation.config;

import connect.oz.reservation.interceptor.LoginInterceptor;
import connect.oz.reservation.resolver.UserWebArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

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
                .addPathPatterns("/reservations/products/{productId:[\\\\\\d]+}");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // webapp/resources 경로를 의미
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserWebArgumentResolver()); //Session에있는 loginedUser값을 가져와서 Users 객체 초기화하는 어노테이션...
    }
}
