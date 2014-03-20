package xeredi.integra.model.bo.metamodelo;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.metamodelo.CodigoReferenciaDAO;
import xeredi.integra.model.vo.metamodelo.CodigoReferenciaVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaAdminBO.
 */
@Singleton
public class CodigoReferenciaBO implements CodigoReferencia {

    /** The cdrf dao. */
    @Inject
    CodigoReferenciaDAO cdrfDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void insert(final CodigoReferenciaVO cdrfVO) throws DuplicateInstanceException {
        Preconditions.checkNotNull(cdrfVO);

        if (cdrfDAO.exists(cdrfVO)) {
            throw new DuplicateInstanceException(CodigoReferenciaVO.class.getName(), cdrfVO);
        }

        cdrfDAO.insert(cdrfVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final CodigoReferenciaVO cdrfVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrfVO);

        final int deleted = cdrfDAO.delete(cdrfVO);

        if (deleted == 0) {
            throw new InstanceNotFoundException(CodigoReferenciaVO.class.getName(), cdrfVO);
        }
    }
}
