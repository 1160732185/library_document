package com.document.ecust.controller;

import com.document.ecust.model.Type;
import com.document.ecust.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("api/v1")
public class MainController {
    @Autowired
    TypeService typeService;
    @ApiOperation(value = "精确查询", notes = "精确查询", produces = "application/json")
    @RequestMapping(value = "/search/{para}/{content}",method = {RequestMethod.GET},produces = "application/json")
    public Type[] getTypeJQ(@PathVariable("para")String para, @PathVariable("content")String content){
        System.out.println(para+content);
        return typeService.getTypeJQ(para,content);
    }

    @ApiOperation(value = "获得所有书籍种类", notes = "获得所有书籍种类", produces = "application/json")
    @RequestMapping(value = "/searchall",method = {RequestMethod.GET},produces = "application/json")
    public Type[] getAllType(){
        System.out.println("searchall");
        return typeService.getAllType();
    }
}
