package RestProject.Test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
	public String ReadFile(String File, String dataSheet,String ColoumnHeader) throws IOException{
		String returnValue=null;
		FileInputStream file=new FileInputStream(new File(File));
		Workbook work=new XSSFWorkbook(file);
		Sheet sheet=work.getSheet(dataSheet);
		Row row=sheet.getRow(0);
		int endrow=sheet.getLastRowNum();//1
		int endcoloumn=row.getLastCellNum();//2
		for(int firstrow=1;firstrow<=endrow;firstrow++){
			for(int firstcolounm=0;firstcolounm<endcoloumn;firstcolounm++){
				if(sheet.getRow(0).getCell(firstcolounm).getStringCellValue().equals(ColoumnHeader)){
					System.out.println(firstrow+":firstrow");
					System.out.println(firstrow+":firstcolounm");
					returnValue=sheet.getRow(firstrow).getCell(firstcolounm).getStringCellValue();
				}
			}
		}
		  return 	returnValue;
	}
}
