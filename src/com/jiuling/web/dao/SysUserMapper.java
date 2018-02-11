package com.jiuling.web.dao;

import com.jiuling.core.base.BaseDao;
import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.web.bo.UserBo;
import com.jiuling.web.model.SysRole;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.model.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper  extends BaseDao<SysUser, Long>{
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);
    
    List<SysUser> selectOthersUsers(Long userId);

    SysUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    

    /**
     * �û���¼��֤��ѯ
     * 
     * @param record
     * @return
     */
    SysUser authentication(@Param("record") SysUser record);
    
    /**
     * ��ҳ��ѯ
     * @param page
     * @param example
     * @return
     */
    List<SysUser> selectByExample(Page<SysUser> page,SysUserExample example);
    
    /**
     * ��ҳ������ѯ
     * 
     * @param page
     * @param example
     * @return
     */
    List<UserBo> selectByExampleAndPage(Page<UserBo> page, @Param("record") SysUser record);
    
    
    /**
     * ��ҳ��ѯ�û���Ϣ ������sys_UserRole��
     * 
     * @param page
     * @param example
     * @return
     */
    List<UserBo> selectUsersByPage(Page<UserBo> page, @Param("record") SysUser record);
    /**
     * �ؼ��ֲ�ѯ 
     * @param searchKey �û��� ��ʵ����
     * @return
     */
    List<SysUser> selectBySearchKey(@Param("searchKey")String searchKey);
    
    List<UserBo>  selectByimg(UserBo userBo);
    
    UserBo selectReportor(Long userId);
    /**
     * 根据角色id查询角色信息
     * @param roleId
     * @return
     */
	SysRole selectByRoleId(Long roleId);
    
}