/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.model.MemberPO;


/**  
 *<p> member服务类</p>
 *@Author:Yips
 *@Since:2017年1月5日 上午9:17:04 
 *@Version:1.1.0  
 */
public interface MemberService {
 
    /**
     * <p>保存member对象 </p>
     * @param memberPO
     * @return  
     * @throws
     */
    MemberPO save ( MemberPO memberPO);
    
    /**
     * 
     * <p>更新对象 </p>
     * @param memberPO
     * @return  
     * @throws
     */
    int update ( MemberPO memberPO);
    
    /**
     * 
     * <p> 根据ID删除对象</p>
     * @param memberId
     * @return  
     * @throws
     */
    int deleteById ( String memberId);
    
    /**
     * <p> 根据ID获取对象</p>
     * @param memberId
     * @return  
     * @throws
     */
    MemberPO getMemberById ( String memberId);
    
    /**
     * 
     * <p>获取所有对象列表 </p>
     * @return  
     * @throws
     */
    List<MemberPO> getMemberList ();
    
    /**
     * <p> 多条件组合获取对象列表</p>
     * @param param
     * @return  
     * @throws
     */
    List<MemberPO> getMemberListByParam ( Map<String,Object> param);
}
