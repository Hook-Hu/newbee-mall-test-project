# Swagger 接口清单

本文档按控制器源码整理，来源为 `src/main/java/ltd/newbee/mall/controller`。当前项目未引入 `springdoc`、`knife4j` 或 `springfox` 依赖，因此这里是“Swagger 风格”的接口清单，而不是运行时自动导出的接口文档。

## 通用说明

- `Result`：项目统一异步接口返回对象，一般包含结果码、提示信息和数据。
- 页面接口：返回 Thymeleaf 视图名，主要用于页面跳转。
- 数据接口：带 `@ResponseBody`，返回 `Result`、字符串、图片流或错误结构。
- 需要登录的前台接口通常依赖 `HttpSession` 中的商城用户；后台接口通常依赖后台登录会话。

## 后台管理接口

### 管理员

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/admin/login` | 页面 | 无 | 后台登录页 |
| GET | `/admin`、`/admin/`、`/admin/index`、`/admin/index.html` | 页面 | 无 | 后台首页 |
| POST | `/admin/login` | 页面提交 | `userName`、`password`、`verifyCode` | 登录成功重定向后台首页，否则返回登录页 |
| GET | `/admin/profile` | 页面 | 无 | 个人资料页 |
| POST | `/admin/profile/password` | 数据 | `originalPassword`、`newPassword` | 字符串，成功返回 `success` |
| POST | `/admin/profile/name` | 数据 | `loginUserName`、`nickName` | 字符串，成功返回 `success` |
| GET | `/admin/logout` | 页面 | 无 | 后台登录页 |

### 用户管理

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/admin/users` | 页面 | 无 | 用户管理页 |
| GET | `/admin/users/list` | 数据 | 查询参数：`page`、`limit` | 用户分页数据 |
| POST | `/admin/users/lock/{lockStatus}` | 数据 | 路径参数：`lockStatus`；请求体：用户编号数组 | 禁用或解除禁用结果 |

### 商品管理

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/admin/goods` | 页面 | 无 | 商品管理页 |
| GET | `/admin/goods/edit` | 页面 | 无 | 新增商品页 |
| GET | `/admin/goods/edit/{goodsId}` | 页面 | 路径参数：`goodsId` | 编辑商品页 |
| GET | `/admin/goods/list` | 数据 | 查询参数：`page`、`limit` | 商品分页数据 |
| POST | `/admin/goods/save` | 数据 | 请求体：`NewBeeMallGoods` | 新增结果 |
| POST | `/admin/goods/update` | 数据 | 请求体：`NewBeeMallGoods` | 修改结果 |
| GET | `/admin/goods/info/{id}` | 数据 | 路径参数：`id` | 商品详情 |
| PUT | `/admin/goods/status/{sellStatus}` | 数据 | 路径参数：`sellStatus`；请求体：商品编号数组 | 批量上下架结果 |

### 商品分类

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/admin/categories` | 页面 | `categoryLevel`、`parentId`、`backParentId` | 分类管理页 |
| GET | `/admin/categories/list` | 数据 | `page`、`limit`、`categoryLevel`、`parentId` | 分类分页数据 |
| GET | `/admin/categories/listForSelect` | 数据 | `categoryId` | 下级分类选择数据 |
| POST | `/admin/categories/save` | 数据 | 请求体：`GoodsCategory` | 新增结果 |
| POST | `/admin/categories/update` | 数据 | 请求体：`GoodsCategory` | 修改结果 |
| GET | `/admin/categories/info/{id}` | 数据 | 路径参数：`id` | 分类详情 |
| POST | `/admin/categories/delete` | 数据 | 请求体：分类编号数组 | 删除结果 |

