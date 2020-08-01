package com.zys.boot.base.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = {"com.zys.boot.**.dao"}) //扫描dao包
public class MybatisConfig {

    @Value("${spring.datasource.master.url}")
    private String oneUrl;

    @Value("${spring.datasource.master.username}")
    private String oneUsername;

    @Value("${spring.datasource.master.password}")
    private String onePassword;

    @Value("${spring.datasource.master.driver-class-name}")
    private String oneDriverClassName;

    @Value("${spring.datasource.master.initialSize}")
    private String oneInitialSize;

    @Value("${spring.datasource.master.minIdle}")
    private String oneMinIdle;

    @Value("${spring.datasource.master.maxActive}")
    private String oneMaxActive;

    @Value("${spring.datasource.master.maxWait}")
    private String oneMaxWait;

    @Value("${spring.datasource.master.timeBetweenEvictionRunsMillis}")
    private String oneTimeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.master.minEvictableIdleTimeMillis}")
    private String oneMinEvictableIdleTimeMillis;

    @Value("${spring.datasource.master.validationQuery}")
    private String oneValidationQuery;

    @Value("${spring.datasource.master.filters}")
    private String oneFilters;


    @Value("${spring.datasource.master.type}")
    private String oneType;

    @Bean("master")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }

    @Bean("slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slave() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("master", master());
        dataSourceMap.put("slave", slave());
        // 将 master 数据源作为默认指定的数据源
        dynamicDataSource.setDefaultDataSource(master());
        // 将 master 和 slave 数据源作为指定的数据源
        dynamicDataSource.setDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource作为数据源则不能实现切换
        sessionFactory.setDataSource(dynamicDataSource());
        sessionFactory.setTypeAliasesPackage("com.zys.boot");    // 扫描Model
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/mapping/*.xml"));    // 扫描映射文件
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
        return new DataSourceTransactionManager(dynamicDataSource());
    }


}
