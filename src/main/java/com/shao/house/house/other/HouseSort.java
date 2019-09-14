package com.shao.house.house.other;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.shao.house.house.model.House;
import sun.awt.datatransfer.DataTransferer;

import java.util.*;

public class HouseSort {
    private House house;

    public void setHouse(House house) {
        this.house = house;
    }

    public House getHouse() {

        return house;
    }
    public static List<House> houseSort (List<House> list ,int way,int ifUp){
        List<House> rankHouse = new ArrayList<>();
        //House[] a =list.toArray(new House[list.size()]);

        if(way==0) {
            //直接在这里添加我们的排序规则
            Collections.sort(list, new Comparator<House>() {
                public int compare(House arg0, House arg1) {
                    if(ifUp==1) return arg1.getPrice().compareTo(arg0.getPrice());
                    else return arg0.getPrice().compareTo(arg1.getPrice());
                }
            });
        } else if(way==1){
            Collections.sort(list, new Comparator<House>() {
                public int compare(House arg0, House arg1) {
                    if(ifUp==1) return arg1.getArea().compareTo(arg0.getArea());
                    else return arg0.getArea().compareTo(arg1.getArea());
                }
            });
        }else if(way==2){
            Collections.sort(list, (arg0, arg1) -> {
                if(ifUp==1) return arg1.getCreateTime().compareTo(arg0.getCreateTime());
                else return arg0.getCreateTime().compareTo(arg1.getCreateTime());
            });
        }else if(way==3){
            Collections.sort(list, new Comparator<House>() {
                public int compare(House arg0, House arg1) {
                    if(ifUp==1) return arg1.getName().compareTo(arg0.getName());
                    else return arg0.getName().compareTo(arg1.getName());
                }
            });
        }else if(way==4){
//            Collections.sort(list, new Comparator<House>() {
//                public int compare(House arg0, House arg1) {
//                    if(ifUp==1) return arg1.getPrice().compareTo(arg0.getPrice());
//                    else return arg0.getPrice().compareTo(arg1.getPrice());
//                }
//            });
        }
        return list;
    }
}
