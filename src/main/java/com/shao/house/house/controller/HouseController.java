package com.shao.house.house.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shao.house.house.model.House;
import com.shao.house.house.model.HouseCondition;
import com.shao.house.house.model.HouseUser;
import com.shao.house.house.other.HouseSort;
import com.shao.house.house.other.Tag;
import com.shao.house.house.service.HouseService;
import com.shao.house.house.service.HouseUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin//解决跨域问题！
@Controller
@ResponseBody
public class HouseController {

    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseUserService houseUserService;

    private static Logger logger = Logger.getLogger(HouseController.class);

    //  没有分页
    @RequestMapping(value = "/searchHouse")
    public List<House> searchHouse(@RequestBody JSONObject object) {
        System.out.println("RequestValue：" + object);
        logger.info(object);
        JSONObject data = object.getJSONObject("form");
        HouseCondition houseCondition = dealWithCondition(data);
        List<House> houseList = new ArrayList<House>();
        houseList = houseService.getHouseListCondition(houseCondition);
        //rank
        houseList = HouseSort.houseSort(houseList, object.getInteger("rank"), object.getInteger("ifUp"));
        System.out.println("houseList: " + houseList);
        return houseList;
    }

    //分页查询
    @RequestMapping(value = "/searchHousePaga")
    public JSONObject searchHousePaga(@RequestBody JSONObject object) {
        System.out.println("RequestValue：" + object);
        logger.info(object);
        Integer page = object.getInteger("page");
        Integer rows = object.getInteger("rows");
        logger.info(object);
        JSONObject data = object.getJSONObject("form");
        HouseCondition houseCondition = dealWithCondition(data);
        JSONObject houseList = houseService.getHouseListConditionPage(houseCondition, page, rows);
        //rank
//        houseList= HouseSort.houseSort(houseList,object.getInteger("rank"),object.getInteger("ifUp"));
        logger.info("houseList: " + houseList);
        return houseList;
    }

    @RequestMapping(value = "/getAllHouse")
    public List<House> getAllHouse() {
        List<House> houseList = new ArrayList<House>();
        houseList = houseService.getHouseList();
        return houseList;
    }

    @RequestMapping(value = "/searchHouseDemo")
    public ArrayList<House> searchHouseDemo(@RequestBody JSONObject value) {
        ArrayList<House> list = new ArrayList<House>();
        list.add(new House());
        list.add(new House());
        String resout = "value:";
        System.out.println(value.getJSONArray("areaCode"));
        System.out.println(value.getJSONArray("areaCode").get(1));
        System.out.println("resout:" + value);
        return list;
    }

    @RequestMapping(value = {"/insertHouse"})
    public House insertHose(@RequestBody JSONObject data) {
        System.out.println("insertHouse:data：" + data);
        JSONObject houseObject = data.getJSONObject("house");
        Long userId = data.getLong("userId");
        House house = new House();
        house.setPrice(houseObject.getInteger("price"));
        house.setBeds(houseObject.getInteger("beds"));
        house.setArea(houseObject.getInteger("area"));
        house.setBaths(houseObject.getInteger("baths"));
        house.setCommunityId(houseObject.getInteger("communityId"));
        house.setCityId(Integer.valueOf(houseObject.getJSONArray("areaCode").get(0).toString()));
        house.setCreateTime(new Date());
        house.setName(houseObject.getString("name"));
        house.setRemarks(houseObject.getString("describe"));
        house.setState(true);
        house.setType(Integer.valueOf(houseObject.getString("type")) != 1); //"1" 租 "2" 卖

//      tags
        String listString = "";
        JSONArray jsonArray = houseObject.getJSONArray("tags");
        List<Integer> list = jsonArray.toJavaList(Integer.class);
        for (Integer l : list) {

        }
        list.forEach(l -> {

        });
        if (!houseObject.getJSONArray("tags").isEmpty()) {
            for (int i = 0; i < houseObject.getJSONArray("tags").size(); i++) {
                int j = Integer.valueOf(houseObject.getJSONArray("tags").get(i).toString());
                String string = Tag.TAGS.getContent(j);
                System.out.println("j: " + j + " String:" + string + "a: " + houseObject.getJSONArray("tags").get(i).toString());
                listString = listString + string;
                if (i + 1 != houseObject.getJSONArray("tags").size())
                    listString += ",";
            }
        }
        house.setTags(listString);
//        image
        String imagsName = "";
        String path = "/images/uploadFiles/";
        if (!houseObject.getJSONArray("imagsName").isEmpty()) {
            for (int i = 0; i < houseObject.getJSONArray("imagsName").size(); i++) {
                imagsName += path + houseObject.getJSONArray("imagsName").get(i);
                if (i + 1 != houseObject.getJSONArray("tags").size()) imagsName += ",";
            }
        }
        house.setImages(imagsName);
        System.out.println(house + " " + userId);

        houseService.insertSelectiveRId(house);
//        System.out.println("houseid:"+house);
        HouseUser houseUser = new HouseUser();
        houseUser.setHouseId(house.getId());
        houseUser.setUserId(userId);
        houseUser.setCreateTime(house.getCreateTime());
        houseUser.setType(true);//true:我的 false:他的
        houseUserService.insertSelective(houseUser);
        return house;
    }

