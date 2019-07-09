package com.zys.boot;

import com.alibaba.fastjson.JSON;
import com.zys.boot.base.utils.EmailUtil;
import com.zys.boot.email.vo.EmailSend;
import com.zys.boot.user.entity.User;
import com.zys.boot.user.model.TraffInVo;
import com.zys.boot.user.model.VoiceTraffDTO;
import com.zys.boot.user.service.GetTraffSetInfo;
import com.zys.boot.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {
    @Autowired
    private GetTraffSetInfo getTraffSetInfo;
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void TestUser() {
        User user = new User();
        user.setEmail("15626183846@163.com");
        user.setUserName("zys");
        List<User> userList = userService.seleteByInfo(user);
        System.out.println(userList.toString());
    }

    @Test
    public void TestCard() throws Exception {
        TraffInVo traffInVo = new TraffInVo();
        traffInVo.setVin("LGXCBFDG1G2679927");
        List<VoiceTraffDTO> cardInfoList = getTraffSetInfo.getTarffInfo(traffInVo);
        System.out.println("前端展示" + JSON.toJSONString(cardInfoList.get(0)));
    }

    @Test
    public void TestEmail() throws Exception {
        // EmailUtil emailUtil = new EmailUtil();
        String to = "zhangyusheng@utry.cn";

        String content = UUID.randomUUID().toString().substring(0, 6) + "测试多收件人";
        try {
            EmailUtil.send_mail(to, content);
            System.out.println("邮件发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSend() {
        EmailSend emailSend = new EmailSend();
        emailSend.setId("111");
        emailSend.setContent("最后终结者 测试内容");
        emailSend.setTitle("最终测主题");
        emailSend.setToUsers("15626183846@163.com");
      //  mailSender.send(emailSend);
    }

}
