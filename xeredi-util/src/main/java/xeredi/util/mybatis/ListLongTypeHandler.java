package xeredi.util.mybatis;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
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
public final class ListLongTypeHandler implements TypeHandler<List<Long>> {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> getResult(final ResultSet resultSet, final String columnName) throws SQLException {
        final Array value = resultSet.getArray(columnName);

        if (value != null) {
            return Arrays.asList((Long[]) value.getArray());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> getResult(final ResultSet resultSet, final int columnIndex) throws SQLException {
        final Array value = resultSet.getArray(columnIndex);

        if (value != null) {
            return Arrays.asList((Long[]) value.getArray());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> getResult(final CallableStatement statement, final int columnIndex) throws SQLException {
        final Array value = statement.getArray(columnIndex);

        if (value != null) {
        	return Arrays.asList((Long[]) value.getArray());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParameter(final PreparedStatement statement, final int index, final List<Long> parameter,
            final JdbcType type) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.ARRAY);
        } else {
            statement.setArray(index, statement.getConnection().createArrayOf("bigint", parameter.toArray()));
        }
    }
}
