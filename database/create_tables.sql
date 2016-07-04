USE easybuy;

DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS goods;
DROP TABLE IF EXISTS image;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS seckill;
DROP TABLE IF EXISTS success_killed;

# 管理员用户表
CREATE TABLE admin (
    id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,     # 用户 ID,主键
    username VARCHAR(64) NOT NULL UNIQUE KEY,             # 用户名
    password VARCHAR(128) NOT NULL                        # 密码
)CHARSET=utf8;

# 普通购买商品的用户表
CREATE TABLE user (
    id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,     # 用户 ID,主键
    username VARCHAR(64) NOT NULL UNIQUE KEY,             # 用户名
    password VARCHAR(128) NOT NULL,                       # 密码
    phone    VARCHAR(32),                                 # 电话号码
    address  VARCHAR(512)                                 # 用户收货地址
)CHARSET=utf8;

# 商品分类表
CREATE TABLE category (
    id          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,  # 主键
    name        VARCHAR(255) NOT NULL,                    # 类名
    description VARCHAR(1024),                            # 分类描述
    parent      INT DEFAULT 0,                            # 该分类的父类ID,如果为顶级分类,父ID为0
    UNIQUE KEY (name, parent)
)CHARSET=utf8;

# 商品信息表
CREATE TABLE goods (
    id      INT NOT NULL PRIMARY KEY AUTO_INCREMENT,      # 主键
    cid     INT,                                          # 分类 ID
    name    VARCHAR(255),                                 # 商品名
    price   FLOAT,                                        # 商品单价
    unit    VARCHAR(64),                                  # 商品单位
    offset  FLOAT,                                        # 商品折扣
    storage INT,                                          # 库存数量
    description VARCHAR(2000),                            # 商品介绍
    image   VARCHAR(2000),                                # 图片地址
    time    TIMESTAMP                                     # 更新时间
)CHARSET=utf8;

# 图片信息表
CREATE TABLE image (
    id   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,         # 主键
    gid  INT,                                             # 图片对应商品的 ID
    path VARCHAR(2000)                                    # 图片存储路径(相对路径)
)CHARSET=utf8;

# 订单表
CREATE TABLE orders (
    id    INT NOT NULL PRIMARY KEY AUTO_INCREMENT,        # 主键
    uid   INT NOT NULL,                                   # 用户 ID
    gid   INT NOT NULL,                                   # 商品 ID
    time  TIMESTAMP,                                      # 最后一次操作时间
    sum   INT,                                            # 商品总数
    state INT,                                            # 商品状态.添加到购物车0,付款1,已发货2,签收3.
    total FLOAT                                           # 订单总金额
)CHARSET=utf8;

CREATE TABLE seckill(
  `seckill_id` BIGINT NOT NUll AUTO_INCREMENT COMMENT '商品库存ID',
  `name` VARCHAR(120) NOT NULL COMMENT '商品名称',
  `number` int NOT NULL COMMENT '库存数量',
  `start_time` TIMESTAMP  NOT NULL COMMENT '秒杀开始时间',
  `end_time`   DATETIME   NOT NULL COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 秒杀成功明细表
-- 用户登录认证相关信息(简化为手机号)
CREATE TABLE success_killed(
  `seckill_id` BIGINT NOT NULL COMMENT '秒杀商品ID',
  `user_phone` BIGINT NOT NULL COMMENT '用户手机号',
  `state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态标识:-1:无效 0:成功 1:已付款 2:已发货',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY(seckill_id,user_phone),/*联合主键*/
  KEY idx_create_time(create_time)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';
