package com.fit.config;

import com.fit.action.SimpleAction;
import com.fit.service.UserService;
import com.fit.util.PropertiesUtils;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class GuiceConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(createServletModule(), createMyBatisModule());
    }

    private Module createServletModule() {
        return new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/*").with(SimpleAction.class);
            }
        };
    }

    private Module createMyBatisModule() {
        return new MyBatisModule() {
            @Override
            protected void initialize() {
                environmentId("production");
                bindDataSourceProviderType(PooledDataSourceProvider.class);
                bindTransactionFactoryType(JdbcTransactionFactory.class);
                //bind(SqlSessionFactory.class).toProvider(SqlSessionFactoryProvider.class).in(Scopes.SINGLETON);

                addSimpleAliases("com.fit.domain");
                addMapperClasses("com.fit.mapper");
                bind(UserService.class);

                Names.bindProperties(binder(), PropertiesUtils.getInstance().getProp());
            }
        };
    }
}
