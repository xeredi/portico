package xeredi.integra.model.bo.configuracion;

import java.util.List;
import java.util.Map;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.configuracion.IdiomaDAO;
import xeredi.integra.model.dao.configuracion.ValorIdiomaDAO;
import xeredi.integra.model.vo.configuracion.IdiomaVO;
import xeredi.integra.model.vo.configuracion.ValorIdiomaCriterioVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class IdiomaBO.
 */
@Singleton
public class IdiomaBO implements Idioma {

    /** The cnid dao. */
    @Inject
    IdiomaDAO cnidDAO;

    /** The cnvi dao. */
    @Inject
    ValorIdiomaDAO cnviDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<IdiomaVO> selectAll() {
        return cnidDAO.selectAllList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Map<String, IdiomaVO> selectAllMap() {
        return cnidDAO.selectAllMap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<String> selectCodigos() {
        return cnidDAO.selectCodigosList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final IdiomaVO select(final Long id) {
        Preconditions.checkNotNull(id);

        return cnidDAO.select(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void insert(final IdiomaVO cnidVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(cnidVO);

        if (cnidDAO.exists(cnidVO)) {
            throw new DuplicateInstanceException(IdiomaVO.class.getName(), cnidVO);
        }

        cnidDAO.insert(cnidVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void update(final IdiomaVO cnidVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cnidVO);

        final int updated = cnidDAO.update(cnidVO);

        if (updated == 0) {
            throw new InstanceNotFoundException(IdiomaVO.class.getName(), cnidVO);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long id) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        final int updated = cnidDAO.delete(id);

        if (updated == 0) {
            throw new InstanceNotFoundException(IdiomaVO.class.getName(), id);
        }

        final ValorIdiomaCriterioVO cnviCriterioVO = new ValorIdiomaCriterioVO();

        cnviCriterioVO.setCnciId(id);
        cnviDAO.delete(cnviCriterioVO);
    }
}
