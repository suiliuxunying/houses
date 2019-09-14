package com.shao.house.house.service;

import com.shao.house.house.mapper.UserMapper;
import com.shao.house.house.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserMapper{

    @Autowired
    UserMapper userMapper;

       @Override
        public int deleteByPrimaryKey(Long id) { return 0; }

       @Override
        public int insert(User record) {
            return userMapper.insert(record);
        }

        @Override
        public int insertSelective(User record) {
            return userMapper.insertSelective(record);
        }

        @Override
        public User selectByPrimaryKey(Long id) {

           System.out.println("selectByPrimaryKey :id:"+id);

           return userMapper.selectByPrimaryKey(id);
        }

        @Override
        public int updateByPrimaryKeySelective(User record) {
            return userMapper.updateByPrimaryKeySelective(record);
        }

        @Override
        public int updateByPrimaryKey(User record) {
            return 0;
        }

    @Override
    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
}
