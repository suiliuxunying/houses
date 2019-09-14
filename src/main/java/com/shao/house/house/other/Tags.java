package com.shao.house.house.other;

import javax.enterprise.inject.New;
import java.util.HashMap;
import java.util.List;

public class Tags {

    public  static HashMap maps;
    {
        HashMap hashMap =new HashMap();
        hashMap.put(1,"精装修");
        hashMap.put(2,"交通便利");
        hashMap.put(3,"毛坯房");
        hashMap.put(4,"有全套家具");
        hashMap.put(5,"拎包入住");
        hashMap.put(6,"地铁站附近");
        hashMap.put(7,"隔音好");
        hashMap.put(8,"支持合租");
        hashMap.put(9,"押一付三");
        hashMap.put(0,"押一付一");
        hashMap.put(10,"独家");
        hashMap.put(11,"学区房");
        hashMap.put(12,"唯一住房");
        this.maps=hashMap;
    }

    public  HashMap getMaps() {
        return maps;
    }

    public String getContent(Integer id) {
        System.out.println("id:"+id);
        return maps.get(id).toString();
    }
}
