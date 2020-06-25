package com.ch.controller;

import com.ch.bean.OBeanBase;
import com.ch.model.DisasterInfo;
import com.ch.service.DisasterInfoService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/disasterinfo")
public class DisasterInfoController {
    @Autowired
    DisasterInfoService disasterInfoService;

//    @Resource
//    protected HttpServletRequest request;

    //   添加数据（两部分）
    @RequestMapping(value = "/generator", method = RequestMethod.POST)
    public String generator(DisasterInfo disasterInfo, MultipartFile file, Model model){
        Logger logger = Logger.getLogger("DAO");
        System.out.println(disasterInfo.toString());
        disasterInfo.setReportingUnit("502"+disasterInfo.getReportingUnit());
        JSONObject object = JSONObject.fromObject(disasterInfo);
        System.out.println(object.toString());
        OBeanBase carrier = new OBeanBase();
        //检查编码和接口是否符合规范
        try{
            if (check(disasterInfo)) {
                int result = 0;
                try {
                    Resolving cm = new Resolving(disasterInfo.getDisasterID());
                    disasterInfo.setLocation(cm.getLocation_name());
                    disasterInfo.setDisasterID(cm.getKind_name());
                    result = disasterInfoService.insert(disasterInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (result > 0) {
                    System.out.println(disasterInfo.getIdDisasterInfo());
                    carrier.setInfo("S01", "插入成功");
                    carrier.setContents(disasterInfo);
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

    public boolean check(DisasterInfo disasterInfo){
        if (!disasterInfo.getReportingUnit().startsWith("502")){
            return false;
        }
        if (disasterInfo.getDisasterDate().equals("")||disasterInfo.getDisasterDate().length()>12){
            return false;
        }
        if (disasterInfo.getLocation().equals("")||disasterInfo.getLocation().length()>100){
            return false;
        }
        if (disasterInfo.getReportingUnit().equals("")||disasterInfo.getReportingUnit().length()>50){
            return false;
        }
        return true;
    }

}
