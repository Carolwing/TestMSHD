package com.ch.controller;

import com.ch.bean.OBeanBase;
import com.ch.model.CivilStructure;
import com.ch.service.CivilStructureService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/civilstructure")
public class CivilStructureController {
    @Autowired
    CivilStructureService civilStructureService;

//    @Resource
//    protected HttpServletRequest request;

    //   添加数据（两部分）
    @RequestMapping(value = "/generator", method = RequestMethod.POST)
    public String generator(CivilStructure civilStructure, MultipartFile file, Model model){
        Logger logger = Logger.getLogger("DAO");
        System.out.println(civilStructure.toString());
        civilStructure.setReportingUnit("203"+civilStructure.getReportingUnit());
        JSONObject object = JSONObject.fromObject(civilStructure);
        System.out.println(object.toString());
        OBeanBase carrier = new OBeanBase();
        //检查编码和接口是否符合规范
        try{
            if (check(civilStructure)) {
                int result = 0;
                try {
                    Resolving cm = new Resolving(civilStructure.getDisasterID());
                    civilStructure.setLocation(cm.getLocation_name());
                    civilStructure.setDisasterID(cm.getKind_name());
                    result = civilStructureService.insert(civilStructure);
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
                if (result > 0) {
                    System.out.println(civilStructure.getIdCivilStructure());
                    carrier.setInfo("S01", "插入成功");
                    carrier.setContents(civilStructure);
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

    public boolean check(CivilStructure civilStructure){
        if (!civilStructure.getReportingUnit().startsWith("203")){
            return false;
        }
        if (civilStructure.getDisasterDate().equals("")||civilStructure.getDisasterDate().length()>12){
            return false;
        }
        if (civilStructure.getLocation().equals("")||civilStructure.getLocation().length()>100){
            return false;
        }
        if (civilStructure.getReportingUnit().equals("")||civilStructure.getReportingUnit().length()>50){
            return false;
        }
        return true;
    }
}
