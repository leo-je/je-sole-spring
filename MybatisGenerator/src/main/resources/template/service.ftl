package ${packagePath};

import ${mudolePath}${modelPackageSuffix}.${domainObjectName};
import ${mudolePath}${modelPackageSuffix}.${domainObjectName}Example;

import java.util.List;

/**
*
* @Title:  ${domainObjectName}Service接口
* @Package ${packagePath}
* @Description:    ${todo}
* @author: ${author}
* @date:   ${(date?string("yyyy-MM-dd"))!}
* @version V1.0
*/
public interface ${domainObjectName}Service {

	/**
	 * 插入数据
	 * @param model
	 */
    void save(${domainObjectName} model);

    /**
     * 批量插入数据
     * @param models
     */
    void save(List<${domainObjectName}> models);

    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(${primaryKey} id);

    /**
     * 更新
     * @param model
     */
    void update(${domainObjectName} model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    ${domainObjectName} findById(${primaryKey} id);

    /**
     * 根据条件查找
     * @param example
     * @return
     */
    List<${domainObjectName}> findByExample(${domainObjectName}Example example);

}
