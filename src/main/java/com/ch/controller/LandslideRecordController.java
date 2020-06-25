package com.ch.controller;

import com.ch.bean.OBeanBase;
import com.ch.model.LandslideRecord;
import com.ch.service.LandslideRecordService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/landsliderecord")
public class LandslideRecordController {
    @Autowired
    LandslideRecordService landslideRecordService;

//    @Resource
//    protected HttpServletRequest request;

    //   添加数据（两部分）
    @RequestMapping(value = "/generator", method = RequestMethod.POST)
    public String generator(LandslideRecord landslideRecord, MultipartFile file, Model model){
        Logger logger = Logger.getLogger("DAO");
        System.out.println(landslideRecord.toString());
        landslideRecord.setReportingUnit("401"+ landslideRecord.getReportingUnit());
        JSONObject object = JSONObject.fromObject(landslideRecord);
        System.out.println(object.toString());
        OBeanBase carrier = new OBeanBase();
        //检查编码和接口是否符合规范
        try{
            if (check(landslideRecord)) {
                int result = 0;
                try {
                    Resolving cm = new Resolving(landslideRecord.getDisasterID());
                    landslideRecord.setLocation(cm.getLocation_name());
                    landslideRecord.setDisasterID(cm.getKind_name());
                    result = landslideRecordService.insert(landslideRecord);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (result > 0) {
                    System.out.println(landslideRecord.getIdLandslideRecord());
                    carrier.setInfo("S01", "插入成功");
                    carrier.setContents(landslideRecord);
                    System.out.println("成功");
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

    public boolean check(LandslideRecord landslideRecord){
        if (!landslideRecord.getReportingUnit().startsWith("401")){
            return false;
        }
        if (landslideRecord.getDisasterDate().equals("")|| landslideRecord.getDisasterDate().length()>12){
            return false;
        }
        if (landslideRecord.getLocation().equals("")|| landslideRecord.getLocation().length()>100){
            return false;
        }
        if (landslideRecord.getReportingUnit().equals("")|| landslideRecord.getReportingUnit().length()>50){
            return false;
        }
        return true;
    }
}
