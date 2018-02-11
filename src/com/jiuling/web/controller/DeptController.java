package com.jiuling.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.core.util.ContxtUtils;
import com.jiuling.core.util.EhcacheUtils;
import com.jiuling.core.util.StringUtils;
import com.jiuling.web.constants.CacheItemConstants;
import com.jiuling.web.constants.CommonConstants;
import com.jiuling.web.model.CtrlUnit;
import com.jiuling.web.model.CtrlUnitExample;
import com.jiuling.web.model.SysDept;
import com.jiuling.web.model.SysDeptExample;
import com.jiuling.web.model.SysDeptExample.Criteria;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.model.SysUserExample;
import com.jiuling.web.service.DeptService;
import com.jiuling.web.service.UserService;

/**
 * 部门控制器(测)
 * 
 * @author ShiXt 2016年1月28日
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
	@Resource
	private DeptService deptService;
	@Resource
	private UserService userService;

	/**
	 * 跳转部门列表
	 * 
	 * @return
	 */
	@RequestMapping("deptManage")
	public ModelAndView listModules(Model m) {
		m.addAttribute("currentDeptId", ContxtUtils.getUserSession().getDeptId());
		m.addAttribute("currentUserName", ContxtUtils.getUserSession().getUsername());
		return new ModelAndView("systemsettings/deptList");
	}

	@RequestMapping("toorg")
	public ModelAndView toorg(String element, Model m) {
		m.addAttribute("element", element);
		return new ModelAndView("common/org");
	}

	/**
	 * 跳转公共根据部门查询用户页面
	 * 
	 * @return
	 */
	@RequestMapping("getUsersOrg")
	public ModelAndView getUsersOrg(HttpServletRequest request, Object preLoadDatas) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (preLoadDatas.equals(null)) {
			map.put("preLoadDatas", preLoadDatas);
		}
		return new ModelAndView("common/userOrg", map);
	}

	/**
	 * 跳转辖区管理
	 * 
	 * @return
	 */
	@RequestMapping("ctrlUnitManage")
	public ModelAndView ctrlUnitManage() {
		return new ModelAndView("systemsettings/ctrlUnitList");
	}

	/**
	 * 跳转行政区域查询页面
	 * 
	 * @return
	 */
	@RequestMapping("getCtrlUnit")
	public ModelAndView getCtrlUnit(HttpServletRequest request, String type, Model m, String index, String element) {
		m.addAttribute("type", type);
		m.addAttribute("index", index);
		m.addAttribute("element", element);
		return new ModelAndView("common/ctrlUnit");
	}

	/**
	 * 组织机构查询带分页
	 * 
	 * @param name
	 * @param sex
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/queryCtrlUnitByPage")
	@ResponseBody
	public Map<String, Object> queryCtrlUnitByPage(HttpServletRequest request, String longNumber, String unitName) {
		String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
		String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
		Page<CtrlUnit> pages = new Page<CtrlUnit>(Integer.parseInt(page), Integer.parseInt(rows));
		deptService.selectCtrlUnitsByPage(pages, longNumber, unitName);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", pages.getResult());// 列表数据
		result.put("total", pages.getTotalPages());// 总页数
		result.put("records", pages.getTotalCount());// 总记录数
		return result;
	}

	/**
	 * 获取部门和用户
	 * 
	 * @param parentId父菜单id
	 * 
	 * @RequestMapping(value = "/getOrgPersonTree")
	 * @ResponseBody public List<Map> getOrgPersonTree(HttpServletRequest
	 *               request,String parentId,String searchKey) throws Exception
	 *               { List<Map<String, Object>> listData = new
	 *               ArrayList<Map<String, Object>>(); List<Map> resultList =
	 *               new ArrayList(); if (parentId == null ||
	 *               "null".equals(parentId)) { SysDeptExample sysDeptExample =
	 *               new SysDeptExample(); SysUserExample userExample = new
	 *               SysUserExample();
	 *               com.jiuling.web.model.SysUserExample.Criteria userCritia =
	 *               userExample.createCriteria(); Criteria criteriaDept =
	 *               sysDeptExample.createCriteria();
	 *               criteriaDept.andDeptLevelEqualTo(1);
	 *               if(StringUtils.isNotEmptyString(searchKey)) {
	 *               criteriaDept.andDeptNameLike("%"+searchKey+"%");
	 *               userCritia.andRealNameLike("%"+searchKey+"%"); }
	 * 
	 *               List<SysDept> orgs = this.deptService.findChildren(1,null);
	 *               //List<SysDept> orgs =
	 *               deptService.findChildren(sysDeptExample); for(SysDept org :
	 *               orgs){ Map orgMap = getOrgTreeNode(org, false);
	 *               resultList.add(orgMap); }
	 * 
	 * 
	 *               List<SysUser> persons =
	 *               userService.selectUsers(userExample); for(SysUser person :
	 *               persons){ Map personMap = getPersonTreeNode(person);
	 *               resultList.add(personMap); } } else { SysDept parentDept =
	 *               this.deptService.selectById(Long.parseLong(parentId)); List
	 *               <SysDept> orgs =
	 *               this.deptService.findChildren(parentDept.getDeptLevel(),
	 *               Long.parseLong(parentId)); for(SysDept org : orgs){ Map
	 *               orgMap = getOrgTreeNode(org, true); resultList.add(orgMap);
	 *               } SysUserExample userExample = new SysUserExample();
	 *               com.jiuling.web.model.SysUserExample.Criteria userCritia =
	 *               userExample.createCriteria(); List<SysUser> persons =
	 *               userService.selectUsers(userExample); for(SysUser person :
	 *               persons){ Map personMap = getPersonTreeNode(person);
	 *               resultList.add(personMap); } } return resultList; }
	 */
	/**
	 * 获取部门和用户
	 * 
	 * @param parentId父菜单id
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getOrgPersonTree")
	@ResponseBody
	public List<Map> getOrgPersonTree(HttpServletRequest request, String parentId, String searchKey, String type)
			throws Exception {
		List<Map> resultList = new ArrayList();
		if (StringUtils.isEmptyString(parentId) || parentId.equals("null")) {// 没传入rootNode的id
			if (StringUtils.isNotEmptyString(searchKey)) {// 使用快速搜索，返回普通列表
				SysDeptExample sysDeptExample = new SysDeptExample();
				Criteria criteriaDept = sysDeptExample.createCriteria();
				SysUserExample userExample = new SysUserExample();
				com.jiuling.web.model.SysUserExample.Criteria userCritia = userExample.createCriteria();
				if (StringUtils.isNotEmptyString(searchKey)) {
					criteriaDept.andDeptNameLike("%" + searchKey + "%");
					userCritia.andRealNameLike("%" + searchKey + "%");
				}
				List<SysDept> orgs = deptService.findChildren(sysDeptExample);
				for (SysDept org : orgs) {
					Map orgMap = getOrgTreeNode(org, false);
					resultList.add(orgMap);
				}
				SysUser sysUser = ContxtUtils.getUserSession();
				List<SysUser> persons = userService.selectUsers(userExample);
				if (StringUtils.isNotEmptyString(type)) {
					for (SysUser person : persons) {
						Map personMap = getPersonTreeNode(person);
						Long userid = sysUser.getUserId();
						Long userids = person.getUserId();
						if (person.isDeptAdmin() && !userid.equals(userids)) {
							resultList.add(personMap);
						}
					}
				} else {
					for (SysUser person : persons) {
						Map personMap = getPersonTreeNode(person);
						resultList.add(personMap);
					}
				}
			} else {// 读取所有根节点

				List<SysDept> orgs = this.deptService.findChildren(Long.parseLong("1"), null);
				for (SysDept org : orgs) {
					Map orgMap = getOrgTreeNode(org, true);
					resultList.add(orgMap);
				}
			}

		} else {// 读取parentId节点下的组织节点和用户
			SysDept parentDept = this.deptService.selectById(Long.parseLong(parentId));
			List<SysDept> orgs = this.deptService.findActiveChildren(parentDept.getDeptLevel(), Long.parseLong(parentId));
			for (SysDept org : orgs) {
				Map orgMap = getOrgTreeNode(org, true);
				resultList.add(orgMap);
			}
			SysUserExample userExample = new SysUserExample();
			com.jiuling.web.model.SysUserExample.Criteria userCritia = userExample.createCriteria();
			userCritia.andDeptIdEqualTo(parentDept.getDeptNumber());
			SysUser sysUser = ContxtUtils.getUserSession();
			List<SysUser> persons = userService.selectUsers(userExample);
			if (StringUtils.isNotEmptyString(type)) {
				for (SysUser person : persons) {
					Map personMap = getPersonTreeNode(person);
					Long userid = sysUser.getUserId();
					Long userids = person.getUserId();
					if (person.isDeptAdmin() && !userid.equals(userids)) {
						resultList.add(personMap);
					}
				}
			} else {
				for (SysUser person : persons) {
					Map personMap = getPersonTreeNode(person);
					resultList.add(personMap);
				}
			}
		}

		return resultList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map getPersonTreeNode(SysUser person) {
		Map personMap = new HashMap();
		personMap.put("id", person.getUserId());
		String name = person.getRealName();
		personMap.put("name", name);
		personMap.put("type", "person");
		personMap.put("state", "open");
		return personMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map getOrgTreeNode(SysDept org, boolean isClosed) {
		Map orgMap = new HashMap();
		orgMap.put("id", org.getDeptId());
		String DeptName;
		if (org.getDeptName().length() > 10) {
			DeptName = "<span title=\"" + org.getDeptName() + "\">" + org.getDeptName()+ "<span>";
		} else {
			DeptName = "<span title=\"" + org.getDeptName() + "\">" + org.getDeptName() + "<span>";
		}
		orgMap.put("name", DeptName);
		orgMap.put("type", "org");
		orgMap.put("deptNumber", org.getDeptNumber());
		if (isClosed) {
			orgMap.put("state", "closed");
		} else {
			orgMap.put("state", "open");
		}

		return orgMap;
	}

	/**
	 * 新增辖区 先判断新增的部门是在上级基础上还是根结点
	 * 如果是在上级基础上新增，则先查出上级部门，先判断上级部门是否为叶子节点，如果是叶子节点，则更改上级状态为非叶子节点，设置部门相关参数
	 * 
	 */
	@RequestMapping(value = "/saveCtrl")
	@ResponseBody
	public Map<String, Object> saveCtrl(HttpServletRequest request, CtrlUnit ctrlUnit, String parentId) {
		Map<String, Object> m = new HashMap<String, Object>();
		Long ctrlId = System.currentTimeMillis();
		String unitNumber = String.valueOf(new Random().nextInt(100000000));
		CtrlUnit parentCtrlUnit = null;
		try {
			while (true) {
				CtrlUnitExample example = new CtrlUnitExample();
				example.createCriteria().andUnitNumberEqualTo(unitNumber);
				List<CtrlUnit> ctrlUnits = deptService.selectCtrlUnitByExample(example);
				if (ctrlUnits.size() > 0) {
					unitNumber = String.valueOf(new Random().nextInt(100000000));
				} else {
					break;
				}
			}

			if (parentId != null) {
				parentCtrlUnit = deptService.selectCtrlUnitById(parentId);
			}
			if (parentCtrlUnit != null) {// 有上级
				if (parentCtrlUnit.getIsLeaf() == 1) {// 父级是叶子节点
					parentCtrlUnit.setIsLeaf(0L);
					deptService.updateCtrlUnit(parentCtrlUnit);// 更新父级节点状态
				}
				ctrlUnit.setUnitLevel(parentCtrlUnit.getUnitLevel() + 1);
				if (StringUtils.isNotEmptyString(unitNumber)) {
					ctrlUnit.setLongNumber(parentCtrlUnit.getLongNumber() + CommonConstants.SPLIT_CHAR + unitNumber);
				}
				ctrlUnit.setDisplayName(ctrlUnit.getUnitName());

			} else {// 无上级
				ctrlUnit.setUnitLevel(1L);
				ctrlUnit.setLongNumber(unitNumber);
				ctrlUnit.setDisplayName(ctrlUnit.getUnitName());
			}
			ctrlUnit.setUnitIdentity(unitNumber);
			ctrlUnit.setIsLeaf(1L);// 新增的模块都为叶子节点
			ctrlUnit.setId(ctrlId);
			ctrlUnit.setUnitState(1L);
			ctrlUnit.setUnitNumber(unitNumber);
			deptService.insertCtrlUnit(ctrlUnit);
			// 清理缓存
			EhcacheUtils.removeItem("CTRL_UNIT");
			EhcacheUtils.removeItem("CTRL_UNIT_1");

			// 同步区域到车辆系统
			// synCarArea(ctrlUnit, parentCtrlUnit);

			m.put("state", true);

		} catch (Exception e) {
			e.printStackTrace();
			m.put("state", false);
			m.put("msg", e.getMessage());
		}
		return m;
	}

	/**
	 * 获取辖区
	 * 
	 * @param parentId父菜单id
	 */
	@RequestMapping(value = "/getCtrlTree/{parentId}")
	@ResponseBody
	public List<Map<String, Object>> getCtrlTree(HttpServletRequest request, @PathVariable("parentId") String parentId)
			throws Exception {
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
		if (parentId == null || "null".equals(parentId)) {
			List<CtrlUnit> mList = this.deptService.findUnitChildren(1, null);
			listData = bulidCtrlTree(mList);
		} else {
			CtrlUnit parentCtrlUnit = this.deptService.selectCtrlUnitById(parentId);
			Integer unitLevel = new Integer(parentCtrlUnit.getUnitLevel() + "");
			List<CtrlUnit> mList = this.deptService.findUnitChildren(unitLevel, parentCtrlUnit.getLongNumber());
			listData = bulidCtrlTree(mList);
		}
		return listData;
	}

	/**
	 * 构建辖区树
	 * 
	 * @param tlist
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, Object>> bulidCtrlTree(List<CtrlUnit> tlist) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (CtrlUnit ctrl : tlist) {
			Map<String, Object> treeNode = new HashMap<String, Object>();
			treeNode.put("id", ctrl.getId());
			treeNode.put("unitName", ctrl.getUnitName());
			treeNode.put("unitDescription", ctrl.getUnitDescription());
			treeNode.put("unitNumber", ctrl.getUnitNumber());
			treeNode.put("unitState", ctrl.getUnitState());
			treeNode.put("unitLevel", ctrl.getUnitLevel());
			treeNode.put("longNumber", ctrl.getLongNumber());
			if (this.deptService.hasUnitChildren(ctrl.getLongNumber())) {
				treeNode.put("state", "closed");
			} else {
				treeNode.put("state", "open");
			}
			list.add(treeNode);
		}
		return list;
	}

	/**
	 * 获取部门
	 * 
	 * @param parentId父菜单id
	 */
	@RequestMapping(value = "/getActiveTree/{parentId}")
	@ResponseBody
	public List<Map<String, Object>> getActiveTree(HttpServletRequest request,
			@PathVariable("parentId") String parentId) throws Exception {
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
		if (parentId == null || "null".equals(parentId)) {
			List<SysDept> mList = this.deptService.findActiveChildren(Long.parseLong("1"), null);
			listData = bulidTree(mList);
		} else {
			SysDept parentDept = this.deptService.selectById(Long.parseLong(parentId));
			List<SysDept> mList = this.deptService.findActiveChildren(parentDept.getDeptLevel(),
					Long.parseLong(parentId));
			listData = bulidTree(mList);
		}
		return listData;
	}

	/**
	 * 获取部门
	 * 
	 * @param parentId父菜单id
	 */
	@RequestMapping(value = "/getTree/{parentId}")
	@ResponseBody
	public List<Map<String, Object>> moduleTree(HttpServletRequest request, @PathVariable("parentId") String parentId)
			throws Exception {
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
		if (parentId == null || "null".equals(parentId)) {
			List<SysDept> mList = this.deptService.findChildren(Long.parseLong("1"), null);
			listData = bulidTree(mList);
		} else {
			SysDept parentDept = this.deptService.selectById(Long.parseLong(parentId));
			List<SysDept> mList = this.deptService.findChildren(parentDept.getDeptLevel(), Long.parseLong(parentId));
			listData = bulidTree(mList);
		}
		return listData;
	}

	/**
	 * 获取部门
	 * 
	 * @param parentId父菜单id
	 */
	@RequestMapping(value = "/getcurrtTree/{parentId}")
	@ResponseBody
	public List<Map<String, Object>> getcurrtTree(HttpServletRequest request, @PathVariable("parentId") String parentId)
			throws Exception {
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();

		if (StringUtils.isNotEmptyString(parentId)) {
			SysDept parentDept = this.deptService.selectById(Long.parseLong(parentId));
			List<SysDept> mList = new ArrayList<>();
			mList.add(parentDept);
			listData = bulidTree(mList);
		}
		return listData;
	}

	/**
	 * 跳转部门列表(当前用户部门)
	 * 
	 * @return
	 */
	@RequestMapping("currentDeptTree")
	public ModelAndView currentDeptTree(Model m) {
		SysUser user = ContxtUtils.getUserSession();

		if (null != user && StringUtils.isNotEmptyString(user.getDeptId())) {
			SysDept deptinfo = deptService.selectByDeptNumber(user.getDeptId(), true);
			if (null != deptinfo) {
				m.addAttribute("deptId", deptinfo.getDeptId());
			}
		}
		return new ModelAndView("common/currentOrg");
	}

	/**
	 * 跳转部门列表(所有部门)
	 * 
	 * @return
	 */
	@RequestMapping("currentAllDeptTree")
	public ModelAndView currentAllDeptTree(Model m) {
		SysDept deptinfo = deptService.selectByDeptNumber("430100000000", true);
		if (null != deptinfo) {
			m.addAttribute("deptId", deptinfo.getDeptId());
		}
		return new ModelAndView("common/currentOrg");
	}

	/**
	 * 构建树
	 * 
	 * @param tlist
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, Object>> bulidTree(List<SysDept> tlist) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (SysDept dept : tlist) {
			Map<String, Object> treeNode = new HashMap<String, Object>();
			treeNode.put("deptId", dept.getDeptId());
			treeNode.put("deptName", dept.getDeptName());
			treeNode.put("description", dept.getDescription());
			treeNode.put("parentId", dept.getParentId());
			treeNode.put("deptNumber", dept.getDeptNumber());
			treeNode.put("deptState", dept.getDeptState());
			treeNode.put("tel", dept.getTel());
			treeNode.put("deptLevel", dept.getDeptLevel());
			if (this.deptService.hasChildren(dept.getDeptId())) {
				treeNode.put("state", "closed");
			} else {
				treeNode.put("state", "open");
			}
			list.add(treeNode);
		}
		return list;
	}

	/**
	 * 新增组织机构 先判断新增的部门是在上级基础上还是根结点
	 * 如果是在上级基础上新增，则先查出上级部门，先判断上级部门是否为叶子节点，如果是叶子节点，则更改上级状态为非叶子节点，设置部门相关参数
	 * 
	 */
	@RequestMapping(value = "/saveDept")
	@ResponseBody
	public Map<String, Object> saveDept(HttpServletRequest request, SysDept dept) {
		Map<String, Object> m = new HashMap<String, Object>();
		// Long deptId =
		// sequenceService.getNextvalBySeqId(SeqContants.SEQ_DEPT_ID);
		dept.setDeptNumber(String.valueOf(System.currentTimeMillis()));
		Long deptId = System.currentTimeMillis();
		try {
			Long parentId = dept.getParentId();
			SysDept parentDept = null;
			if (parentId != null) {
				parentDept = deptService.selectById(parentId);
			}
			if (parentDept != null) {// 有上级
				if (parentDept.getIsLeaf() == 1) {// 父级是叶子节点
					parentDept.setIsLeaf(0L);
					deptService.updateDept(parentDept);// 更新父级节点状态
				}
				dept.setDeptLevel(parentDept.getDeptLevel() + 1);
				if (StringUtils.isNotEmptyString(dept.getDeptNumber())) {
					dept.setLongNumber(parentDept.getLongNumber() + CommonConstants.SPLIT_CHAR + dept.getDeptNumber());
				}
				dept.setDisplayName(parentDept.getDisplayName() + CommonConstants.SPLIT_CHAR + dept.getDeptName());
				dept.setParentId(parentDept.getDeptId());

			} else {// 无上级
				dept.setDeptLevel(1L);
				if (StringUtils.isNotEmptyString(dept.getDeptNumber())) {
					dept.setLongNumber(dept.getDeptNumber());
				}
				dept.setDisplayName(dept.getDeptName());
			}
			dept.setIsLeaf(1L);// 新增的模块都为叶子节点
			dept.setDeptId(deptId);
			//dept.setDeptState(1L);
			deptService.insertDept(dept);
			m.put("state", true);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("state", false);
			m.put("msg", e.getMessage());
		}
		return m;
	}

	/**
	 * 删除部门
	 */
	@RequestMapping(value = "/delDept/{id}")
	@ResponseBody
	public Map<String, Object> del(HttpServletRequest request, @PathVariable("id") String id) throws Exception {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("state", true);
		if (StringUtils.isNotEmptyString(id)) {
			try {
				deptService.deleteDept(Long.parseLong(id));
			} catch (Exception e) {
				m.put("state", false);
				m.put("msg", CommonConstants.DELETE_FAILURE);
				e.printStackTrace();
			}
		} else {
			m.put("state", false);
			m.put("msg", CommonConstants.DELETE_FAILURE);
		}
		return m;
	}

	/**
	 * 编辑部门
	 */
	@RequestMapping(value = "/editDept")
	@ResponseBody
	public Map<String, Object> editDept(HttpServletRequest request, SysDept sysDept) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			SysDept sysDeptSource = deptService.selectById(sysDept.getDeptId());

			List<SysDept> mList = this.deptService.findAllChildren(sysDept.getDeptId(), sysDept);// 查出所有子部门
			if (mList.size() > 0) {
				for (SysDept child : mList) {
					child.setDisplayName(StringUtils.replaceStrWithLevel(child.getDisplayName(),
							CommonConstants.SPLIT_CHAR, sysDept.getDeptLevel().intValue(), sysDept.getDeptName()));
					child.setLongNumber(StringUtils.replaceStrWithLevel(child.getLongNumber(),
							CommonConstants.SPLIT_CHAR, sysDept.getDeptLevel().intValue(), sysDept.getDeptNumber()));
					deptService.updateDept(child);
				}
			}
			/*
			 * sysDeptSource.setLongNumber(StringUtils.replaceStrWithLevel(
			 * sysDeptSource.getLongNumber(), CommonConstants.SPLIT_CHAR,
			 * sysDept.getDeptLevel().intValue(), sysDept.getDeptNumber()));
			 */
			sysDeptSource.setDisplayName(StringUtils.replaceStrWithLevel(sysDeptSource.getDisplayName(),
					CommonConstants.SPLIT_CHAR, sysDept.getDeptLevel().intValue(), sysDept.getDeptName()));
			sysDeptSource.setDeptName(sysDept.getDeptName());
			sysDeptSource.setDescription(sysDept.getDescription());
			sysDeptSource.setTel(sysDept.getTel());
			// sysDeptSource.setDeptNumber(sysDept.getDeptNumber());
			sysDeptSource.setDeptState(sysDept.getDeptState());
			deptService.updateDept(sysDeptSource);
			m.put("state", true);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("state", false);
			m.put("msg", e.getMessage());
		}
		return m;
	}

	/**
	 * 组织机构查询带分页
	 * 
	 * @param name
	 * @param sex
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/queryDeptsByPage")
	@ResponseBody
	public Map<String, Object> queryDeptsByPage(HttpServletRequest request, Long parentId, String deptName) {
		String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
		String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
		Page<SysDept> pages = new Page<SysDept>(Integer.parseInt(page), Integer.parseInt(rows));
		deptService.selectDeptsByPage(pages, parentId, deptName);
		Map<String, Object> result = new HashMap<String, Object>();
		/*
		 * SysDept dept = deptService.selectById(parentId);
		 * pages.getResult().add(dept);
		 */
		result.put("rows", pages.getResult());// 列表数据
		result.put("total", pages.getTotalPages());// 总页数
		result.put("records", pages.getTotalCount());// 总记录数
		return result;
	}

	/**
	 * 根据组织机构查询用户带分页
	 * 
	 * @param name
	 * @param sex
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/queryUsersByOrgPage")
	@ResponseBody
	public Map<String, Object> queryUsersByOrgPage(HttpServletRequest request, String deptId) {
		String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
		String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
		Page<SysUser> pages = new Page<SysUser>(Integer.parseInt(page), Integer.parseInt(rows));
		deptService.selectUsersByOrgPage(pages, deptId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", pages.getResult());// 列表数据
		result.put("total", pages.getTotalPages());// 总页数
		result.put("records", pages.getTotalCount());// 总记录数
		return result;
	}

	@SuppressWarnings("unused")
	private final List<SysDept> getChildrenNode(Long parentId, List<SysDept> treeDataList) {

		List<SysDept> newTreeDataList = new ArrayList<SysDept>();
		for (SysDept sysDept : treeDataList) {
			// 这是一个子节点
			if (sysDept.getParentId().equals(parentId)) {
				// 递归获取子节点下的子节点
				List<SysDept> tempList = deptService.findAllChildren(sysDept.getDeptId(), sysDept);
				sysDept.setChildren(getChildrenNode(sysDept.getDeptId(), tempList));
				newTreeDataList.add(sysDept);
			}
		}
		return newTreeDataList;
	}

	/**
	 * 获取行政区域
	 * 
	 * @param parentId父菜单id
	 */
	@RequestMapping(value = "/getCtrlUnitTree/{parentId}")
	@ResponseBody
	public List<Map<String, Object>> getCtrlUnitTree(HttpServletRequest request,
			@PathVariable("parentId") String parentId) throws Exception {
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();

		listData = getCtrlUnitData(parentId, listData);

		return listData;
	}

	private List<Map<String, Object>> getCtrlUnitData(String parentId, List<Map<String, Object>> listData)
			throws Exception {
		@SuppressWarnings("unchecked")
		List<CtrlUnit> cacheCtrlUnitList = (List<CtrlUnit>) EhcacheUtils.getItem("CTRL_UNIT");
		@SuppressWarnings("unchecked")
		List<CtrlUnit> cacheFirstCtrlUnitList = (List<CtrlUnit>) EhcacheUtils.getItem("CTRL_UNIT_1");
		// 缓存没有，查询数据库更新缓存
		if (null == cacheCtrlUnitList || cacheCtrlUnitList.size() == 0) {
			CtrlUnitExample example = new CtrlUnitExample();
			cacheCtrlUnitList = deptService.findCtrlUnitByExample(example);
			EhcacheUtils.putItem(CacheItemConstants.CTRL_UNIT, cacheCtrlUnitList);

			example.createCriteria().andUnitLevelEqualTo(1);
			cacheFirstCtrlUnitList = this.deptService.findCtrlUnitByExample(example);
			EhcacheUtils.putItem(CacheItemConstants.CTRL_UNIT_1, cacheFirstCtrlUnitList);
		}

		List<CtrlUnit> mList = new ArrayList<CtrlUnit>();
		// 第一层
		if (parentId == null || "null".equals(parentId)) {
			// 缓存查找
			if (null != cacheFirstCtrlUnitList && cacheFirstCtrlUnitList.size() > 0) {

				long begin = System.currentTimeMillis();
				listData = bulidCtrlUnitTree(cacheFirstCtrlUnitList);
				long end = System.currentTimeMillis();
				System.out.println(end - begin);
			}

		} else {
			// 缓存查找
			if (null != cacheCtrlUnitList && cacheCtrlUnitList.size() > 0) {
				String longNumber = null;
				String currentParentId = null;
				for (CtrlUnit ctrl : cacheCtrlUnitList) {
					longNumber = ctrl.getLongNumber() + "";
					currentParentId = "";
					String[] longNumbers = longNumber.split("!");
					if (1 != ctrl.getUnitLevel() && null != longNumbers & longNumbers.length > 0) {
						currentParentId = longNumbers[longNumbers.length - 2];
					}
					if (parentId.equals(currentParentId)) {
						mList.add(ctrl);
					}

				}
			}
			listData = bulidCtrlUnitTree(mList);
		}
		return listData;
	}

	/**
	 * 构建树
	 * 
	 * @param tlist
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, Object>> bulidCtrlUnitTree(List<CtrlUnit> tlist) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (CtrlUnit ctrlUnit : tlist) {
			Map<String, Object> treeNode = new HashMap<String, Object>();
			treeNode.put("id", ctrlUnit.getUnitIdentity());
			treeNode.put("unitName", ctrlUnit.getUnitName());
			treeNode.put("unitDescription", ctrlUnit.getUnitDescription());
			treeNode.put("longNumber", ctrlUnit.getLongNumber());
			treeNode.put("unitNumber", ctrlUnit.getUnitNumber());
			treeNode.put("unitState", ctrlUnit.getUnitState());
			treeNode.put("unitLevel", ctrlUnit.getUnitLevel());
			if (0 == ctrlUnit.getIsLeaf()) {
				treeNode.put("state", "closed");
			} else {
				treeNode.put("state", "open");
			}
			list.add(treeNode);
		}
		return list;
	}

	/**
	 * 删除辖区
	 */
	@RequestMapping(value = "/delCtrl/{id}")
	@ResponseBody
	public Map<String, Object> delCtrl(HttpServletRequest request, @PathVariable("id") String id) throws Exception {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("state", true);
		if (StringUtils.isNotEmptyString(id)) {
			try {
				deptService.deleteCtrlUnit(id);
				// 清理缓存
				EhcacheUtils.removeItem("CTRL_UNIT");
				EhcacheUtils.removeItem("CTRL_UNIT_1");
			} catch (Exception e) {
				m.put("state", false);
				m.put("msg", CommonConstants.DELETE_FAILURE);
				e.printStackTrace();
			}
		} else {
			m.put("state", false);
			m.put("msg", CommonConstants.DELETE_FAILURE);
		}
		return m;
	}

	/**
	 * 编辑辖区
	 */
	@RequestMapping(value = "/editCtrl")
	@ResponseBody
	public Map<String, Object> editCtrl(HttpServletRequest request, CtrlUnit ctrlUnit) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			CtrlUnit ctrlUnitSource = deptService.selectCtrlUnitById(String.valueOf(ctrlUnit.getId()));
			ctrlUnitSource.setDisplayName(ctrlUnit.getUnitName());
			ctrlUnitSource.setUnitName(ctrlUnit.getUnitName());
			ctrlUnitSource.setUnitDescription(ctrlUnit.getUnitDescription());
			deptService.updateCtrlUnit(ctrlUnitSource);
			// 清理缓存
			EhcacheUtils.removeItem("CTRL_UNIT");
			EhcacheUtils.removeItem("CTRL_UNIT_1");
			m.put("state", true);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("state", false);
			m.put("msg", e.getMessage());
		}
		return m;
	}

	/**
	 * 跳转部门列表(派出所)
	 * 
	 * @return
	 */
	@RequestMapping("policeStationTree")
	public ModelAndView policeStationTree(Model m, String element, String model) {
		SysDept deptinfo = deptService.selectByDeptNumber(ContxtUtils.getUserSession().getDeptId(), true);
		if (null != deptinfo) {
			m.addAttribute("deptId", deptinfo.getDeptId());
		}
		m.addAttribute("element", element);
		return new ModelAndView("common/policeStationOrg");
	}

	/**
	 * 获取部门
	 * 
	 * @param parentId父菜单id
	 */
	@RequestMapping(value = "/getPoliceStationTree/{parentId}")
	@ResponseBody
	public List<Map<String, Object>> getPoliceStationTree(@PathVariable("parentId") String parentId) throws Exception {
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
		if (parentId == null || "null".equals(parentId)) {
			List<SysDept> mList = deptService.findPoliceStationChildren(Long.parseLong(parentId), null);
			listData = bulidPoliceStationTree(mList);
		} else {
			SysDept parentDept = deptService.selectById(Long.parseLong(parentId));
			List<SysDept> mList = deptService.findPoliceStationChildren(parentDept.getDeptLevel(),
					Long.parseLong(parentId));
			listData = bulidPoliceStationTree(mList);
		}
		return listData;
	}

	/**
	 * 构建警察局树
	 * 
	 * @param tlist
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, Object>> bulidPoliceStationTree(List<SysDept> tlist) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (SysDept dept : tlist) {
			Map<String, Object> treeNode = new HashMap<String, Object>();
			treeNode.put("deptId", dept.getDeptId());
			treeNode.put("deptName", dept.getDeptName());
			treeNode.put("description", dept.getDescription());
			treeNode.put("parentId", dept.getParentId());
			treeNode.put("deptNumber", dept.getDeptNumber());
			treeNode.put("deptState", dept.getDeptState());
			treeNode.put("tel", dept.getTel());
			treeNode.put("deptLevel", dept.getDeptLevel());
			if (dept.getDeptLevel() == 3) {
				treeNode.put("state", "open");
				treeNode.put("operation", "<span style=\"color: #4f98f7;cursor: pointer;\" onclick='chooseType(\""
						+ dept.getDeptId() + "\",\"" + dept.getDeptName() + "\");'>选择</span>");
			} else {
				treeNode.put("state", "closed");
			}
			list.add(treeNode);
		}
		return list;
	}
}
