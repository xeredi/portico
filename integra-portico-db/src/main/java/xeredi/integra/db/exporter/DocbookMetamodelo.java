package xeredi.integra.db.exporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import xeredi.integra.model.proxy.metamodelo.EntidadProxy;
import xeredi.integra.model.proxy.metamodelo.TipoDatoProxy;
import xeredi.integra.model.proxy.metamodelo.TipoEstadisticaProxy;
import xeredi.integra.model.proxy.metamodelo.TipoParametroProxy;
import xeredi.integra.model.proxy.metamodelo.TipoServicioProxy;
import xeredi.integra.model.vo.metamodelo.CodigoReferenciaVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.integra.model.vo.metamodelo.TipoDatoVO;
import xeredi.integra.model.vo.metamodelo.TipoEstadisticaVO;
import xeredi.integra.model.vo.metamodelo.TipoParametroVO;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DocBookMetamodelo.
 */
public final class DocbookMetamodelo {

    /** The file path. */
    private static final String FILE_PATH = "/metamodelo.xml";

    /**
     * Generar.
     */
    public void generar() {
        try (final PrintWriter writer = new PrintWriter(new File(FILE_PATH));) {
            writer.println("<?xml version='1.0' encoding='UTF-8'?>");
            writer.println("<book xml:lang='en' xmlns='http://docbook.org/ns/docbook' version='5.0' xmlns:xi='http://www.w3.org/2001/XInclude' xmlns:xl='http://www.w3.org/1999/xlink'>");
            writer.println("<info><title>Metamodelo de Datos</title></info>");

            // Entidades
            writer.println("<chapter><info><title>Entidades</title></info>");
            // Entidades - Maestros
            writer.println("<section><title>Maestros</title>");
            writer.println("<table><title>Maestros</title><tgroup cols='6'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='2*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='8*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='6*' />");
            writer.println("<colspec colnum='4' colname='col4' colwidth='2*' />");
            writer.println("<colspec colnum='5' colname='col5' colwidth='2*' />");
            writer.println("<colspec colnum='6' colname='col6' colwidth='2*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("<entry>Dup</entry>");
            writer.println("<entry>I18n</entry>");
            writer.println("<entry>Tmp</entry>");
            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoParametroProxy.selectLabelValues()) {
                final TipoParametroVO entiVO = TipoParametroProxy.select((Long) labelValueVO.getValue());

                writer.println("<row>");
                writer.println("<entry>" + entiVO.getId() + "</entry>");
                writer.println("<entry>" + entiVO.getCodigo() + "</entry>");
                writer.println("<entry>" + entiVO.getNombre() + "</entry>");
                writer.println("<entry>" + (entiVO.isCmdDuplicado() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entiVO.isI18n() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entiVO.isTempExp() ? "S" : "") + "</entry>");
                writer.println("</row>");
            }

            writer.println("</tbody></tgroup></table>");
            writer.println("</section>");

            // Entidades - Tipos de Servicio
            writer.println("<section><title>Tipos de Servicio</title>");
            writer.println("<table><title>Tipos de Servicio</title><tgroup cols='7'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='1.5*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='8*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='6*' />");
            writer.println("<colspec colnum='4' colname='col4' colwidth='1.5*' />");
            writer.println("<colspec colnum='5' colname='col5' colwidth='1.5*' />");
            writer.println("<colspec colnum='6' colname='col6' colwidth='1.5*' />");
            writer.println("<colspec colnum='7' colname='col7' colwidth='6*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("<entry>Dup</entry>");
            writer.println("<entry>Tmp</entry>");
            writer.println("<entry>Fact</entry>");
            writer.println("<entry>TD Estado</entry>");
            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoServicioProxy.selectLabelValues()) {
                final TipoServicioVO entiVO = TipoServicioProxy.select((Long) labelValueVO.getValue());

                writer.println("<row>");
                writer.println("<entry>" + entiVO.getId() + "</entry>");
                writer.println("<entry>" + entiVO.getCodigo() + "</entry>");
                writer.println("<entry>" + entiVO.getNombre() + "</entry>");
                writer.println("<entry>" + (entiVO.isCmdDuplicado() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entiVO.isTemporal() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entiVO.isFacturable() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entiVO.getTpdtEstado() == null ? "" : entiVO.getTpdtEstado().getNombre())
                        + "</entry>");
                writer.println("</row>");
            }

            writer.println("</tbody></tgroup></table>");
            writer.println("</section>");

            // Entidades - Tipos de Estadistica
            writer.println("<section><title>Tipos de Estadistica</title>");
            writer.println("<table><title>Tipos de Estadistica</title><tgroup cols='3'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='1.5*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='8*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='6*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoEstadisticaProxy.selectLabelValues()) {
                final TipoEstadisticaVO entiVO = TipoEstadisticaProxy.select((Long) labelValueVO.getValue());

                writer.println("<row>");
                writer.println("<entry>" + entiVO.getId() + "</entry>");
                writer.println("<entry>" + entiVO.getCodigo() + "</entry>");
                writer.println("<entry>" + entiVO.getNombre() + "</entry>");
                writer.println("</row>");
            }

            writer.println("</tbody></tgroup></table>");
            writer.println("</section>");

            writer.println("</chapter>");

            // Tipos de Datos
            writer.println("<chapter><info><title>Tipos de datos</title></info>");
            writer.println("<table width='100%'><title>Tipos de Datos</title><tgroup cols='7'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='2*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='6*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='6*' />");
            writer.println("<colspec colnum='4' colname='col4' colwidth='1*' />");
            writer.println("<colspec colnum='5' colname='col5' colwidth='1*' />");
            writer.println("<colspec colnum='6' colname='col6' colwidth='6*' />");
            writer.println("<colspec colnum='7' colname='col7' colwidth='7*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("<entry>TE</entry>");
            writer.println("<entry>TH</entry>");
            writer.println("<entry>Entidad</entry>");
            writer.println("<entry>Valores</entry>");

            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoDatoProxy.selectLabelValues()) {
                final TipoDatoVO tipoDatoVO = TipoDatoProxy.select((Long) labelValueVO.getValue());

                writer.println("<row>");

                writer.println("<entry>" + tipoDatoVO.getId() + "</entry>");
                writer.println("<entry>" + tipoDatoVO.getCodigo() + "</entry>");
                writer.println("<entry>" + tipoDatoVO.getNombre() + "</entry>");
                writer.println("<entry>" + tipoDatoVO.getTipoElemento() + "</entry>");
                writer.println("<entry>" + tipoDatoVO.getTpht() + "</entry>");
                writer.println("<entry>" + (tipoDatoVO.getEnti() == null ? "" : tipoDatoVO.getEnti().getNombre())
                        + "</entry>");

                writer.println("<entry>");
                if (tipoDatoVO.getCdrfList() != null) {
                    for (final CodigoReferenciaVO codigoReferenciaVO : tipoDatoVO.getCdrfList()) {
                        writer.println(", " + codigoReferenciaVO.getValor());
                    }
                }
                writer.println("</entry>");

                writer.println("</row>");
            }

            writer.println("</tbody></tgroup></table>");
            writer.println("</chapter>");

            // Maestros
            writer.println("<chapter><info><title>Maestros</title></info>");

            for (final LabelValueVO labelValueVO : TipoParametroProxy.selectLabelValues()) {
                final TipoParametroVO entiVO = TipoParametroProxy.select((Long) labelValueVO.getValue());

                writer.println("<section><title>" + entiVO.getNombre() + "</title>");

                writer.println("<section><title>Atributos</title>");
                writer.println("<variablelist>");
                writer.println(getVarlistentry("Codigo", entiVO.getCodigo()));
                writer.println("</variablelist>");
                writer.println("</section>");

                writeEntiInfo(entiVO, writer);

                writer.println("</section>");
            }

            writer.println("</chapter>");

            // Tipos de Servicio
            writer.println("<chapter><info><title>Tipos de Servicio</title></info>");

            for (final LabelValueVO labelValueVO : TipoServicioProxy.selectLabelValues()) {
                final TipoServicioVO entiVO = TipoServicioProxy.select((Long) labelValueVO.getValue());

                writer.println("<section><title>" + entiVO.getNombre() + "</title>");

                writer.println("<section><title>Atributos</title>");
                writer.println("<variablelist>");
                writer.println(getVarlistentry("Codigo", entiVO.getCodigo()));
                writer.println("</variablelist>");
                writer.println("</section>");

                writeEntiInfo(entiVO, writer);

                writer.println("</section>");
            }

            writer.println("</chapter>");

            // Tipos de Estadistica
            writer.println("<chapter><info><title>Tipos de Estadistica</title></info>");

            for (final LabelValueVO labelValueVO : TipoEstadisticaProxy.selectLabelValues()) {
                final TipoEstadisticaVO entiVO = TipoEstadisticaProxy.select((Long) labelValueVO.getValue());

                writer.println("<section><title>" + entiVO.getNombre() + "</title>");

                writer.println("<section><title>Atributos</title>");
                writer.println("<variablelist>");
                writer.println(getVarlistentry("Codigo", entiVO.getCodigo()));
                writer.println("</variablelist>");
                writer.println("</section>");

                writeEntiInfo(entiVO, writer);

                writer.println("</section>");
            }

            writer.println("</chapter>");

            writer.println("</book>");
        } catch (final IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    /**
     * Write enti info.
     * 
     * @param entiVO
     *            the enti vo
     * @param writer
     *            the writer
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void writeEntiInfo(final EntidadVO entiVO, final PrintWriter writer) throws IOException {
        if (entiVO.getEntdList() != null) {
            writer.println("<section><title>Datos Asociados</title>");

            writer.println("<table><title>Datos Asociados de " + entiVO.getNombre() + "</title><tgroup cols='13'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='5*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='8*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='1.5*' />");
            writer.println("<colspec colnum='4' colname='col4' colwidth='1.5*' />");
            writer.println("<colspec colnum='5' colname='col5' colwidth='8*' />");
            writer.println("<colspec colnum='6' colname='col6' colwidth='1*' />");
            writer.println("<colspec colnum='7' colname='col7' colwidth='1*' />");
            writer.println("<colspec colnum='8' colname='col8' colwidth='1*' />");
            writer.println("<colspec colnum='9' colname='col9' colwidth='1*' />");
            writer.println("<colspec colnum='10' colname='col10' colwidth='1*' />");
            writer.println("<colspec colnum='11' colname='col11' colwidth='1*' />");
            writer.println("<colspec colnum='12' colname='col12' colwidth='1*' />");
            writer.println("<colspec colnum='13' colname='col13' colwidth='5*' />");
            writer.println("<thead><row>");
            writer.println("<entry>Etiqueta</entry>");
            writer.println("<entry>T. Dato</entry>");
            writer.println("<entry>TE</entry>");
            writer.println("<entry>TH</entry>");
            writer.println("<entry>Ent. Referenciada</entry>");
            writer.println("<entry>Pt</entry>");
            writer.println("<entry>F</entry>");
            writer.println("<entry>C</entry>");
            writer.println("<entry>An</entry>");
            writer.println("<entry>Ob</entry>");
            writer.println("<entry>Gr</entry>");
            writer.println("<entry>Fl</entry>");
            writer.println("<entry>V. Defecto</entry>");
            writer.println("</row></thead><tbody>");

            for (final Long tpdtId : entiVO.getEntdList()) {
                final EntidadTipoDatoVO entdVO = entiVO.getEntdMap().get(tpdtId);

                writer.println("<row>");
                writer.println("<entry>" + entdVO.getEtiqueta() + "</entry>");
                writer.println("<entry>" + entdVO.getTpdt().getNombre() + "</entry>");
                writer.println("<entry>" + entdVO.getTpdt().getTipoElemento() + "</entry>");
                writer.println("<entry>" + entdVO.getTpdt().getTpht() + "</entry>");
                writer.println("<entry>"
                        + (entdVO.getTpdt().getEnti() == null ? "" : entdVO.getTpdt().getEnti().getNombre())
                        + "</entry>");
                writer.println("<entry>" + (entdVO.getGrupo() == null ? "" : entdVO.getGrupo()) + "</entry>");
                writer.println("<entry>" + entdVO.getFila() + "</entry>");
                writer.println("<entry>" + entdVO.getOrden() + "</entry>");
                writer.println("<entry>" + entdVO.getSpan() + "</entry>");
                writer.println("<entry>" + (entdVO.isObligatorio() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entdVO.isGridable() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entdVO.isFiltrable() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entdVO.getValorDefecto() == null ? "" : entdVO.getValorDefecto())
                        + "</entry>");
                writer.println("</row>");
            }

            writer.println("</tbody></tgroup></table>");

            writer.println("</section>");
        }

        if (entiVO.getEntiHijasList() != null) {
            writer.println("<section><title>Entidades hijas</title>");

            writer.println("<table><title>Entidades hijas de " + entiVO.getNombre() + "</title><tgroup cols='2'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='8*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='6*' />");
            writer.println("<thead><row>");
            writer.println("<entry>Codigo</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("</row></thead><tbody>");

            for (final Long entiHijaId : entiVO.getEntiHijasList()) {
                final EntidadVO entiHijaVO = EntidadProxy.select(entiHijaId);

                writer.println("<row>");
                writer.println("<entry>" + entiHijaVO.getCodigo() + "</entry>");
                writer.println("<entry>" + entiHijaVO.getNombre() + "</entry>");
                writer.println("</row>");
            }

            writer.println("</tbody></tgroup></table>");

            writer.println("</section>");
        }
    }

    private String getVarlistentry(final String dt, final String dd) {
        return "<varlistentry><term>" + dt + "</term><listitem><para>" + dd + "</para></listitem></varlistentry>";
    }

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final DocbookMetamodelo docbookMetamodelo = new DocbookMetamodelo();

        docbookMetamodelo.generar();
    }
}
