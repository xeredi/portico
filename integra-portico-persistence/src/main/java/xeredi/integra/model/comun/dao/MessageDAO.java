package xeredi.integra.model.comun.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.MessageCriterioVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.comun.vo.MessageVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageDAO.
 */
public interface MessageDAO {

    /**
     * Select.
     *
     * @param key
     *            the key
     * @return the message vo
     */
    public MessageVO select(final MessageI18nKey key);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<MessageVO> selectList(final MessageCriterioVO criterio);
}
