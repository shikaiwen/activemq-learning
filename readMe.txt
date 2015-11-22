
队列消息和topic消息最大的区别就是队列消息消费者任何时候都可以连接上来，如果有消息就会收到，但是Topic
的subscriber一定要先连上MQ，然后publisher再发消息，这样才会收到，如果publisher先发消息，然后publisher再
连接上来，那么之前的消息就收不到了
The big defference between publisher with subscriber( message called topic ) and consumer with message sender(message called queue)
is that you can handle the messages in queue any time when you connect to the ActiveMQ with BROKER_URL, but with
topic , you must have subsribers subscribed first and then you send topic message, by this way subscribers will 
receive the message correctly , but if you send topic messages first and then have the subscribers connect to
the ActiveMQ ,you will not receive any messages.


mq 也有PooledConnectionFactory 支持配置多个connection    

MessageProducer和 Message接口分别有 setDeliveryMode以及setJMSDeliveryMode方法,两者达到的效果应该都一样,如果为true，那么
jms server会将消息保存到服务器本地，即时把服务器重启也不会丢失













JTA的分布式事务支持是要靠数据库厂商的支持的
自己实现分布式事务的例子：https://www.ibm.com/developerworks/cn/java/j-lo-jta/
mysql5.7才开始支持分布式事务 :http://dev.mysql.com/doc/refman/5.7/en/xa.html
分布式事务使用的协议XA  https://en.wikipedia.org/wiki/X/Open_XA

关于事务的 很全面  http://www.cnblogs.com/superjt/archive/2013/05/20/3088847.html