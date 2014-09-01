package xeredi.util.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

// TODO: Auto-generated Javadoc
/**
 * The Class StringTypeHandler.
 */
public final class StringTypeHandler extends BaseTypeHandler<String> {

    /**
     * Sets the parameter.
     * 
     * @param statement
     *            the statement
     * @param index
     *            the index
     * @param parameter
     *            the parameter
     * @param jdbcType
     *            the jdbc type
     * @throws SQLException
     *             the sQL exception
     * @see BaseTypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object,
     *      org.apache.ibatis.type.JdbcType)
     */
    @Override
    public void setParameter(final PreparedStatement statement, final int index, final String parameter,
                    final JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.VARCHAR);
        } else {
            setNonNullParameter(statement, index, parameter, jdbcType);
        }
    }

    /**
     * Sets the non null parameter.
     * 
     * @param statement
     *            the statement
     * @param index
     *            the index
     * @param parameter
     *            the parameter
     * @param jdbcType
     *            the jdbc type
     * @throws SQLException
     *             the sQL exception
     * @see BaseTypeHandler#setNonNullParameter(java.sql.PreparedStatement, int, java.lang.Object,
     *      org.apache.ibatis.type.JdbcType)
     */
    @Override
    public void setNonNullParameter(final PreparedStatement statement, final int index,
                    final String parameter, final JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.VARCHAR);
        } else {
            statement.setString(index, parameter);
        }
    }

    /**
     * Devuelve el valor de nullable result.
     * 
     * @param rs
     *            the rs
     * @param columnName
     *            the column name
     * @return El valor de nullable result
     * @throws SQLException
     *             the sQL exception
     * @see BaseTypeHandler#getNullableResult(java.sql.ResultSet, java.lang.String)
     */
    @Override
    public String getNullableResult(final ResultSet rs, final String columnName) throws SQLException {
        return rs.getString(columnName);
    }

    /**
     * Gets the nullable result.
     * 
     * @param rs
     *            the rs
     * @param columnIndex
     *            the column index
     * @return the nullable result
     * @throws SQLException
     *             the sQL exception
     * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet, int)
     */
    @Override
    public String getNullableResult(final ResultSet rs, final int columnIndex) throws SQLException {
        return rs.getString(columnIndex);
    }

    /**
     * Devuelve el valor de nullable result.
     * 
     * @param cs
     *            the cs
     * @param columnIndex
     *            the column index
     * @return El valor de nullable result
     * @throws SQLException
     *             the sQL exception
     * @see BaseTypeHandler#getNullableResult(java.sql.CallableStatement, int)
     */
    @Override
    public String getNullableResult(final CallableStatement cs, final int columnIndex) throws SQLException {
        return cs.getString(columnIndex);
    }

}
