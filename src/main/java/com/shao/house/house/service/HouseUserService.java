package com.shao.house.house.service;

import com.shao.house.house.mapper.HouseUserMapper;
import com.shao.house.house.model.HouseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseUserService implements HouseUserMapper{

    @Autowired
    private HouseUserMapper houseUserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(HouseUser record) {
        return 0;
    }

    @Override
    public int insertSelective(HouseUser record) {
        return houseUserMapper.insertSelective(record);
    }

    @Override
    public HouseUser selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(HouseUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(HouseUser record) {
        return 0;
    }

    @Override
    public List<HouseUser> getMaster(Long houseId) {
        return houseUserMapper.getMaster(houseId);
    }

    @Override
    public List<HouseUser> getMyHoust(long id) {
        return houseUserMapper.getMyHoust(id);
    }

    public Long getMasterId(Long houseId) {
        List<HouseUser> houseUserList=houseUserMapper.getMaster(houseId);
        Long masterId =Long.getLong("0");
        for (int i=0;i<houseUserList.size();i++){
            HouseUser houseUser=houseUserList.get(i);
            if(houseUser.getType()){
                masterId =houseUser.getUserId();
            }
        }
        return masterId;
    }

    public List<Long> getCollecterId(Long houseId) {
        List<HouseUser> houseUserList=houseUserMapper.getMaster(houseId);
        List<Long> collectIds = new ArrayList<>();
        for (int i=0;i<houseUserList.size();i++){
            HouseUser houseUser=houseUserList.get(i);
            if(!houseUser.getType()){
                collectIds.add(houseUser.getUserId());
            }
        }
        return collectIds;
    }

    public List<Long> getMyHouseId(Long userId) {
        List<HouseUser> houseUserList=houseUserMapper.getMyHoust(userId);
//        System.out.println("getMyHouseId:"+houseUserList);
        List<Long> myHouseId = new ArrayList<>();
        if(houseUserList!=null){
            for (int i=0;i<houseUserList.size();i++){
                HouseUser houseUser=houseUserList.get(i);
                if(houseUser.getType()){
                    System.out.println("my houseUser:"+houseUser);
                    Long a=houseUser.getHouseId();
                    myHouseId.add(a);
                }
            }
        }
        System.out.println("my houseUser:"+myHouseId);
        return myHouseId;
    }

    public List<Long> getCollectHouseId(Long userId) {
        List<HouseUser> houseUserList=houseUserMapper.getMyHoust(userId);
//        System.out.println("getCollectHouseId:"+houseUserList);
        List<Long> CollectIds = new ArrayList<>();
        if(houseUserList!=null){
            for (int i=0;i<houseUserList.size();i++){
                HouseUser houseUser=houseUserList.get(i);
                if(!houseUser.getType()){
                    System.out.println("collect houseUser:"+houseUser);
                    CollectIds.add(houseUser.getHouseId());
                }
            }
        }
        System.out.println("collect houseUser:"+CollectIds);
        return CollectIds;
    }


}
