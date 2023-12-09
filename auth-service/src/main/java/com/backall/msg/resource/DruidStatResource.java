package com.backall.msg.resource;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/druid")
public class DruidStatResource {

    @GetMapping("/stat")
    public Object druidStat(){
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }

}
