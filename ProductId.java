package com.jcpenney.digital.catalog.api.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product  Id and Sequence Number.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class ProductId implements Serializable {

  private static final long serialVersionUID = -2636890073422340172L;

  private String productId;
  private Integer sequence;

}
