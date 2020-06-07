import java.util.ArrayList;
import java.util.List;

import com.ch.controller.CommDisasterController;
import com.ch.model.CommDisaster;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-service.xml","classpath:applicationContext-dao.xml",
"classpath:applicationContext-trans.xml"})
public class CheckDataTest {
    @Autowired
    CommDisasterController commDisasterService;
    @Test
    @Rollback(true)
    public void TestCheckID(){
        CommDisaster commDisaster1 = new CommDisaster();
        commDisaster1.setDisasterID("202");
        commDisaster1.setDisasterDate("202005061124");
        commDisaster1.setDisasterType("2");
        commDisaster1.setGrade("4");
        commDisaster1.setLocation("TestLocation");
        commDisaster1.setReportingUnit("TestUnit");
        CommDisaster commDisaster2 = new CommDisaster();
        commDisaster2.setDisasterID("xxxx");
        commDisaster2.setDisasterDate("202005061124");
        commDisaster2.setDisasterType("2");
        commDisaster2.setGrade("4");
        commDisaster2.setLocation("TestLocation");
        commDisaster2.setReportingUnit("TestUnit");

        String s1 = commDisasterService.generator(commDisaster1,null,null);
        Assert.assertEquals("success",s1);
        String s2 = commDisasterService.generator(commDisaster2,null,null);
        Assert.assertEquals("fail",s2);
    }

    @Test
    @Rollback(true)
    public void TestCheckData(){
        CommDisaster commDisaster1 = new CommDisaster();
        commDisaster1.setDisasterID("202");
        commDisaster1.setDisasterDate("20200506112433");
        commDisaster1.setDisasterType("2");
        commDisaster1.setGrade("4");
        commDisaster1.setLocation("TestLocation");
        commDisaster1.setReportingUnit("TestUnit");

        CommDisaster commDisaster2 = new CommDisaster();
        commDisaster2.setDisasterID("202");
        commDisaster2.setDisasterDate("202005061124");
        commDisaster2.setDisasterType("22222");
        commDisaster2.setGrade("4");
        commDisaster2.setLocation("TestLocation");
        commDisaster2.setReportingUnit("TestUnit");

        CommDisaster commDisaster3 = new CommDisaster();
        commDisaster3.setDisasterID("202");
        commDisaster3.setDisasterDate("202005061124");
        commDisaster3.setDisasterType("2");
        commDisaster3.setGrade("44444");
        commDisaster3.setLocation("TestLocation");
        commDisaster3.setReportingUnit("TestUnit");

        CommDisaster commDisaster4 = new CommDisaster();
        commDisaster4.setDisasterID("202");
        commDisaster4.setDisasterDate("202005061124");
        commDisaster4.setDisasterType("2");
        commDisaster4.setGrade("444");
        commDisaster4.setLocation(new String(new char[101]).replace('\0','s'));
        commDisaster4.setReportingUnit("TestUnit");

        CommDisaster commDisaster5 = new CommDisaster();
        commDisaster5.setDisasterID("202");
        commDisaster5.setDisasterDate("202005061124");
        commDisaster5.setDisasterType("2");
        commDisaster5.setGrade("444");
        commDisaster5.setLocation("TestLocation");
        commDisaster5.setReportingUnit(new String(new char[51]).replace('\0','s'));

        CommDisaster commDisaster6 = new CommDisaster();
        commDisaster6.setDisasterID("202");

        CommDisaster commDisaster7 = new CommDisaster();
        commDisaster7.setIdcommdisaster(18);
        commDisaster7.setDisasterID("202");
        commDisaster7.setDisasterDate("202005061124");
        commDisaster7.setDisasterType("2");
        commDisaster7.setGrade("4");
        commDisaster7.setLocation("TestLocation");
        commDisaster7.setReportingUnit("TestUnit");

        String s1 = commDisasterService.generator(commDisaster1,null,null);
        Assert.assertEquals("fail",s1);
        String s2 = commDisasterService.generator(commDisaster2,null,null);
        Assert.assertEquals("fail",s2);
        String s3 = commDisasterService.generator(commDisaster3,null,null);
        Assert.assertEquals("fail",s3);
        String s4 = commDisasterService.generator(commDisaster4,null,null);
        Assert.assertEquals("fail",s4);
        String s5 = commDisasterService.generator(commDisaster5,null,null);
        Assert.assertEquals("fail",s5);
        String s6 = commDisasterService.generator(commDisaster6,null,null);
        Assert.assertEquals("fail",s6);
        String s7 = commDisasterService.generator(commDisaster7,null,null);
        Assert.assertEquals("success",s7);

    }

}