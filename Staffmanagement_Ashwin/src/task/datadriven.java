package task;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class datadriven
{
	public static ArrayList<String> add_data(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./excel/Staff_testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		ArrayList<String> array = new ArrayList<String>();
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			Cell cel = sh.getRow(i).getCell(0);	
			String value = cel.toString();
			array.add(value);
		}
		
		return array;
	}
}	
