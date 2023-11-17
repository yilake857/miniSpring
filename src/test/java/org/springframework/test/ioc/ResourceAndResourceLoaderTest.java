package org.springframework.test.ioc;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;

import org.github.springframework.core.io.DefaultResourceLoader;
import org.github.springframework.core.io.FileSystemResource;
import org.github.springframework.core.io.Resource;
import org.github.springframework.core.io.UrlResource;
import org.junit.Test;

import cn.hutool.core.io.IoUtil;

/**
 * @author zhaoyu
 * Created on 2023-11-17
 */
public class ResourceAndResourceLoaderTest {

    @Test
    public void testResourceLoader() throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        //加载classpath下的资源
        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assertThat(content).isEqualTo("hello world");

        //加载文件系统资源
        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        assertThat(resource instanceof FileSystemResource).isTrue();
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assertThat(content).isEqualTo("hello world");

        //加载url资源
        resource = resourceLoader.getResource("https://www.baidu.com");
        assertThat(resource instanceof UrlResource).isTrue();
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}
