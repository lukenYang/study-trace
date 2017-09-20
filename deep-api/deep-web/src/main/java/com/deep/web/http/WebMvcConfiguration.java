package com.deep.web.http;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.commons.io.Charsets;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;

/**
 * @author lhcpig
 */
@Configuration
@ImportResource("classpath:mvc/spring-mvc.xml")
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @PostConstruct
    private void init() {
        System.out.println("---");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        final FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        fastJsonHttpMessageConverter.setCharset(Charsets.UTF_8);
        fastJsonHttpMessageConverter.setFeatures(DisableCircularReferenceDetect, WriteDateUseDateFormat, QuoteFieldNames);
        converters.add(fastJsonHttpMessageConverter);
        super.configureMessageConverters(converters);
    }
}
