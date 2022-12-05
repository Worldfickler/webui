package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author dell
 * @version 1.0
 */

@Mapper
public interface CovidMapper {

    @Select("select `name`, `cg` as `采购`, `xb` as `下拨`, `jz` as `捐赠`, `xh` as `消耗`, `xq` as `需求`, `kc` as `库存` from `covid19_wz`;")
    List<Map<String,Object>> getCovidWz();

    @Select("select `datetime`, `currentConfirmedCount`, `confirmedCount`, `suspectedCount`, `curedCount`, `deadCount` from `covid19_1` where `datetime`= #{datetime};")
    List<Map<String, Object>> getNationalData(String datetime);

    @Select("select `provinceShortName` as `name`, `confirmedCount` as `value` from `covid19_2` where `datetime`= #{datetime};")
    List<Map<String, Object>> getNationalConfirmedMapData(String datetime);

    @Select("select `provinceShortName` as `name`, `currentConfirmedCount` as `value` from `covid19_2` where `datetime`= #{datetime};")
    List<Map<String, Object>> getNationalCurrentConfirmedCountMapData(String datetime);

    @Select("select `dateId`, `confirmedIncr` as `新增确诊`, `confirmedCount` as `累计确诊`, `suspectedCount` as `疑似病例`, `curedCount` as `累计治愈`, `deadCount` as `累计死亡` from `covid19_3`;")
    List<Map<String, Object>> getCovidTimeData();

    @Select("select `provinceShortName` as `name`, `confirmedCount` as `value` from `covid19_4` where `datetime`= #{datetime} order by `value` desc limit 10;")
    List<Map<String, Object>> getCovidImportData(String datetime);


}
