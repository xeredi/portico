package xeredi.integra.model.bo.metamodelo;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

public interface TipoSubparametro {
    List<LabelValueVO> selectLabelValues();

    List<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO);

    PaginatedList<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO, final int offset,
            final int limit);

    TipoSubparametroVO select(final Long id);

    void insert(final TipoSubparametroVO tpspVO) throws DuplicateInstanceException;

    void update(final TipoSubparametroVO tpspVO) throws InstanceNotFoundException;

    void delete(final Long tpspId) throws InstanceNotFoundException;
}
