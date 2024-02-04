package org.github.springframework.core.convert.support;

import org.github.springframework.core.convert.converter.ConverterRegistry;

/**
 * @author zhaoyu
 * @date 2024/2/4 20:07
 */
public class DefaultConversionService extends GenericConversionService{
    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
        //TODO 添加其他ConverterFactory
    }
}
