<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package com.xuanwu.xtionframe.facade.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import org.apache.commons.collections.MapUtils;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.RestResult;
import org.openkoala.koalacommons.mybatis.TenantMybatisQueryChannelService;
import com.xuanwu.xtionframe.application.${className}Application;
import com.xuanwu.xtionframe.core.domain.CurrentUser;
import com.xuanwu.xtionframe.core.domain.${className};
import com.xuanwu.xtionframe.facade.${className}Facade;
import com.xuanwu.xtionframe.facade.dto.${className}DTO;
import com.xuanwu.xtionframe.facade.impl.assembler.${className}Assembler;
import com.xuanwu.xtionframe.infra.common.ResultHelper;
import com.xuanwu.xtionframe.infra.constant.*;
import com.xuanwu.xtionframe.infra.util.BeanUtil;

@SuppressWarnings({ "unchecked" })
@Named
public class ${className}FacadeImpl extends CoreFacadeImpl implements ${className}Facade {
	
	@Inject
	private ${className}Application ${classNameLower}Application;
	
	@Inject
	public TenantMybatisQueryChannelService queryChannel;

	public Response save(${className}DTO dto) {
		try{
			${classNameLower}Application.save(${className}Assembler.toEntity(dto));
			return ResultHelper.success("新增成功");
		}catch(Exception e){
			return ResultHelper.failure(BizErrorCode.VALIDATE_DATA_ERROR,"新增失败");
		}
	}

	@Override
	public Response delete(Long id) {
		try{
			${classNameLower}Application.delete(id);
			return ResultHelper.success("删除成功");
		}catch(Exception e){
			return ResultHelper.failure(BizErrorCode.VALIDATE_DEL_ERROR,"删除失败");
		}
	}

	@Override
	public Response setStatus(Long id,Long status) {
		try{
			${classNameLower}Application.setStatus(id,status);
			return ResultHelper.success("设置成功");
		}catch(Exception e){
			return ResultHelper.failure(BizErrorCode.VALIDATE_DATA_ERROR,"设置失败");
		}
	}

	@Override
	public Response list(Map<String, Object> param) {
		
		int pageno = MapUtils.getIntValue(param, "pageno",1);
		int pagesize = MapUtils.getIntValue(param, "pagesize",15);
		param.put("firstrow", (pageno-1)*pagesize);
		param.put("lastrow", pageno*pagesize);
		
		Page<Map<String, Object>> pages = queryChannel
				.createNamedQuery(${className}.class, "list")
				.setParameters(param)
				.setPage(pageno, pagesize).pagedList(CurrentUser.getEnterprisenumber(), CurrentUser.getSystemCode());
		
		return ResultHelper.success(new Page<Map<String, Object>>(pages.getStart(), pages.getResultCount(),
				pagesize, pages.getData()));
	}

	@Override
	public Response get(Map<String, Object> param) {
	
		${className} ${classNameLower} = (${className}) queryChannel
				.createNamedQuery(${className}.class, "get")
				.setParameters(param)
				.singleResult(CurrentUser.getEnterprisenumber(), CurrentUser.getSystemCode());
				
		return RestResult.success(${className}Assembler.toDTO(${classNameLower}));
	}

}
