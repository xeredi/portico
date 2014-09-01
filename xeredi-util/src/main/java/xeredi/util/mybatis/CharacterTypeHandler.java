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
 * The Class CharacterTypeHandler.
 */
public final class CharacterTypeHandler implements TypeHandler<Character> {

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
    public Character getResult(final ResultSet resultSet, final String columnName)
            throws SQLException {
        final String value = resultSet.getString(columnName);

        Character character = null;

        if (!resultSet.wasNull() && value.length() > 0) {
            character = Character.valueOf(value.charAt(0));
        }

        return character;
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
    public Character getResult(final ResultSet resultSet, final int columnIndex)
            throws SQLException {
        final String value = resultSet.getString(columnIndex);

        Character character = null;

        if (!resultSet.wasNull() && value.length() > 0) {
            character = Character.valueOf(value.charAt(0));
        }

        return character;
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
    public Character getResult(final CallableStatement statement, final int columnIndex)
            throws SQLException {
        final String value = statement.getString(columnIndex);

        Character character = null;

        if (value != null && value.length() > 0) {
            character = Character.valueOf(value.charAt(0));
        }

        return character;
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
            final Character parameter, final JdbcType type) throws SQLException {
        if (parameter == null) {
            statement.setNull(index, Types.CHAR);
        } else {
            statement.setString(index, String.valueOf((parameter).charValue()));
        }
    }
}
