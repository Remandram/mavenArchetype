package chatRoom.controller;

import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/chatRoom/api/login")
public class UserLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "张三");
        jsonObject.put("age", 30);
        jsonObject.put("city", "北京");
        jsonObject.put("redirect", "/home");

        // 设置响应内容类型为JSON
        resp.setContentType("application/json;charset=UTF-8");
        // 将JSONObject转换为字符串并写入响应体
        PrintWriter out = resp.getWriter();
        out.print(jsonObject);
        out.flush();
    }
}
