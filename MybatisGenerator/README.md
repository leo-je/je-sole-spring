# MybatisGenerator
基于Mybatis-Generator,freemarker生成对应dao,service层的代码

#使用
1.在resource的配置文件中设置数据库信息<br>
2.配置需要生成代码的表名<br>
3.运行GenMain<br>

#说明
1.生成的代码,xml文件都会在${mudolePath}路径下<br>
2.service层相关文件可在模板文件中自行优化<br>

#存在问题
1.目前一次只能对一张表进行操作<br>
2.已添加实体类自定义注释,但无法生成类注释,求大佬指导<br>
3.当mudolePath不存在时,可能会生成错误路径<br>