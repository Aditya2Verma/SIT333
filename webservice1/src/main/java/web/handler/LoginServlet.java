package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LoginServlet] GET");

        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        System.out.println("Username/password: " + username + ", " + password);

        if (LoginService.login(username, password, dob)) {
            sendResponse(resp, "success");
        } else {
            sendResponse(resp, "fail");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST method not supported");
    }

    private void sendResponse(HttpServletResponse resp, String status) throws IOException {
        resp.setContentType("text/html");

        String htmlResponse = "<!DOCTYPE html>";
        htmlResponse += "<html lang='en'>";
        htmlResponse += "<head>";
        htmlResponse += "<meta charset='UTF-8'>";
        htmlResponse += "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
        htmlResponse += "<title>Login Result</title>";
        htmlResponse += "<style>";
        htmlResponse += "body { display: flex; justify-content: center; align-items: center; height: 100vh; font-family: sans-serif; background-color: #f4f4f4; }";
        htmlResponse += ".box { text-align: center; background: #fff; padding: 30px 40px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }";
        htmlResponse += "#loginStatus { color: " + (status.equals("success") ? "green" : "red") + "; font-size: 22px; font-weight: bold; }";
        htmlResponse += "</style>";
        htmlResponse += "</head>";
        htmlResponse += "<body>";
        htmlResponse += "<div class='box'>";
        htmlResponse += "<div id='loginStatus'>" + status + "</div>";
        htmlResponse += "</div>";
        htmlResponse += "</body>";
        htmlResponse += "</html>";

        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
    }
}