    public HouseCondition dealWithCondition(JSONObject data) {

        HouseCondition houseCondition = new HouseCondition();
        House house = new House();

//      卫生间
        if (!data.getJSONArray("baths").isEmpty()) {
            List<Integer> listInteger = new ArrayList<>();
            for (int i = 0; i < data.getJSONArray("baths").size(); i++) {
                int j = (Integer) data.getJSONArray("baths").get(i);
                listInteger.add(j);
                if (j == 3) house.setBaths(j);
            }
            houseCondition.setBathN(listInteger);
        }
//        卧室
        List<Integer> list = data.getJSONArray("beds").toJavaList(Integer.class);
        if (!list.isEmpty()) {
            List<Integer> listInteger = new ArrayList<>();
            for (Integer i : list) {
                listInteger.add(i);
                if (i == 3) house.setBeds(i);
            }
            houseCondition.setBedsN(listInteger);
        }
//      面积
        if (!data.getJSONArray("area").isEmpty()) {
            List<Integer> listInteger = new ArrayList<>();
            for (int i = 0; i < data.getJSONArray("area").size(); i++) {
                int j = (Integer) data.getJSONArray("area").get(i) * 50;
                listInteger.add(j);
                if (j == 150) house.setArea(j);
            }
            houseCondition.setAreaN(listInteger);
        }

//      价格
        {
            List<Integer> listInteger = new ArrayList<>();
            if (!data.getBoolean("userDefined")) {
                if (!data.getJSONArray("price").isEmpty()) {
                    for (int i = 0; i < data.getJSONArray("price").size(); i++) {
                        int j = (Integer) data.getJSONArray("price").get(i) * 1000;
                        listInteger.add(j);
                        if (j == 3000) house.setPrice(j);
                    }
                }
            } else {
                for (int i = (Integer) data.getJSONArray("userDefinedPrice").get(0); i < (Integer) data.getJSONArray("userDefinedPrice").get(1); i++) {
                    listInteger.add(i * 1000);
                }
            }
            houseCondition.setPriceN(listInteger);
        }
//      小区
//        System.out.println("communityId: "+data.getInteger("communityId"));
        if (data.getInteger("communityId") != null) {
            house.setCommunityId(data.getInteger("communityId"));
        }
//      tags
        List<String> listString = new ArrayList<>();
        if (!data.getJSONArray("tags").isEmpty()) {
            for (int i = 0; i < data.getJSONArray("tags").size(); i++) {
                int j = Integer.valueOf(data.getJSONArray("tags").get(i).toString());
                String string = Tag.TAGS.getContent(j);
//                System.out.println("j: "+j+" String:"+string+"a: "+data.getJSONArray("tags").get(i).toString());
                listString.add(string);
            }
            houseCondition.setTagsS(listString);
        }
//      Type
        house.setType(data.getBoolean("type"));
        houseCondition.setHouse(house);
        return houseCondition;
    }
}
