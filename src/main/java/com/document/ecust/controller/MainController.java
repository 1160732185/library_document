package com.document.ecust.controller;

import com.document.ecust.model.Type;
import com.document.ecust.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("api/v1")
public class MainController {
    @Autowired
    TypeService typeService;
    @ApiOperation(value = "精确查询", notes = "精确查询", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "para", value = "para", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "content", value = "content", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/search",method = {RequestMethod.GET},produces = "application/json")
    public Type[] login(@RequestParam("para")String para, @RequestParam("content")String content){
        return new Type[]{};
    }

    @ApiOperation(value = "获得所有书籍种类", notes = "获得所有书籍种类", produces = "application/json")
    @RequestMapping(value = "/searchall",method = {RequestMethod.GET},produces = "application/json")
    public Type[] getAllType(){
        return typeService.getAllType();
    }
}
