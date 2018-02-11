package com.jiuling.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiuling.core.base.BaseDao;
import com.jiuling.core.base.BaseServiceImpl;
import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.core.util.StringUtils;
import com.jiuling.web.bo.TreeNode;
import com.jiuling.web.constants.CommonConstants;
import com.jiuling.web.dao.CtrlUnitMapper;
import com.jiuling.web.dao.SysDeptMapper;
import com.jiuling.web.dao.SysUserMapper;
import com.jiuling.web.model.CtrlUnit;
import com.jiuling.web.model.CtrlUnitExample;
import com.jiuling.web.model.SysDept;
import com.jiuling.web.model.SysDeptExample;
import com.jiuling.web.model.SysDeptExample.Criteria;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.model.SysUserExample;
import com.jiuling.web.service.DeptService;
/**
 * 组织机构Service实现类
 * @author ShiXt  2016年1月28日
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<SysDept, Long> implements DeptService {
	@Resource
	private SysDeptMapper deptMapper;
	
	@Resource
	private SysUserMapper sysUserMapper;
	
	public BaseDao<SysDept, Long> getDao() {
		 return deptMapper;
	}

	@Resource
    private CtrlUnitMapper ctrlUnitMapper;
	
	@Override
	public void insertDept(SysDept dept) {
		deptMapper.insert(dept);
		
	}
	
	@Override
	public void updateDept(SysDept dept) {
		deptMapper.updateByPrimaryKey(dept);
		
	}

	@Override
	public void deleteDept(Long id) {
		SysDept m = this.selectById(id);
		if(m.getIsLeaf().equals(1)){//叶子节点
			SysDeptExample parentExample = new SysDeptExample();
			Criteria parentCriteria = parentExample.createCriteria();
			parentCriteria.andLongNumberEqualTo(StringUtils.getParentLongNumber(m.getLongNumber(), CommonConstants.MODULE_SPLIT));
			List<SysDept> deptList = deptMapper.selectByExample(parentExample);
			if(deptList.size()>0){
				SysDept parent=deptList.get(0);
				if(parent!=null){
					SysDeptExample isOnlyLeaf = new SysDeptExample();
					isOnlyLeaf.createCriteria().andParentIdEqualTo(parent.getDeptId()).andDeptLevelEqualTo(m.getDeptLevel()).andDeptIdNotEqualTo(id);
					List<SysDept> modules= deptMapper.selectByExample(isOnlyLeaf);
					if(modules.size()==0){//没有其他叶子节点
						parent.setIsLeaf(Long.valueOf(1));
						deptMapper.updateByPrimaryKey(parent);//更新leaf状态
					}
				}
			}
			deptMapper.deleteByPrimaryKey(id);
		}else{//非叶子节点
			SysDeptExample deptExample = new SysDeptExample();
			Criteria criteria = deptExample.createCriteria();
			criteria.andLongNumberLike("%"+m.getLongNumber()+"%");
			List<SysDept> allDepts=deptMapper.selectByExample(deptExample);
			List<Long> ids=new ArrayList<Long>();
			for(SysDept sysDept:allDepts){
				ids.add(sysDept.getDeptId());
			}
			deptExample.clear();
			deptExample.createCriteria().andDeptIdIn(ids);
			deptMapper.deleteByExample(deptExample);
		}
		
	}

	@Override
	public List<SysDept> selectDepts(SysDeptExample sysDeptExample) {
		return null;
	}
	
	@Override
	public List<CtrlUnit> findCtrlUnitByExample(CtrlUnitExample ctrlUnitExample) {
        return ctrlUnitMapper.selectByExample(ctrlUnitExample);
    }

	@Override
	public boolean hasChildren(Long id) {
		SysDeptExample sysDeptExample = new SysDeptExample();
		sysDeptExample.createCriteria().andParentIdEqualTo(id);
		return deptMapper.selectByExample(sysDeptExample).size()>0;
	}
	
	@Override
	public List<SysDept> findActiveChildren(Long level,Long parentId) {
		SysDeptExample sysDeptExample = new SysDeptExample();
		Criteria criteria = sysDeptExample.createCriteria();
		//查詢生效的部门
		criteria.andDeptStateEqualTo(1L);
		if(parentId!=null){
			criteria.andDeptLevelEqualTo(level+1);
			criteria.andParentIdEqualTo(parentId);
		}else{
			criteria.andDeptLevelEqualTo(level);
		}
		return deptMapper.selectByExample(sysDeptExample);
	}

	@Override
	public List<SysDept> findChildren(Long level,Long parentId) {
		SysDeptExample sysDeptExample = new SysDeptExample();
		Criteria criteria = sysDeptExample.createCriteria();
		if(parentId!=null){
			criteria.andDeptLevelEqualTo(level+1);
			criteria.andParentIdEqualTo(parentId);
		}else{
			criteria.andDeptLevelEqualTo(level);
		}
		return deptMapper.selectByExample(sysDeptExample);
	}

	@Override
	public int selectMaxLevel() {
		return 0;
	}

	  /**
     * 分页查询行政区域
     */
	public List<CtrlUnit> selectCtrlUnitsByPage(Page<CtrlUnit> page, String longNumber, String unitName) {
        CtrlUnitExample ctrlUnitExample = new CtrlUnitExample();
        com.jiuling.web.model.CtrlUnitExample.Criteria criteria = ctrlUnitExample.createCriteria();
        if(StringUtils.isNotEmptyString(longNumber)){
            criteria.andLongNumberLike("%"+longNumber+"%");
        }
        if(StringUtils.isNotEmptyString(unitName)){
            criteria.andUnitNameLike("%"+unitName+"%");
        }
        return ctrlUnitMapper.selectByExample(page, ctrlUnitExample);
    }

	@Override
	public List<SysDept> findAllChildren(String deptName) {
		SysDeptExample sysDeptExample = new SysDeptExample();
		Criteria criteria = sysDeptExample.createCriteria();
		criteria.andDisplayNameLike("%"+CommonConstants.SPLIT_CHAR+deptName+"%");
		return deptMapper.selectByExample(sysDeptExample);
	}

	@Override
	public List<SysDept> findAllChildren(Long deptId,SysDept dept) {
		SysDeptExample example = new SysDeptExample();
		List<SysDept> deptList = deptMapper.selectByExample(example);
		fomateDept(deptList, dept);
		List<SysDept> result = dept.getChildren();
		if(result == null){
			result = new ArrayList<SysDept>();
		}
		return result;
	}
	
    private static void fomateDept(List<SysDept> tmp, SysDept dept) {
		for (SysDept row : tmp) {
			if ( row.getParentId()!=null && row.getParentId().equals(dept.getDeptId())) {
				List<SysDept> list = dept.getChildren();
				if (list == null) {
					list = new ArrayList<SysDept>();
				}
				list.add(row);
				dept.setChildren(list);
				fomateDept(tmp, row);
			}
			
		}
	}
	@Override
	public List<SysDept> selectDeptsByPage(Page<SysDept> page, Long parentId, String deptName) {
		SysDeptExample sysDeptExample = new SysDeptExample();
		Criteria criteria = sysDeptExample.createCriteria();
		Criteria criteria2 = sysDeptExample.createCriteria();
		criteria.andDeptStateEqualTo(1L);
		criteria2.andDeptStateEqualTo(1L);
		if(parentId!=null){
			criteria.andParentIdEqualTo(parentId);
			criteria2.andDeptIdEqualTo(parentId);
		}
		if(StringUtils.isNotEmptyString(deptName)){
			criteria.andDeptNameLike("%"+deptName+"%");
			criteria2.andDeptNameLike("%"+deptName+"%");
		}
		sysDeptExample.or(criteria2);
		sysDeptExample.setOrderByClause("dept_number asc");
		return deptMapper.selectByExample(page, sysDeptExample);
	}

	public List<SysUser> selectUsersByOrgPage(Page<SysUser> page,String deptId) {
        SysUserExample sysUserExample = new SysUserExample();
        if(deptId!=null){
            sysUserExample.createCriteria().andDeptIdEqualTo(deptId);
        }
        return sysUserMapper.selectByExample(page, sysUserExample);
    }

	@Override
	public List<SysDept> findChildren(SysDeptExample sysDeptExample) {
		return deptMapper.selectByExample(sysDeptExample);
	}
	

    public boolean hasUnitChildren(String longNumber) {
        CtrlUnitExample ctrlUnitExample = new CtrlUnitExample();
        ctrlUnitExample.createCriteria().andLongNumberLike("%"+longNumber+"%");
        return ctrlUnitMapper.selectByExample(ctrlUnitExample).size()>1;
    }

    public List<CtrlUnit> findUnitChildren(Integer level, String longNumber) {
        CtrlUnitExample ctrlUnitExample = new CtrlUnitExample();
        com.jiuling.web.model.CtrlUnitExample.Criteria criteria = ctrlUnitExample.createCriteria();
        if(longNumber!=null){
            criteria.andUnitLevelEqualTo(level+1);
            criteria.andLongNumberLike("%"+longNumber+"%");
        }else{
            criteria.andUnitLevelEqualTo(level);
        }
        return ctrlUnitMapper.selectByExample(ctrlUnitExample);
    }
    

    public CtrlUnit selectCtrlUnitById(String id) {
        return ctrlUnitMapper.selectByPrimaryKey(Long.valueOf(id));
    }
    

    public void updateCtrlUnit(CtrlUnit ctrlUnit) {
        ctrlUnitMapper.updateByPrimaryKey(ctrlUnit);
        
    }

    public void insertCtrlUnit(CtrlUnit ctrlUnit) {
        ctrlUnitMapper.insert(ctrlUnit);
    }

    public void deleteCtrlUnit(String id) {
        CtrlUnit m = this.selectCtrlUnitById(id);
        if(m.getIsLeaf().equals(1)){//叶子节点
            CtrlUnitExample parentExample = new CtrlUnitExample();
            com.jiuling.web.model.CtrlUnitExample.Criteria parentCriteria = parentExample.createCriteria();
            parentCriteria.andLongNumberEqualTo(StringUtils.getParentLongNumber(m.getLongNumber(), CommonConstants.MODULE_SPLIT));
            List<CtrlUnit> ctrlUnitList = ctrlUnitMapper.selectByExample(parentExample);
            if(ctrlUnitList.size()>0){
                CtrlUnit parent=ctrlUnitList.get(0);
                if(parent!=null){
                    CtrlUnitExample isOnlyLeaf = new CtrlUnitExample();
                    //父类所有下级，排除与本辖区相同等级又非本辖区 
                    isOnlyLeaf.createCriteria().andLongNumberLike("%"+parent.getLongNumber()+"%").andUnitLevelEqualTo(Integer.valueOf(m.getUnitLevel().toString())).andIdNotEqualTo(id);
                    List<CtrlUnit> ctrlUnits=ctrlUnitMapper.selectByExample(isOnlyLeaf);
                    if(ctrlUnits.size()==0){//没有其他叶子节点
                        parent.setIsLeaf(1L);
                        ctrlUnitMapper.updateByPrimaryKey(parent);//更新leaf状态
                    }
                }
            }
            ctrlUnitMapper.deleteByPrimaryKey(Long.valueOf(id));
        }else{//非叶子节点
            CtrlUnitExample ctrlUnitExample = new CtrlUnitExample();
            com.jiuling.web.model.CtrlUnitExample.Criteria criteria = ctrlUnitExample.createCriteria();
            criteria.andLongNumberLike("%"+m.getLongNumber()+"%");
            List<CtrlUnit> allCtrl = ctrlUnitMapper.selectByExample(ctrlUnitExample);
            List<Long> ids=new ArrayList<Long>();
            for(CtrlUnit ctrlUnit:allCtrl){
                ids.add(ctrlUnit.getId());
            }
            ctrlUnitExample.clear();
            ctrlUnitExample.createCriteria().andIdIn(ids);
            ctrlUnitMapper.deleteByExample(ctrlUnitExample);
        }
        
    }
	
    @Override
    public List<CtrlUnit> selectCtrlUnitByExample(CtrlUnitExample example) {
        return ctrlUnitMapper.selectByExample(example);
    }
    
    @Override
    public SysDept selectById(Long id){
    	return deptMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 根据部门编号
     * @return
     */
    @Override
    public SysDept selectByDeptNumber(String deptNumber,boolean isActive)
    {
        SysDept sysDept = new SysDept();
        SysDeptExample example = new SysDeptExample();
        com.jiuling.web.model.SysDeptExample.Criteria criteria = example.createCriteria();
        criteria.andDeptNumberEqualTo(deptNumber);
        if (isActive)
        {
        	criteria.andDeptStateEqualTo(1L);
        }
      
       List<SysDept> list = deptMapper.selectByExample(example);
       
       if (null != list && list.size() > 0) {
           sysDept = list.get(0);
       }
        return sysDept;
    }
    
    public SysDept selectByDeptName(String deptName,boolean isActive) {
        SysDeptExample example = new SysDeptExample();
        com.jiuling.web.model.SysDeptExample.Criteria criteria = example.createCriteria();
        criteria.andDeptNameEqualTo(deptName);
        if (isActive)
        {
        	criteria.andDeptStateEqualTo(1L);
        }
        List<SysDept> listDept = deptMapper.selectByExample(example);
        if (listDept.size() > 0) {
            return listDept.get(0);
        }
        return null;
    }
    
    /**
	 * 查询警察局节点
	 */
	@Override
	public List<SysDept> findPoliceStationChildren(Long level, Long parentId) {
		SysDeptExample sysDeptExample = new SysDeptExample();
		Criteria criteria = sysDeptExample.createCriteria();
		//查詢生效的部门
//		criteria.andDeptStateEqualTo(1L);
		if(parentId != null){
			criteria.andDeptLevelEqualTo(level+1);
			criteria.andParentIdEqualTo(parentId);
		}else{
			criteria.andDeptLevelEqualTo(level);
		}
		List<SysDept> rstListDept = new ArrayList<SysDept>();
		List<SysDept> listDept = deptMapper.selectByExample(sysDeptExample);
		for(int i = 0; i < listDept.size() ; i ++){
			SysDept dept = listDept.get(i);
			if(level == 1){
				if(dept.getDeptName().contains("分局") 
						&& !dept.getDeptName().contains("直属分局")){
					rstListDept.add(dept);
				}
			}else if(level == 2){
				if(dept.getDeptName().contains("派出所")){
					rstListDept.add(dept);
				}
			}
		}
		return rstListDept;
	}
	
	/**
     * 根据pid查询当前节点的所有子节点
     * @param pid
     * @return
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<TreeNode> queryChildTreeNode(String pid) {
		Map map = new HashMap();
		map.put("pid", pid);
		List<TreeNode> list = new ArrayList<TreeNode>();
		List<CtrlUnit> reList= ctrlUnitMapper.queryChildTreeNode(map);
		for (CtrlUnit ctrlUnit : reList) {
			TreeNode node = new TreeNode();
			node.setId(ctrlUnit.getUnitIdentity());
			//node.setLevel(String.valueOf(ctrlUnit.getUnitLevel()));
			node.setpId(StringUtils.isEmptyString(ctrlUnit.getUnitParentId())?"0":ctrlUnit.getUnitParentId());
			
			node.setName(ctrlUnit.getDisplayName());
			list.add(node);
		}
		return list;
	}

	/**
	 * 根据节点id查询节点信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public TreeNode getTreeNode(String id) {
		Map map = new HashMap();
		map.put("id", id);
		TreeNode node = new TreeNode();
		List<CtrlUnit> reList= ctrlUnitMapper.getTreeNode(map);
		if(reList!=null &&reList.size()==1){
			for (CtrlUnit ctrlUnit : reList) {
				node.setId(ctrlUnit.getUnitIdentity());
				//node.setLevel(String.valueOf(ctrlUnit.getUnitLevel()));
				node.setpId(StringUtils.isEmptyString(ctrlUnit.getUnitParentId())?"0":ctrlUnit.getUnitParentId());
				node.setName(ctrlUnit.getDisplayName());
			}
		}
		return node;
	}

	/**
	 * 查询长沙下面所有节点
	 */
	@Override
	public List<TreeNode> initTreeNode() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		List<CtrlUnit> reList= ctrlUnitMapper.initTreeNode();
		for (CtrlUnit ctrlUnit : reList) {
			TreeNode node = new TreeNode();
			node.setId(ctrlUnit.getUnitIdentity());
			node.setUnitLevel(String.valueOf(ctrlUnit.getUnitLevel()));
			node.setpId(StringUtils.isEmptyString(ctrlUnit.getUnitParentId())?"0":ctrlUnit.getUnitParentId());
			node.setName(ctrlUnit.getDisplayName());
			node.setIsParent(ctrlUnit.getIsLeaf()==1?false:true);
			list.add(node);
		}
		return list;
	}

	/**
	 * 分页查询行政区域
	 */
	@Override
	public List<CtrlUnit> selectCtrlUnitsByPageNew(Page<CtrlUnit> page, String pid, String level) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pid",pid);
		map.put("level",level);
		
		return ctrlUnitMapper.selectCtrlUnitsByPageNew(page,map);
	}

	
}
