# newbee-mall-test-project

## 项目简介

本项目基于开源商城系统 newbee-mall 搭建测试环境，围绕用户登录、商品浏览、购物车、订单提交、优惠券、秒杀、后台管理等核心业务模块，开展功能测试、接口测试、自动化测试与性能测试实践。

本项目主要用于展示完整的软件测试流程，包括测试计划制定、测试用例设计、接口测试、缺陷记录、自动化测试脚本编写、性能压测与测试报告输出。

## 测试范围

- 用户登录与注册
- 商品分类与商品详情
- 购物车管理
- 订单提交与订单查询
- 优惠券领取
- 秒杀下单
- 后台商品管理
- 后台订单管理

## 技术与工具

- 测试对象：Spring Boot 商城系统
- 数据库：MySQL
- 缓存：Redis
- 接口测试：Postman / Apifox
- 自动化测试：Python + Pytest + Requests
- 性能测试：JMeter
- 测试报告：Allure / Markdown
- 版本管理：Git + GitHub

## 项目测试目录

```text
test_docs/
├── 01_project_overview      # 项目功能梳理
├── 02_test_plan             # 测试计划与测试方案
├── 03_test_cases            # 测试用例
├── 04_api_testing           # 接口测试
├── 05_automation_testing    # 自动化测试
├── 06_performance_testing   # 性能测试
├── 07_bug_reports           # 缺陷报告
├── 08_test_reports          # 测试报告
└── 09_interview_review      # 面试复盘