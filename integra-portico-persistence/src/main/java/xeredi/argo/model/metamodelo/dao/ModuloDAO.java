package xeredi.argo.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

/**
 * The Interface ModuloDAO.
 */
public interface ModuloDAO {
	int count(final ModuloCriterioVO criterio);

	List<ModuloVO> selectList(final ModuloCriterioVO criterio, final RowBounds bounds);

	List<ModuloVO> selectList(final ModuloCriterioVO criterio);

	ModuloVO selectObject(final ModuloCriterioVO criterio);

	boolean exists(final ModuloVO vo);

	void insert(final ModuloVO vo);

	int update(final ModuloVO vo);

	int delete(final ModuloVO vo);
}
