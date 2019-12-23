package com.jcpenney.digital.catalog.handler;

import com.jcpenney.digital.catalog.api.model.ImageAssetTypeEnum;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class ImageAssertTypeEnumTypeHandler extends BaseTypeHandler<ImageAssetTypeEnum> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, ImageAssetTypeEnum parameter,
      JdbcType jdbcType)
      throws SQLException {
    ps.setString(i, parameter.getDescription());
  }

  @Override
  public ImageAssetTypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return ImageAssetTypeEnum.getEnumForValue(rs.getString(columnName));
  }

  @Override
  public ImageAssetTypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return ImageAssetTypeEnum.getEnumForValue(rs.getString(columnIndex));
  }

  @Override
  public ImageAssetTypeEnum getNullableResult(CallableStatement cs, int columnIndex)
      throws SQLException {
    return ImageAssetTypeEnum.getEnumForValue(cs.getString(columnIndex));
  }
}
