import com.foo.Bar;

//http://logging.apache.org/log4j/1.2/manual.html


 import org.apache.log4j.Logger;
 import org.apache.log4j.PropertyConfigurator;

 public class MyApp2 {

   static Logger logger = Logger.getLogger(MyApp.class.getName());

   public static void main(String[] args) {


     // BasicConfigurator replaced with PropertyConfigurator.
     PropertyConfigurator.configure(args[0]);
		if (logger.isInfoEnabled()) {
			logger.info("Entering application.");
		}
		Bar bar = new Bar();
		bar.doIt();
		if (logger.isInfoEnabled()) {
			logger.info("Exiting application.");
		}

   }
 }
