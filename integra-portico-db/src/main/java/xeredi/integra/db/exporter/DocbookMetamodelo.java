package xeredi.integra.db.exporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.metamodelo.proxy.EntidadProxy;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DocBookMetamodelo.
 */
public final class DocbookMetamodelo {

    /** The file path. */
    private static final String FILE_PATH = "src/docbkx/metamodelo.xml";

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
            writer.println("<informaltable><title>Maestros</title><tgroup cols='6'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='2*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='6*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='8*' />");
            writer.println("<colspec colnum='4' colname='col4' colwidth='2*' />");
            writer.println("<colspec colnum='5' colname='col5' colwidth='2*' />");
            writer.println("<colspec colnum='6' colname='col6' colwidth='2*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("<entry>Dup</entry>");
            writer.println("<entry>I18n</entry>");
            writer.println("<entry>Tmp</entry>");
            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoParametroProxy.selectLabelValues()) {
                try {
                    final TipoParametroVO entiVO = TipoParametroProxy.select((Long) labelValueVO.getValue());

                    writer.println("<row>");
                    writer.println("<entry>" + entiVO.getId() + "</entry>");
                    writer.println("<entry>" + entiVO.getNombre() + "</entry>");
                    writer.println("<entry>" + entiVO.getCodigo() + "</entry>");
                    writer.println("<entry>" + (entiVO.getCmdDuplicado() ? "S" : "") + "</entry>");
                    writer.println("<entry>" + (entiVO.getI18n() ? "S" : "") + "</entry>");
                    writer.println("<entry>" + (entiVO.getTempExp() ? "S" : "") + "</entry>");
                    writer.println("</row>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</section>");

            // Entidades - Submaestros
            writer.println("<section><title>Submaestros</title>");
            writer.println("<informaltable><title>Maestros</title><tgroup cols='8'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='2*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='6*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='8*' />");
            writer.println("<colspec colnum='4' colname='col4' colwidth='6*' />");
            writer.println("<colspec colnum='5' colname='col5' colwidth='6*' />");
            writer.println("<colspec colnum='6' colname='col6' colwidth='2*' />");
            writer.println("<colspec colnum='7' colname='col7' colwidth='2*' />");
            writer.println("<colspec colnum='8' colname='col8' colwidth='2*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("<entry>Maestro Padre</entry>");
            writer.println("<entry>Maestro Asoc.</entry>");
            writer.println("<entry>Dup</entry>");
            writer.println("<entry>I18n</entry>");
            writer.println("<entry>Tmp</entry>");
            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoSubparametroProxy.selectLabelValues()) {
                try {
                    final TipoSubparametroVO entiVO = TipoSubparametroProxy.select((Long) labelValueVO.getValue());
                    final TipoParametroVO tpprPadreVO = TipoParametroProxy.select(entiVO.getTpprId());

                    writer.println("<row>");
                    writer.println("<entry>" + entiVO.getId() + "</entry>");
                    writer.println("<entry>" + entiVO.getNombre() + "</entry>");
                    writer.println("<entry>" + entiVO.getCodigo() + "</entry>");
                    writer.println("<entry>" + tpprPadreVO.getNombre() + "</entry>");
                    writer.println("<entry>" + entiVO.getTpprAsociado().getNombre() + "</entry>");
                    writer.println("<entry>" + (entiVO.getCmdDuplicado() ? "S" : "") + "</entry>");
                    writer.println("<entry>" + (entiVO.getI18n() ? "S" : "") + "</entry>");
                    writer.println("<entry>" + (entiVO.getTempExp() ? "S" : "") + "</entry>");
                    writer.println("</row>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</section>");

            // Entidades - Tipos de Servicio
            writer.println("<section><title>Tipos de Servicio</title>");
            writer.println("<informaltable><title>Tipos de Servicio</title><tgroup cols='7'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='1.5*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='6*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='8*' />");
            writer.println("<colspec colnum='4' colname='col4' colwidth='1.5*' />");
            writer.println("<colspec colnum='5' colname='col5' colwidth='1.5*' />");
            writer.println("<colspec colnum='6' colname='col6' colwidth='1.5*' />");
            writer.println("<colspec colnum='7' colname='col7' colwidth='6*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("<entry>Dup</entry>");
            writer.println("<entry>Tmp</entry>");
            writer.println("<entry>Fact</entry>");
            writer.println("<entry>TD Estado</entry>");
            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoServicioProxy.selectLabelValues()) {
                try {
                    final TipoServicioVO entiVO = TipoServicioProxy.select((Long) labelValueVO.getValue());

                    writer.println("<row>");
                    writer.println("<entry>" + entiVO.getId() + "</entry>");
                    writer.println("<entry>" + entiVO.getNombre() + "</entry>");
                    writer.println("<entry>" + entiVO.getCodigo() + "</entry>");
                    writer.println("<entry>" + (entiVO.getCmdDuplicado() ? "S" : "") + "</entry>");
                    writer.println("<entry>" + (entiVO.getTemporal() ? "S" : "") + "</entry>");
                    writer.println("<entry>" + (entiVO.getFacturable() ? "S" : "") + "</entry>");
                    writer.println("<entry>"
                            + (entiVO.getTpdtEstado() == null ? "" : entiVO.getTpdtEstado().getNombre()) + "</entry>");
                    writer.println("</row>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</section>");

            // Entidades - Tipos de Subservicio
            writer.println("<section><title>Tipos de Subservicio</title>");
            writer.println("<informaltable><title>Tipos de Subservicio</title><tgroup cols='7'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='1.5*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='6*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='8*' />");
            writer.println("<colspec colnum='4' colname='col4' colwidth='1.5*' />");
            writer.println("<colspec colnum='5' colname='col5' colwidth='1.5*' />");
            writer.println("<colspec colnum='6' colname='col6' colwidth='1.5*' />");
            writer.println("<colspec colnum='7' colname='col7' colwidth='6*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("<entry>Dup</entry>");
            writer.println("<entry>Tmp</entry>");
            writer.println("<entry>Fact</entry>");
            writer.println("<entry>TD Estado</entry>");
            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoSubservicioProxy.selectLabelValues()) {
                try {
                    final TipoSubservicioVO entiVO = TipoSubservicioProxy.select((Long) labelValueVO.getValue());

                    writer.println("<row>");
                    writer.println("<entry>" + entiVO.getId() + "</entry>");
                    writer.println("<entry>" + entiVO.getNombre() + "</entry>");
                    writer.println("<entry>" + entiVO.getCodigo() + "</entry>");
                    writer.println("<entry>" + (entiVO.getCmdDuplicado() ? "S" : "") + "</entry>");
                    writer.println("<entry>" + (entiVO.getTemporal() ? "S" : "") + "</entry>");
                    writer.println("<entry>" + (entiVO.getFacturable() ? "S" : "") + "</entry>");
                    writer.println("<entry>"
                            + (entiVO.getTpdtEstado() == null ? "" : entiVO.getTpdtEstado().getNombre()) + "</entry>");
                    writer.println("</row>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</section>");

            // Entidades - Tipos de Estadistica
            writer.println("<section><title>Tipos de Estadistica</title>");
            writer.println("<informaltable><title>Tipos de Estadistica</title><tgroup cols='3'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='1.5*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='6*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='8*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoEstadisticaProxy.selectLabelValues()) {
                try {
                    final TipoEstadisticaVO entiVO = TipoEstadisticaProxy.select((Long) labelValueVO.getValue());

                    writer.println("<row>");
                    writer.println("<entry>" + entiVO.getId() + "</entry>");
                    writer.println("<entry>" + entiVO.getNombre() + "</entry>");
                    writer.println("<entry>" + entiVO.getCodigo() + "</entry>");
                    writer.println("</row>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</section>");

            writer.println("</chapter>");

            // Tipos de Datos
            writer.println("<chapter><info><title>Tipos de datos</title></info>");
            writer.println("<informaltable width='100%'><title>Tipos de Datos</title><tgroup cols='7'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='2*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='6*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='6*' />");
            writer.println("<colspec colnum='4' colname='col4' colwidth='1*' />");
            writer.println("<colspec colnum='5' colname='col5' colwidth='1*' />");
            writer.println("<colspec colnum='6' colname='col6' colwidth='6*' />");
            writer.println("<colspec colnum='7' colname='col7' colwidth='7*' />");
            writer.println("<thead><row>");
            writer.println("<entry>ID</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("<entry>Código</entry>");
            writer.println("<entry>TE</entry>");
            writer.println("<entry>TH</entry>");
            writer.println("<entry>Entidad</entry>");
            writer.println("<entry>Valores</entry>");

            writer.println("</row></thead><tbody>");

            for (final LabelValueVO labelValueVO : TipoDatoProxy.selectLabelValues()) {
                try {
                    final TipoDatoVO tipoDatoVO = TipoDatoProxy.select((Long) labelValueVO.getValue());

                    writer.println("<row>");

                    writer.println("<entry>" + tipoDatoVO.getId() + "</entry>");
                    writer.println("<entry>" + tipoDatoVO.getNombre() + "</entry>");
                    writer.println("<entry>" + tipoDatoVO.getCodigo() + "</entry>");
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
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</chapter>");

            // Maestros
            writer.println("<chapter><info><title>Maestros</title></info>");

            for (final LabelValueVO labelValueVO : TipoParametroProxy.selectLabelValues()) {
                try {
                    final TipoParametroVO entiVO = TipoParametroProxy.select((Long) labelValueVO.getValue());

                    writer.println("<section xml:id='ent_" + entiVO.getCodigo() + "'><title>" + entiVO.getNombre()
                            + "</title>");

                    writer.println("<section><title>Atributos</title>");
                    writer.println("<informaltable width='100%'><title>Atributos de " + entiVO.getNombre()
                            + "</title><tgroup cols='2'>");
                    writer.println("<colspec colnum='1' colname='col1' colwidth='1*' />");
                    writer.println("<colspec colnum='2' colname='col2' colwidth='4*' />");
                    writer.println("<tbody>");
                    writer.println("<row><entry>Codigo</entry><entry>" + entiVO.getCodigo() + "</entry></row>");
                    writer.println("<row><entry>Nombre</entry><entry>" + entiVO.getNombre() + "</entry></row>");
                    writer.println("<row><entry>Etiqueta</entry><entry>" + entiVO.getEtiqueta() + "</entry></row>");
                    writer.println("<row><entry>Temporalidad Explicita?</entry><entry>"
                            + (entiVO.getTempExp() ? "S" : "N") + "</entry></row>");
                    writer.println("<row><entry>I18N?</entry><entry>" + (entiVO.getI18n() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Alta?</entry><entry>" + (entiVO.getCmdAlta() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Baja?</entry><entry>" + (entiVO.getCmdBaja() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Edicion?</entry><entry>" + (entiVO.getCmdEdicion() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Duplicado?</entry><entry>"
                            + (entiVO.getCmdDuplicado() ? "S" : "N") + "</entry></row>");
                    writer.println("</tbody></tgroup></informaltable>");
                    writer.println("</section>");

                    writeEntiInfo(entiVO, writer);

                    writer.println("</section>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</chapter>");

            // Submaestros
            writer.println("<chapter><info><title>Submaestros</title></info>");

            for (final LabelValueVO labelValueVO : TipoSubparametroProxy.selectLabelValues()) {
                try {
                    final TipoSubparametroVO entiVO = TipoSubparametroProxy.select((Long) labelValueVO.getValue());
                    final TipoParametroVO tpprPadreVO = TipoParametroProxy.select(entiVO.getTpprId());

                    writer.println("<section xml:id='ent_" + entiVO.getCodigo() + "'><title>" + entiVO.getNombre()
                            + "</title>");

                    writer.println("<section><title>Atributos</title>");
                    writer.println("<informaltable width='100%'><title>Atributos de " + entiVO.getNombre()
                            + "</title><tgroup cols='2'>");
                    writer.println("<colspec colnum='1' colname='col1' colwidth='1*' />");
                    writer.println("<colspec colnum='2' colname='col2' colwidth='4*' />");
                    writer.println("<tbody>");
                    writer.println("<row><entry>Codigo</entry><entry>" + entiVO.getCodigo() + "</entry></row>");
                    writer.println("<row><entry>Nombre</entry><entry>" + entiVO.getNombre() + "</entry></row>");
                    writer.println("<row><entry>Etiqueta</entry><entry>" + entiVO.getEtiqueta() + "</entry></row>");
                    writer.println("<row><entry>Maestro Padre</entry><entry>" + getLinkEntidad(tpprPadreVO)
                            + "</entry></row>");
                    writer.println("<row><entry>Maestro Asoc.</entry><entry>"
                            + getLinkEntidad(entiVO.getTpprAsociado()) + "</entry></row>");
                    writer.println("<row><entry>Temporalidad Explicita?</entry><entry>"
                            + (entiVO.getTempExp() ? "S" : "N") + "</entry></row>");
                    writer.println("<row><entry>I18N?</entry><entry>" + (entiVO.getI18n() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Alta?</entry><entry>" + (entiVO.getCmdAlta() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Baja?</entry><entry>" + (entiVO.getCmdBaja() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Edicion?</entry><entry>" + (entiVO.getCmdEdicion() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Duplicado?</entry><entry>"
                            + (entiVO.getCmdDuplicado() ? "S" : "N") + "</entry></row>");
                    writer.println("</tbody></tgroup></informaltable>");
                    writer.println("</section>");

                    writeEntiInfo(entiVO, writer);

                    writer.println("</section>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</chapter>");

            // Tipos de Servicio
            writer.println("<chapter><info><title>Tipos de Servicio</title></info>");

            for (final LabelValueVO labelValueVO : TipoServicioProxy.selectLabelValues()) {
                try {
                    final TipoServicioVO entiVO = TipoServicioProxy.select((Long) labelValueVO.getValue());

                    writer.println("<section xml:id='ent_" + entiVO.getCodigo() + "'><title>" + entiVO.getNombre()
                            + "</title>");

                    writer.println("<section><title>Atributos</title>");
                    writer.println("<informaltable width='100%'><title>Atributos de " + entiVO.getNombre()
                            + "</title><tgroup cols='2'>");
                    writer.println("<colspec colnum='1' colname='col1' colwidth='1*' />");
                    writer.println("<colspec colnum='2' colname='col2' colwidth='4*' />");
                    writer.println("<tbody>");
                    writer.println("<row><entry>Codigo</entry><entry>" + entiVO.getCodigo() + "</entry></row>");
                    writer.println("<row><entry>Nombre</entry><entry>" + entiVO.getNombre() + "</entry></row>");
                    writer.println("<row><entry>Etiqueta</entry><entry>" + entiVO.getEtiqueta() + "</entry></row>");
                    writer.println("<row><entry>Temporal?</entry><entry>" + (entiVO.getTemporal() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Facturable?</entry><entry>" + (entiVO.getFacturable() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Alta?</entry><entry>" + (entiVO.getCmdAlta() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Baja?</entry><entry>" + (entiVO.getCmdBaja() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Edicion?</entry><entry>" + (entiVO.getCmdEdicion() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Duplicado?</entry><entry>"
                            + (entiVO.getCmdDuplicado() ? "S" : "N") + "</entry></row>");
                    writer.println("</tbody></tgroup></informaltable>");
                    writer.println("</section>");

                    writeEntiInfo(entiVO, writer);

                    writer.println("</section>");
                    writer.println("<?hard-pagebreak?>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</chapter>");

            // Tipos de Subservicio
            writer.println("<chapter><info><title>Tipos de Subservicio</title></info>");

            for (final LabelValueVO labelValueVO : TipoSubservicioProxy.selectLabelValues()) {
                try {
                    final TipoSubservicioVO entiVO = TipoSubservicioProxy.select((Long) labelValueVO.getValue());

                    writer.println("<section xml:id='ent_" + entiVO.getCodigo() + "'><title>" + entiVO.getNombre()
                            + "</title>");

                    writer.println("<section><title>Atributos</title>");
                    writer.println("<informaltable width='100%'><title>Atributos de " + entiVO.getNombre()
                            + "</title><tgroup cols='2'>");
                    writer.println("<colspec colnum='1' colname='col1' colwidth='1*' />");
                    writer.println("<colspec colnum='2' colname='col2' colwidth='4*' />");
                    writer.println("<tbody>");
                    writer.println("<row><entry>Codigo</entry><entry>" + entiVO.getCodigo() + "</entry></row>");
                    writer.println("<row><entry>Nombre</entry><entry>" + entiVO.getNombre() + "</entry></row>");
                    writer.println("<row><entry>Etiqueta</entry><entry>" + entiVO.getEtiqueta() + "</entry></row>");
                    writer.println("<row><entry>Tipo de Servicio</entry><entry>"
                            + getLinkEntidad(TipoServicioProxy.select(entiVO.getTpsrId())) + "</entry></row>");
                    writer.println("<row><entry>Temporal?</entry><entry>" + (entiVO.getTemporal() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Facturable?</entry><entry>" + (entiVO.getFacturable() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Alta?</entry><entry>" + (entiVO.getCmdAlta() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Baja?</entry><entry>" + (entiVO.getCmdBaja() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Edicion?</entry><entry>" + (entiVO.getCmdEdicion() ? "S" : "N")
                            + "</entry></row>");
                    writer.println("<row><entry>Cmd. Duplicado?</entry><entry>"
                            + (entiVO.getCmdDuplicado() ? "S" : "N") + "</entry></row>");
                    writer.println("</tbody></tgroup></informaltable>");
                    writer.println("</section>");

                    writeEntiInfo(entiVO, writer);

                    writer.println("</section>");
                    writer.println("<?hard-pagebreak?>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</chapter>");

            // Tipos de Estadistica
            writer.println("<chapter><info><title>Tipos de Estadistica</title></info>");

            for (final LabelValueVO labelValueVO : TipoEstadisticaProxy.selectLabelValues()) {
                try {
                    final TipoEstadisticaVO entiVO = TipoEstadisticaProxy.select((Long) labelValueVO.getValue());

                    writer.println("<section xml:id='ent_" + entiVO.getCodigo() + "'><title>" + entiVO.getNombre()
                            + "</title>");

                    writer.println("<section><title>Atributos</title>");
                    writer.println("<informaltable width='100%'><title>Atributos de " + entiVO.getNombre()
                            + "</title><tgroup cols='2'>");
                    writer.println("<colspec colnum='1' colname='col1' colwidth='1*' />");
                    writer.println("<colspec colnum='2' colname='col2' colwidth='4*' />");
                    writer.println("<tbody>");
                    writer.println("<row><entry>Codigo</entry><entry>" + entiVO.getCodigo() + "</entry></row>");
                    writer.println("<row><entry>Nombre</entry><entry>" + entiVO.getNombre() + "</entry></row>");
                    writer.println("<row><entry>Etiqueta</entry><entry>" + entiVO.getEtiqueta() + "</entry></row>");
                    // writer.println("<row><entry>Cmd. Alta?</entry><entry>" + (entiVO.isCmdAlta() ? "S" : "N")
                    // + "</entry></row>");
                    // writer.println("<row><entry>Cmd. Baja?</entry><entry>" + (entiVO.isCmdBaja() ? "S" : "N")
                    // + "</entry></row>");
                    // writer.println("<row><entry>Cmd. Edicion?</entry><entry>" + (entiVO.isCmdEdicion() ? "S" : "N")
                    // + "</entry></row>");
                    // writer.println("<row><entry>Cmd. Duplicado?</entry><entry>" + (entiVO.isCmdDuplicado() ? "S" :
                    // "N")
                    // + "</entry></row>");
                    writer.println("</tbody></tgroup></informaltable>");
                    writer.println("</section>");

                    writeEntiInfo(entiVO, writer);

                    writer.println("</section>");
                    writer.println("<?hard-pagebreak?>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
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
        if (entiVO.getEngdList() != null) {
            writer.println("<section><title>Grupos de Datos Asociados</title>");
            writer.println("<informaltable><title>Grupos de Datos Asociados de " + entiVO.getNombre()
                    + "</title><tgroup cols='2'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='2*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='8*' />");
            writer.println("<thead><row>");
            writer.println("<entry>Orden</entry>");
            writer.println("<entry>Etiqueta</entry>");
            writer.println("</row></thead><tbody>");

            for (final EntidadGrupoDatoVO engd : entiVO.getEngdList()) {
                writer.println("<row>");
                writer.println("<entry>" + engd.getNumero() + "</entry>");
                writer.println("<entry>" + engd.getEtiqueta() + "</entry>");
                writer.println("</row>");
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</section>");
        }

        if (entiVO.getEntdList() != null) {
            writer.println("<section><title>Datos Asociados</title>");

            writer.println("<informaltable><title>Datos Asociados de " + entiVO.getNombre()
                    + "</title><tgroup cols='13'>");
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

            for (final EntidadTipoDatoVO entd : entiVO.getEntdList()) {
                writer.println("<row>");
                writer.println("<entry>" + entd.getEtiqueta() + "</entry>");
                writer.println("<entry>" + entd.getTpdt().getNombre() + "</entry>");
                writer.println("<entry>" + entd.getTpdt().getTipoElemento() + "</entry>");
                writer.println("<entry>" + entd.getTpdt().getTpht() + "</entry>");
                writer.println("<entry>"
                        + (entd.getTpdt().getEnti() == null ? "" : getLinkEntidad(entd.getTpdt().getEnti()))
                        + "</entry>");
                writer.println("<entry>" + (entd.getGrupo() == null ? "" : entd.getGrupo()) + "</entry>");
                writer.println("<entry>" + entd.getFila() + "</entry>");
                writer.println("<entry>" + entd.getOrden() + "</entry>");
                writer.println("<entry>" + entd.getSpan() + "</entry>");
                writer.println("<entry>" + (entd.getObligatorio() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entd.getGridable() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entd.getFiltrable() ? "S" : "") + "</entry>");
                writer.println("<entry>" + (entd.getValorDefecto() == null ? "" : entd.getValorDefecto()) + "</entry>");
                writer.println("</row>");
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</section>");
        }

        if (entiVO.getEntiHijasList() != null) {
            writer.println("<section><title>Entidades hijas</title>");

            writer.println("<informaltable><title>Entidades Hijas de " + entiVO.getNombre()
                    + "</title><tgroup cols='2'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='8*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='6*' />");
            writer.println("<thead><row>");
            writer.println("<entry>Codigo</entry>");
            writer.println("<entry>Nombre</entry>");
            writer.println("</row></thead><tbody>");

            for (final Long entiHijaId : entiVO.getEntiHijasList()) {
                try {
                    final EntidadVO entiHijaVO = EntidadProxy.select(entiHijaId);

                    writer.println("<row>");
                    writer.println("<entry>" + entiHijaVO.getCodigo() + "</entry>");
                    writer.println("<entry>" + entiHijaVO.getNombre() + "</entry>");
                    writer.println("</row>");
                } catch (final InstanceNotFoundException ex) {
                    throw new Error(ex);
                }
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</section>");
        }

        if (entiVO.getEnacList() != null) {
            writer.println("<section><title>Acciones Especificas de la Entidad</title>");

            writer.println("<informaltable><title>Acciones Especificas de la de " + entiVO.getNombre()
                    + "</title><tgroup cols='3'>");
            writer.println("<colspec colnum='1' colname='col1' colwidth='2*' />");
            writer.println("<colspec colnum='2' colname='col2' colwidth='4*' />");
            writer.println("<colspec colnum='3' colname='col3' colwidth='8*' />");
            writer.println("<thead><row>");
            writer.println("<entry>Orden</entry>");
            writer.println("<entry>Path</entry>");
            writer.println("<entry>Etiqueta</entry>");
            writer.println("</row></thead><tbody>");

            for (final EntidadAccionVO enac : entiVO.getEnacList()) {
                writer.println("<row>");
                writer.println("<entry>" + enac.getOrden() + "</entry>");
                writer.println("<entry>" + enac.getPath() + "</entry>");
                writer.println("<entry>" + enac.getEtiqueta() + "</entry>");
                writer.println("</row>");
            }

            writer.println("</tbody></tgroup></informaltable>");
            writer.println("</section>");
        }
    }

    /**
     * Gets the varlistentry.
     *
     * @param dt
     *            the dt
     * @param dd
     *            the dd
     * @return the varlistentry
     */
    private String getVarlistentry(final String dt, final String dd) {
        return "<varlistentry><term>" + dt + ":</term><listitem><para>" + dd + "</para></listitem></varlistentry>";
    }

    /**
     * Gets the link entidad.
     *
     * @param vo
     *            the vo
     * @return the link entidad
     */
    private String getLinkEntidad(final EntidadVO vo) {
        return "<link linkend='ent_" + vo.getCodigo() + "'>" + vo.getNombre() + "</link>";
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
