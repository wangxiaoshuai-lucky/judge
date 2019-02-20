package cn.wzy.kafka;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("judge process start ！");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		JudgeConsumer.executor.shutdown();
		System.out.println("judge process shutdown ！");
	}
}
