package xeredi.argo.model.auditoria.bo;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.auditoria.dao.EventoAuditoriaDAO;
import xeredi.argo.model.auditoria.vo.AuditoriaAccion;
import xeredi.argo.model.auditoria.vo.EventoAuditoriaVO;
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EventoAuditoriaBO.
 */
public final class EventoAuditoriaUtils {

    /**
     * Insert.
     *
     * @param session
     *            the session
     * @param auditable
     *            the auditable
     * @param accion
     *            the accion
     * @return the evento auditoria VO
     */
    public static final EventoAuditoriaVO insert(final @NonNull SqlSession session, final @NonNull Auditable auditable,
            final @NonNull AuditoriaAccion accion) {
        Preconditions.checkNotNull(auditable.getPrefijoEntidad());
        Preconditions.checkNotNull(auditable.getUsroId());

        final EventoAuditoriaVO evau = new EventoAuditoriaVO();
        final UsuarioVO usro = new UsuarioVO();

        usro.setId(auditable.getUsroId());

        evau.setId((new IgBO()).nextVal(IgBO.SQ_INTEGRA));
        evau.setFecha(Calendar.getInstance().getTime());
        evau.setAccion(accion);
        evau.setPrefijoEntidad(auditable.getPrefijoEntidad());
        evau.setUsro(usro);

        final EventoAuditoriaDAO evauDAO = session.getMapper(EventoAuditoriaDAO.class);

        evauDAO.insert(evau);

        return evau;
    }
}
