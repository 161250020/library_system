package changeFileToPDF;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/**
 * author：丁雯雯
 * time：2019/01/25
 * 管理员的基本信息
 */
public class change2 {
    public static boolean getLicense() {

        boolean result = false;

        try {

            InputStream is = Test.class.getClassLoader().getResourceAsStream("wordlicense.xml"); //  wordlicense.xml应放在..\WebRoot\WEB-INF\classes路径下

            com.aspose.words.License aposeLic = new com.aspose.words.License();

            aposeLic.setLicense(is);

            result = true;

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }

    public static void word2pdf(String Address) {

        if (!getLicense()) {          // 验证License 若不验证则转化出的PDP文档会有水印产生

            return;

        }

        try {

            File file = new File("F:/pdf1.pdf");  //新建一个空白pdf文档

            FileOutputStream os = new FileOutputStream(file);
System.out.println(Address);
            Document doc = new Document(Address);                    //Address是将要被转化的word文档

            doc.save(os, SaveFormat.PDF);                            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换            os.close();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }
}
