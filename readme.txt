SSM整合步骤web版

1、创建项目，copy jar包

2、copy generatorConfig.xml文件（自动生成）修改内容
    注意：数据库连接 及驱动jar包位置
        ①路径（可以用绝对路径）
        ②包名 com.ssm.xx
        ③表名 生成实体类去除 tb_
        ④指定生成的实体类字段的类型
           <columnOverride column="comm" javaType="java.lang.Float"/>
           <columnOverride column="sal" javaType="java.lang.Float" />

3、通过命令行生成实体类，dao和mapper.xml文件（SQL语句）
    1）、 将mybatis-generator-core.jar放在generatorConfig.xml同一目录下
         在该目录下打开命令行（shift+右键）（前提：已经配置好JDK的path），执行如下命令：
         java -jar mybatis-generator-core-1.3.5.jar -configfile generatorConfig.xml -overwrite
    2）、 使用mybatis-generator插件
          先创建包名，将generatorConfig.xml放置在resources目录下，右键运行Ran As MyBatisGenerator
    3）、 maven项目的话可以添加插件 使用maven命令执行

4、整合spring （配置文件applicationContext.xml）
    1）为web项目添加spring支持
        ①在resources目录下创建applicationContext.xml
        ②在web.xml添加配置

    2）为spring添加mybatis支持
        ①创建mybatis-config.xml将mapper文件添加进去
        ②在spring配置文件中配置中添加
          i     数据源
          ii    mybatis SqlSessionFactoryBean
          iii   自动扫描dao接口 MapperScannerConfigurer
          iv    事务管理（顺便配一下 aop）
        ③为mybatis添加log4j支持--创建log4j.properties文件
            注意：log4j配置文件需在resources目录下

5、整合springmvc
    1)为web项目添加springmvc支持
        ①在resources目录下创建springmvc.xml
        ②在web.xml添加配置
        ③在springmvc中配置
            i   视图解析器
            ii  基于注解映射器、适配器
            iii 配置拦截器
            iv  支持文件上传
            v   自定义参数绑定
            vi  配置Jackson转换器返回数据为json

    2）创建包service、action、intercept、utils
    3）编写service，action，intercept，相关java类
    4）测试