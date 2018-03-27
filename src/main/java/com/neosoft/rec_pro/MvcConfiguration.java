package com.neosoft.rec_pro;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration
@EnableWebMvc
@ComponentScan("com.neosoft.rec_pro")
public class MvcConfiguration extends WebMvcConfigurerAdapter
{

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) 
	{
        configurer.enable();
    }
	
	/**/
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	
    	System.out.println("in MVCConfiguratio");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
   /*     resolver.setViewClass(JstlView.class);*/
        registry.viewResolver(resolver);
    }
}
