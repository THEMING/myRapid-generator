/*
 * 文 件 名:  ${table.className}ServiceImpl.java
 * 创 建 人:  
 * 创建时间:  <#if now??>${now?string('yyyy-MM-dd')}</#if>
 */
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.common.utils.StringNumberUtil;
import ${basepackage}.service.${className}Service;
import ${basepackage}.entity.po.${className};
import ${basepackage}.dao.${className}Mapper;

/**
 * <一句话功能简述>
 */
@Service
public class ${className}ServiceImpl implements ${className}Service {
	
    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;
    
    @Transactional
	public int add(${className} ${classNameLower}) {
		if(null == ${classNameLower}){
			return 0;
		}
        int rows = ${classNameLower}Mapper.insert(${classNameLower});
        return rows;
	}

    
    @Transactional
    public int update(${className} ${classNameLower}) {
		if(null == ${classNameLower}){
			return 0;
		}
        int rows = ${classNameLower}Mapper.update(${classNameLower});
        return rows;
    }
    
    
    @Transactional
    public int delete(Integer id) {
		if(null == id){
			return 0;
		}
        int rows = ${classNameLower}Mapper.deleteById(id);
        return rows;
    }
    
    
    public ${className} getById(Integer id) {
		if(null == id){
			return null;
		}
		${className} ${classNameLower} = ${classNameLower}Mapper.getById(id);
		//
        return ${classNameLower};
    }
	
	public Integer countBy(Map<String, Object> params){
		Integer rows = ${classNameLower}Mapper.countBy(params);
		return rows;
	}
	
	public List<${className}> listPage(Map<String, Object> params){
		List<${className}> lists = ${classNameLower}Mapper.listPage(params);
		
		return lists;
	}
}