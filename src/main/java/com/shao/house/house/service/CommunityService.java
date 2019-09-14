package com.shao.house.house.service;

import com.shao.house.house.mapper.CommunityMapper;
import com.shao.house.house.model.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.enterprise.inject.New;
import java.util.List;

@Service
public class CommunityService implements CommunityMapper {
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Community record) {
        return 0;
    }

    @Override
    public int insertSelective(Community record) {
        return 0;
    }

    @Override
    public Community selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Community record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Community record) {
        return 0;
    }

    @Override
    public List<Community> getCommunityList() {
        return communityMapper.getCommunityList();
    }

    @Override
    public Integer selectIdByName(String name) {
        return 0;
    }

    public Integer gteIdByname (String name){
        Integer ID=communityMapper.selectIdByName(name);

        if(ID==null){
            System.out.println("新建小区");
            Community community= new Community();
            community.setCityCode("110000");
            community.setName(name);
            community.setCityName("北京市");
            communityMapper.insertSelective(community);
            ID = community.getId();
        }
        return ID;
        //return 1;
    }
}
