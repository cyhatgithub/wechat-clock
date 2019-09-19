package com.yinghao.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenyinghao on 2019/9/18.
 */
@Service
public interface BaseServiceInter<T> {
    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

}
