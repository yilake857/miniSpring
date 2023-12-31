package org.github.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 资源的抽象接口
 *
 * @author zhaoyu
 * Created on 2023-11-17
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
