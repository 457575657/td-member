/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.config.DataSource;
import com.example.dao.MemberDAO;
import com.example.model.MemberPO;
import com.example.service.MemberService;



/**  
 *<p> </p>
 *@Author:Yips
 *@Since:2017年1月5日 上午9:33:54 
 *@Version:1.1.0  
 */
@Service("memberService")
public class MemberServiceimpl implements MemberService {
    
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
    
    @Autowired
    private MemberDAO memberDAO;
    
    @Override
    @DataSource("writeDataSource")
    @Transactional(rollbackFor={Exception.class})
    public MemberPO save(MemberPO memberPO) {
        try {
            memberDAO.save(memberPO);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("save Exception ====>",e);
        }  
        return memberPO;
    }

    @Override
    @DataSource("writeDataSource")
    @Transactional(rollbackFor={Exception.class})
    public int update(MemberPO memberPO) {
        int result = -1;
        
        try {
             result =   memberDAO.update(memberPO);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("update Exception ====>",e);
        }
        return result;
    }

    @Override
    @DataSource("writeDataSource")
    public int deleteById(String memberId) {
        int result = -1;
        try {
            result = memberDAO.delete(memberId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("delete Exception ====>",e);
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    @DataSource("readDataSource")
    public MemberPO getMemberById(String memberId) {
        MemberPO po = null;
        try {
            po = memberDAO.queryById(memberId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("delete Exception ====>",e);
        }
        return po;
    }

   @Override
   @DataSource("readDataSource")
    @Transactional( readOnly = true)
    public List<MemberPO> getMemberList() {
        List<MemberPO> list = null;
        try {
            list = memberDAO.queryList();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("delete Exception ====>",e);
        }
        return list;
    }

        
    @Override
    @Transactional
    @DataSource("readDataSource")
    public List<MemberPO> getMemberListByParam(Map<String, Object> param) {
        List<MemberPO> list = null;
        try {
            list = memberDAO.queryListByParam(param);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("delete Exception ====>",e);
        }
        return list;
    }




}
