package hello;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class GrouperServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(GrouperServlet.class.getName());
    /**
     * @author Jake Sylvstre
     * @param HttpServletRequest -> request object
     * @param HttpServletResponse -> response object
     * @return void
     * pipes response to tomcat
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BasicConfigurator.configure();
        String phoneNumber = request.getParameter("From");
        String body = request.getParameter("Body");
        log.info(phoneNumber + ": " + body);
        Text text = new Text(phoneNumber, body);
        text.execute();
        response.setContentType("application/xml");
        response.getWriter().print("<Response></Response>");
    }
}
