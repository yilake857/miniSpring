package org.github.springframework.context.annotation;

import cn.hutool.core.bean.BeanUtil;
import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.PropertyValues;
import org.github.springframework.beans.factory.BeanFactory;
import org.github.springframework.beans.factory.BeanFactoryAware;
import org.github.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.github.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.lang.reflect.Field;

/**
 * @author zhaoyu
 * @date 2024/2/3 18:58
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        //处理@Value注解
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (valueAnnotation != null) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        //处理@Autowired注解（下一节实现）

        return pvs;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

}
