package org.github.springframework.core.io;


/**
 * 资源加载器接口
 *
 * @author zhaoyu
 * Created on 2023-11-17
 */
public interface ResourceLoader {

	Resource getResource(String location);
}