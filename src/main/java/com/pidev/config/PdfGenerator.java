package com.pidev.config;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pidev.models.Reservation;

public class PdfGenerator {
	private List<Reservation> listReservations;
    
    public PdfGenerator(List<Reservation> listReservations) {
        this.listReservations = listReservations;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Company", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Reserved By", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);
         
        
        cell.setPhrase(new Phrase("Duration", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("Number of people", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("Contact Info", font));
        table.addCell(cell); 
    }
     
    private void writeTableData(PdfPTable table) {
        for (Reservation reservation : listReservations) {
            table.addCell(String.valueOf(reservation.getIdReservation()));
            table.addCell(reservation.getCompanyName());
            table.addCell(reservation.getReservedBy());
            table.addCell(String.valueOf(reservation.getDateReservation()));
            table.addCell(String.valueOf(reservation.getDuration()));
            table.addCell(String.valueOf(reservation.getNumberPeople()));
            table.addCell(String.valueOf(reservation.getTel()));
        }
    }
     
    
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Reservations List", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 1.5f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }

}
