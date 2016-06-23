
package com.health.servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.health.model.DynamicPicture;
import com.health.model.User;
import com.health.model.UserDynamic;
import com.health.service.impl.DynamicPictureService;
import com.health.service.impl.UserService;
import com.health.util.JsonToModel;
import com.health.util.ReadStream;
import com.opensymphony.xwork2.ActionContext;

@Component ("GetUserDynamic")
public class GetUserDynamic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource
    private UserService userService; 
	@Resource
	private DynamicPictureService dynamicPictureService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserDynamic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
	        if(isMultipart){  
	            String realPath = this.getServletContext().getRealPath("image");  
	              
	            System.out.println(realPath);  
	              
	            File dir = new File(realPath);  
	              
	            if(!dir.exists()){  
	                dir.mkdir();  
	            }  
	              
	            DiskFileItemFactory factory = new DiskFileItemFactory();  
	            ServletFileUpload upload = new ServletFileUpload(factory);  
	              
	            upload.setHeaderEncoding("utf-8");  
	            SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
	            try {  
	                List<FileItem> items = upload.parseRequest(request);  
	                int id = 0;
	                String dynamicInformation = null;
	                Date dynamicDate = null;
	                User user = new User();
	                List<DynamicPicture> pList = new ArrayList<>();
	                UserDynamic userDynamic = new UserDynamic();
	                int i = 1000;
	                for(FileItem item : items){  
	                	
	                    if(item.isFormField()){ //username="username"  
	                        String name = item.getFieldName();  
	                        String value = item.getString("utf-8"); 
	                        if (name.equals("id")) {
	                        	id = Integer.parseInt(value);
	                        	user = userService.getUser(id);
	                        }
	                        else if (name.equals("dynamicDate")) 
	                        	dynamicDate = formatter.parse(value);
	                        else
	                        	dynamicInformation = value;
	                        System.out.println(name + " = " + value);  
	                    } else { //文件  
	                        String name = item.getName();  
	                        item.write(new File(dir,   dynamicDate.toString().replace(" ", "1") +i + name.substring(name.lastIndexOf("."))));
	                        DynamicPicture picture = new DynamicPicture();
	                        picture.setPictureInformation("/" + "healthAppService/image" + "/" + dynamicDate.toString().replace(" ", "1") + i + name.substring(name.lastIndexOf(".")));
	                        pList.add(picture);
	                        i ++;
	                    }     
	                }  
                    userDynamic.setDynamicDate(dynamicDate);
                    userDynamic.setDynamicInformation(dynamicInformation);
                    System.out.println (pList);
                    userDynamic.setPictureList(pList);
                    List<UserDynamic> list = new ArrayList<>();
                    list.add(userDynamic);
                    user.setUserDynamic(list);
	                userService.addorUpdataUser(user);
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }
	}

	}
}
