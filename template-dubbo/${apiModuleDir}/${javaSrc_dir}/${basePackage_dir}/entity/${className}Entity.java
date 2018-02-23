<#assign className = table.tableClassName>
package ${basePackage}.entity;

import ${annotationInsertNotNull}
import ${annotationUpdateNotNull}

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

<#include "/include/java_copyright.ftl">
public class ${className}Entity implements Serializable {

    <#list table.columns as column>
    /**
     * ${column.columnComment}
     */
<#if (column.primaryKey && column.autoIncrement)>
    @InsertNotNull
<#elseif (column.columnName != 'create_time' && column.columnName != 'update_time')>
    @InsertNotNull
    @UpdateNotNull
</#if>
    private ${column.columnFieldType} ${column.columnFieldNameFirstLower};

    </#list>

    <#list table.columns as column>
    /**
    * 设置${column.columnComment}
    */
    public void set${column.columnFieldName}(${column.columnFieldType} ${column.columnFieldNameFirstLower}) {
        this.${column.columnFieldNameFirstLower} = ${column.columnFieldNameFirstLower};
    }

    /**
    * 获取${column.columnComment}
    */
    public ${column.columnFieldType} get${column.columnFieldName}() {
        return this.${column.columnFieldNameFirstLower};
    }

    </#list>
}