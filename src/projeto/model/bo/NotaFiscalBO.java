package projeto.model.bo;

import java.io.FileOutputStream;

import javafx.event.ActionEvent;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import projeto.model.vo.NotaFiscalVO;

public class NotaFiscalBO implements NotaFiscalInterBO{
	public void imprimir (NotaFiscalVO nota) {
			Document doc = new Document();
			String ArquivoPdf = "Nota de venda";
			try {
				PdfWriter.getInstance(doc, new FileOutputStream(ArquivoPdf));
				doc.open();
				doc.setPageSize(PageSize.A3);
				Paragraph p = new Paragraph (" Nota de venda");
				p.setAlignment(1);
				p =  new Paragraph(" ");
				
			} catch (Exception e){
				
			}
		}
	
	
	public void exibir (NotaFiscalVO nota) {
		// Esse metodo irá exibir a nota fiscal da
		// Venda que está sendo posta como atributo
		// em NotaFiscalVO
	}
}
