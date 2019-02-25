#redis note(The Design and Implement of Redis)

## first chapter --data structure and object

#### SDS(simple dynamic string) 
- 包含字符串的键值对在底层都是SDS实现的
- 设置和更新SDS长度的工作由SDS的API在执行时自动完成
- 空间预分配和惰性空间释放 减少 修改字符串带来的内存重新分配次数

#### linkedlist

#### dict and dictht
- 拉链法
- rehash   ht[0]和ht[1]
- 渐进 rehash

#### skiplist
- 查找o(lgn)

#### 整数集合intset
- 按值从小到大排列
- 支持升级，但不支持降级

#### ziplist
- 节约内存

#### object
- object encoding ob   对象的底层编码
- type ob   对象的类型
- 创建两个对象 ： 键对象和值对象
- String  ： SDS(raw)，整数值或 embstr
- List : linkedlist 或 ziplist
- Hash : dict 或 ziplist
- SET :  dict 或 intset
- zset : ziplist 或 (skiplist 和 dict)
- 类型检查 多态命令(根据对象的底层编码)
- 内存回收 refernce counting    object refcount on
- 对象共享(redis 只对包含整数值的字符串对象进行共享)

## second chapter --Expire and RDB and AOF 

###expire
expires词典保存数据库所有键的过期信息
redis删除过期键策略：惰性删除+定期删除
在save或bgsave生成rdb文件时，程序会对数据库中的键进行检查，已过期的键不会被保存
在载入rdb文件时，若服务器以主服务器运行，则不载入已过期键；若服务器以从服务器运行，则也载入已过期键
aof写入只在显式删除（定期删除或惰性删除）时添加del key在文件尾
aof重写时会对已过期过滤
复制的时候，从服务器不会主动删除已过期键，即使用户get访问

###rdb
bgsave为子进程操作，save会堵塞主进程
若开启aof则优先载入aof文件
在配置文件中有定期自动保存设置（根据dirty和lastsave）（也就是改动次数和上次修改的时间）
od -xc dump.rdb 以ascii和16进制方式查看rdb文件

###aof
bgrewriteaof 由子进程执行
命令追加 文件写入 文件同步(appendfsync)
文件载入
aof重写 

## third chapter ——copy
###slaveof

###同步和命令传播
(断线重连)full synchro(rdb) 和 partial synchro(几个命令)
身份验证 从服务器中的masterauth和主服务器的requirepass
info replication查看slave的状况


## third chapter  ——transaction
没有rollback  只能所有指令一起执行   执行的时候进程堵塞
指令先进消息队列
aci可以  只有appendfsync=always时用aof才持久化(d)
watch 某个key   若该key被其他客户端在此期间修改了  则事务一个指令也不会执行(乐观锁)


## fourth chapter   -sort
- 可以对列表，集合，有序集合进行排序
- sort<key> [ALPHA][ASC|DESC] [LIMIT][STORE]
- 对有序集合自定义排序
- ```
    zadd test-result 3.0 jack 3.5 peter 4.0 tom
    mset peter_number 1 tom_number 2 jack_number 3
    sort test-result by *_number
   ```
- ```      
    sadd fruits "apple" "banana" "cherry"
    mset apple-id "fruit-25" banana-id "fruit-79" cherry-id "fruit-13"
    sort fruits by *-id alpha
  ```
- ```
    sadd fruits "apple" "banana" "cherry"
    mset apple-color "red" banana-color "banana" cherry-color "red"
    sort fruits alpha get *-color
  ```
- 执行顺序
  1. 排序（alpha asc desc by）
  2. limit
  3. get
  4. store
  5. 向客户端返回结果集

                                                                                                                                    
      





    


  