### 轮播图

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/admin/carousels` | 页面 | 无 | 轮播图管理页 |
| GET | `/admin/carousels/list` | 数据 | `page`、`limit` | 轮播图分页数据 |
| POST | `/admin/carousels/save` | 数据 | 请求体：`Carousel` | 新增结果 |
| POST | `/admin/carousels/update` | 数据 | 请求体：`Carousel` | 修改结果 |
| GET | `/admin/carousels/info/{id}` | 数据 | 路径参数：`id` | 轮播图详情 |
| POST | `/admin/carousels/delete` | 数据 | 请求体：轮播图编号数组 | 删除结果 |

### 首页配置

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/admin/indexConfigs` | 页面 | `configType` | 首页配置页 |
| GET | `/admin/indexConfigs/list` | 数据 | `page`、`limit` | 首页配置分页数据 |
| POST | `/admin/indexConfigs/save` | 数据 | 请求体：`IndexConfig` | 新增结果 |
| POST | `/admin/indexConfigs/update` | 数据 | 请求体：`IndexConfig` | 修改结果 |
| GET | `/admin/indexConfigs/info/{id}` | 数据 | 路径参数：`id` | 首页配置详情 |
| POST | `/admin/indexConfigs/delete` | 数据 | 请求体：首页配置编号数组 | 删除结果 |

### 订单管理

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/admin/orders` | 页面 | 无 | 订单管理页 |
| GET | `/admin/orders/list` | 数据 | `page`、`limit` | 订单分页数据 |
| POST | `/admin/orders/update` | 数据 | 请求体：`NewBeeMallOrder` | 修改订单结果 |
| GET | `/admin/order-items/{id}` | 数据 | 路径参数：`id` | 订单明细列表 |
| POST | `/admin/orders/checkDone` | 数据 | 请求体：订单编号数组 | 配货结果 |
| POST | `/admin/orders/checkOut` | 数据 | 请求体：订单编号数组 | 出库结果 |
| POST | `/admin/orders/close` | 数据 | 请求体：订单编号数组 | 关闭订单结果 |

### 优惠券管理

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/admin/coupon` | 页面 | 无 | 优惠券管理页 |
| GET | `/admin/coupon/list` | 数据 | `page`、`limit` | 优惠券分页数据 |
| POST | `/admin/coupon/save` | 数据 | 请求体：`NewBeeMallCoupon` | 新增结果 |
| POST | `/admin/coupon/update` | 数据 | 请求体：`NewBeeMallCoupon` | 修改结果 |
| GET | `/admin/coupon/{id}` | 数据 | 路径参数：`id` | 优惠券详情 |
| DELETE | `/admin/coupon/{id}` | 数据 | 路径参数：`id` | 删除结果 |

### 秒杀管理

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/admin/seckill` | 页面 | 无 | 秒杀管理页 |
| GET | `/admin/seckill/list` | 数据 | `page`、`limit` | 秒杀分页数据 |
| POST | `/admin/seckill/save` | 数据 | 请求体：`NewBeeMallSeckill` | 新增结果 |
| POST | `/admin/seckill/update` | 数据 | 请求体：`NewBeeMallSeckill` | 修改结果 |
| GET | `/admin/seckill/{id}` | 数据 | 路径参数：`id` | 秒杀详情 |
| DELETE | `/admin/seckill/{id}` | 数据 | 路径参数：`id` | 删除结果 |

### 文件上传

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| POST | `/admin/upload/file` | 数据 | 表单文件：`file` | 单图上传结果，数据为文件访问路径 |
| POST | `/admin/upload/files` | 数据 | 多文件表单，最多 5 张图片 | 多图上传结果，数据为文件访问路径列表 |

## 商城前台接口

### 首页与商品

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/`、`/index`、`/index.html` | 页面 | 无 | 商城首页 |
| GET | `/search`、`/search.html` | 页面 | `page`、`goodsCategoryId`、`orderBy`、`keyword` | 商品搜索页 |
| GET | `/goods/detail/{goodsId}` | 页面 | 路径参数：`goodsId` | 商品详情页 |

