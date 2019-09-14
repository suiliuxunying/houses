package com.shao.house.house.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shao.house.house.mapper.HouseMapper;
import com.shao.house.house.model.House;
import com.shao.house.house.model.HouseCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService implements HouseMapper{

    @Autowired
    HouseMapper houseMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return houseMapper.deleteByPrimaryKey(id);

    }

    @Override
    public int insert(House record) {
        return houseMapper.insert(record);
    }

    @Override
    public int insertSelective(House record) {
        return houseMapper.insertSelective(record);
    }

    @Override
    public House selectByPrimaryKey(Long id) {
        return houseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(House record) {
        return houseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(House record) {
        return 0;
    }

    @Override
    public List<House> getHouseList() {
        return houseMapper.getHouseList();
    }

    @Override
    public List<House> getHouseListCondition(HouseCondition houseCondition) {
        return houseMapper.getHouseListCondition(houseCondition);
    }

    @Override
    public int insertSelectiveRId(House house) {
        return houseMapper.insertSelectiveRId(house);
    }
    //分页查询
    public JSONObject getHouseListConditionPage(HouseCondition houseCondition ,Integer page, Integer rows) {
        //为了程序的严谨性，判断非空：
        if(page == null){
            page = 1;   //设置默认当前页
        }
        if(page <= 0){
            page = 1;
        }
        if(rows == null){
            rows = 4;    //设置默认每页显示的商品数(因为jsp页面上默认写的就是30条)
        }
        //1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(page, rows);
        //2、执行查询
        List<House> list = houseMapper.getHouseListCondition(houseCondition);
        //3、获取分页查询后的数据
        PageInfo<House> pageInfo = new PageInfo<>(list);
        //4、封装需要返回的分页实体
        JSONObject object = new JSONObject();
        //设置获取到的总记录数total：
        object.put("total",pageInfo.getTotal());
        //设置数据集合rows;
        object.put("rows",list);
        return object;
    }
}
