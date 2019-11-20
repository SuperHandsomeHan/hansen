package edu.nf.hansen.config;

import edu.nf.hansen.controller.interceptor.LoginInterceptor;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Achine
 * @date 2019/11/18
 * 取代spring mvc配置文件
 */
@Configuration
/**
 * 报扫描，只扫描controller包
 */
@ComponentScan("edu.nf.hansen.controller")
/**
 * 启用mvc注解驱动，
 * 等同于配置文件<mvc:annotation-driven/>
 */
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 启用默认servlet处理静态资源
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置内部资源视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 配置校验器
     * @return
     */
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setProviderClass(HibernateValidator.class);
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("classpath:message");
        factoryBean.setValidationMessageSource(messageSource);
        return factoryBean;
    }

    /**
     * 配置上传
     * @return
     */
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxInMemorySize(1024*1024*1024);
        return resolver;
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * addPathPatterns方法拦截那些地址
         * excludePathPatterns方法除了这些地址不需要拦截
         */
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html", "/register.html", "/password_login", "/js/**", "/css/**");
    }
}
