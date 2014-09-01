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
 * The Class ListIntegerTypeHandler.
 */
@MappedJdbcTypes(JdbcType.ARRAY)
@MappedTypes(value = List.class)
public final class ListIntegerTypeHandler implements TypeHandler<List<Integer>> {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getResult(final ResultSet resultSet, final String columnName) throws SQLException {
        final Array value = resultSet.getArray(columnName);

        if (value != null) {
            return Arrays.asList((Integer[]) value.getArray());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getResult(final ResultSet resultSet, final int columnIndex) throws SQLException {
        final Array value = resultSet.getArray(columnIndex);

        if (value != null) {
            return Arrays.asList((Integer[]) value.getArray());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getResult(final CallableStatement statement, final int columnIndex) throws SQLException {
        final Array value = statement.getArray(columnIndex);

        if (value != null) {
            return Arrays.asList((Integer[]) value.getArray());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParameter(final PreparedStatement statement, final int index, final List<Integer> parameter,
            final JdbcType type) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.ARRAY);
        } else {
            statement.setArray(index, statement.getConnection().createArrayOf("int", parameter.toArray()));
        }
    }
}
