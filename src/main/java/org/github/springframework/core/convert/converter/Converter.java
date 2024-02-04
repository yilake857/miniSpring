package org.github.springframework.core.convert.converter;

/**
 * 类型转换抽象接口
 *
 * @author zhaoyu
 * @date 2024/2/4 19:13
 */
public interface Converter <S,T>{
    /**
     * 类型转换
     */
    T convert(S source);
}
