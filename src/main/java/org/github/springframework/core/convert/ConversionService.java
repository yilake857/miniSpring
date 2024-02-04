package org.github.springframework.core.convert;

/**
 * 类型转换抽象接口
 *
 * @author zhaoyu
 * @date 2024/2/4 19:37
 */
public interface ConversionService {

    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);

}
