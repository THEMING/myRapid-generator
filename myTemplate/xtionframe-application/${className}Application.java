<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package com.xuanwu.xtionframe.application;

import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import com.xuanwu.xtionframe.core.domain.${className};

public interface ${className}Application {
	public void save(${className} ${classNameLower});

	public void delete(Long id);

	public void setStatus(Long id,Long status);
}
