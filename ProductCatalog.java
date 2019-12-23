/*
 * Copyright (c) 2018 JCPenney Co. All rights reserved.
 */

package com.jcpenney.digital.catalog.api.model.product;

import com.jcpenney.digital.catalog.api.model.ItemStatus;
import com.jcpenney.digital.catalog.api.model.ProductId;
import com.jcpenney.digital.catalog.api.model.SalesChannel;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representation of Catalog details for Product.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class ProductCatalog implements Serializable {

  private static final long serialVersionUID = -7531689150260718197L;

  private String id;
  private String displayName;
  private String description;
  private ItemStatus status;
  private LotType lotType;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private LocalDateTime creationDate;
  private String countryOfOrigin;
  private Map<String, String> salesChannelAttributes;
  private String productLine;
  private String productType;
  private String subType;
  private String itemType;
  private SalesChannel channel;
  private String factoryShipVendor;

  @NotBlank(message = "Subdivision cannot be empty")
  private String subDivisionId;
  //added divisionId and wareHouseClass to save db calls before doing startDate and endDate validations.
  private String divisionId;

  private Integer entity;
  private Integer productClass;
  private Integer brandId;
  private String modelNumber;
  private String manufacturer;
  private String legacyId;
  private List<ProductId> serviceIds;
  private String serviceType;
  private String shortName;
  private List<ProductAttribute> productAttributes;
  private String ppkId;
  private String customizationModelId;

}
