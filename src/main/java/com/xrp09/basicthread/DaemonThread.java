
public class DaemonThread {

	public static void main(String[] args) throws InterruptedException {
			//线程开始
			Thread thread = new Thread(() ->{
				while(true){
					try {
//						System.out.println("lambda代码片段");
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
//			thread.setDaemon(true);//将thread设置为守护线程
			thread.start();
			Thread.sleep(2_000L);
			//main线程结束
			System.out.println("Main thread finished lifecycle.");
			/*现在即使main线程结束了自己的生命周期，
			JVM进程永远不会退出，因为JVM进程中还存在一个非守护线程在运行*/
	}

}
