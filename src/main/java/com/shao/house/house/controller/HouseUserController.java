package com.shao.house.house.controller;

import com.alibaba.fastjson.JSONObject;
import com.shao.house.house.model.House;
import com.shao.house.house.model.HouseUser;
import com.shao.house.house.model.User;
import com.shao.house.house.service.HouseService;
import com.shao.house.house.service.HouseUserService;
import com.shao.house.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin//解决跨域问题！
@Controller
@ResponseBody
public class HouseUserController {
    @Autowired
    private  HouseUserService houseUserService;
    @Autowired
    private UserService userService;
    @Autowired
    private HouseService houseService;

    @RequestMapping(value = {"/getMaster"})
    public User getMaster(@RequestBody JSONObject data){
        System.out.println("data:"+data);
        long userId = houseUserService.getMasterId(data.getLong("houseId"));
        System.out.println("userId:"+userId);
        User user =userService.selectByPrimaryKey(userId);
        if(user!=null){
            System.out.println("user:"+user);
            return user;
        }else {
            return new User();
        }

    }

    @RequestMapping(value = {"/getHouses"})
    public JSONObject getCollectHouses (@RequestBody JSONObject data){
        System.out.println("data:"+data);
        List<House> houseListCollect=new  ArrayList<>();
        List<House> houseListMy=new ArrayList<>();
        List<Long> collectHouseIds = new  ArrayList<>();
        List<Long> myHouseIds = new ArrayList<>();
        JSONObject object=new JSONObject();
        myHouseIds=houseUserService.getMyHouseId(data.getLong("userId"));
        collectHouseIds=houseUserService.getCollectHouseId(data.getLong("userId"));
        if(collectHouseIds!=null){
            for(int i=0;i<collectHouseIds.size();i++){
                House house=houseService.selectByPrimaryKey(collectHouseIds.get(i));
                if (house!=null){
                    System.out.println(house);
                    houseListCollect.add(house);
                }
            }
        }
        if(myHouseIds!=null){
            for(int i=0;i<myHouseIds.size();i++){
                House house=houseService.selectByPrimaryKey( myHouseIds.get(i) );
                if (house!=null){
                    System.out.println(house);
                    houseListMy.add(house);
                }
            }
        }
//        System.out.println("houseListCollect houseListMy"+houseListCollect+houseListMy);
        object.put("houseListCollect",houseListCollect);
        object.put("houseListMy",houseListMy);
//        System.out.println("houseListCollect houseListMy"+object);
        return object;
    }
}
