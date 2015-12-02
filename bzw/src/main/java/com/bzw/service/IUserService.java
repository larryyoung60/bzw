package com.bzw.service;

import com.bzw.entity.UserEntity;

/**
 * Created by centling on 2014/7/28.
 */
public interface IUserService {

    public UserEntity getByUsername(String username);
}
