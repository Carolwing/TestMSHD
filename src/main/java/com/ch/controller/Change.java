package com.ch.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Change {

    String location_path = "C:\\data\\location_data.xls";
    private String code;
    private String location;
    //分为不同字段的地址（省、市、区）
    private String[] loc;
    private Workbook wb = null;

    public Change(String location) throws IOException {
        this.location = location;
        code = "";
        loc = location.split("-");
        ChangeToCode();
    }
    public void ChangeToCode() throws IOException {
        File file_location = new File(location_path);
        //判断文件是否存在
        if(file_location.isFile()&&file_location.exists()){
            String[] split = file_location.getName().split("\\.");
            if ( "xls".equals(split[1])){
                //文件流对象
                FileInputStream fis = new FileInputStream(file_location);
                wb = new HSSFWorkbook(fis);
                System.out.println("location open success");
            }else {
                System.out.println("文件类型错误!");
                return;
            }
        }
        else return;

        //解析第2个Sheet(省、市)
        Sheet sheet = wb.getSheetAt(0);
        int row_num = sheet.getLastRowNum();
        String parent_id = "0.0";
        //loc数组中序号
        int index = 0;
        String area_id = "0";

        //遍历查找location所代表的code
        for(int i=0;i<loc.length;i++){
            int j=1;
            while(j<row_num){
                Row row = sheet.getRow(j);
                //当前级别 地区的id
                area_id = row.getCell(0).toString();
                String area_name = row.getCell(1).toString();
                String cur_parent_id = row.getCell(2).toString();

                if(cur_parent_id.equals(parent_id)){
                    //如果area_id号码对应
                    if(loc[index].equals(area_name)){
                        index+=1;
                        parent_id = area_id;
                        break;
                    }
                }
                j++;
            }
        }
        code = area_id;
    }

    public String getCode(){
        code = code.substring(0,6);
        code = code + "000000";
        return code;
    }
}
