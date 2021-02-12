import com.foo.Bar;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//http://logging.apache.org/log4j/1.2/manual.html

 public class MyApp2 {

     static Logger logger = Logger.getLogger(MyApp2.class.getName());

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
