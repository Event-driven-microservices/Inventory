package com.microservices.inventory.content.product.adapter.in.rest.dtos.out;

import com.project.lowcode.content.app.appConfig.pathParam.adapter.in.rest.dtos.out.PathParamOutDto;
import com.project.lowcode.content.app.appConfig.requestParam.adapter.in.rest.dtos.out.RequestParamOutDto;
import com.project.lowcode.content.app.appConfig.roleProduct.adapter.in.rest.dtos.out.RoleProductOutDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOutDto extends SimpleProductOutDto {
  private List<RoleProductOutDto> roleProducts;
  private List<RequestParamOutDto> requestParams;
  private List<PathParamOutDto> pathParams;
}
