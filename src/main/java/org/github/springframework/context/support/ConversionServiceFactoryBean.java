package org.github.springframework.context.support;

import org.github.springframework.beans.factory.FactoryBean;
import org.github.springframework.beans.factory.InitializingBean;
import org.github.springframework.core.convert.ConversionService;
import org.github.springframework.core.convert.converter.Converter;
import org.github.springframework.core.convert.converter.ConverterFactory;
import org.github.springframework.core.convert.converter.ConverterRegistry;
import org.github.springframework.core.convert.converter.GenericConverter;
import org.github.springframework.core.convert.support.DefaultConversionService;
import org.github.springframework.core.convert.support.GenericConversionService;

import java.util.Set;

/**
 * @author zhaoyu
 * @date 2024/2/5 18:22
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {
    private Set<?> converters;

    private GenericConversionService conversionService;

    @Override
    public void afterPropertiesSet() throws Exception {
        conversionService = new DefaultConversionService();
        registerConverters(converters, conversionService);
    }

    private void registerConverters(Set<?> converters, ConverterRegistry registry) {
        if (converters != null) {
            for (Object converter : converters) {
                if (converter instanceof GenericConverter) {
                    registry.addConverter((GenericConverter) converter);
                } else if (converter instanceof Converter<?, ?>) {
                    registry.addConverter((Converter<?, ?>) converter);
                } else if (converter instanceof ConverterFactory<?, ?>) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else {
                    throw new IllegalArgumentException("Each converter object must implement one of the " +
                            "Converter, ConverterFactory, or GenericConverter interfaces");
                }
            }
        }
    }

    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }
}
