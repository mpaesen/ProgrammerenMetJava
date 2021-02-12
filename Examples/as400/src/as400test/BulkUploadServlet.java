 package as400test;

 import javax.servlet.ServletException;
 import javax.servlet.ServletInputStream;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.io.*;

 public class BulkUploadServlet extends HttpServlet {
 	private static String uploadLocation;
 	private static String dataQueueLibrary;
 	private static NativeProcedureInterface nativeInterface;

 	private void writeCarCubeLogMessage(String fileName) {
 		nativeInterface.writeCarCubeLogMessage(
 				dataQueueLibrary.getBytes(),
				fileName.getBytes());
 	} // end writeCarCubeLogMessage;

 	public void init() throws ServletException {
 		dataQueueLibrary = getInitParameter("dataQueueLibrary");
 		log("[RADIUS] - data queue library = " + dataQueueLibrary);
 		uploadLocation = getInitParameter("uploadLocation");
 		log("[RADIUS] - upload location = " + uploadLocation);
 		nativeInterface = new NativeProcedureInterface();
 		log("[RADIUS] - native procedure interface linked");
 		log("[RADIUS] be.securitas.bulkserver.BulkUploadServlet started");
 	}

 	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
 		try {
 			res.setContentType("text/html");
 			PrintWriter w = res.getWriter();
 			w.print("<html>");
 			w.print("<head>");
 			w.print("<title>be.securitas.bulkserver.BulkUploadServlet</title>");
 			w.print("</head>");
 			w.print("<body>");
 			w.print("<h1>The Bulk Upload Servlet Is Active</h1>");
 			w.print("</body>");
 			w.print("</html>");
 			w.close();
 		} catch (IOException ioe) {
 			log(
 					"[RADIUS] Exception in UploadServlet, GET method: "
 					+ ioe.getMessage());
 			throw ioe;
 		}
 	}

 	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
 		log("[RADIUS] Upload request...");
 		int fileNameLength = 0;
 		String fileName = null;
 		int length = 0;
 		byte[] bytes = null;
 		try {
 			ServletInputStream sis = req.getInputStream();
 			DataInputStream dis = new DataInputStream(sis);
 			fileNameLength = dis.readInt();
 			log("[RADIUS] file length = " + fileNameLength);
 			bytes = new byte[fileNameLength];
 			dis.read(bytes);
 			fileName = new String(bytes);
 			bytes = new byte[256];
 			log(
 					"[RADIUS] uploading file : "
 					+ uploadLocation
					+ File.separator
					+ fileName);
 			FileOutputStream fos =
 				new FileOutputStream(
 						uploadLocation + File.separator + fileName);
 			while ((length = dis.read(bytes)) > 0) {
 				fos.write(bytes, 0, length);
 			}
 			fos.close();
 			dis.close();
 			sis.close();
 			log("[RADIUS] file uploaded.");
 			writeCarCubeLogMessage(uploadLocation + File.separator + fileName);
 			log("[RADIUS] safe message (CL) sent");
 		} catch (IOException ioe) {
 			log(
 					"[RADIUS] exception in UploadServlet, upload failed: "
 					+ ioe.getMessage());
 			throw ioe;
 		}
 	}

 	public void destroy() {
 		log("[RADIUS] be.securitas.bulkserver.BulkUploadServlet stopped.");
 	}
 } // end class BulkUploadServlet
 