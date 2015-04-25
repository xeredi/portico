package xeredi.integra.model.comun.dao;

import xeredi.integra.model.comun.vo.ArchivoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ArchivoDAO.
 */
public interface ArchivoDAO {

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final ArchivoVO vo);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the archivo vo
     */
    ArchivoVO select(final Long id);
}
