package com.health.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.health.model.PhysicalCondition;
import com.health.model.User;
import com.health.service.impl.UserService;
import com.health.util.Calculate;
import com.health.util.GetBodyCondition;
import com.health.util.JsonToModel;

@Component ("UploadUserPhoto")
public class UploadUserPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	@Resource
	private Calculate calculate;

    public UploadUserPhoto() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
        if(isMultipart){  
            String realPath = this.getServletContext().getRealPath("upload");  
              
            System.out.println(realPath);  
              
            File dir = new File(realPath);  
              
            if(!dir.exists()){  
                dir.mkdir();  
            }  
              
            DiskFileItemFactory factory = new DiskFileItemFactory();  
            ServletFileUpload upload = new ServletFileUpload(factory);  
              
            upload.setHeaderEncoding("utf-8");  
              
            try {  
                List<FileItem> items = upload.parseRequest(request);  
                 User user = new User();
                for(FileItem item : items){  
                    if(item.isFormField()){ //username="username"  
                        String name = item.getFieldName();  
                        String value = item.getString("utf-8"); 
                        if (value != null) {
                        	int id = Integer.parseInt(value);
                        	user = userService.getUser(id);
                        }
                          //System.out.println("askjhdajks");
                        System.out.println(name + " = " + value);  
                    } else { //文件  
                        String name = item.getName();  
                        item.write(new File(dir, user.getId() + name.substring(name.lastIndexOf("."))));  
                        user.setHeadPortrait("/" + "healthAppService/upload" + "/" + user.getId() + name.substring(name.lastIndexOf(".")));
                        userService.addorUpdataUser(user);
                        System.out.println(user.getHeadPortrait());
                        JSONObject json = new JSONObject();
                        json.accumulate("headPortrait", user.getHeadPortrait());
                        response.getWriter().println(json.toString());
                    }  
                      
                }  
                  
            } catch (Exception e) {  
                e.printStackTrace();  
            }
        }
		
		/*request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String str = request.getParameter("id");
		String userpic = request.getParameter("userpic");
		System.out.println(userpic);
		
		System.out.println(str);
		int  id = 0;
		if (str != null)
			id = Integer.parseInt(str);
		System.out.println (id);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String time = String.valueOf(System.currentTimeMillis());
		String path = request.getSession().getServletContext()
				.getRealPath("/image");
		System.out.println("path:" + path);
		if (!new File(path).exists()) {
			new File(path).mkdir();
		}
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list;
			list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				
				String name = item.getFieldName();
				
				if (item.isFormField()) {
					
					String value = item.getString();
					request.setAttribute(name, value);
				}
				
				else {
				
					String value = item.getName();
				
					int start = value.lastIndexOf("\\");
					
					String filename = time + ".jpg";
				
					OutputStream out = new FileOutputStream(new File(path,
							filename));
					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];
					
					while ((length = in.read(buf)) != -1) {
						out.write(buf, 0, length);
					}
					System.out.println (filename);
					in.close();
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}*/
	}

}
