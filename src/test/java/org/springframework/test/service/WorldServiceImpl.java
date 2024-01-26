package org.springframework.test.service;

/**
 * @author zhaoyu
 * @date 2024/1/25 17:54
 */
public class WorldServiceImpl implements WorldService{
    @Override
    public void explode() {
        System.out.println("The Earth is going to explode");
    }
}
