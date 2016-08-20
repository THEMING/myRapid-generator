<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package com.xuanwu.xtionframe.application.impl;

import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import com.xuanwu.xtionframe.application.${className}Application;
import com.xuanwu.xtionframe.core.domain.CurrentUser;
import com.xuanwu.xtionframe.core.domain.${className};

@Named
@Transactional
public class ${className}ApplicationImpl implements ${className}Application {

	public void save(${className} ${classNameLower}) {
		String viMsg = vilidate(${classNameLower});
		
		if(viMsg!=null){
			throw new CommonException(BizErrorCode.VALIDATE_BIZOBJ_ERROR, viMsg);
		}
		
		${classNameLower}.save(CurrentUser.getEnterprisenumber(),CurrentUser.getSystemCode());
	}
	
	public void delete(Long id) {
		${className}.delete(id);
	}
	
	public void setStatus(Long id,Long status){
		${className}.setStatus(id,status);
	}
	
}
