package org.github.springframework.beans.factory;

import java.util.Map;

import org.github.springframework.beans.BeansException;
/**
 * @author zhaoyu
 * Created on 2023-11-19
 */
public interface ListableBeanFactory extends BeanFactory {

	/**
	 * 返回指定类型的所有实例
	 *
	 * @param type
	 * @param <T>
	 * @return
	 * @throws BeansException
	 */
	<T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

}