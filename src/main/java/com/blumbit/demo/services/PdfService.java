package com.blumbit.demo.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.blumbit.demo.dtos.RolDto;
import com.lowagie.text.PageSize;

@Service
public class PdfService {

    private final SpringTemplateEngine springTemplateEngine;

    private final IRolService rolService;

    public PdfService(SpringTemplateEngine springTemplateEngine, IRolService rolService) {
        this.springTemplateEngine = springTemplateEngine;
        this.rolService = rolService;
    }

    public File generateRolesPdf() throws IOException{
        Context context = getContextRolesPdf();
        String html = loadHtmlTemplate(context);
        String xhtml = convertToXtml(html);
        return convertToPdf(xhtml);
    }

    private String convertToXtml(String html){
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        tidy.setIndentContent(true);
        tidy.setPrintBodyOnly(true);
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setShowWarnings(false);
        tidy.setTidyMark(false);

        Document htmlDom = tidy.parseDOM(new ByteArrayInputStream(html.getBytes()), null);
        OutputStream out = new ByteArrayOutputStream();
        tidy.pprint(htmlDom, out);
        return out.toString();
    }

    private File convertToPdf(String xhtml) throws IOException {
        File file = File.createTempFile("roles", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(xhtml, new ClassPathResource("/css/").getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private String loadHtmlTemplate(Context context){
        return this.springTemplateEngine.process("index", context);
    }

    private Context getContextRolesPdf(){
        List<RolDto> roles = this.rolService.findAllRoles();
        Context context = new Context();
        context.setVariable("roles", roles);
        return context;
    }
}
