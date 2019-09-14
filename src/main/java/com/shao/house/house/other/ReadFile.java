package com.shao.house.house.other;

import com.shao.house.house.model.House;
import com.shao.house.house.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadFile {

    @Autowired
    private static CommunityService communityService;

    public static List<House> readTxt(String filePath) throws Exception{
//        System.out.println(filePath);
        List<House> houseList= new ArrayList<>();
//        try {
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt;
                System.out.println(br.readLine());//表头
                int i=0;
                while ((lineTxt = br.readLine()) != null) {
//                        System.out.println(lineTxt);
                    House house=getHouse(lineTxt);
                    if(house!=null){
                        i++;
//                      System.out.println("size:"+i+" "+house);
                        houseList.add(house);
                    }
                    if(i==600) break;
                }
                br.close();

//                System.out.println(lineTxt = br.readLine());
//                System.out.println(lineTxt = br.readLine());
////                重点！！
//                System.out.println(getHouse(lineTxt));
//                String[] list1=lineTxt1.split("\t");
//                String[] list=lineTxt.split("\t");
//                int i=0;
//                for (String item: list1){
//                    System.out.println(i++ +"\t"+ list[i-1]+"\t" +item);
//                }
            } else {
                System.out.println("文件不存在!");
            }
//        } catch (Exception e) {
//            System.out.println("文件读取错误!");
//        }
        return houseList;
    }
    public static House getHouse (String lineTxt){
        String[] list=lineTxt.split("\t");
//        int i=0;
//        for (String item: list){
//            System.out.println(i++ +":"+ item);
//        }

        if(list.length!=26){
            System.out.println("ERRORList:"+list.toString()+" "+list.length);
            return null;
        }
        House house =new House();
        house.setName(list[0]);
        house.setRemarks(list[0]);
        house.setType(false);
        house.setArea(Integer.valueOf(list[1]));
        house.setPrice(Integer.valueOf(list[2])/10);
        house.setState(true);
        house.setCreateTime(new Date());
        house.setCityId(110000);
        house.setBeds(Integer.valueOf(list[11]));
        house.setBaths(Integer.valueOf(list[12]));

        String tags="";
        if((list[13]!=null&&!list[13].equals(""))){
            tags+=list[13]+",";
        }
        if((list[14]!=null&&!list[14].equals(""))){
            tags+=list[14]+",";
        }
        if((list[15]!=null&&!list[15].equals(""))) {
            tags += list[15]+",";
        }
        if(!tags.equals("")) tags=tags.substring(0,tags.length()-1);

        house.setTags(tags);
        house.setImages(getHouseImag());
        //String communityName="";
        String communityName=list[20].replace("'", "");
        if(communityName==null){
            System.out.println(communityName);
            return null;
        }else house.setFloorPlan(communityName);
//         System.out.println("list[20].replace(\"'\", \"\") :"+list[20].replace("'", "") );
       // int a=communityService.gteIdByname(list[20]);
       //house.setCommunityId(a);

        return house;
    }
    public static String getHouseImag(){

        int b ,a;
        a=(int)(1+Math.random()*(40-1+1));
        b=(int)(1+Math.random()*(40-1+1));
        return "/images/uploadFiles/"+"imag("+a+").jpg,"+"/images/uploadFiles/"+"imag("+b+").jpg";
    }


    public static void main(String[] args) {
        String filePath = "C:\\Users\\10703\\Desktop\\毕业设计\\资料\\抓取链家官网北京房产信息并用python进行数据挖掘\\LJ2014.txt";
        //readTxt(filePath);

//        CommunityService communityService= new CommunityService();
//        System.out.println(communityService.getCommunityList());

    }

}
