/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-04-24 01:51:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Arrays;
import javax.servlet.http.HttpSession;

public final class Write2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/bluemidpj/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/midproject/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1681996648000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("javax.servlet.http.HttpSession");
    _jspx_imports_classes.add("java.util.Arrays");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<title>글 작성</title>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("table {\r\n");
      out.write("	width: 50% !important;\r\n");
      out.write("	margin-left: 25%;\r\n");
      out.write("	margin-right: 25%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/Board/Layout.jsp", out, false);
      out.write("\r\n");
      out.write("	<div style=\"border: 3px solid #b7d9df; border-radius: 20px; width: 1300px; height: auto; position: absolute; left: 310px;\">\r\n");
      out.write("	<h2 style=\"text-align: center;\">글 작성</h2>\r\n");
      out.write("	<br>\r\n");
      out.write("\r\n");
      out.write("	<form action=\"../board/write2.do\" method=\"post\" name=\"writeForm\"\">\r\n");
      out.write("		<table class=\"table table-bordered\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th scope=\"col\">작성 위치</th>\r\n");
      out.write("				<td>\r\n");
      out.write("					");

					String boardkind = request.getParameter("boardkind");
					
      out.write(" <select id=\"WRITING_LOCATION\" name=\"boardkind\" size=\"1\"\r\n");
      out.write("					onchange=\"if(this.value=='0') location.href='Write.jsp?boardkind=0'\">\r\n");
      out.write("						<option value=\"\">작성 위치를 선택하세요.</option>\r\n");
      out.write("						<option value=\"0\" ");
if ("0".equals(boardkind)) {
      out.write(" selected\r\n");
      out.write("							");
}
      out.write(">공지사항</option>\r\n");
      out.write("						<option value=\"1\" ");
if ("1".equals(boardkind)) {
      out.write(" selected\r\n");
      out.write("							");
}
      out.write(">알림장</option>\r\n");
      out.write("				</select>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th scope=\"col\">받는 사람</th>\r\n");
      out.write("				<td>\r\n");
      out.write("					<button type=\"button\" onclick=\"openPopup()\">찾아보기</button>\r\n");
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th scope=\"col\">제목</th>\r\n");
      out.write("				<td><input type=\"text\" name=\"title\" style=\"width: 90%;\" /></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th scope=\"col\">내용</th>\r\n");
      out.write("				<td><textarea name=\"content\" style=\"width: 90%; height: 100px;\"></textarea>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td colspan=\"2\" style=\"text-align: center;\">\r\n");
      out.write("					<button type=\"submit\">작성완료</button>\r\n");
      out.write("					<button type=\"reset\">초기화</button>\r\n");
      out.write("					<button type=\"button\" onclick=\"location.href='../board/list2.do';\">\r\n");
      out.write("						목록 바로가기</button>\r\n");
      out.write("					<button type=\"button\"\r\n");
      out.write("						onclick=\"location.href='../Board/Enterance.jsp';\">홈페이지 바로\r\n");
      out.write("						가기</button>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("		function openPopup() {\r\n");
      out.write("			window.open(\"../board/find.do\", \"popup\", \"width=700,height=500\");\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
