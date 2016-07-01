USE easybuy;

INSERT INTO admin(username, password) VALUES
('admin001', '123456'),
('admin002', '123456');

INSERT INTO user(username, password, phone, address) VALUES
  ('小明', '123456', '13312345678', '武汉'),
  ('小红', '123456', '15512345678', '北京'),
  ('test001', '123456', '13312345678', 'China');

insert into category (name,description,parent) values ("电子产品","",0);
insert into category (name,description,parent) values ("学习用品","",0);
insert into category (name,description,parent) values ("生活用品","",0);
insert into category (name,description,parent) values ("电脑","",1);
insert into category (name,description,parent) values ("电视","",1);
insert into category (name,description,parent) values ("电冰箱","",1);
insert into category (name,description,parent) values ("电风扇","",1);
insert into category (name,description,parent) values ("平板","",1);
insert into category (name,description,parent) values ("手机","",1);
insert into category (name,description,parent) values ("书籍","",2);
insert into category (name,description,parent) values ("草稿纸","",2);
insert into category (name,description,parent) values ("作业本","",2);
insert into category (name,description,parent) values ("铅笔","",2);
insert into category (name,description,parent) values ("钢笔","",2);
insert into category (name,description,parent) values ("毛笔","",2);
insert into category (name,description,parent) values ("墨水","",2);
insert into category (name,description,parent) values ("都市","",10);
insert into category (name,description,parent) values ("言情","",10);
insert into category (name,description,parent) values ("武侠","",10);
insert into category (name,description,parent) values ("玄幻","",10);
insert into category (name,description,parent) values ("历史","",10);
insert into category (name,description,parent) values ("人文","",10);
insert into category (name,description,parent) values ("哲学","",10);
insert into category (name,description,parent) values ("军事","",10);
insert into category (name,description,parent) values ("恐怖","",10);
insert into category (name,description,parent) values ("短袖","",3);
insert into category (name,description,parent) values ("衬衫","",3);
insert into category (name,description,parent) values ("牛仔裤","",3);
insert into category (name,description,parent) values ("羽绒服","",3);
insert into category (name,description,parent) values ("内裤","",3);
insert into category (name,description,parent) values ("胸罩","",3);
insert into category (name,description,parent) values ("席梦思","",3);
insert into category (name,description,parent) values ("枕头","",3);
insert into category (name,description,parent) values ("卫生巾","",3);

insert into goods (cid,name,price,unit,offset,storage,description,image) values (22,"安意如全集",88.00,"本",0.8,255,"浪漫古典文学小说","D:\images\1.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (23,"孙子兵法",25.00,"本",0.88,1314,"军事哲学博弈论巨著","D:\images\2.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (21,"明朝那些事",99.00,"本",0.8,379,"值得一读的经典畅销书","D:\images\3.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (23,"道德经",22.00,"本",0.8,379,"清净无为","D:\images\4.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (19,"金庸武侠小说全集",666.00,"套",0.8,379,"武侠巨制","D:\images\5.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (29,"波司登羽绒服",789.00,"件",0.9,379,"","D:\images\6.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (34,"苏菲卫生巾",,"包",0.99,520,"菲你不可，贴身闺蜜","D:\images\6.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (28,"以纯",138.00,"条",0.88,379,"","D:\images\7.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (4,"华硕A450J笔记本电脑",5700.00,"台",099,379,"Intel i7处理器","D:\images\8.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (4,"华硕S46C笔记本电脑",4800.00,"台",0.99,379,"停产了","D:\images\9.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (4,"联想G450笔记本电脑",4400.00,"台",0.99,379,"你值得拥有","D:\images\10.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (14,"派克钢笔",222.00,"支",0.8,379,"美国原装进口","D:\images\11.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (9,"红米note3 小米手机",899.00,"部",1,379,"性价比超高发烧友必备","D:\images\12.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (9,"华为荣耀6",1499.00,"部",1,379," 华为荣耀系列手机","D:\images\13.jpg");
insert into goods (cid,name,price,unit,offset,storage,description,image) values (8,"iPad平板电脑",3288.00,"台",1,379,"苹果平板，土豪必备","D:\images\14.jpg");

