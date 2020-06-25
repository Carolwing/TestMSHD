package com.ch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class BackupDatabaseManager {
    private static final Logger log = LoggerFactory.getLogger(BackupDatabaseManager.class);
//    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
//    @Value("${spring.datasource.url}")
    private String url;

    /**     * 获取数据库名     */
    public String getDataBaseName() {
        return url.substring(url.indexOf("3306"), url.indexOf("?"))
                .replaceAll("/", "")
                .replaceAll("3306", "");
    }

    /**     * 获取主机地址     */
    private String getHost() {
        return url.substring(url.indexOf("mysql"), url.indexOf("3306"))
                .replace(":", "")
                .replace("//", "")
                .replace("mysql", "");
    }

    /**     * 导出 sql 并返回相关信息     */
    public void exportSql(String time) {
        StringBuilder sb = new StringBuilder();

        //不要用变量拼接 路径不要有符号
        sb.append("mysqldump");
        sb.append(" -u root ");
        sb.append(" --password=");
        sb.append("nbuser ");
        sb.append(" disaster ");
        //备份数据存储位置，需要在mysql所在的盘
        sb.append(">C:\\data_send.sql");

        //mysql的exe位置
        File dir = new File("C:\\Program Files\\mysql_install\\mysql-8.0.13-winx64\\bin");

        try {
            Process exec = Runtime.getRuntime().exec("cmd /c "+sb.toString(),null,dir);

            if (exec.waitFor() == 0) {
                log.info("数据库备份成功，保存路径：" +"!!!");
            } else {
                System.out.println("process.waitFor()=" + exec.waitFor());

            }
        } catch (IOException e) {
            log.error("备份 数据库 出现 IO异常 ", e);
        } catch (InterruptedException e) {
            log.error("备份 数据库 出现 线程中断异常 ", e);
        } catch (Exception e) {
            log.error("备份 数据库 出现 其他异常 ", e);
        }
    }
}
