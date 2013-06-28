package org.apache.jsp.statistics;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

public final class goodStatistics_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

// Version 2.0 Deprecated - Please use FusionChartsRenderer.jsp, FusionChartsHTMLRenderer.jsp and com.fusionCharts.FusionChartsHelper to achieve the same functionality
//Page: FusionCharts.jsp
    //Author: InfoSoft Global (P) Ltd.

    //This page contains functions that can be used to create FusionCharts.

    /**
     * Encodes the dataURL before it's served to FusionCharts.
     * If you have parameters in your dataURL, you necessarily need to encode it.
     * @param strDataURL - dataURL to be fed to chart
     * @param addNoCacheStr - Whether to add aditional string to URL to disable caching of data
     * @return
     */

    public String encodeDataURL(String strDataURL, String addNoCacheStr,
	    HttpServletResponse response) {
		String encodedURL = strDataURL;
		//Add the no-cache string if required
		if (addNoCacheStr.equals("true")) {
		    /*We add ?FCCurrTime=xxyyzz
		    If the dataURL already contains a ?, we add &FCCurrTime=xxyyzz
		    We send the date separated with '_', instead of the usual ':' as FusionCharts cannot handle : in URLs
		    */
		    java.util.Calendar nowCal = java.util.Calendar.getInstance();
		    java.util.Date now = nowCal.getTime();
		    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
			    "MM/dd/yyyy HH_mm_ss a");
		    String strNow = sdf.format(now);
		    if (strDataURL.indexOf("?") > 0) {
			encodedURL = strDataURL + "&FCCurrTime=" + strNow;
		    } else {
			strDataURL = strDataURL + "?FCCurrTime=" + strNow;
		    }
		    encodedURL = response.encodeURL(strDataURL);
	
		}
		return encodedURL;
    }

    /**
     * Creates the Chart HTML+Javascript to create the FusionCharts object with the given parameters.
     * This method uses JavaScript to overcome the IE browser problem with SWF wherein you have to 'Click to activate' the control
     * @param chartSWF - SWF File Name (and Path) of the chart which you intend to plot
     * @param strURL - If you intend to use dataURL method for this chart, pass the URL as this parameter. Else, set it to "" (in case of dataStr method)
     * @param strXML - If you intend to use dataStr method for this chart, pass the XML data as this parameter. Else, set it to "" (in case of dataURL method)
     * @param chartId - Id for the chart, using which it will be recognized in the HTML page. Each chart on the page needs to have a unique Id.
     * @param chartWidth - Intended width for the chart (in pixels)
     * @param chartHeight - Intended height for the chart (in pixels)
     * @param debugMode - Whether to start the chart in debug mode
     * @param registerWithJS - Whether to ask chart to register itself with JavaScript
     */
    public String createChart(String chartSWF, String strURL, String strXML,
	    String chartId, int chartWidth, int chartHeight, boolean debugMode,
	    boolean registerWithJS) {
		StringBuffer strBuf = new StringBuffer();
		/*
		First we create a new DIV for each chart. We specify the name of DIV as "chartId"Div.
		DIV names are case-sensitive.
		*/
		strBuf.append("<!--START Script Block for Chart -->\n");
		strBuf.append("\t\t<div id='" + chartId + "Div' align='center'>\n");
		strBuf.append("\t\t\t\tChart.\n");
	
		/*The above text "Chart" is shown to users before the chart has started loading
		 (if there is a lag in relaying SWF from server). This text is also shown to users
		 who do not have Flash Player installed. You can configure it as per your needs.*/
	
		strBuf.append("\t\t</div>\n");
	
		/*Now, we render the chart using FusionCharts Class. Each chart's instance (JavaScript) Id
		 is named as chart_"chartId".*/
	
		strBuf.append("\t\t<script type='text/javascript'>\n");
		//Instantiate the Chart
		Boolean registerWithJSBool = new Boolean(registerWithJS);
		Boolean debugModeBool = new Boolean(debugMode);
		int regWithJSInt = boolToNum(registerWithJSBool);
		int debugModeInt = boolToNum(debugModeBool);
	
		strBuf.append("\t\t\t\tvar chart_" + chartId + " = new FusionCharts('"
			+ chartSWF + "', '" + chartId + "', '" + chartWidth + "', '"
			+ chartHeight + "', '" + debugModeInt + "', '" + regWithJSInt
			+ "');\n");
		//Check whether we've to provide data using dataStr method or dataURL method
		if (strXML.equals("")) {
		    strBuf.append("\t\t\t\t//Set the dataURL of the chart\n");
		    strBuf.append("\t\t\t\tchart_" + chartId + ".setDataURL(\"" + strURL
			    + "\");\n");
		} else {
		    strBuf.append("\t\t\t\t//Provide entire XML data using dataStr method\n");
		    strBuf.append("\t\t\t\tchart_" + chartId + ".setdataStr(\"" + strXML
			    + "\");\n");
		}
		strBuf.append("\t\t\t\t//Finally, render the chart.\n");
		strBuf.append("\t\t\t\tchart_" + chartId + ".render(\"" + chartId + "Div\");\n");
		strBuf.append("\t\t</script>\n");
		strBuf.append("\t\t<!--END Script Block for Chart-->\n");
		return strBuf.substring(0);
    }

    /**
     * Creates the Chart HTML to embed the swf object with the given parameters
     * @param chartSWF - SWF File Name (and Path) of the chart which you intend to plot
     * @param strURL - If you intend to use dataURL method for this chart, pass the URL as this parameter. Else, set it to "" (in case of dataStr method)
     * @param strXML - If you intend to use dataStr method for this chart, pass the XML data as this parameter. Else, set it to "" (in case of dataURL method)
     * @param chartId - Id for the chart, using which it will be recognized in the HTML page. Each chart on the page needs to have a unique Id.
     * @param chartWidth - Intended width for the chart (in pixels)
     * @param chartHeight - Intended height for the chart (in pixels)
     * @param debugMode - Whether to start the chart in debug mode
     */

    public String createChartHTML(String chartSWF, String strURL,
	    String strXML, String chartId, int chartWidth, int chartHeight,
	    boolean debugMode) { 
		/*Generate the FlashVars string based on whether dataURL has been provided
	     or dataStr.*/
		String strFlashVars = "";
		Boolean debugModeBool = new Boolean(debugMode);
	
		if (strXML.equals("")) {
		    //DataURL Mode
		    strFlashVars = "chartWidth=" + chartWidth + "&chartHeight="
			    + chartHeight + "&debugMode=" + boolToNum(debugModeBool)
			    + "&dataURL=" + strURL + "";
		} else {
		    //dataStr Mode
		    strFlashVars = "chartWidth=" + chartWidth + "&chartHeight="
			    + chartHeight + "&debugMode=" + boolToNum(debugModeBool)
			    + "&dataStr=" + strXML + "";
		}
		StringBuffer strBuf = new StringBuffer();
	
		// START Code Block for Chart  
		strBuf.append("\t\t<!--START Code Block for Chart-->\n");
		strBuf
			.append("\t\t\t\t<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0' width='"
				+ chartWidth
				+ "' height='"
				+ chartHeight
				+ "' id='"
				+ chartId + "'>\n");
		strBuf.append("\t\t\t\t	<param name='allowScriptAccess' value='always' />\n");
		strBuf.append("\t\t\t\t	<param name='movie' value='" + chartSWF + "'/>\n");
		strBuf.append("\t\t\t\t<param name='FlashVars' value=\"" + strFlashVars
			+ "\" />\n");
		strBuf.append("\t\t\t\t	<param name='quality' value='high' />\n");
		strBuf
			.append("\t\t\t\t<embed src='"
				+ chartSWF
				+ "' FlashVars=\""
				+ strFlashVars
				+ "\" quality='high' width='"
				+ chartWidth
				+ "' height='"
				+ chartHeight
				+ "' name='"
				+ chartId
				+ "' allowScriptAccess='always' type='application/x-shockwave-flash' pluginspage='http://www.macromedia.com/go/getflashplayer' />\n");
		strBuf.append("\t\t</object>\n");
		// END Code Block for Chart
		strBuf.append("\t\t<!--END Code Block for Chart-->\n");
		return strBuf.substring(0);
    }

    /**
     * Converts boolean to corresponding integer
     * @param bool - The boolean that is to be converted to number
     * @return int - 0 or 1 representing the given boolean value
     */
    public int boolToNum(Boolean bool) {
		int num = 0;
		if (bool.booleanValue()) {
		    num = 1;
		}
		return num;
    }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/FunsionChar/jsp/FusionCharts.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\t<title>FusionCharts - Simple Column 3D Chart</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/admin/main.css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery-1.8.3.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"FunsionChar/js/FusionCharts.debug.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction module(type){\r\n");
      out.write("\t\t\tswitch(type){\r\n");
      out.write("\t\t\t\tcase 'day':\r\n");
      out.write("\t\t\t\t\turl = \"");
      out.print(request.getContextPath() );
      out.write("/dayGoodStatisticsAction.action\";\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\tcase 'month':\r\n");
      out.write("\t\t\t\t\turl = \"");
      out.print(request.getContextPath() );
      out.write("/monthGoodStatisticsAction.action\";\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\tcase 'year':\r\n");
      out.write("\t\t\t\t\turl = \"");
      out.print(request.getContextPath() );
      out.write("/yearGoodStatisticsAction.action\";\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar chart = new FusionCharts(\r\n");
      out.write("\t\t\t\t\t\"FunsionChar/swf/Column2D.swf\", \"myfist\", \"750\",\r\n");
      out.write("\t\t\t\t\t\"400\");\r\n");
      out.write("\t\t\t//chart.setDataURL(escape(\"column3DChart!initColumn3D.action\"));\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : url,\r\n");
      out.write("\t\t\t\ttype : 'post',\r\n");
      out.write("\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tchart.setJSONData(data);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tchart.render(\"chartdiv\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"content\">\r\n");
      out.write("\t\t<h3 class=\"admin_link_bar\">\r\n");
      out.write("\t\t\t<span style=\"color: white;\"> \r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"module('day');\"><font color=\"white\">今日销售商品</font></a>\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"module('month')\"><font color=\"white\">本月销售商品</font></a>\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"module('year')\"><font color=\"white\">年销售统计</font></a>\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t</h3>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t<div id=\"chartdiv\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\tvar chart = new FusionCharts(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"FunsionChar/swf/Column2D.swf\", \"myfist\", \"750\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\"400\");\r\n");
      out.write("\t\t\t\t\t\t//chart.setDataURL(escape(\"column3DChart!initColumn3D.action\"));\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\turl : 'dayGoodStatisticsAction.action',\r\n");
      out.write("\t\t\t\t\t\t\ttype : 'post',\r\n");
      out.write("\t\t\t\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\t\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\tchart.setJSONData(data);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\tchart.render(\"chartdiv\");\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t</div> \r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"bottom\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
