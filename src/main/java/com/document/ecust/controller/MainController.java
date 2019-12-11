package com.document.ecust.controller;

import com.document.ecust.model.Information;
import com.document.ecust.model.Type;
import com.document.ecust.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api
@RestController
@RequestMapping("api/v1")
public class MainController {
    @Autowired
    TypeService typeService;
    @ApiOperation(value = "简单查询", notes = "简单查询", produces = "application/json")
    @RequestMapping(value = "/search/{para}/{content}",method = {RequestMethod.GET},produces = "application/json")
    public Information getTypeJQ(@PathVariable("para")String para, @PathVariable("content")String content){
        System.out.println(para+content);
        Information info = typeService.getTypeJQ(para,content);
        return typeService.getTypeJQ(para,content);
    }

    @ApiOperation(value = "高级查询", notes = "高级查询", produces = "application/json")
    @RequestMapping(value = "adsearch/{name}/{author}/{publisher}/{isbn}/{callno}",method = {RequestMethod.GET},produces = "application/json")
    public Information getTypeAD(@PathVariable("name")String name, @PathVariable("author")String author, @PathVariable("publisher")String publisher, @PathVariable("isbn")String isbn, @PathVariable("callno")String callno){
        System.out.println(name.equals("undefined"));
        return typeService.getTypeAD(name,author,publisher,isbn,callno);
    }

    @ApiOperation(value = "分面查询", notes = "分面查询", produces = "application/json")
    @RequestMapping(value = "fmsearch/{name}/{author}/{publisher}/{isbn}/{callno}/{a}/{d}/{l}/{t}",method = {RequestMethod.GET},produces = "application/json")
    public Information getTypeFM(@PathVariable("name")String name, @PathVariable("author")String author, @PathVariable("publisher")String publisher, @PathVariable("isbn")String isbn, @PathVariable("callno")String callno
    ,@PathVariable("a")String a,@PathVariable("d")String d,@PathVariable("l")String l,@PathVariable("t")String t){
        System.out.println(name.equals("undefined"));
        Information info = typeService.getTypeFM(name,author,publisher,isbn,callno,a,d,l,t);
        return typeService.getTypeFM(name,author,publisher,isbn,callno,a,d,l,t);
    }

    @ApiOperation(value = "获得所有书籍种类", notes = "获得所有书籍种类", produces = "application/json")
    @RequestMapping(value = "/searchall",method = {RequestMethod.GET},produces = "application/json")
    public Type[] getAllType(){
        System.out.println("searchall");
        return typeService.getAllType();
    }

    @ApiOperation(value = "获得热搜", notes = "获得热搜", produces = "application/json")
    @RequestMapping(value = "/hot",method = {RequestMethod.GET},produces = "application/json")
    public String[] getHot(){
        return typeService.getHot();
    }
}
