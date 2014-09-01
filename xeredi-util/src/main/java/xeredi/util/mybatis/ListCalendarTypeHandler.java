package xeredi.util.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class ListCalendarTypeHandler.
 */
@MappedJdbcTypes(JdbcType.ARRAY)
@MappedTypes(value = List.class)
public final class ListCalendarTypeHandler implements
        TypeHandler<List<Calendar>> {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Calendar> getResult(final ResultSet resultSet,
            final String columnName) throws SQLException {
        throw new SQLException("No implementado");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Calendar> getResult(final ResultSet resultSet,
            final int columnIndex) throws SQLException {
        throw new SQLException("No implementado");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Calendar> getResult(final CallableStatement statement,
            final int columnIndex) throws SQLException {
        throw new SQLException("No implementado");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParameter(final PreparedStatement statement,
            final int index, final List<Calendar> parameter, final JdbcType type)
            throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.ARRAY);
        } else {
            statement.setArray(
                    index,
                    statement.getConnection().createArrayOf("date",
                            parameter.toArray()));
        }
    }
}
