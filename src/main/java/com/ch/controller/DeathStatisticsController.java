package com.ch.controller;

import com.ch.bean.OBeanBase;
import com.ch.model.DeathStatistics;
import com.ch.service.DeathStatisticsServiceImpl;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by apple on 2017/4/25.
 */
@Controller
@RequestMapping("/deathstatistics")
public class DeathStatisticsController {
    @Autowired
    DeathStatisticsServiceImpl deathStatisticsService;

//    @Resource
//    protected HttpServletRequest request;

    //   添加数据（两部分）
    @RequestMapping(value = "/generator", method = RequestMethod.POST)
    public String generator(DeathStatistics deathStatistics, MultipartFile file, Model model){
        Logger logger = Logger.getLogger("DAO");
        System.out.println(deathStatistics.toString());
        deathStatistics.setReportingUnit("201"+deathStatistics.getReportingUnit());
        JSONObject object = JSONObject.fromObject(deathStatistics);
        System.out.println(object.toString());
        OBeanBase carrier = new OBeanBase();
        //检查编码和接口是否符合规范
        try{
            if (check(deathStatistics)) {
                int result = 0;
                try {
                    result = deathStatisticsService.insert(deathStatistics);
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
                if (result > 0) {
                    System.out.println(deathStatistics.getIdDeathStatistics());
                    carrier.setInfo("S01", "插入成功");
                    carrier.setContents(deathStatistics);
                    System.out.println("成功");
//                    JSONObject object = JSONObject.fromObject(deathStatistics);
//                    DisasterPost.post(object,"http://127.0.0.1:8080/TestMSHD_war/post/receive");
//                    http://localhost:8081/Center_MSHD_war/post/authentication
                   // DisasterPost.post(object,"http://127.0.0.1:8080/table_war/post/authentication");
                    return "success";
                } else {
                    carrier.setInfo("E01", "插入失败");
                    System.out.println("插入失败");
                    return "fail";
                }
            }else{
                carrier.setInfo("E01", "插入失败");
                System.out.println("check失败");
                return "fail";
            }
        }catch (Exception e){
            carrier.setInfo("E01", "插入失败");
            System.out.println("check异常失败");
            return "fail";
        }
    }

    public boolean check(DeathStatistics deathStatistics){
        if (!deathStatistics.getReportingUnit().startsWith("201")){
            return false;
        }
        if (deathStatistics.getDisasterDate().equals("")||deathStatistics.getDisasterDate().length()>12){
            return false;
        }
        if (deathStatistics.getLocation().equals("")||deathStatistics.getLocation().length()>100){
            return false;
        }
        if (deathStatistics.getReportingUnit().equals("")||deathStatistics.getReportingUnit().length()>50){
            return false;
        }
        return true;
    }
}
