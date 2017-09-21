package com.icefox.mustRemember;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

public class CreatePDF {

    public static void main(String[] args) {
        try {
            String path = "D:\\test.pdf";
            String path2 = "D:\\test2.pdf";

            OutputStream out = new FileOutputStream(new File(path));

            Document doc = new Document();
            PdfWriter.getInstance(doc, out);

            doc.open();
            doc.addTitle("my docment");
            doc.add(new Paragraph("Hello world"));
            doc.add(new Paragraph(new Date().toString()));
            // 加图片
            Image jpg = Image.getInstance(CreatePDF.class.getResource("img.gif"));
            doc.add(jpg);

            doc.close();
            out.close();

            addPdfMark(path, path2, CreatePDF.class.getResource("img1.png").toString(), 1, "正版授权");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addPdfMark(String InPdfFile, String outPdfFile, String markImagePath, int pageSize,
            String waterMarkName) throws Exception {

        PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(outPdfFile));

        BaseFont base = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// 使用系统字体

        Image img = Image.getInstance(markImagePath);// 插入水印
        // 图片位置
        img.setAbsolutePosition(400, 480);
        int j = waterMarkName.length();
        char c = 0;
        int rise = 0;
        for (int i = 1; i <= pageSize; i++) {
            rise = 400;
            System.out.println(i);
            PdfContentByte under = stamp.getUnderContent(i);

            under.beginText();
            under.setFontAndSize(base, 30);

            if (j >= 15) {
                under.setTextMatrix(200, 120);
                for (int k = 0; k < j; k++) {
                    under.setTextRise(rise);
                    c = waterMarkName.charAt(k);
                    under.showText(c + "");
                }
            } else {
                for (int n = 1; n < 4; n++) {
                    under.setTextMatrix(240 * n, 100 * n);
                    for (int k = 0; k < j; k++) {
                        under.setTextRise(rise);
                        c = waterMarkName.charAt(k);
                        under.showText(c + "");
                        rise -= 18;
                    }
                }
            }

            under.addImage(img);
            under.endText();

            // 画个圈
            // under.ellipse(250, 450, 350, 550);
            // under.setLineWidth(1f);
            // under.stroke();
        }

        stamp.close();// 关闭

        File tempfile = new File(InPdfFile);

        if (tempfile.exists()) {
            tempfile.delete();
        }

    }

}
