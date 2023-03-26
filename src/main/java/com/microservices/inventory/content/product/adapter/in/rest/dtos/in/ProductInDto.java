package com.microservices.inventory.content.product.adapter.in.rest.dtos.in;

import com.project.lowcode.content.app.appConfig.pathParam.adapter.in.rest.dtos.in.PathParamInDto;
import com.project.lowcode.content.app.appConfig.requestParam.adapter.in.rest.dtos.in.RequestParamInDto;
import com.project.lowcode.content.app.appConfig.roleProduct.adapter.in.rest.dtos.in.RoleProductInDto;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInDto extends SimpleProductInDto {
  @Valid private List<RoleProductInDto> roleProducts;
  @Valid private List<RequestParamInDto> requestParams;
  @Valid private List<PathParamInDto> pathParams;
}
