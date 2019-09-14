package com.shao.house.house.controller;

import com.alibaba.fastjson.JSONObject;
import com.shao.house.house.model.House;
import com.shao.house.house.model.HouseUser;
import com.shao.house.house.model.User;
import com.shao.house.house.other.ReadFile;
import com.shao.house.house.other.Tag;
import com.shao.house.house.service.CommunityService;
import com.shao.house.house.service.HouseService;
import com.shao.house.house.service.HouseUserService;
import com.shao.house.house.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@ResponseBody
@Controller
@CrossOrigin
public class OtherController {

//    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    private Logger logger = LoggerFactory.getLogger(OtherController.class);
    @Autowired
    private CommunityService communityService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;
    @Autowired
    private HouseUserService houseUserService;

    @RequestMapping(value = {"/getTags"})
    public HashMap getTags(){
        return Tag.TAGS.getMaps();
    }

    @RequestMapping(value = {"/save"})
    public String save(@RequestParam("multipartfiles") MultipartFile[] multipartfiles, String productId) throws IOException {
        //获取项目编译之后的文件路径，一般是“项目路径/target/classes”
//        System.out.println("data:"+multipartfiles+productId);
//        System.out.println("data:"+productId);
//        String Path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")+"static/swagger/")).replaceAll("file:/", "").replaceAll("%20", " ").trim();
//        System.out.println("Path:"+Path);
//        if(Path.indexOf(":") != 1){
//            Path = File.separator + Path;
//            System.out.println("File.separator:"+File.separator);
//        }
        String Path="D:/file/code/vue/house/static/imgs/";
        System.out.println("Path:"+Path);
        String imagName="";
        //遍历文件
        System.out.println("multipartfiles:"+multipartfiles + multipartfiles.length);
        if(multipartfiles != null && multipartfiles.length>0){
            for(MultipartFile item : multipartfiles){
                System.out.println("item:"+item);
                String fileName = item.getOriginalFilename();//获取文件名
               String filePath = Path + "images/uploadFiles";//自定义上传路径
                File file = new File(filePath,fileName);
                if(!file.exists()){//判断文件夹是否存在，如果不存在则创建
                    if(!file.getParentFile().exists()){
                        //创建文件目录
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                item.transferTo(file);//上传文件
                imagName=fileName;
            }
        }
        System.out.println(imagName);
        return imagName;
    }

    @RequestMapping(value = {"/delete"})
    public int delete(@RequestBody JSONObject object) throws IOException {
        //获取项目编译之后的文件路径，一般是“项目路径/target/classes”
        System.out.println("data:"+object);
        String fileName=object.getString("fileName");
        String Path="D:/file/code/vue/house/static/imgs/";
        System.out.println("Path:"+Path);
        //删除文件
        String filePath = Path + "images/uploadFiles";//自定义上传路径
        File file = new File(filePath,fileName);
        int state=0;
        if(file.exists()){//判断文件夹是否存在
            file.delete();
            state=1;
        }
        return state;
    }

    @RequestMapping("/readFile")
    public List<House> readFile () throws Exception {
        String filePath = "C:\\Users\\10703\\Desktop\\毕业设计\\资料\\抓取链家官网北京房产信息并用python进行数据挖掘\\LJ2014.txt";
        List<House> houseList=ReadFile.readTxt(filePath);
        for (House item:houseList){
            //System.out.println(item.getFloorPlan());
            String communityName=item.getFloorPlan();
            int id=communityService.gteIdByname(communityName);//不得已这里存了下小区名
            item.setCommunityId(id);
//          已经成功！
            houseService.insertSelectiveRId(item);
            logger.info("info:"+item.getId());

//            item.setFloorPlan(null);
        }
        return houseList;
//        int a=communityService.gteIdByname("翠成馨园");
//        System.out.println("A:"+a);
    }
    @RequestMapping("/setDataHouseUser")
    public List<HouseUser> setData(){
        List<HouseUser> list =new ArrayList<>();
    //house: 48-1036
    //user:103-203
//    int a = (int)(1+Math.random()*(40-1+1));
    for (int i=48; i<1037;i++){
        int a = (int)(1+Math.random()*(101-1+1))+102;
        HouseUser houseUser =new HouseUser ();
        houseUser.setType(true);
        houseUser.setCreateTime(new Date());
        houseUser.setHouseId(Long.valueOf(i));
        houseUser.setUserId(Long.valueOf(a));
        list.add(houseUser);
        houseUserService.insertSelective(houseUser);

        if(a<162){//60% 的房子被收藏
            HouseUser houseUser1 =new HouseUser ();
            houseUser1.setType(false);
            houseUser1.setCreateTime(new Date());
            houseUser1.setHouseId(Long.valueOf(i));
            Random ra =new Random();
            int a1 = (ra.nextInt(100)+1);//产生收藏次数权重
            logger.warn(""+a1);
            int a2 =1;
            if(a1<35) a2=1;
            else if (a1<60)a2=2;
            else if (a1<80)a2=3;
            else if (a1<95)a2=4;
            else a2=5;
            logger.warn("a1："+a1+" a2: "+a2);
            List<Integer> a3Arry =new ArrayList<>();;//存历史 a3
            for(int j=0;j<a2;j++){
                int state=1;
                Random random =new Random();
                int a3 = random.nextInt(101)+102;
                if (a3 == a){
                   continue;
                }
                if(!a3Arry.isEmpty()) {
                    for (int k = 0; k <a3Arry.size(); k++)
                        if (a3Arry.get(k).equals(a3)) {
                        logger.info("!!!!!!!!!");
                        state=0;
                        }
                }
                if(state!=0){
                    a3Arry.add( a3);
                    houseUser1.setUserId(Long.valueOf(a3));
                    logger.info(a3 + "a3 " + a + " ！！" + "a");
                    houseUserService.insertSelective(houseUser1);
                    list.add(houseUser1);
                }
                else {
                    logger.info("@@@@@@@@@@@@@@");
                }
                }

            }

        }
    return list;
    }
    @RequestMapping("/setUserData")
    public List<User> setUserData(){
        List<User> List =new ArrayList<> ();
        int a = (int)(1+Math.random()*(40-1+1));
        for(int i=2;i< 101;i++){
            User user=new User();
            user.setEnable(true);
            user.setType(true);
            user.setPhone("10701"+i);
            user.setName("张"+i);
            user.setPassword("123456");
            user.setEmail(i+"10701"+"@shao.com");
            user.setCreateTime(new Date());
            user.setAvatar(i%2==1?"啊"+i+"汪":"啊"+i+"喵");
            user.setAboutme("我是一只快乐的"+user.getAvatar()+",没事最喜欢睡啊睡！");
            List.add(user);
            userService.insertSelective(user);
        }
        return List;
    }
}
