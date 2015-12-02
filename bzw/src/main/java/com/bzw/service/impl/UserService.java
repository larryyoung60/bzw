package com.bzw.service.impl;

import com.bzw.dao.UserDAO;
import com.bzw.entity.UserEntity;
import com.bzw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by centling on 2014/7/28.
 */
@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserDAO userDAO;

    public UserEntity getByUsername(String username){
        String stHQL = " FROM UserEntity WHERE username=?";
        List<UserEntity> userEntityList = (List<UserEntity>)userDAO.getListByHQL(0,0,stHQL,new String[]{username});
        if (userEntityList!=null && userEntityList.size()>0){
            return userEntityList.get(0);
        }
        return null;
    }
}
