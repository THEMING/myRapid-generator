<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package com.xuanwu.xtionframe.core.domain;

import java.io.Serializable;
import org.openkoala.koala.commons.domain.mybatis.TenantMybatisBaseQuery;

@SuppressWarnings({"serial"})
public class ${className} extends CoreEntity {

	<#list table.columns as column>
	// ${column.columnAlias}
	private ${column.simpleJavaType} ${column.columnNameLower};
	</#list>
		
	<#list table.columns as column>
	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	</#list>
	
	@Override
	public boolean existed() {
		return getRepository().exists(${className}.class, this, CurrentUser.getEnterprisenumber(),CurrentUser.getSystemCode());
	}
	
	@Override
	public boolean notExisted() {
		return !existed();
	}
	
	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ${className} load(){
		return load(CurrentUser.getEnterprisenumber(), CurrentUser.getSystemCode());
	}
	
	public ${className} load(int enterprisenumber,String systemCode){
		return getRepository().load(${className}.class, this, enterprisenumber, systemCode);
	}
	
	public static void setStatus(Long id,Long status){
		getRepository().createNamedQuery(${className}.class, "setStatus").addParameter("id", id).addParameter("status", status)
		.executeUpdate(CurrentUser.getEnterprisenumber(), CurrentUser.getSystemCode());
	}
	
	public static void delete(Long id){
		getRepository().createNamedQuery(${className}.class, "delete").addParameter("id", id)
		.executeUpdate(CurrentUser.getEnterprisenumber(), CurrentUser.getSystemCode());
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
