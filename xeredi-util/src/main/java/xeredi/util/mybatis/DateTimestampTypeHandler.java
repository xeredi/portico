package xeredi.util.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class DateTimestampTypeHandler.
 */
public final class DateTimestampTypeHandler implements TypeHandler<Date> {

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
     *             the sQL exception {@inheritDoc}
     */
    @Override
    public void setParameter(final PreparedStatement statement, final int index,
            final Date parameter, final JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.TIMESTAMP);
        } else {
            statement.setTimestamp(index, new Timestamp(parameter.getTime()));
        }
    }

    /**
     * Gets the result.
     *
     * @param resultSet
     *            the result set
     * @param columnName
     *            the column name
     * @return the result
     * @throws SQLException
     *             the sQL exception {@inheritDoc}
     */
    @Override
    public Date getResult(final ResultSet resultSet, final String columnName) throws SQLException {
        final Timestamp timestamp = resultSet.getTimestamp(columnName);
        Date valueDate = null;

        if (!resultSet.wasNull()) {
            valueDate = new Date(timestamp.getTime());
        }

        return valueDate;
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
    public Date getResult(final ResultSet resultSet, final int columnIndex) throws SQLException {
        final Timestamp timestamp = resultSet.getTimestamp(columnIndex);
        Date valueDate = null;

        if (!resultSet.wasNull()) {
            valueDate = new Date(timestamp.getTime());
        }

        return valueDate;
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
     *             the sQL exception {@inheritDoc}
     */
    @Override
    public Date getResult(final CallableStatement statement, final int columnIndex)
            throws SQLException {
        final Timestamp timestamp = statement.getTimestamp(columnIndex);
        Date valueDate = null;

        if (!statement.wasNull()) {
            valueDate = new Date(timestamp.getTime());
        }

        return valueDate;
    }

}
