package ${packagePath};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import ${mudolePath}${modelPackageSuffix}.${domainObjectName};
import ${mudolePath}${modelPackageSuffix}.${domainObjectName}Example;
import ${mudolePath}${daoMapperPackageSuffix}.${domainObjectName}Mapper;

import ${mudolePath}.service.${domainObjectName}Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @Title:  ${domainObjectName}Service实现类
* @Package ${packagePath}
* @Description:    ${todo}
* @author: ${author}
* @date:   ${(date?string("yyyy-MM-dd"))!}
* @version V1.0
*/
@Service
@Transactional
public  class ${domainObjectName}ServiceImpl implements ${domainObjectName}Service {

    @Autowired
    protected ${domainObjectName}Mapper mapper;

    public void save(${domainObjectName} model) {
        mapper.insertSelective(model);
    }

    public void save(List<${domainObjectName}> models) {
        for (${domainObjectName} model : models){
            mapper.insert(model);
        }
    }

    public void deleteById(${primaryKey} id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void update(${domainObjectName} model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public ${domainObjectName} findById(${primaryKey} id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<${domainObjectName}> findByExample(${domainObjectName}Example example) {
        return mapper.selectByExample(example);
    }

}
