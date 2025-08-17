# Mall订单服务 (mall-order-service)

## 项目简介
Mall订单服务是商城系统的核心服务之一，负责处理订单创建、查询、状态管理以及购物车功能。

## 技术栈
- Java 21
- Spring Boot 3.2.4
- Spring Cloud 2023.0.1
- MyBatis-Plus 3.5.12
- Knife4j 4.5.0
- MySQL 8.0
- Nacos
- Seata

## 项目结构

```shell
mysqldump -h 127.0.0.1 -P 3306 -uroot -proot --no-create-info --skip-triggers --compact mall_order > mall_order_data.sql
```

```shell
mysqldump -h 127.0.0.1 -P 3306 -uroot -proot --no-data --skip-triggers --skip-routines mall_order > mall_order_schema_only.sql
```