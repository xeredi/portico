package xeredi.util.mybatis;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class ListBooleanTypeHandler.
 */
@MappedJdbcTypes(JdbcType.ARRAY)
@MappedTypes(value = List.class)
public final class ListBooleanTypeHandler implements TypeHandler<List<Boolean>> {

    /** The Constant TRUE_INT. */
    private static final int TRUE_INT = 1;

    /** The Constant FALSE_INT. */
    private static final int FALSE_INT = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> getResult(final ResultSet resultSet,
            final String columnName) throws SQLException {
        final Array value = resultSet.getArray(columnName);

        if (value != null) {
            return Arrays.asList((Boolean[]) value.getArray());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> getResult(final ResultSet resultSet,
            final int columnIndex) throws SQLException {
        final Array value = resultSet.getArray(columnIndex);

        if (value != null) {
            return Arrays.asList((Boolean[]) value.getArray());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> getResult(final CallableStatement statement,
            final int columnIndex) throws SQLException {
        final Array value = statement.getArray(columnIndex);

        if (value != null) {
            return Arrays.asList((Boolean[]) value.getArray());
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParameter(final PreparedStatement statement,
            final int index, final List<Boolean> parameter, final JdbcType type)
                    throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.ARRAY);
        } else {
            final List<Integer> integers = new ArrayList<>(
                    parameter.size());

            for (final Boolean value : parameter) {
                integers.add(value ? TRUE_INT : FALSE_INT);
            }

            statement.setArray(
                    index,
                    statement.getConnection().createArrayOf("int",
                            integers.toArray()));
        }
    }
}
