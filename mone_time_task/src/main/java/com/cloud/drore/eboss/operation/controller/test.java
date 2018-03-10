package com.cloud.drore.eboss.operation.controller;

import java.util.concurrent.*;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/9 0009 下午 8:02 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class test {

        public static void main(String[] args) throws Exception {

            final ExecutorService exec = Executors.newFixedThreadPool(1);

            Callable<String> call = () -> {
                // 开始执行耗时操作
                Thread.sleep(1000 * 2);
                return "线程执行完成.";
            };

            try {
                Future<String> future = exec.submit(call);
                String obj = future.get(1000 * 1, TimeUnit.MILLISECONDS); // 任务处理超时时间设为
                // 1 秒
                System.out.println("任务成功返回:" + obj);
            } catch (TimeoutException ex) {
                System.out.println("处理超时啦....");
                ex.printStackTrace();
            } catch (Exception e) {
                System.out.println("处理失败.");
                e.printStackTrace();
            }finally {

                // 关闭线程池
                exec.shutdown();
            }
        }

}
