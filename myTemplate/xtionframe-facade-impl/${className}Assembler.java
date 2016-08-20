<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package com.xuanwu.xtionframe.facade.impl.assembler;

import java.util.ArrayList;
import java.util.List;
import com.xuanwu.xtionframe.core.domain.${className};
import com.xuanwu.xtionframe.facade.dto.${className}DTO;

public class ${className}Assembler {
	public static ${className} toEntity(${className}DTO dto){
		${className} ${classNameLower} = new ${className}();
		<#list table.columns as column>
		${classNameLower}.set${column.columnName}(dto.get${column.columnName});
		</#list>
		return ${classNameLower};
	}
	
	public static List<${className}> toEntitys(List<${className}DTO> dtos){
		if(dtos==null){
			return null;
		}
		
		List<${className}> list = new ArrayList<${className}>();
		
		for(int i=0;i<dtos.size();i++){
			list.add(toEntity(dtos.get(i)));
		}
		
		return list;
	}
	
	public static ${className}DTO toDto(${className} ${classNameLower}){
		if(${classNameLower}==null){
			return null;
		}
		
		${className}DTO dto = new ${className}DTO();
		<#list table.columns as column>
		dto.set${column.columnName}(${classNameLower}.get${column.columnName});
		</#list>
		
		return dto;
	}

	public static List<${className}DTO> toDTOs(List<${className}> ${classNameLower}s) {
		if(${classNameLower}s==null){
			return null;
		}
	
		List<${className}DTO> dtos = new ArrayList<${className}DTO>();
		for(int i=0;i<${classNameLower}s.size();i++){
			dtos.add(toDTO(${classNameLower}s.get(i)));
		}
		return dtos;
	}

}

<#macro generateJavaColumns>
	<#list table.columns as column>
    <@generateBycondition column.sqlName>
	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	</@generateBycondition>
	</#list>
</#macro>

