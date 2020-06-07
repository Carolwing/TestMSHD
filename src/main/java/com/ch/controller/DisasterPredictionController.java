package com.ch.controller;

import com.ch.bean.OBeanBase;
import com.ch.model.DisasterPrediction;
import com.ch.service.DisasterPredictionService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/disasterprediction")
public class DisasterPredictionController {
    @Autowired
    DisasterPredictionService disasterPredictionService;

//    @Resource
//    protected HttpServletRequest request;

    //   添加数据（两部分）
    @RequestMapping(value = "/generator", method = RequestMethod.POST)
    public String generator(DisasterPrediction disasterPrediction, MultipartFile file, Model model){
        Logger logger = Logger.getLogger("DAO");
        System.out.println(disasterPrediction.toString());
        disasterPrediction.setReportingUnit("501"+disasterPrediction.getReportingUnit());
        JSONObject object = JSONObject.fromObject(disasterPrediction);
        System.out.println(object.toString());
        OBeanBase carrier = new OBeanBase();
        //检查编码和接口是否符合规范
        try{
            if (check(disasterPrediction)) {
                int result = 0;
                try {
                    result = disasterPredictionService.insert(disasterPrediction);
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
                if (result > 0) {
                    System.out.println(disasterPrediction.getIdDisasterPrediction());
                    carrier.setInfo("S01", "插入成功");
                    carrier.setContents(disasterPrediction);
                    System.out.println("成功");
//                    DisasterPost.post(object,"http://127.0.0.1:8080/TestMSHD_war/post/receive");
//                    http://localhost:8081/Center_MSHD_war/post/authentication
                    //DisasterPost.post(object,"http://127.0.0.1:8080/table_war/post/authentication");
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

    public boolean check(DisasterPrediction disasterPrediction){
        if (!disasterPrediction.getReportingUnit().startsWith("501")){
            return false;
        }
        if (disasterPrediction.getDisasterDate().equals("")||disasterPrediction.getDisasterDate().length()>12){
            return false;
        }
        if (disasterPrediction.getLocation().equals("")||disasterPrediction.getLocation().length()>100){
            return false;
        }
        if (disasterPrediction.getReportingUnit().equals("")||disasterPrediction.getReportingUnit().length()>50){
            return false;
        }
        return true;
    }

}
