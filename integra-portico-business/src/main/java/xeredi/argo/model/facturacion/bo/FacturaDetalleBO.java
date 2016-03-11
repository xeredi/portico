package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.FacturaDetalleDAO;
import xeredi.argo.model.facturacion.vo.FacturaDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaDetalleVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleBO.
 */
public final class FacturaDetalleBO {

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the factura detalle vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public FacturaDetalleVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaDetalleDAO fctdDAO = session.getMapper(FacturaDetalleDAO.class);
            final FacturaDetalleCriterioVO fctdCriterio = new FacturaDetalleCriterioVO();

            fctdCriterio.setId(id);
            fctdCriterio.setIdioma(idioma);

            final FacturaDetalleVO fctd = fctdDAO.selectObject(fctdCriterio);

            if (fctd == null) {
                throw new InstanceNotFoundException(MessageI18nKey.fctd, id);
            }

            return fctd;
        }
    }

    /**
     * Select list.
     *
     * @param fctlId the fctl id
     * @param idioma the idioma
     * @param offset the offset
     * @param limit the limit
     * @return the paginated list
     */
    public PaginatedList<FacturaDetalleVO> selectList(final @NonNull Long fctlId, final String idioma,
            final int offset, final int limit) {
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaDetalleDAO fctdDAO = session.getMapper(FacturaDetalleDAO.class);
            final FacturaDetalleCriterioVO fctdCriterio = new FacturaDetalleCriterioVO();

            fctdCriterio.setFctlId(fctlId);
            fctdCriterio.setIdioma(idioma);

            final int count = fctdDAO.count(fctdCriterio);
            final List<FacturaDetalleVO> fctdList = new ArrayList<>();

            if (count >= offset) {
                fctdList.addAll(fctdDAO.selectList(fctdCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<FacturaDetalleVO>(fctdList, offset, limit, count);
        }
    }
}
