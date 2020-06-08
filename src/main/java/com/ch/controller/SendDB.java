package com.ch.controller;


import com.ch.service.BackupDatabaseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/db")
public class SendDB {
    @Autowired
    private BackupDatabaseManager backUpDataBaseManager;

    private static final Logger log = LoggerFactory.getLogger(com.ch.controller.SendDB.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");

    @RequestMapping(value = "/backupDB", method = RequestMethod.POST)
    public String getDB() throws IOException, InterruptedException {
        Thread.sleep(1000*2);
        String format = dateFormat.format(System.currentTimeMillis());
        log.info("The time is now {}", format);
        backUpDataBaseManager.exportSql(format);
        System.out.println("zixitong BackUp Successfully");

        //与主系统建立socket连接
        Socket s = new Socket(InetAddress.getLocalHost(), 9001);
        // 获得输出流
        OutputStream out = s.getOutputStream();
        // 获得输入流
        //备份的文件路径
        FileInputStream fis = new FileInputStream("D:\\data.sql");
        // 发送文件信息
        byte[] buf = new byte[1024*1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            // 写入到Socket输出流
            out.write(buf, 0, len);
        }
        s.shutdownOutput();
        //文件传输成功，关闭socket
        System.out.println("!!!!!!!!!!!SEND SUCCESS!!!!!!!!!!!!");
        out.close();
        fis.close();
        s.close();
        return "success";
    }
}
