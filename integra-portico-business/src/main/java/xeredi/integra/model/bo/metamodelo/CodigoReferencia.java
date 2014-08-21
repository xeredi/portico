package xeredi.integra.model.bo.metamodelo;

import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

public interface CodigoReferencia {
    void insert(final CodigoReferenciaVO cdrfVO) throws DuplicateInstanceException;

    void delete(final CodigoReferenciaVO cdrfVO) throws InstanceNotFoundException;
}
