
������Ϣ��topic��Ϣ����������Ƕ�����Ϣ�������κ�ʱ�򶼿��������������������Ϣ�ͻ��յ�������Topic
��subscriberһ��Ҫ������MQ��Ȼ��publisher�ٷ���Ϣ�������Ż��յ������publisher�ȷ���Ϣ��Ȼ��publisher��
������������ô֮ǰ����Ϣ���ղ�����
The big defference between publisher with subscriber( message called topic ) and consumer with message sender(message called queue)
is that you can handle the messages in queue any time when you connect to the ActiveMQ with BROKER_URL, but with
topic , you must have subsribers subscribed first and then you send topic message, by this way subscribers will 
receive the message correctly , but if you send topic messages first and then have the subscribers connect to
the ActiveMQ ,you will not receive any messages.


mq Ҳ��PooledConnectionFactory ֧�����ö��connection    

MessageProducer�� Message�ӿڷֱ��� setDeliveryMode�Լ�setJMSDeliveryMode����,���ߴﵽ��Ч��Ӧ�ö�һ��,���Ϊtrue����ô
jms server�Ὣ��Ϣ���浽���������أ���ʱ�ѷ���������Ҳ���ᶪʧ













JTA�ķֲ�ʽ����֧����Ҫ�����ݿ⳧�̵�֧�ֵ�
�Լ�ʵ�ֲַ�ʽ��������ӣ�https://www.ibm.com/developerworks/cn/java/j-lo-jta/
mysql5.7�ſ�ʼ֧�ֲַ�ʽ���� :http://dev.mysql.com/doc/refman/5.7/en/xa.html
�ֲ�ʽ����ʹ�õ�Э��XA  https://en.wikipedia.org/wiki/X/Open_XA

��������� ��ȫ��  http://www.cnblogs.com/superjt/archive/2013/05/20/3088847.html