/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.96
 * Generated at: 2024-10-20 08:08:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addEvent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Add New Event</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        /* Your existing styles here */\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            background-image: url(\"images/background2.jpg\");\r\n");
      out.write("            background-repeat: no-repeat;\r\n");
      out.write("            background-size: cover; \r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        #addevent-header {\r\n");
      out.write("		    background: linear-gradient(135deg, #FF4F81, #A500B5);\r\n");
      out.write("		    color: white;\r\n");
      out.write("		    text-align: center; \r\n");
      out.write("		    padding: 20px 20px;\r\n");
      out.write("		    border-radius: 0 0 20px 20px;\r\n");
      out.write("		    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3); \r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("        h1 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-family: Arial black;\r\n");
      out.write("            font-size: 2.5rem;\r\n");
      out.write("            color: white; \r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);  \r\n");
      out.write("            border-bottom: 2px solid rgba(255, 255, 255, 0.8); \r\n");
      out.write("            padding-bottom: 10px; \r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #add-event-form {\r\n");
      out.write("            background-color: rgba(255, 255, 255, 0.3);\r\n");
      out.write("            backdrop-filter: blur(15px); \r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);\r\n");
      out.write("            padding: 30px;\r\n");
      out.write("            max-width: 500px;\r\n");
      out.write("            margin: 50px auto;\r\n");
      out.write("            font-family: 'Arial', sans-serif;\r\n");
      out.write("            border: 2px solid rgba(255, 255, 255, 0.7);\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        #add-event-form label {\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("            display: block;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        #add-event-form input[type=\"text\"],\r\n");
      out.write("        #add-event-form input[type=\"number\"],\r\n");
      out.write("        #add-event-form textarea,\r\n");
      out.write("        #add-event-form input[type=\"file\"],\r\n");
      out.write("        #add-event-form select {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            margin: 10px 0;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            font-size: 1rem;\r\n");
      out.write("            transition: border 0.3s;\r\n");
      out.write("            background-color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        #add-event-form input[type=\"text\"]:focus,\r\n");
      out.write("        #add-event-form input[type=\"number\"]:focus,\r\n");
      out.write("        #add-event-form textarea:focus,\r\n");
      out.write("        #add-event-form select:focus {\r\n");
      out.write("            border-color: #4CAF50; \r\n");
      out.write("            outline: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #add-event-form button {\r\n");
      out.write("            background-color: #FF6F61;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 12px 20px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            font-size: 1.2rem;\r\n");
      out.write("            transition: background-color 0.3s;\r\n");
      out.write("            width: 100%; \r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #add-event-form button:hover {\r\n");
      out.write("            background-color: #FF4C3B;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Error styling */\r\n");
      out.write("        .error {\r\n");
      out.write("            color: red;\r\n");
      out.write("            font-size: 0.9rem;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function validateForm(event) {\r\n");
      out.write("            let isValid = true;\r\n");
      out.write("\r\n");
      out.write("            // Clear previous error messages\r\n");
      out.write("            document.querySelectorAll('.error').forEach(el => el.innerHTML = '');\r\n");
      out.write("\r\n");
      out.write("            // Validate event type\r\n");
      out.write("            const eventType = document.getElementById('event_type');\r\n");
      out.write("            if (eventType.value === '') {\r\n");
      out.write("                showError(eventType, 'Please select an event type.');\r\n");
      out.write("                isValid = false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // Validate event venue\r\n");
      out.write("            const eventVenue = document.getElementById('event_venue');\r\n");
      out.write("            if (eventVenue.value.trim() === '') {\r\n");
      out.write("                showError(eventVenue, 'Please enter the event venue.');\r\n");
      out.write("                isValid = false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // Validate number of participants\r\n");
      out.write("            const nop = document.getElementById('nop');\r\n");
      out.write("            if (nop.value.trim() === '' || isNaN(nop.value) || nop.value <= 0) {\r\n");
      out.write("                showError(nop, 'Please enter a valid number of participants.');\r\n");
      out.write("                isValid = false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // Validate event description\r\n");
      out.write("            const eventDescription = document.getElementById('event_description');\r\n");
      out.write("            if (eventDescription.value.trim() === '') {\r\n");
      out.write("                showError(eventDescription, 'Please enter a description for the event.');\r\n");
      out.write("                isValid = false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // Validate event image (file upload)\r\n");
      out.write("            const eventImage = document.getElementById('event_image');\r\n");
      out.write("            if (eventImage.files.length === 0) {\r\n");
      out.write("                showError(eventImage, 'Please upload an image for the event.');\r\n");
      out.write("                isValid = false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            if (!isValid) {\r\n");
      out.write("                event.preventDefault();  // Prevent form submission if validation fails\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function showError(input, message) {\r\n");
      out.write("            const errorDiv = document.createElement('div');\r\n");
      out.write("            errorDiv.className = 'error';\r\n");
      out.write("            errorDiv.innerHTML = message;\r\n");
      out.write("            input.parentNode.insertBefore(errorDiv, input.nextSibling);  // Insert error message after the input field\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h1 id=\"addevent-header\">Add New Event</h1>\r\n");
      out.write("    <div id=\"add-event-form\">\r\n");
      out.write("        <form action=\"addEventServlet\" method=\"POST\" enctype=\"multipart/form-data\" onsubmit=\"validateForm(event)\">\r\n");
      out.write("            <label for=\"eventType\">Event Type:</label>\r\n");
      out.write("            <select id=\"event_type\" name=\"event_type\" required>\r\n");
      out.write("                <option value=\"\">Select an event type</option>\r\n");
      out.write("                <option value=\"wedding\">Wedding</option>\r\n");
      out.write("                <option value=\"birthday_party\">Birthday Party</option>\r\n");
      out.write("                <option value=\"corporate_event\">Corporate Event</option>\r\n");
      out.write("                <option value=\"anniversary_celebration\">Anniversary Celebration</option>\r\n");
      out.write("                <option value=\"baby_shower\">Baby Shower</option>\r\n");
      out.write("                <option value=\"graduation_party\">Graduation Party</option>\r\n");
      out.write("                <option value=\"concert\">Concert</option>\r\n");
      out.write("                <option value=\"charity_event\">Charity Event</option>\r\n");
      out.write("                <option value=\"family_reunion\">Family Reunion</option>\r\n");
      out.write("                <option value=\"holiday_party\">Holiday Party</option>\r\n");
      out.write("                <option value=\"conference\">Conference</option>\r\n");
      out.write("                <option value=\"seminar\">Seminar</option>\r\n");
      out.write("                <option value=\"workshop\">Workshop</option>\r\n");
      out.write("                <option value=\"prom\">Prom</option>\r\n");
      out.write("                <option value=\"sporting_event\">Sporting Event</option>\r\n");
      out.write("                <option value=\"picnic\">Picnic</option>\r\n");
      out.write("                <option value=\"themed_party\">Themed Party</option>\r\n");
      out.write("                <option value=\"farewell_party\">Farewell Party</option>\r\n");
      out.write("                <option value=\"art_exhibition\">Art Exhibition</option>\r\n");
      out.write("                <option value=\"fashion_show\">Fashion Show</option>\r\n");
      out.write("            </select>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"event_venue\">Event Venue:</label>\r\n");
      out.write("            <input type=\"text\" id=\"event_venue\" name=\"event_venue\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"nop\">Number of Participants:</label>\r\n");
      out.write("            <input type=\"number\" id=\"nop\" name=\"nop\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"event_description\">Event Description:</label>\r\n");
      out.write("            <textarea id=\"event_description\" name=\"event_description\" required></textarea>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"event_image\">Event Image:</label>\r\n");
      out.write("            <input type=\"file\" id=\"event_image\" name=\"event_image\" accept=\"image/*\" required>\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\">Submit</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
