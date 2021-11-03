package com.base.web.设计模式.抽象工厂模式;

/**
 * 模式定义：
 *      提供一个创建一系列相关或互相依赖对象的接口，而无需指定他们具体的类。
 * 应用场景：
 *      程序需要处理不同系列的相关产品，但是不希望它依赖于这些产品的具体类时，可以使用抽象工厂。
 * 优点：
 *      1、可以确信从工厂中得到的产品彼此是兼容的
 *      2、可以避免具体产品和客户端代码之间是解耦
 *      3、符合单一职责原则
 *      3、负责开闭原则
 * JDK源码中的应用：
 *      java.sql.Connection
 *      java.sql.Driver
 *
 */
public class AbstractFactory {

    public static void main(String[] args) {
        //IDataSourceUtils dataSourceUtils = new MySQLDataUtils();
        IDataSourceUtils dataSourceUtils = new OracleDataUtils();
        IConnect connect = dataSourceUtils.getConnect();
        connect.connectMethod();
        ICommand command = dataSourceUtils.getCommand();
        command.commandMethod();

    }
}

    //  相同： MySQL  Oracle
    //        连接connect   指令command
interface IConnect{
    void connectMethod();
}

interface ICommand{
    void commandMethod();
}

interface IDataSourceUtils{
    IConnect getConnect();
    ICommand getCommand();
}

//MySQL
class MySQLConnect implements IConnect{

    @Override
    public void connectMethod() {
        System.out.println("MySQL 连接");
    }
}

class MySQLCommand implements ICommand{

    @Override
    public void commandMethod() {
        System.out.println("MySQL 命令");
    }
}

class MySQLDataUtils implements IDataSourceUtils{

    @Override
    public IConnect getConnect() {
        return new MySQLConnect();
    }

    @Override
    public ICommand getCommand() {
        return new MySQLCommand();
    }
}
//Oracle
class OracleConnect implements IConnect{

    @Override
    public void connectMethod() {
        System.out.println("Oracle 连接");
    }
}

class OracleCommand implements ICommand{

    @Override
    public void commandMethod() {
        System.out.println("Oracle 命令");
    }
}

class OracleDataUtils implements IDataSourceUtils{

    @Override
    public IConnect getConnect() {
        return new OracleConnect();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}