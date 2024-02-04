package org.springframework.test.common;

import org.github.springframework.core.convert.converter.GenericConverter;

import java.util.Collections;
import java.util.Set;

/**
 * @author zhaoyu
 * @date 2024/2/4 20:54
 */
public class StringToBooleanConverter implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, Boolean.class));
    }

    @Override
    public Object convert(Object source, Class sourceType, Class targetType) {
        return Boolean.valueOf((String) source);
    }
}
