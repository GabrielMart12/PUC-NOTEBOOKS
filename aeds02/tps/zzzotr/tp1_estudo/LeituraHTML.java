import java.io.*;
import java.net.*;

public class LeituraHTML {
    public static String lerHTML(String html) {
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        int aAg = 0, eAg = 0, iAg = 0, oAg = 0, uAg = 0;
        int aCr = 0, eCr = 0, iCr = 0, oCr = 0, uCr = 0;
        int aTi = 0, oTi = 0;
        int aCi = 0, eCi = 0, iCi = 0, oCi = 0, uCi = 0;
        int con = 0, br = 0, tab = 0;
        String resp = "";

        for(int index = 0; index < html.length(); index++) {
            if(html.charAt(index) == 'a') { a++; }
            if(html.charAt(index) == 'e') { e++; }
            if(html.charAt(index) == 'i') { i++; }
            if(html.charAt(index) == 'o') { o++; }
            if(html.charAt(index) == 'u') { u++; }

            if(html.charAt(index) == 'á') { aAg++; }
            if(html.charAt(index) == 'é') { eAg++; }
            if(html.charAt(index) == 'í') { iAg++; }
            if(html.charAt(index) == 'ó') { oAg++; }
            if(html.charAt(index) == 'ú') { uAg++; }

            if(html.charAt(index) == 'à') { aCr++; }
            if(html.charAt(index) == 'è') { eCr++; }
            if(html.charAt(index) == 'ì') { iCr++; }
            if(html.charAt(index) == 'ò') { oCr++; }
            if(html.charAt(index) == 'ù') { uCr++; }

            if(html.charAt(index) == 'ã') { aTi++; }
            if(html.charAt(index) == 'õ') { oTi++; }

            if(html.charAt(index) == 'â') { aCi++; }
            if(html.charAt(index) == 'ê') { eCi++; }
            if(html.charAt(index) == 'î') { iCi++; }
            if(html.charAt(index) == 'ô') { oCi++; }
            if(html.charAt(index) == 'û') { uCi++; }

            if(isConsoante(html.charAt(index))) { con++; } 

            if(isBr(html, index)) { br++; }
            if(isTable(html, index)) { tab++; }
        }

        resp += "a(" + (a - tab) + ") ";
        resp += "e(" + (e - tab) + ") ";
        resp += "i(" + (i) + ") ";
        resp += "o(" + (o) + ") ";
        resp += "u(" + (u) + ") ";

        resp += "á(" + (aAg) + ") ";
        resp += "é(" + (eAg) + ") ";
        resp += "í(" + (iAg) + ") ";
        resp += "ó(" + (oAg) + ") ";
        resp += "ú(" + (uAg) + ") ";

        resp += "à(" + (aCr) + ") ";
        resp += "è(" + (eCr) + ") ";
        resp += "ì(" + (iCr) + ") ";
        resp += "ò(" + (oCr) + ") ";
        resp += "ù(" + (uCr) + ") ";

        resp += "ã(" + (aTi) + ") ";
        resp += "õ(" + (oTi) + ") ";

        resp += "â(" + (aCi) + ") ";
        resp += "ê(" + (eCi) + ") ";
        resp += "î(" + (iCi) + ") ";
        resp += "ô(" + (oCi) + ") ";
        resp += "û(" + (uCi) + ") ";

        resp += "consoante(" + (con - (2 * br) - (3 * tab)) + ") ";

        resp += "<br>(" + (br) + ") ";
        resp += "<table>(" + (tab) + ") ";
        
        return resp;
    }

    public static boolean isConsoante(char c) {
        return isLetra(c) && !(isVogal(c));
    }

    public static boolean isLetra(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isVogal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static boolean isBr(String str, int index) {
        boolean resp = false;
        resp =  str.charAt(index    ) == '<' && 
                str.charAt(index + 1) == 'b' && 
                str.charAt(index + 2) == 'r' && 
                str.charAt(index + 3) == '>';
        return resp;
    }

    public static boolean isTable(String str, int index) {
        boolean resp = false;
        resp =  str.charAt(index    ) == '<' && 
                str.charAt(index + 1) == 't' && 
                str.charAt(index + 2) == 'a' && 
                str.charAt(index + 3) == 'b' && 
                str.charAt(index + 4) == 'l' &&
                str.charAt(index + 5) == 'e' &&
                str.charAt(index + 6) == '>';
        return resp;
    }

    public static String getHTML(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;
        try {
           url = new URL(endereco);
           is = url.openStream();  // throws an IOException
           br = new BufferedReader(new InputStreamReader(is));
           while ((line = br.readLine()) != null) {
              resp += line + "\n";
           }
        } catch (MalformedURLException mue) {
           mue.printStackTrace();
        } catch (IOException ioe) {
           ioe.printStackTrace();
        } 
        try {
           is.close();
        } catch (IOException ioe) {
           // nothing to see here
        }
        return resp;
    }

    public static boolean isHTML(String str) {
        return str.charAt(0) == 'h' && str.charAt(1) == 't' && str.charAt(2) == 't' && str.charAt(3) == 'p';
    }

    public static boolean isFim(String str) {
        return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[1000];
        String[] saida = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
            saida[numEntrada] = isHTML(entrada[numEntrada]) ? lerHTML(getHTML(entrada[numEntrada])) : entrada[numEntrada];
        } while(!isFim(entrada[numEntrada++]));
        numEntrada--;

        for(int i = 0; i < numEntrada; i++) {
            if(i % 2 != 0) {
                MyIO.println(saida[i] + saida[i - 1]);
            }
        }
    }
}
