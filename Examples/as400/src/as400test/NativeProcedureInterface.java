package as400test;

public class NativeProcedureInterface
{
	static
	{
		System.load("/QSYS.LIB/PRDOBJ.LIB/RDJNIIFC.SRVPGM");
	} // end static

	native void writeCarCubeLogMessage(byte[] libraryName, byte[] fileName);

	public static void main(final String[] arguments)
	{
		final NativeProcedureInterface nativeInterface = new NativeProcedureInterface();
		nativeInterface.writeCarCubeLogMessage(arguments[0].getBytes(), arguments[1].getBytes());
	} // end main
} // end class NativeProcedureInterface
