package xeredi.integra.model.report.rtf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InternalErrorException;

// TODO: Auto-generated Javadoc
/**
 * The Class RtfGenerator.
 */
public final class RtfGenerator {

    /**
     * Generate.
     *
     * @param templateName
     *            the template name
     * @param destFile
     *            the dest file
     * @param context
     *            the context
     * @throws ApplicationException
     *             the application exception
     */
    public void generate(final String templateName, final String destFile, final Map<String, Object> context)
            throws ApplicationException {
        try (final InputStream in = this.getClass().getResourceAsStream(templateName);
                final OutputStream out = new FileOutputStream(new File(destFile))) {
            final IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
            final FieldsMetadata metadata = new FieldsMetadata();

            metadata.addFieldAsList("items.c1");
            metadata.addFieldAsList("items.c2");

            report.setFieldsMetadata(metadata);

            final IContext icontext = report.createContext();

            icontext.putMap(context);

            report.process(icontext, out);
        } catch (final XDocReportException ex) {
            throw new InternalErrorException(ex);
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final RtfGenerator generator = new RtfGenerator();
        final Map<String, Object> context = new HashMap<>();

        context.put("prueba", "Texto de Prueba");
        context.put("fecha", "12");

        final List<TestVO> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(new TestVO("v1_" + i, "v2_" + i));
        }

        context.put("items", list);

        try {
            generator.generate("/xeredi/integra/model/report/rtf/DocxTemplate.docx", "/test.docx", context);
        } catch (final ApplicationException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
