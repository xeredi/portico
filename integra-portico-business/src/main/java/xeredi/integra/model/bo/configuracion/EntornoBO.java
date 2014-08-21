package xeredi.integra.model.bo.configuracion;

import java.util.List;
import java.util.Map;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.configuracion.dao.EntornoDAO;
import xeredi.integra.model.configuracion.dao.ValorDAO;
import xeredi.integra.model.configuracion.vo.EntornoVO;
import xeredi.integra.model.configuracion.vo.ValorCriterioVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class EntornoBO.
 */
@Singleton
public class EntornoBO implements Entorno {

    /** The cnen dao. */
    @Inject
    EntornoDAO cnenDAO;

    /** The cnvl dao. */
    @Inject
    ValorDAO cnvlDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<EntornoVO> selectAll() {
        return cnenDAO.selectAllList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Map<String, EntornoVO> selectAllMap() {
        return cnenDAO.selectAllMap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<String> selectCodigos() {
        return cnenDAO.selectCodigosList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final EntornoVO select(final Long id) {
        Preconditions.checkNotNull(id);

        return cnenDAO.select(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void insert(final EntornoVO cnenVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(cnenVO);

        if (cnenDAO.exists(cnenVO)) {
            throw new DuplicateInstanceException(EntornoVO.class.getName(), cnenVO);
        }

        cnenDAO.insert(cnenVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final EntornoVO cnenVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cnenVO);

        final int updated = cnenDAO.update(cnenVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(EntornoVO.class.getName(), cnenVO);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long id) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        final int updated = cnenDAO.delete(id);

        if (updated == 0) {
            throw new InstanceNotFoundException(EntornoVO.class.getName(), id);
        }

        final ValorCriterioVO cnvlCriterioVO = new ValorCriterioVO();

        cnvlCriterioVO.setCnenId(id);
        cnvlDAO.delete(cnvlCriterioVO);
    }

}
