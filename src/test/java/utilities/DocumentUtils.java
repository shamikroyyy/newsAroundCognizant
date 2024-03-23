package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class DocumentUtils {
	
	public XWPFDocument document;
	String path;
	public FileOutputStream out;
	public XWPFParagraph paragraph;
	public XWPFRun line;
	
	public DocumentUtils(String path) throws FileNotFoundException
	{
		this.path=path;
		document = new XWPFDocument();
	    out= new FileOutputStream(new File(path));
	    paragraph= document.createParagraph();
	}
	
	public void printingLine(String text)
	{
	    line = paragraph.createRun();
	    line.setText(text);
	    line.addBreak();
	}
	
	public void closingDocument() throws IOException
	{
	    document.write(out);
	    out.close();
	    document.close();
	}
}
