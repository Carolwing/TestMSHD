package com.ch.controller;

import com.ch.bean.OBeanBase;
import com.ch.model.CommDisaster;
import com.ch.service.CommDisasterServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by apple on 2017/4/25.
 */
@Controller
@RequestMapping("/commdisaster")
public class CommDisasterController {
    @Autowired
    CommDisasterServiceImpl commDisasterService;

//    @Resource
//    protected HttpServletRequest request;

    //   添加数据（两部分）
    @RequestMapping(value = "/generator", method = RequestMethod.POST)
    public String generator(CommDisaster commDisaster, MultipartFile file, Model model){
        Logger logger = Logger.getLogger("DAO");
        System.out.println(commDisaster.toString());
        OBeanBase carrier = new OBeanBase();
        commDisaster.setReportingUnit("202"+commDisaster.getReportingUnit());
        //检查编码和接口是否符合规范
        try{
            if (check(commDisaster)) {
                int result = 0;
                try {
                    Resolving cm = new Resolving(commDisaster.getDisasterID());
                    commDisaster.setLocation(cm.getLocation_name());
                    commDisaster.setDisasterID(cm.getKind_name());
                    result = commDisasterService.insert(commDisaster);
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                    e.printStackTrace();
                }
                if (result > 0) {
                    System.out.println(commDisaster.getIdcommdisaster());
                    carrier.setInfo("S01", "插入成功");
                    carrier.setContents(commDisaster);
                    System.out.println("成功");
                    JSONObject object = JSONObject.fromObject(commDisaster);
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

    public boolean check(CommDisaster commDisaster){
        if (!commDisaster.getReportingUnit().startsWith("202")){
            return false;
        }
        if (commDisaster.getDisasterDate().equals("")||commDisaster.getDisasterDate().length()>12){
            return false;
        }
        if (commDisaster.getLocation().equals("")||commDisaster.getLocation().length()>100){
            return false;
        }
        if (commDisaster.getDisasterType().equals("")||commDisaster.getDisasterType().length()>4){
            return false;
        }
        if (commDisaster.getGrade().equals("")||commDisaster.getGrade().length()>4){
            return false;
        }
        if (commDisaster.getReportingUnit().equals("")||commDisaster.getReportingUnit().length()>50){
            return false;
        }
        if (commDisaster.getNote()!=null&&!commDisaster.getNote().equals("")&&commDisaster.getNote().length()>200){
            return false;
        }
        return true;
    }

//    @RequestMapping(value = "/success")
//    public String success(CommDisaster commDisaster, MultipartFile file, Model model){
//        Logger logger = Logger.getLogger("DAO");
//        System.out.println(commDisaster.toString());
//        OBeanBase carrier = new OBeanBase();
//        int result = commDisasterService.insert(commDisaster);
//        if (result>0) {
//            System.out.println(commDisaster.getIdcommdisaster());
//            carrier.setInfo("S01", "插入成功");
//            logger.debug("插入成功");
//            carrier.setContents(commDisaster);
//            return "redirect:success";
//        } else {
//            carrier.setInfo("E01", "插入失败");
//            return "redirect:fail";
//        }
//    }
//    public OBeanBase doGenerate(@RequestBody CommDisasterGeneratorIBean commDisasterGeneratorIBean) {
//        Logger logger = Logger.getLogger("DAO");
//        OBeanBase carrier = new OBeanBase();
//
//        CommDisaster commDisaster = new CommDisaster(commDisasterGeneratorIBean.getIdCommDisaster(),
//                commDisasterGeneratorIBean.getId(),commDisasterGeneratorIBean.getDate(),
//                commDisasterGeneratorIBean.getLocation(),commDisasterGeneratorIBean.getType(),
//                commDisasterGeneratorIBean.getGrade(), commDisasterGeneratorIBean.getNote(),
//                commDisasterGeneratorIBean.getReportingUnit(),commDisasterGeneratorIBean.getPicture());
//        int result = commDisasterService.insert(commDisaster);
//        if (result>0) {
//            System.out.println(commDisaster.getIdcommdisaster());
//            carrier.setInfo("S01", "插入成功");
//            logger.debug("插入成功");
//            carrier.setContents(commDisaster);
//        } else {
//            carrier.setInfo("E01", "插入失败");
//        }
//
//        return carrier;
//    }
}