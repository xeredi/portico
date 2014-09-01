package xeredi.util.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class CalendarTypeHandler.
 */
public final class CalendarTypeHandler implements TypeHandler<Calendar> {

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
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet,
     *      java.lang.String)
     */
    @Override
    public Calendar getResult(final ResultSet resultSet, final String columnName)
            throws SQLException {
        final Timestamp value = resultSet.getTimestamp(columnName);
        Calendar calendar = null;

        if (!resultSet.wasNull()) {
            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(value.getTime());
        }

        return calendar;
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
    public Calendar getResult(final ResultSet resultSet, final int columnIndex) throws SQLException {
        final Timestamp value = resultSet.getTimestamp(columnIndex);
        Calendar calendar = null;

        if (!resultSet.wasNull()) {
            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(value.getTime());
        }

        return calendar;
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
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement,
     *      int)
     */
    @Override
    public Calendar getResult(final CallableStatement statement, final int columnIndex)
            throws SQLException {
        final Timestamp value = statement.getTimestamp(columnIndex);
        Calendar calendar = null;

        if (value != null) {
            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(value.getTime());
        }

        return calendar;
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
     * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement,
     *      int, java.lang.Object, org.apache.ibatis.type.JdbcType)
     */
    @Override
    public void setParameter(final PreparedStatement statement, final int index,
            final Calendar parameter, final JdbcType type) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.TIMESTAMP);
        } else {
            statement.setTimestamp(index, new Timestamp((parameter).getTimeInMillis()));
        }
    }
}
