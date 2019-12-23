

package com.jcpenney.digital.catalog.handler;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * A mybatis type handler that translates from the typed java.util.List<String> to the postgres
 * Array database type.
 */
@MappedJdbcTypes(JdbcType.ARRAY)
@MappedTypes(List.class)
public class ListToArrayTypeHandler extends BaseTypeHandler<List<String>> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter,
      JdbcType jdbcType)
      throws SQLException {
    ps.setArray(i, ps.getConnection().createArrayOf("text", parameter.toArray()));
  }

  @Override
  public List<String> getNullableResult(ResultSet rs, String columnName)
      throws SQLException {
    return getArray(rs.getArray(columnName));
  }

  @Override
  public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return getArray(rs.getArray(columnIndex));
  }

  @Override
  public List<String> getNullableResult(CallableStatement cs, int columnIndex)
      throws SQLException {
    return getArray(cs.getArray(columnIndex));
  }

  private List<String> getArray(Array array) throws SQLException {
    return array == null ? null
        : Arrays.asList((String[]) array.getArray()).stream().filter(Objects::nonNull)
            .collect(Collectors.toList());
  }


}
