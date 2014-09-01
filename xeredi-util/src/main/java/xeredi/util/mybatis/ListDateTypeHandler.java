package xeredi.util.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class ListLongTypeHandler.
 */
@MappedJdbcTypes(JdbcType.ARRAY)
@MappedTypes(value = List.class)
public final class ListDateTypeHandler implements TypeHandler<List<Date>> {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Date> getResult(final ResultSet resultSet, final String columnName) throws SQLException {
        throw new SQLException("No implementado");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Date> getResult(final ResultSet resultSet, final int columnIndex) throws SQLException {
        throw new SQLException("No implementado");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Date> getResult(final CallableStatement statement, final int columnIndex) throws SQLException {
        throw new SQLException("No implementado");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParameter(final PreparedStatement statement, final int index, final List<Date> parameter,
            final JdbcType type) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.ARRAY);
        } else {
            statement.setArray(index, statement.getConnection().createArrayOf("timestamp", parameter.toArray()));
        }
    }
}
