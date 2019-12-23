

package com.jcpenney.digital.catalog.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * A mybatis type handler that translates from the typed java.util.List<String> to the postgres
 * Array database type.
 */
@MappedJdbcTypes(JdbcType.SMALLINT)
@MappedTypes(Boolean.class)
public class BooleanToIntTypeHandler extends BaseTypeHandler<Boolean> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter,
      JdbcType jdbcType)
      throws SQLException {
    ps.setInt(i, parameter ? 1 : 0);
  }

  @Override
  public Boolean getNullableResult(ResultSet rs, String columnName)
      throws SQLException {
    return getBoolean(rs.getInt(columnName));
  }

  @Override
  public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return getBoolean(rs.getInt(columnIndex));
  }

  @Override
  public Boolean getNullableResult(CallableStatement cs, int columnIndex)
      throws SQLException {
    return getBoolean(cs.getInt(columnIndex));
  }

  private Boolean getBoolean(int value) {
    return value == 0 ? false : true;
  }

}
