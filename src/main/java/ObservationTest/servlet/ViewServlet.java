package ObservationTest.servlet;

import org.junit.runner.Request;
import org.thymeleaf.context.WebContext;
import ObservationTest.config.WebConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "SearchServlet", urlPatterns = "/index",
        loadOnStartup = 1)
public class ViewServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Initializing Thymeleaf template engine");
        final ServletContext servletContext = this.getServletContext();
        WebConfig.createTemplateEngine(servletContext);
    }

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
        String animal = request.getParameter("animal");
        String province = request.getParameter("province");

        WebContext ctx = new WebContext(
                request,
                response,
                request.getServletContext(),
                request.getLocale());

        HttpSession session = request.getSession();


        System.out.println("animal = " + animal);
        System.out.println("province = " + province);


        session.setAttribute("animal", animal);
        session.setAttribute("province", province);

        ctx.setVariable("animal", animal);
        ctx.setVariable("province", province);

        System.out.println("Forwarding to map page");

        WebConfig.createTemplateEngine(getServletContext()).
                process("map", ctx, response.getWriter());
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);

    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        WebConfig.configureResponse(response);
        WebContext ctx = new WebContext(
                request,
                response,
                request.getServletContext(),
                request.getLocale());
        HttpSession session = request.getSession();

        WebConfig.createTemplateEngine(getServletContext()).
                process("index", ctx, response.getWriter());

    }
}

