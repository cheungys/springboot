package com.zys.boot;

import com.alibaba.fastjson.JSON;
import com.zhenzi.sms.ZhenziSmsClient;
import com.zys.boot.base.utils.EmailUtil;
import com.zys.boot.email.vo.EmailSend;
import com.zys.boot.message.entity.Message;
import com.zys.boot.message.service.SendMessageService;
import com.zys.boot.sys.config.redis.RedisUtil;
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
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {
    @Autowired
    private GetTraffSetInfo getTraffSetInfo;
    @Autowired
    private UserService userService;
    @Autowired
    private SendMessageService sendMessageService;
    @Autowired
    private RedisUtil redisUtil;

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

    @Test
    public void testSendMessage() {
        Message message = new Message();
        message.setReceives("15626183846");
        message.setContent("您正在登录验证，验证码为：451228,请在5分钟内按页面提示提交验证码，切勿将验证码泄露于他人。\n");
        if (sendMessageService.sendMessage(message)) {
            System.out.println("发送短信成功了");
        } else {
            System.out.println("发送失败");
        }
    }

    @Test
    public void tttt() {
        DecimalFormat df = new DecimalFormat("0000");

        String str2 = df.format(12);

        System.out.println(str2);
    }
    @Test
    public void testRedis() {
        redisUtil.del("zys","zys1111","zys888");

    }
}