### 登录注册与个人中心

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/personal` | 页面 | 无 | 个人中心页 |
| GET | `/logout` | 页面 | 无 | 商城登录页 |
| GET | `/login`、`login.html` | 页面 | 无 | 商城登录页 |
| GET | `/register`、`register.html` | 页面 | 无 | 商城注册页 |
| GET | `/personal/addresses` | 页面 | 无 | 地址管理页 |
| POST | `/login` | 数据 | `loginName`、`password`、`verifyCode` | 登录结果 |
| POST | `/register` | 数据 | `loginName`、`password`、`verifyCode` | 注册结果 |
| POST | `/personal/updateInfo` | 数据 | 请求体：`MallUser` | 用户资料修改结果 |

### 购物车

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/shop-cart` | 页面 | 无 | 购物车页 |
| POST | `/shop-cart` | 数据 | 请求体：`NewBeeMallShoppingCartItem` | 添加购物车结果 |
| PUT | `/shop-cart` | 数据 | 请求体：`NewBeeMallShoppingCartItem` | 修改购物车结果 |
| DELETE | `/shop-cart/{newBeeMallShoppingCartItemId}` | 数据 | 路径参数：`newBeeMallShoppingCartItemId` | 删除购物车项结果 |
| GET | `/shop-cart/settle` | 页面 | 无 | 订单结算页 |

### 订单与支付

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/orders/{orderNo}` | 页面 | 路径参数：`orderNo` | 订单详情页 |
| GET | `/orders` | 页面 | `page` | 我的订单页 |
| GET | `/saveOrder` | 页面 | `couponUserId` | 创建普通订单后重定向订单详情 |
| GET | `/saveSeckillOrder/{seckillSuccessId}/{userId}/{seckillSecretKey}` | 页面 | 路径参数：`seckillSuccessId`、`userId`、`seckillSecretKey` | 创建秒杀订单后重定向订单详情 |
| GET | `/selectPayType` | 页面 | `orderNo` | 支付方式选择页 |
| GET | `/payPage` | 页面 | `orderNo`、`payType` | 支付页 |
| GET | `/returnOrders/{orderNo}/{userId}` | 页面 | 路径参数：`orderNo`、`userId` | 支付返回后的订单详情页 |
| POST | `/paySuccess` | 数据 | `payType`、`orderNo`，支付宝回调参数 | 支付成功处理结果 |
| PUT | `/orders/{orderNo}/cancel` | 数据 | 路径参数：`orderNo` | 取消订单结果 |
| PUT | `/orders/{orderNo}/finish` | 数据 | 路径参数：`orderNo` | 确认收货结果 |

### 优惠券

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/couponList` | 页面 | 无 | 可领取优惠券页 |
| GET | `/myCoupons` | 页面 | `page`、`status` | 我的优惠券页 |
| POST | `/coupon/{couponId}` | 数据 | 路径参数：`couponId` | 领取优惠券结果 |
| DELETE | `/coupon/{couponUserId}` | 数据 | 路径参数：`couponUserId` | 删除用户优惠券结果 |

### 秒杀

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/seckill` | 页面 | 无 | 秒杀列表页 |
| GET | `/seckill/time/now` | 数据 | 无 | 当前服务器时间戳 |
| POST | `/seckill/{seckillId}/checkStock` | 数据 | 路径参数：`seckillId` | 虚拟库存校验结果 |
| POST | `/seckill/{seckillId}/exposer` | 数据 | 路径参数：`seckillId` | 秒杀链接暴露信息 |
| POST | `/seckillExecution/{seckillId}/{userId}/{md5}` | 数据 | 路径参数：`seckillId`、`userId`、`md5` | 秒杀执行结果 |
| GET | `/seckill/info/{seckillId}` | 页面 | 路径参数：`seckillId` | 秒杀详情页 |
| GET | `/seckill/list` | 数据 | 无 | 首页秒杀商品列表 |
| GET | `/seckill/{seckillId}` | 数据 | 路径参数：`seckillId` | 秒杀商品详情 |

## 公共接口

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| GET | `/common/kaptcha` | 图片流 | 无 | 后台验证码图片 |
| GET | `/common/mall/kaptcha` | 图片流 | 无 | 商城验证码图片 |

## 错误处理接口

| 请求方式 | 路径 | 类型 | 参数或请求体 | 返回 |
| --- | --- | --- | --- | --- |
| 任意 | `/error`，`Accept: text/html` | 页面 | 无 | 400、404 或 5xx 错误页 |
| 任意 | `/error` | 数据 | 无 | 错误详情结构 |

