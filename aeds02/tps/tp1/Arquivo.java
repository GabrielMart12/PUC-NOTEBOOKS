import java.io.*;
import java.lang.Math;

class Arquivo {
	public static void imprimir(double entrada) {
		if(entrada - Math.floor(entrada) == 0.0) {
			MyIO.println((int)entrada);
		} else {
			MyIO.println(entrada);
		}
	}

	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");
		int numEntradas = MyIO.readInt();
		int index = 0;
		while(index < numEntradas) {
			double tmp = MyIO.readDouble();
			raf.writeDouble(tmp);
			index++;
		}
		raf.close();
		
		RandomAccessFile raf2 = new RandomAccessFile("exemplo.txt", "r");
		index = numEntradas;
		while(index > 0) { 
			raf2.seek((8 * index) - 8);
			imprimir(raf2.readDouble());
			index--;
		}
		raf2.close();
		
		
	}
}
