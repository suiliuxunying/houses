package com.shao.house.house.controller;

import com.shao.house.house.model.Community;
import com.shao.house.house.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin//解决跨域问题！
@Controller
@ResponseBody
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @RequestMapping(value = {"/getCommunityList"})
    public List<Community> getCommunityList(){
        return communityService.getCommunityList();
    }
}
