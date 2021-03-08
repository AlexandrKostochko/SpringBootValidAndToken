package app.configuration;

import app.interceptor.AdminInterceptor;
import app.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

//    @Autowired
//    private Interceptor interceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Autowired
    private UserInterceptor userInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/store/order");

        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/pet")
                .addPathPatterns("/pet/{id}")
                .addPathPatterns("/store/inventory");
    }


}
