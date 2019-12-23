/*
 * Copyright (c) 2018 JCPenney Co. All rights reserved.
 */

package com.jcpenney.digital.catalog.api.model.product;

import com.jcpenney.digital.catalog.api.model.AttributeMetadata;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representation of Product Attributes.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class ProductAttribute implements Serializable {

  private static final long serialVersionUID = 3433127506797857428L;

  private String code;
  private List<String> values;
  private AttributeMetadata attributeMetadata;
}
