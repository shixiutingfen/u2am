package com.jiuling.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jiuling.core.util.PropertiesUtil;

@Controller
@RequestMapping(value = "/tools")
public class ToolsController {

	/**
	 * 跳转调取本地应用
	 * 
	 * @return
	 */
	@RequestMapping("toNativeTools")
	public ModelAndView toNativeTools(Model m) {
		//万能播放器
		String QSTPlayerKey = PropertiesUtil.getMsgPackey("QSTPlayer.tools.key");
		String QSTPlayerPath = PropertiesUtil.getMsgPackey("QSTPlayer.tools.path");
		m.addAttribute("QSTPlayerKey", QSTPlayerKey);
		m.addAttribute("QSTPlayerPath", QSTPlayerPath);
		
		//图像处理
		String JIPSKey = PropertiesUtil.getMsgPackey("JIPS.tools.key");
		String JIPSPath = PropertiesUtil.getMsgPackey("JIPS.tools.path");
		m.addAttribute("JIPSKey", JIPSKey);
		m.addAttribute("JIPSPath", JIPSPath);
		
		//视侦通
		String HikVideoSuiteKey = PropertiesUtil.getMsgPackey("HikVideoSuite.tools.key");
		String HikVideoSuitePath = PropertiesUtil.getMsgPackey("HikVideoSuite.tools.path");
		m.addAttribute("HikVideoSuiteKey", HikVideoSuiteKey);
		m.addAttribute("HikVideoSuitePath", HikVideoSuitePath);
		
		//行为分析
		String CortexViewerkey = PropertiesUtil.getMsgPackey("CortexViewer.tools.key");
		String CortexViewerPath = PropertiesUtil.getMsgPackey("CortexViewer.tools.path");
		m.addAttribute("CortexViewerkey", CortexViewerkey);
		m.addAttribute("CortexViewerPath", CortexViewerPath);
		
		return new ModelAndView("business/nativeTools/nativetools");
	}
	
}
