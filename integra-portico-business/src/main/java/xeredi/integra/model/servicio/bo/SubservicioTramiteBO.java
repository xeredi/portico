package xeredi.integra.model.servicio.bo;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ItemTramiteDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.servicio.dao.SubservicioTramiteDAO;
import xeredi.integra.model.servicio.dao.SubservicioTramiteDatoDAO;
import xeredi.integra.model.servicio.vo.SubservicioTramiteCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioTramiteVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTramiteBO.
 */
public final class SubservicioTramiteBO {

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the subservicio tramite vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public SubservicioTramiteVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioTramiteDAO sstrDAO = session.getMapper(SubservicioTramiteDAO.class);
            final SubservicioTramiteCriterioVO sstrCriterio = new SubservicioTramiteCriterioVO();

            sstrCriterio.setId(id);
            sstrCriterio.setIdioma(idioma);

            final SubservicioTramiteVO sstr = sstrDAO.selectObject(sstrCriterio);

            if (sstr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.sstr, id);
            }

            final SubservicioTramiteDatoDAO sstdDAO = session.getMapper(SubservicioTramiteDatoDAO.class);

            for (final ItemTramiteDatoVO itdt : sstdDAO.selectList(sstrCriterio)) {
                sstr.getItdtMap().put(itdt.getTpdtId(), itdt);
            }

            return sstr;
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<SubservicioTramiteVO> selectList(final @NonNull SubservicioTramiteCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioTramiteDAO sstrDAO = session.getMapper(SubservicioTramiteDAO.class);

            return sstrDAO.selectList(criterio);
        }
    }
}
