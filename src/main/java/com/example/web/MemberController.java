/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MemberPO;
import com.example.service.MemberService;

/**  
 *<p> </p>
 *@Author:Yips
 *@Since:2017年1月20日 下午2:38:22 
 *@Version:1.1.0  
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
    @Autowired
    private MemberService memberService;

    @RequestMapping(value="/save", method = {RequestMethod.POST,RequestMethod.GET})
   public String saveMember(){
        logger.info("=====>  save member info");
        MemberPO  po = new MemberPO();
        po.setBirthday(new Date());
        po.setMobile("18000000000");
        po.setName("Test");
        po.setRemark("@#$%^&##%#");
        po = memberService.save(po);
        if ( !StringUtils.isEmpty( po.getMemberId()) ) {
            return "OK";
        }else {
            return "Error";
        }
   }
    
}
