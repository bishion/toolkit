# 穿山甲项目

登录信息透传，核心思路是在拦截器中拦截到固定header的信息，封装后存入线程变量，然后再在远程调用中设置到header中去

## 注意

1. header信息需要由网关系统设置
2. 系统默认未登录的用户，用户名为*_no_login*
3. 为防止信息泄露，在请求第三方接口时，需要清理掉已经设置的header信息, 方法为实现 *FillReqInfoJudgeService 接口*
4. 目前使用 TransmittableThreadLocal 保存登录信息，对于多线程下注意自行区分