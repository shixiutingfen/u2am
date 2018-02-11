package com.jiuling.web.service;

import java.util.List;

import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.web.bo.TreeNode;
import com.jiuling.web.model.CtrlUnit;
import com.jiuling.web.model.CtrlUnitExample;
import com.jiuling.web.model.SysDept;
import com.jiuling.web.model.SysDeptExample;
import com.jiuling.web.model.SysUser;

public interface DeptService {
	/**
	 * 新增部门
	 */
	 void insertDept(SysDept dept);

	/**
	 * 修改部门
	 */
	 void updateDept(SysDept dept);
	 /**
	  * 删除部门By id
	  */
	 void deleteDept(Long id);
	 /**
	  * 查询部门
	  */
	 List<SysDept> selectDepts(SysDeptExample sysDeptExample);
	 /**
	  * 是否有子部门
	  */
	 boolean hasChildren(Long id);
	 /**
	  * 查询所有子部门
	  */
	 List<SysDept> findChildren(Long level,Long parentId);
	 /**
	  * 查询所有子部门
	  */
	 List<SysDept> findChildren(SysDeptExample sysDeptExample);
	 /**
	  * 查询所有子部门（包括下级和下级的下级）
	  */
	 List<SysDept> findAllChildren(String deptName);
	 /**
	  * 
	  */
	 List<SysDept> findAllChildren(Long deptId,SysDept dept);
	 /**
	  * 根据id查询部门
	  */
	 SysDept selectById(Long id);
	 
	 /**
	  * 根据部门编号
	  * @return
	  */
	 SysDept selectByDeptNumber(String deptNumber,boolean isActive);
	 /**
	  * 获取最大级别菜单
	  */
	 int selectMaxLevel();
	 /**
	  * 分页查询部门
	  */
	 List<SysDept> selectDeptsByPage(Page<SysDept> page,Long parentId,String deptName);
	 
	 SysDept selectByDeptName(String deptName,boolean isActive);
     
	 /**
	  * 分页根据部门查询用户
	  */
	 List<SysUser> selectUsersByOrgPage(Page<SysUser> page,String deptId);
	 
	
	   /**
      * 分页查询行政区域
      */
     List<CtrlUnit> selectCtrlUnitsByPage(Page<CtrlUnit> page,String longNumber,String unitName);
     
	 /**
      * 根据id查询辖区
      */
     CtrlUnit selectCtrlUnitById(String id);
	 
	   /**
      * 是否有子辖区
      */
     boolean hasUnitChildren(String  longNumber);
     
       /**
      * 查询所有子辖区
      */
     List<CtrlUnit> findUnitChildren(Integer level,String longNumber);
     
     /**
      * 根据example查询所有辖区
      */
     List<CtrlUnit> selectCtrlUnitByExample(CtrlUnitExample example);
     
     /**
      * 更新辖区
      */
     void updateCtrlUnit(CtrlUnit ctrlUnit);
     /**
      * 新增辖区
      */
     void insertCtrlUnit(CtrlUnit ctrlUnit);
     /**
      * 删除辖区
      */
     void deleteCtrlUnit(String id);
     
     /**
      * 根据条件查询
      */
     List<CtrlUnit> findCtrlUnitByExample(CtrlUnitExample ctrlUnitExample);
     
     List<SysDept> findActiveChildren(Long level,Long parentId);
     
     /**
      * 查询警察局 子节点
      * @param level
      * @param parentId
      * @return
      */
 	 List<SysDept> findPoliceStationChildren(Long level, Long parentId);
 	 
 	 
     /**
      * 根据节点id查询节点信息
      * @param id
      * @return
      */
     TreeNode getTreeNode(String id);
     
     /**
      * 根据pid查询当前节点的所有子节点
      * @param pid
      * @return
      */
     List<TreeNode> queryChildTreeNode(String pid);
     
     /**
      * 查询长沙下面所有行政区域节点
      * @param pid
      * @return
      */
     List<TreeNode> initTreeNode();
     
     /**
      * 分页查询行政区域
      */
     List<CtrlUnit> selectCtrlUnitsByPageNew(Page<CtrlUnit> page,String pid, String level);
}
