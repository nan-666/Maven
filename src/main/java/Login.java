

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.JsonData;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//初始化
	    request.setCharacterEncoding("utf-8");
	    //设置初始账号和密码
	    String CODE = "zhangsan";//账号
	    String PWD = "123456";//密码
	    //(参)获取参数值
	    String code = request.getParameter("code");
	    String loginpwd = request.getParameter("loginpwd");
	    
	    
	    if(CODE.equals(code)||PWD.equals(loginpwd)){
	    	、
		    
		    //2.将POJO对象转发给服务DAO
		    int i = memberSD.login(member);
		    //3.(存)将数据对象存储到request作用范围变量
		    boolean success=false;//操作成功与否
		    String msg="失败";//返回的结果信息
		    if(i==0){
		    	success = false;
		    	msg = "账户不存在或密码错误";
		    }else if(i==1){
		    	Cookie cookie = new Cookie("code",member.getCode());
		    	response.addCookie(cookie);
		    	success = true;
		    	msg = "登录成功";
		    }
		    JsonData JsonData = new JsonData(success,msg);
		    request.setAttribute("JsonData", JsonData);
		    //4.(转)将业务转发到View
		    RequestDispatcher rd = request.getRequestDispatcher("/view/toJson");
		    rd.forward(request, response);
	    }
	    else{
	    	boolean success = false;
	    	String msg="验证码输入错误，请重新输入";
	    	JsonData JsonData = new JsonData(success,msg);
		    request.setAttribute("JsonData", JsonData);
		    //4.(转)将业务转发到View
		    RequestDispatcher rd = request.getRequestDispatcher("/view/toJson");
		    rd.forward(request, response);
	    }
	    
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
