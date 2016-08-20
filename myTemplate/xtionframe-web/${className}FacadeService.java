<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package com.xuanwu.xtionframe.web.rest;

import javax.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xuanwu.xtionframe.core.domain.${className};
import com.xuanwu.xtionframe.facade.${className}Facade;


@Component 
@Path("/${classNameLower}")
public class ${className}FacadeService {
	
	@Autowired
	private ${className}Facade ${classNameLower}Facade;
	
	@Context 
	HttpServletRequest request;
	
	@Context 
	HttpServletResponse response;

	@POST()
	@Path("/save")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(${className}DTO ${classNameLower}){
		return ${classNameLower}Facade.save(${classNameLower});
	}
	
	@POST()
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(Long id){
		return ${classNameLower}Facade.delete(id);
	}
	
	@POST()
	@Path("/setStatus")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response setStatus(Map<String, Object> param){
		return ${classNameLower}Facade.setStatus(MapUtils.getLong(param, "id",null),MapUtils.getLong(param, "status",null));
	}
	
	@POST()
	@Path("/list")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response list(Map<String, Object> param){		
		return ${classNameLower}Facade.list(param);
	}
	
	@POST()
	@Path("/get")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response get(Map<String, Object> param){
		return ${classNameLower}Facade.get(param);
	}
	
}
