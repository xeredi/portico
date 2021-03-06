package xeredi.argo.model.maestro.bo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroBOTest.
 */
public final class ParametroBOTest {

    /**
     * Test select.
     */
    @Test
    public static void testSelect() {
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.TIPO_ACTIVIDAD.getId());
        final ParametroCriterioVO criterioVO = new ParametroCriterioVO();
        final Set<Long> tpprIds = new HashSet<>();

        tpprIds.add(Entidad.TIPO_ACTIVIDAD.getId());

        criterioVO.setEntiIds(tpprIds);
        criterioVO.setFechaVigencia(Calendar.getInstance().getTime());
        criterioVO.setIdioma(ConfigurationProxy.getString(ConfigurationKey.language_default));

        final List<ParametroVO> list = prmtBO.selectList(criterioVO);

        for (final ParametroVO vo : list) {
            System.out.println(vo);
        }
    }

    /**
     * Test select map.
     */
    @Test
    public static void testSelectMap() {
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.PAIS.getId());
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();
        final Set<Long> tpprIds = new HashSet<>(Arrays.asList(new Long[] { Entidad.PAIS.getId() }));

        prmtCriterioVO.setEntiIds(tpprIds);
        prmtCriterioVO.setFechaVigencia(Calendar.getInstance().getTime());
        prmtCriterioVO.setIdioma(ConfigurationProxy.getString(ConfigurationKey.language_default));

        final Map<String, ParametroVO> prmtMap = prmtBO.selectMapByCodigo(prmtCriterioVO);

        System.out.println(prmtMap);
    }

    // /**
    // * Test insert.
    // */
    // @Test
    // public void testInsert() {
    // final ParametroBO bo = new ParametroBO();
    // final ParametroVO vo = new ParametroVO();
    // final TipoParametroVO tpprVO = new TipoParametroVO();
    //
    // tpprVO.setId(GlobalNames.TPPR_CLASE_JAVA);
    //
    // final ParametroVersionVO prvrVO = new ParametroVersionVO();
    //
    // prvrVO.setFinicio(Calendar.getInstance().getTime());
    //
    // vo.setTppr(tpprVO);
    // vo.setPrvr(prvrVO);
    // vo.setParametro("String");
    //
    // try {
    // bo.insert(vo);
    //
    // Assert.fail("Deberia Fallar");
    // } catch (final DuplicateInstanceException ex) {
    // System.out.println("Error controlado");
    // }
    //
    // vo.setParametro("Cacota");
    //
    // try {
    // bo.insert(vo);
    // } catch (final DuplicateInstanceException ex) {
    // System.out.println("Error insertando " + vo);
    //
    // ex.printStackTrace(System.err);
    //
    // Assert.fail(ex.getMessage());
    // }
    // }

}
