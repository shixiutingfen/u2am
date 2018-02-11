package com.jiuling.core.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.DataAccessException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: BaseController
 * @Description: 主控制类
 * @author YANGXQ
 * @date: 2016-01-5 10:43:05
 */
public class BaseController {
  protected Logger log = Logger.getLogger(this.getClass());

  /**
   * 自定义日期类型数据绑定 将指定时间格式的字符串能自动加载到Timestamp类型的控制层参数中 如果不加，Controller中的方法无法直接用Timestamp类型接收前台时间数据
   * 自动删除前后空格
   * 
   * @param binder
   *          前台数据绑定器
   * @throws Exception
   */
  @InitBinder
  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
      throws Exception {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    CustomDateEditor editor = new CustomDateEditor(df, false);
    // string 时间格式转date
    binder.registerCustomEditor(Date.class, editor);
    // 自动删除前后空格
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
  }

  /**
   * @Title: parameter2String
   * @Description: 将请求参数转化为字符串
   * @param req
   *          request内置对象
   * @return 参数字符串
   * @ReturnType: String
   */
  private String parameter2String(HttpServletRequest req) {
    Map<?, ?> m = req.getParameterMap();
    StringBuilder sb = new StringBuilder();
    for (Iterator<?> i = m.keySet().iterator(); i.hasNext();) {
      Object key = i.next();
      Object[] object = (Object[]) m.get(key);
      Object value = object[0];
      if (!StringUtils.isEmpty(value)) {
        sb.append(key + "=" + value + ",");
      }
    }
    return sb.toString();
  }

  /**
   * @Title: handleError
   * @Description: 获取请求错误
   * @param req
   * @param e
   * @return
   * @ReturnType: Object
   */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Object handleError(HttpServletRequest req, Exception e) {
    log.error(e.getMessage(), e);
    log.error(
        "Request: " + req.getRequestURL() + "---" + parameter2String(req) + ", raised: "
            + e.getMessage(), e.getCause());
    return getExceptionMsg(e);
  }

  /**
   * @Title: getExceptionMsg
   * @Description: 根据异常类型返回错误信息
   * @param e
   * @return
   * @ReturnType: String
   */
  private String getExceptionMsg(Exception e) {
    if (e instanceof DataAccessException) {
      return "数据库访问错误";
    }
    return e.getMessage();
  }

}
