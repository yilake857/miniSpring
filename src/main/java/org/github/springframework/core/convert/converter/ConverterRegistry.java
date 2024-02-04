package org.github.springframework.core.convert.converter;

/**
 * @author zhaoyu
 * @date 2024/2/4 19:20
 */
public interface ConverterRegistry {

    void addConverter(Converter<?, ?> converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);

    void addConverter(GenericConverter converter);
}
