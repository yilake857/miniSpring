package org.github.springframework.core.convert.converter;

/**
 * 类型转换工厂
 *
 * @author zhaoyu
 * @date 2024/2/4 19:19
 */
public interface ConverterFactory <S,R>{

    <T extends R> Converter<S, T> getConverter(Class<T> targetType);

}
