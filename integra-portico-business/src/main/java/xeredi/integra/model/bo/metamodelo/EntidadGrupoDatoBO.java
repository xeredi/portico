package xeredi.integra.model.bo.metamodelo;

import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.metamodelo.EntidadGrupoDatoDAO;
import xeredi.integra.model.vo.metamodelo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.vo.metamodelo.EntidadGrupoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoBO.
 */
@Singleton
public class EntidadGrupoDatoBO implements EntidadGrupoDato {

    /** The engd dao. */
    @Inject
    EntidadGrupoDatoDAO engdDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void insert(final EntidadGrupoDatoVO engdVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(engdVO);
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());
        Preconditions.checkNotNull(engdVO.getEtiqueta());

        if (engdDAO.exists(engdVO)) {
            throw new DuplicateInstanceException(EntidadGrupoDatoVO.class.getName(), engdVO);
        }

        engdDAO.insert(engdVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final EntidadGrupoDatoVO engdVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(engdVO);
        Preconditions.checkNotNull(engdVO.getEntiId());
        Preconditions.checkNotNull(engdVO.getNumero());
        Preconditions.checkNotNull(engdVO.getEtiqueta());

        if (engdDAO.update(engdVO) == 0) {
            throw new InstanceNotFoundException(EntidadGrupoDatoVO.class.getName(), engdVO);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long entiId, final Integer numero) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entiId);
        Preconditions.checkNotNull(numero);

        final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

        engdCriterioVO.setEntiId(entiId);
        engdCriterioVO.setNumero(numero);

        if (engdDAO.delete(engdCriterioVO) == 0) {
            throw new InstanceNotFoundException(EntidadGrupoDatoVO.class.getName(), engdCriterioVO);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final EntidadGrupoDatoVO select(final Long entiId, final Integer numero) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entiId);
        Preconditions.checkNotNull(numero);

        final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

        engdCriterioVO.setEntiId(entiId);
        engdCriterioVO.setNumero(numero);

        final EntidadGrupoDatoVO engdVO = engdDAO.selectCriterio(engdCriterioVO);

        if (engdVO == null) {
            throw new InstanceNotFoundException(EntidadGrupoDatoVO.class.getName(), engdCriterioVO);
        }

        return engdVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<EntidadGrupoDatoVO> selectList(final Long entiId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(entiId);

        final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

        engdCriterioVO.setEntiId(entiId);

        return engdDAO.selectList(engdCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<LabelValueVO> selectLabelValues(final Long entiId) {
        Preconditions.checkNotNull(entiId);

        final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

        engdCriterioVO.setEntiId(entiId);

        return engdDAO.selectLabelValues(engdCriterioVO);
    }
}
