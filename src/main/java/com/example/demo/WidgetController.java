package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangkaicheng on 2017/7/2.
 */

@RestController
public class WidgetController {

    @RequestMapping(value={"/", "/index"},
                    method = {RequestMethod.GET, RequestMethod.POST},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Widget index() {
        return new Widget("green", 10, 7);
    }

    @RequestMapping(value="/method5",
                    headers={"name=pankaj", "id=1"})
    @ResponseBody
    public String method5(){
        return "method5";
    }

    @RequestMapping(value="/method6",
                    produces={"application/json","application/xml"},
                    consumes="text/html")
    //produces and consumes variables where we can specify the request content-type and the response content type
    @ResponseBody
    public String method6(){
        return "method6";
    }

    @RequestMapping(value="/method7/{id}") //http://localhost:8080/method7/123
    @ResponseBody
    public String method7(@PathVariable("id") int id){
        return "method7 with id="+id;
    }

    @RequestMapping(value="/method8/{id:[\\d]+}/{name}") //http://localhost:8080/method8/123/aaa
    @ResponseBody
    public String method8(@PathVariable("id") long id, @PathVariable("name") String name){
        return "method8 with id= "+id+" and name="+name;
    }

    @RequestMapping(value="/method9") //http://localhost:8080/method9?id=12
    @ResponseBody
    public String method9(@RequestParam("id") int id){
        return "method9 with id= "+id;
    }

    @RequestMapping()
    @ResponseBody
    public String defaultMethod(){
        return "default method";
    }

    @RequestMapping("*")
    @ResponseBody
    public String fallbackMethod(){
        return "Error 404";
    }
}