/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.MemberPO;



/**  
 *<p> </p>
 *@Author:Yips
 *@Since:2017年1月6日 上午10:04:22 
 *@Version:1.1.0  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    
    @Test
    public void save () {
        MemberPO  po = new MemberPO();
        po.setBirthday(new Date());
        po.setMobile("13392368845");
        po.setName("testN234ame");
        po.setRemark("asdfsdf");
        memberService.save(po);
        //System.out.println("=====>" + JSON.toJSONString(po));
    }
    //4330d1d5-d3b5-11e6-b36f-f48e38ad3930
    /**
     * 
     * <p> </p>  
     * @throws
     */
    @Test
    public void update () {
        MemberPO  po = new MemberPO();
        po.setMemberId("4330d1d5-d3b5-11e6-b36f-f48e38ad3930");
        po.setMobile("13392368848");
        int result =memberService.update(po);
        System.out.println("====>" + result);
    }
    
    @Test
    public void delete () {
        String id = "4330d1d5-d3b5-11e6-b36f-f48e38ad3930";
        int resutl = memberService.deleteById(id);
        System.out.println("====>" + resutl);
    }
    
    @Test
    public void getMemberList () {
        
    }
}
