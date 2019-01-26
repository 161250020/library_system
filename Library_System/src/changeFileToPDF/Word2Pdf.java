package changeFileToPDF;

import com.aspose.words.Document;         //引入aspouse-word-14.11.0-jdk16.jar包
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/**
 * author：丁雯雯
 * time：2019/01/25
 * 进行Word转PDF
 */
public class Word2Pdf {
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = Test.class.getClassLoader().getResourceAsStream("wordlicense.xml");
            //  wordlicense.xml应放在..\WebRoot\WEB-INF\classes路径下
            com.aspose.words.License aposeLic = new com.aspose.words.License();
            aposeLic.setLicense(is);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void word2pdf(String Address, String fileName) {//在相对路径下面创建PDF文件
        if (!getLicense()) {          // 验证License 若不验证则转化出的PDP文档会有水印产生
            return;
        }
        try {
            //新建文件的路径
            String newpath2=Word2Pdf.class.getResource("/").getFile();//获得的地址当中的" "为"%20"
            String[] pathSplits=newpath2.split("out/artifacts");
            String newFilePath=pathSplits[0]+"Library_System/web/jsps/readBook/ebooks/"+fileName+".pdf";
            newFilePath=newFilePath.substring(1);
            newFilePath=newFilePath.replace("%20"," ");//将"%20"转化成" "，否则福阿创建新的文件

            Address=pathSplits[0]+Address;
            Address=Address.substring(1);//需要转化的Word文件的绝对路径
            Address=Address.replace("%20"," ");

            File file = new File(newFilePath);  //新建一个空白pdf文档
            //File file=new File("F:/学习资料/大3/第2学期/软件系统设计与体系结构/作业/Assignment 3 Design Patterns/library_system/Library_System/web/jsps/readBook/ebooks/02cdd54a-c2e1-4c82-b2c8-b4d1504edc1d.pdf");
            FileOutputStream os = new FileOutputStream(file);

            Address="F:/学习资料/大3/第2学期/软件系统设计与体系结构/作业/Assignment 3 Design Patterns/library_system/Library_System/web/jsps/readBook/ebooks/Linux系统基础实验一答案.doc";
            System.out.println("--:"+Address);
            Document doc = new Document(Address);//Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF); //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换            os.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
