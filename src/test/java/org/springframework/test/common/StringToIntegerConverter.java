package org.springframework.test.common;

import org.github.springframework.core.convert.converter.Converter;

/**
 * @author zhaoyu
 * @date 2024/2/4 20:55
 */
public class StringToIntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }
}
