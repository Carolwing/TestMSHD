package com.ch.controller;

import com.ch.bean.OBeanBase;
import com.ch.model.CollapseRecord;
import com.ch.service.CollapseRecordService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/collapserecord")
public class CollapseRecordController {
    @Autowired
    CollapseRecordService collapseRecordService;

//    @Resource
//    protected HttpServletRequest request;

    //   添加数据（两部分）
    @RequestMapping(value = "/generator", method = RequestMethod.POST)
    public String generator(CollapseRecord collapseRecord, MultipartFile file, Model model){
        Logger logger = Logger.getLogger("DAO");
        System.out.println(collapseRecord.toString());
        collapseRecord.setReportingUnit("402"+collapseRecord.getReportingUnit());
        JSONObject object = JSONObject.fromObject(collapseRecord);
        System.out.println(object.toString());
        OBeanBase carrier = new OBeanBase();
        //检查编码和接口是否符合规范
        try{
            if (check(collapseRecord)) {
                int result = 0;
                try {
                    Change locationCode = new Change(collapseRecord.getLocation());
                    String location = locationCode.getCode();
                    String kind = "441";
                    String sequence="";
                    File _file = new File("441.txt");
                    InputStream in = null;

                    if (_file.isFile() && _file.exists()) { //判断文件是否存在
                        byte[] tempbytes = new byte[1024];
                        int byteread = 0;
                        in = new FileInputStream(_file);
                        int num = in.read();
                        sequence=String.valueOf(num+1);
                        if (sequence.length()==1) {
                            sequence = "00" + sequence;
                        }else if (sequence.length()==2) {
                            sequence = "0" + sequence;
                        }
                        in.close();
                    }
                    else {
                        sequence="000";
                    }

                    OutputStream out =new FileOutputStream(_file);
                    out.write(Integer.parseInt(sequence));
                    out.close();

                    String state;
                    Map<String,Integer> stateMap=new HashMap<>();
                    stateMap.put("特大",1);
                    stateMap.put("重大",2);
                    stateMap.put("较大",3);
                    stateMap.put("一般",4);
                    state=String.valueOf(stateMap.get(collapseRecord.getStatus()));

                    collapseRecord.setDisasterID(location+kind+sequence+state);

                    Resolving cm = new Resolving(collapseRecord.getDisasterID());
//                    if (!cm.getLocation_name().equals(""))
//                        collapseRecord.setLocation(cm.getLocation_name());
                    collapseRecord.setNote(cm.getKind_name());
                    result = collapseRecordService.insert(collapseRecord);
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
                if (result > 0) {
                    System.out.println(collapseRecord.getIdCollapseRecord());
                    carrier.setInfo("S01", "插入成功");
                    carrier.setContents(collapseRecord);
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

    public boolean check(CollapseRecord collapseRecord){
        if (!collapseRecord.getReportingUnit().startsWith("402")){
            return false;
        }
        if (collapseRecord.getDisasterDate().equals("")||collapseRecord.getDisasterDate().length()>12){
            return false;
        }
        if (collapseRecord.getLocation().equals("")||collapseRecord.getLocation().length()>100){
            return false;
        }
        if (collapseRecord.getReportingUnit().equals("")||collapseRecord.getReportingUnit().length()>50){
            return false;
        }
        return true;
    }
}
