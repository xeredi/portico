package xeredi.integra.model.estadistica.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.estadistica.vo.CuadroMesParametroVO;
import xeredi.integra.model.estadistica.vo.CuadroMesVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CuadroMesDAO.
 */
public interface CuadroMesDAO {

    /**
     * Exists.
     *
     * @param peprId
     *            the pepr id
     * @return true, if successful
     */
    boolean exists(final @Nonnull Long peprId);

    /**
     * Delete.
     *
     * @param peprId
     *            the pepr id
     * @return the int
     */
    int delete(final @Nonnull Long peprId);

    /**
     * Select list.
     *
     * @param peprId
     *            the pepr id
     * @return the list
     */
    public List<CuadroMesVO> selectList(final @Nonnull Long peprId);

    /**
     * Insert_ c m_ pescaf.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_PESCAF(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ avppet.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_AVPPET(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ avotro.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_AVOTRO(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ buqun i_ buqg t_ es.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_BUQUNI_BUQGT_ES(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ buqun i_ buqg t_ zz.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_BUQUNI_BUQGT_ZZ(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ crubuq.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_CRUBUQ(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ glpet r_ glgas n_ glpre f_ glotro.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_GLPETR_GLGASN_GLPREF_GLOTRO(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ gsies p_ gsnies.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_GSIESP_GSNIES(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ m g_ pasaj e_ ve t2.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_MG_PASAJE_VET2(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ pascru.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_PASCRU(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ cnumca.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_CNUMCA(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ ctonca.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_CTONCA(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ cnumv a_ ctonv a_ cteus.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_CNUMVA_CTONVA_CTEUS(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ rrteu s_ rrtonc.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_RRTEUS_RRTONC(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ rrtono.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_RRTONO(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ traloc.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_TRALOC(final @Nonnull CuadroMesParametroVO vo);

    /**
     * Insert_ c m_ mconv.
     *
     * @param vo
     *            the vo
     */
    void insert_CM_MCONV(final @Nonnull CuadroMesParametroVO vo);
}
