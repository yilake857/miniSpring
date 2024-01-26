package org.springframework.test.jdkProxy;

/**
 * @author zhaoyu
 * @date 2024/1/25 19:24
 */
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("添加user");
    }
}
