package extend.views;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.beyang.cn.entity.User;
@Component
public class MyExcelView extends AbstractExcelView{ 
	@Override  
	@SuppressWarnings({"unchecked"})  
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,HttpServletResponse response) throws Exception{  
		response.setHeader("Content-Disposition", "attachment;filename=bruce.xls");
	    List<User> rrl = (List<User>) model.get("userList");  
	    HSSFSheet sheet = workbook.createSheet("测试");  
	    //setColumnsWidth(sheet);  
	    fillTableHeader(workbook, sheet);  
	    fillTableBody(workbook, sheet, rrl);  
	}  
	private void setColumnsWidth(HSSFSheet sheet) {  
	    final int[] warr = new int[] {  
	        500,  // <空>  
	        4500, // 日期  
	        4500, // 车辆  
	        4500, // 燃油种类  
	        4500, // 燃油单价  
	        4500, // 加油方式  
	        4500, // 加油量  
	        3000, // 花费  
	        12000  // 备注  
	    };  
	    for (int i = 0; i < warr.length; i ++) {  
	        sheet.setColumnWidth(i, warr[i]);  
	    }  
	}  
	// 填充表格头  
	private void fillTableHeader(HSSFWorkbook workbook, HSSFSheet sheet) {  
	    final String[] contents = new String[] {  
	        "序号",  
	        "用户名",  
	        "年龄",  
	        "学号",  
	        "地址",  
	        "备注"  
	    };  
	    int r = 1;  
	    int c = 1;  
	    CellStyle style = workbook.createCellStyle();  
	    style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());      // 填充黄色  
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);           // 填充方式  
	    // 设置border  
	    style.setBorderLeft(CellStyle.BORDER_THIN);  
	    style.setBorderRight(CellStyle.BORDER_THIN);  
	    style.setBorderTop(CellStyle.BORDER_THIN);  
	    style.setBorderBottom(CellStyle.BORDER_THIN);  
	    for (int i = 0; i < contents.length; i ++) {  
	        Cell cell = getCell(sheet, r, c + i);  
	        cell.setCellValue(contents[i]);  
	        cell.setCellStyle(style);  
	    }  
	}  
  
	 private void fillTableBody(HSSFWorkbook workbook, HSSFSheet sheet, List<User> records) {  
	    // 通用style  
	    CellStyle style = workbook.createCellStyle();  
	    style.setFillForegroundColor(IndexedColors.WHITE.getIndex());       // 填充白色  
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);                   // 填充方式  
	    style.setBorderLeft(CellStyle.BORDER_THIN);  
	    style.setBorderRight(CellStyle.BORDER_THIN);  
	    style.setBorderTop(CellStyle.BORDER_THIN);  
	    style.setBorderBottom(CellStyle.BORDER_THIN);  
	      
	    // 日期style  
	    CellStyle dateStyle = workbook.createCellStyle();  
	    dateStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());       // 填充白色  
	    dateStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);                   // 填充方式  
	    dateStyle.setBorderLeft(CellStyle.BORDER_THIN);  
	    dateStyle.setBorderRight(CellStyle.BORDER_THIN);  
	    dateStyle.setBorderTop(CellStyle.BORDER_THIN);  
	    dateStyle.setBorderBottom(CellStyle.BORDER_THIN);  
	    dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));  
	      
	    int r = 2;  
	    int c = 1;  
	    Cell cell = null;  
	    for (int i = 0; i < records.size(); i ++) {  
	    	User user = records.get(i);  
	          
	        // 序号  
	        cell = getCell(sheet, r, c + 0);  
	        cell.setCellValue(i+1);  
	        cell.setCellStyle(dateStyle);  
	
	        // userName  
	        cell = getCell(sheet, r, c + 1);  
	        if (user.getUserName()!= null)  
	        cell.setCellValue(user.getUserName());  
	        cell.setCellStyle(style);  
	          
	        // userAge 
	        cell = getCell(sheet, r, c + 2);  
	        if (user.getAge() != null)  
	         cell.setCellValue(user.getAge());   
	         cell.setCellStyle(style);  
	          
	        // userNo  
	        cell = getCell(sheet, r, c + 3);  
	        if (user.getUserNo() != null)  
	        cell.setCellValue(user.getUserNo());  
	        cell.setCellStyle(style);  
	          
	        // address  
	        cell = getCell(sheet, r, c + 4);  
	        if (user.getAddress()!= null) 
	        cell.setCellValue("");  
	        cell.setCellStyle(style); 
	          
	        // 备注 
	        cell = getCell(sheet, r, c + 5);  
	        cell.setCellValue("");  
	        cell.setCellStyle(style);  
	        r ++;  
	    }  
	}
}
