package xeredi.util.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public final class LongArray implements Array {

    private final transient Object[] values;

    private final transient String string;

    private LongArray(final List<Long> avalues) {
        super();
        values = avalues.toArray();
        string = ToStringBuilder.reflectionToString(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void free() throws SQLException {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getArray() throws SQLException {
        return values;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getArray(final Map<String, Class<?>> arg0)
            throws SQLException {
        return getArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getArray(final long offset, final int limit)
            throws SQLException {
        // TODO Auto-generated method stub
        return Arrays.copyOfRange(values, (int) offset, (int) offset + limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getArray(final long offset, final int length,
            final Map<String, Class<?>> arg2) throws SQLException {
        return getArray(offset, length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBaseType() throws SQLException {
        return Types.BIGINT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBaseTypeName() throws SQLException {
        return "bigint";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultSet getResultSet() throws SQLException {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultSet getResultSet(final Map<String, Class<?>> arg0)
            throws SQLException {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultSet getResultSet(final long arg0, final int arg1)
            throws SQLException {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultSet getResultSet(final long arg0, final int arg1,
            final Map<String, Class<?>> arg2) throws SQLException {
        throw new UnsupportedOperationException();
    }

}
