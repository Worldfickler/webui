package com.example.controller;

import com.example.bean.Result;
import com.example.mapper.CovidMapper;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author dell
 * @version 1.0
 */

@RestController//返回的数据格式为json格式
@RequestMapping("covid")
public class Covid19Controller {

    @Autowired
    private CovidMapper covidMapper;

    /**
     * 物资数据
     * @return
     */
    @RequestMapping("getCovidWz")
    public Result getCovidWz(){
        List<Map<String, Object>> data = covidMapper.getCovidWz();
        Result result = Result.success(data);
        return result;
    }

    /**
     * 全国疫情汇总数据
     * @return
     */
    @RequestMapping("getNationalData")
    public Result getNationData() {
        System.out.println("接收到前端请求并获取json数据的请求，从mysql中查询并返回数据");
        String datetime = FastDateFormat.getInstance("yyyy-MM-dd").format(System.currentTimeMillis());
        Map<String, Object> nationalData = covidMapper.getNationalData(datetime).get(0);
        Result result = Result.success(nationalData);
        System.out.println("这个是result的结果" + result);
        System.out.println("11111" + nationalData);
        return result;
    }

    /**
     * 全国累累积确诊人数
     * @return
     */
    @RequestMapping("getNationalConfirmedMapData")
    public Result getNationalConfirmedMapData(){
        String datetime = "2022-12-12";
//        String datetime = FastDateFormat.getInstance("yyyy-MM-dd").format(System.currentTimeMillis());
        //datetime = "2022-12-5";
        List<Map<String, Object>> data  = covidMapper.getNationalConfirmedMapData(datetime);
        Result result = Result.success(data);
        return result;
    }

    /**
     * 全国现存确诊人数
     * @return
     */
    @RequestMapping("getNationalCurrentConfirmedCountMapData")
    public Result getNationalCurrentConfirmedCountMapData(){
        String datetime = FastDateFormat.getInstance("yyyy-MM-dd").format(System.currentTimeMillis());
        List<Map<String, Object>> data  = covidMapper.getNationalCurrentConfirmedCountMapData(datetime);
        Result result = Result.success(data);
        return result;
    }

    @RequestMapping("getCovidTimeData")
    public Result getCovidTimeData(){
        List<Map<String, Object>> data = covidMapper.getCovidTimeData();
        Result result = Result.success(data);
        return result;
    }

    @RequestMapping("getCovidImportData")
    public Result getCovidImportData(){
        String datetime = FastDateFormat.getInstance("yyyy-MM-dd").format(System.currentTimeMillis());
        List<Map<String, Object>> data = covidMapper.getCovidImportData(datetime);
        Result result = Result.success(data);
        return result;
    }

}
