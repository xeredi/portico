package xeredi.util.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegerTypeHandler.
 */
public final class IntegerTypeHandler implements TypeHandler<Integer> {

    /**
     * Gets the result.
     *
     * @param resultSet
     *            the result set
     * @param columnName
     *            the column name
     * @return the result
     * @throws SQLException
     *             the sQL exception
     * @see TypeHandler#getResult(ResultSet, String)
     */
    @Override
    public Integer getResult(final ResultSet resultSet, final String columnName)
            throws SQLException {
        final int value = resultSet.getInt(columnName);
        Integer valueInteger = null;

        if (!resultSet.wasNull()) {
            valueInteger = value;
        }

        return valueInteger;
    }

    /**
     * Gets the result.
     *
     * @param resultSet
     *            the result set
     * @param columnIndex
     *            the column index
     * @return the result
     * @throws SQLException
     *             the sQL exception
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet,
     *      int)
     */
    @Override
    public Integer getResult(final ResultSet resultSet, final int columnIndex) throws SQLException {
        final int value = resultSet.getInt(columnIndex);
        Integer valueInteger = null;

        if (!resultSet.wasNull()) {
            valueInteger = value;
        }

        return valueInteger;
    }

    /**
     * Gets the result.
     *
     * @param statement
     *            the statement
     * @param columnIndex
     *            the column index
     * @return the result
     * @throws SQLException
     *             the sQL exception
     * @see TypeHandler#getResult(CallableStatement, int)
     */
    @Override
    public Integer getResult(final CallableStatement statement, final int columnIndex)
            throws SQLException {
        final int value = statement.getInt(columnIndex);
        Integer valueInteger = null;

        if (!statement.wasNull()) {
            valueInteger = value;
        }

        return valueInteger;
    }

    /**
     * Sets the parameter.
     *
     * @param statement
     *            the statement
     * @param index
     *            the index
     * @param parameter
     *            the parameter
     * @param type
     *            the type
     * @throws SQLException
     *             the sQL exception
     * @see TypeHandler#setParameter(PreparedStatement, int, Object, JdbcType)
     */
    @Override
    public void setParameter(final PreparedStatement statement, final int index,
            final Integer parameter, final JdbcType type) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.INTEGER);
        } else {
            statement.setInt(index, parameter);
        }
    }

}
