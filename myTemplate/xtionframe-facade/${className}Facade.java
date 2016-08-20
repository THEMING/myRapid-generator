<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package com.xuanwu.xtionframe.facade;

import java.util.Map;

import javax.ws.rs.core.Response;

public interface ${className}Facade extends CoreFacade {

	public Response save(${className}DTO dto);

	public Response delete(Long id);

	public Response setStatus(Long id,Long status);
	
	public Response list(Map<String, Object> param);
	
	public Response get(Map<String, Object> param);
}
