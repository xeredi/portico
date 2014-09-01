package xeredi.util.mybatis;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class ListLongTypeHandler.
 */
@MappedJdbcTypes(JdbcType.ARRAY)
public final class SetLongTypeHandler implements TypeHandler<Set<Long>> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Long> getResult(final ResultSet resultSet, final String columnName) throws SQLException {
        final Array value = resultSet.getArray(columnName);
        Set<Long> set = null;

        if (!resultSet.wasNull()) {
            set = new HashSet<>(Arrays.asList((Long[]) value.getArray()));
        }

        return set;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Long> getResult(final ResultSet resultSet, final int columnIndex) throws SQLException {
        final Array value = resultSet.getArray(columnIndex);
        Set<Long> set = null;

        if (!resultSet.wasNull()) {
            set = new HashSet<>(Arrays.asList((Long[]) value.getArray()));
        }

        return set;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Long> getResult(final CallableStatement statement, final int columnIndex) throws SQLException {
        final Array value = statement.getArray(columnIndex);
        Set<Long> set = null;

        if (!statement.wasNull()) {
            set = new HashSet<>(Arrays.asList((Long[]) value.getArray()));
        }

        return set;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParameter(final PreparedStatement statement, final int index, final Set<Long> parameter,
            final JdbcType type) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.ARRAY);
        } else {
            statement.setArray(index, statement.getConnection().createArrayOf("bigint", parameter.toArray()));
        }
    }
}
