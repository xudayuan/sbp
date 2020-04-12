package me.xuyupeng.sbp.controller;

import me.xuyupeng.sbp.req.NameReq;
import me.xuyupeng.sbp.res.NameRes;
import me.xuyupeng.sbp.service.MyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一个测试的Controller
 *
 * @author xuyupeng
 * @date 2020/4/11 16:46
 */
@RestController
@RequestMapping("/xyp")
public class MyController {
    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @PostMapping(value = "/name", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    NameRes getName(@RequestBody NameReq name) {
        NameRes res = new NameRes();
        res.setName("my name is " + name.getName());
        return res;
    }
}
