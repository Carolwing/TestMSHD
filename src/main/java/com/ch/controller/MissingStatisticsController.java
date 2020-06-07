package com.ch.controller;

import com.ch.bean.OBeanBase;
import com.ch.model.DeathStatistics;
import com.ch.model.MissingStatistics;
import com.ch.service.MissingStatisticsService;
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
@RequestMapping("/missingstatistics")
public class MissingStatisticsController {
    @Autowired
    MissingStatisticsService missingStatisticsService;

//    @Resource
//    protected HttpServletRequest request;

    //   添加数据（两部分）
    @RequestMapping(value = "/generator", method = RequestMethod.POST)
    public String generator(MissingStatistics missingStatistics, MultipartFile file, Model model){
        Logger logger = Logger.getLogger("DAO");
        System.out.println(missingStatistics.toString());
        missingStatistics.setReportingUnit("204"+missingStatistics.getReportingUnit());
        JSONObject object = JSONObject.fromObject(missingStatistics);
        System.out.println(object.toString());
        OBeanBase carrier = new OBeanBase();
        //检查编码和接口是否符合规范
        try{
            if (check(missingStatistics)) {
                int result = 0;
                try {
                    result = missingStatisticsService.insert(missingStatistics);
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
                if (result > 0) {
                    System.out.println(missingStatistics.getIdMissingStatistics());
                    carrier.setInfo("S01", "插入成功");
                    carrier.setContents(missingStatistics);
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

    public boolean check(MissingStatistics missingStatistics){
        if (!missingStatistics.getReportingUnit().startsWith("204")){
            return false;
        }
        if (missingStatistics.getDisasterDate().equals("")||missingStatistics.getDisasterDate().length()>12){
            return false;
        }
        if (missingStatistics.getLocation().equals("")||missingStatistics.getLocation().length()>100){
            return false;
        }
        if (missingStatistics.getReportingUnit().equals("")||missingStatistics.getReportingUnit().length()>50){
            return false;
        }
        return true;
    }
}
