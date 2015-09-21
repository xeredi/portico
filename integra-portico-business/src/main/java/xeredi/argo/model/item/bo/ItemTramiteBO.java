package xeredi.argo.model.item.bo;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.dao.ItemTramiteDAO;
import xeredi.argo.model.item.dao.ItemTramiteDatoDAO;
import xeredi.argo.model.item.vo.ItemTramiteCriterioVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteBO.
 */
public final class ItemTramiteBO {

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the item tramite vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ItemTramiteVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ItemTramiteDAO ittrDAO = session.getMapper(ItemTramiteDAO.class);
            final ItemTramiteCriterioVO ittrCriterio = new ItemTramiteCriterioVO();

            ittrCriterio.setId(id);
            ittrCriterio.setIdioma(idioma);

            final ItemTramiteVO ittr = ittrDAO.selectObject(ittrCriterio);

            if (ittr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.ittr, id);
            }

            final ItemTramiteDatoDAO ittdDAO = session.getMapper(ItemTramiteDatoDAO.class);

            ittrCriterio.setFechaVigencia(ittr.getFref());

            for (final ItemTramiteDatoVO ittd : ittdDAO.selectList(ittrCriterio)) {
                ittr.getIttdMap().put(ittd.getTpdtId(), ittd);
            }

            return ittr;
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<ItemTramiteVO> selectList(final @NonNull ItemTramiteCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ItemTramiteDAO ittrDAO = session.getMapper(ItemTramiteDAO.class);

            return ittrDAO.selectList(criterio);
        }
    }
}
