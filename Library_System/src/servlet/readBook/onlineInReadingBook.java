package servlet.readBook;

import changeFileToPDF.Word2Pdf;
import factory.ServiceFactory;
import model.ElectronicBooks;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 管理员的基本信息
 */
@WebServlet(name = "onlineInReadingBook")
public class onlineInReadingBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet---onlineInReadingBook");

        HttpSession session=request.getSession(false);
        ServletContext context = getServletContext();

        String showEBookId=request.getParameter("eBookId");
        ElectronicBooks ebookInfo = ServiceFactory.getElectronicBooksManageService().getElectronicBookInfoById(showEBookId);

        session.setAttribute("ebookInfo", ebookInfo);
        if(ebookInfo.getId()!=null){//根据输入的电子书的ID可以寻找到电子书
            //电子书如果不是PDF的则将其转化成PDF文件并且修改path
            if(ebookInfo.getDocumentFormat().equals("pdf")){
                session.setAttribute("filePath", ebookInfo.getFilepath());
            }
            else{
                String uuid= UUID.randomUUID().toString();//转化成的PDF的名称
                String Address="Library_System/web"+ebookInfo.getFilepath();
                System.out.println(Address);
                Word2Pdf.word2pdf(Address, uuid);//新建PDF文件
                String path=ebookInfo.getFilepath().substring(0, 22)+uuid+".pdf";
                System.out.println(path);
                session.setAttribute("filePath",path);//传递新建的PDF文件的路径
            }
            context.getRequestDispatcher("/jsps/readBook/onlineInReadingBook.jsp").forward(request, response);
        }
        else{//根据输入的电子书的ID无法寻找到电子书：返回错误提醒："该ID电子书不存在或者寻找失误！"
            request.setAttribute("errInfo","错误提示：该ID电子书不存在或者寻找失误！");
            context.getRequestDispatcher("/jsps/readBook/onlineReadBook.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
