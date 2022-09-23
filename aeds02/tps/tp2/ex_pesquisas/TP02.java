//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.RandomAccessFile;
//import java.util.Locale;
//import java.util.Date;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

class Games {
	private int appId;
	private String name;
	private Date releaseDate;
	private String owners;
	private int age;
	private float price;
	private int dlcs;
	private String[] languages;
	private String website;
	private boolean windows;
	private boolean mac;
	private boolean linux;
	private float upvotes;
	private int avgPt;
	private String developers;
	private String[] genres;

	void Game() {
		this.appId = 0;
		this.name = "";
		this.releaseDate = new Date();
		this.owners = "";
		this.age = 0;
		this.price = 0;
		this.dlcs = 0;
		this.languages = new String[20];
		this.website = "";
		this.windows = false;
		this.mac = false;
		this.linux = false;
		this.upvotes = 0;
		this.avgPt = 0;
		this.developers = "";
	        this.genres = new String[20];	
	}

	void Game(int appId, String name, Date releaseDate, String owners, int age, float price, int dlcs, String[] languages, String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers, String[] genres) {
		this.appId = appId;
		this.name = name;
		this.releaseDate = releaseDate;
		this.owners = owners;
		this.age = age;
		this.price = price;
		this.dlcs = dlcs;
		this.languages = languages;
		this.website = website;
		this.windows = windows;
		this.mac = mac;
		this.linux = linux;
		this.upvotes = upvotes;
		this.avgPt = avgPt;
		this.developers = developers;
	}

	public int getAppId() { return this.appId; }
	public void setAppId(int appId) { this.appId = appId; }

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	public Date getReleaseDate() { return this.releaseDate; }
	public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

	public String getOwners() { return this.owners; }
	public void setOwners(String owners) { this.owners = owners; }

	public int getAge() { return this.age; }
	public void setAge(int age) { this.age = age; }

	public float getPrice() { return this.price; }
	public void setPrice(float price) { this.price = price; }

	public int getDlcs() { return this.dlcs; }
	public void setDlcs(int dlcs) { this.dlcs = dlcs; }

	public String[] getLanguages() { return this.languages; }
	public void setLanguages(String[] languages) { this.languages = languages; }

	public String getWebsite() { return this.website; }
	public void setWebsite(String website) { this.website = website; }

	public boolean getWindows() { return this.windows; }
	public void setWindows(boolean windows) { this.windows = windows; }

	public boolean getMac() { return this.mac; }
	public void setMac(boolean mac) { this.mac = mac; }

	public boolean getLinux() { return this.linux; }
	public void setLinux(boolean linux) { this.linux = linux; }

	public float getUpvotes() { return this.upvotes; }
	public void setUpvotes(float upvotes) { this.upvotes = upvotes; }

	public int getAvgPt() { return this.avgPt; }
	public void setAvgPt(int avgPt) { this.avgPt = avgPt; }

	public String getDevelopers() { return this.developers; }
	public void setDevelopers(String developers) { this.developers = developers; }
	
	public String[] getGenres() { return this.genres; }
	public void setGenres(String[] genres) { this.genres = genres; }
	
	public String imprimir() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM/yyyy", Locale.US);
		String resp = getAppId() + " " +
		              getName() + " " + 
		              sdf.format(getReleaseDate()) + " " +
		              getOwners() + " " +
		              getAge() + " " +
		              formatPrice(getPrice()) + " " +
		              getDlcs() + " " +
		              parseArrayString(getLanguages()) + " " +
		              getWebsite() + " " +
		              getWindows() + " " +
		              getMac() + " " +
		              getLinux() + " " + 
		              parsePorcentagem(getUpvotes()) + " " +
		              parseHrMin(getAvgPt()) + " " +
			      getDevelopers() + " " +
			      parseArrayString(getGenres());
		return resp;
	}

	private String formatPrice(float price) {
		String resp = Float.toString(price);
		return resp.charAt(resp.length() - 1) == '0' && resp.charAt(resp.length() - 2) == '.' ? resp + "0" : resp;
	}

	public String parseArrayString(String[] arr) {
		String resp = "[";
		if(arr != null) {
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != arr[arr.length - 1]) {
					resp += arr[i] + ", ";
				} else {
					resp += arr[i];
				}
			}
		}
		return resp + "]";
	}
	
	public String parseArrayStringTeste(String[] arr) {
		String resp = "";
		for(int i = 0; i < arr.length; i++) {
			resp += arr[i] + " ";
		}
		return resp;
	}

	private String parsePorcentagem(Float entrada) {
		entrada = (float)Math.round(entrada * 100);
		String resp = Float.toString(entrada);
		//System.out.println(resp);
		return resp.equals("100.0") ? "100%" : resp.substring(0, 2) + "%";
	} 

	private String parseHrMin(int entrada) {
		int horas = entrada / 60;
		int min = entrada % 60;
		String resp = horas + "h " + min + "m";
		resp = resp.equals("0h 0m") ? "null" : resp;
		resp = resp.equals("0h " + min + "m") ? min + "m" : resp;
		resp = resp.equals(horas + "h 0m") ? horas + "h" : resp;
		return resp;
	}
	
	private boolean isAspas(char c) {
		return c == '"';
	}
	
	private boolean isVirgula(char c) {
		return c == ',';
	}
	
	private boolean isVirgulaAspas(char c1, char c2) {
		return isVirgula(c1) && isAspas(c2);
	}
	
	public void ler(String identificador) throws Exception {
		String local = "./tmp/games.csv";
		FileReader fr = new FileReader(local);
		BufferedReader br = new BufferedReader(fr);
		int index = 0;
		String linha = br.readLine();

		while(!linha.contains(identificador)) linha = br.readLine();
		
		// getAppID
		String appId = "";
		while(!isVirgula(linha.charAt(index))) appId += linha.charAt(index++);
		setAppId(Integer.parseInt(appId));
		index++;
		
		int idInt = Integer.parseInt(identificador);
		while(idInt != getAppId()) {
			linha = br.readLine();
			while(!linha.contains(identificador)) linha = br.readLine();
			
			appId = "";
			index = 0;
			while(!isVirgula(linha.charAt(index))) appId += linha.charAt(index++);
			setAppId(Integer.parseInt(appId));
			index++;
		}
		
		// getName
		String name = "";
		if(isAspas(linha.charAt(index))) {
			index++;
			while(!(isAspas(linha.charAt(index)) && isVirgula(linha.charAt(index + 1)))) { 
				name += linha.charAt(index++); 
			}
			index += 2; // pular ,"
		} else {
			while((!isVirgula(linha.charAt(index)))) { 
				name += linha.charAt(index++); 
			}
			index++;
		}
		setName(name);
		

		// getReleaseDate
		String releaseDate = "";
		if(isAspas(linha.charAt(index))) {
			index++;
			while(!(isAspas(linha.charAt(index)) && isVirgula(linha.charAt(index + 1)))) { releaseDate += linha.charAt(index++); }
			index += 2; // pular ,"
		} else {
			while((!isVirgula(linha.charAt(index)))) { releaseDate += linha.charAt(index++); }
			index++;
		}
		
		try {
			if(releaseDate.split(" ").length == 3) {
				setReleaseDate(parseReleaseDateQtd3(releaseDate));
			} else if (releaseDate.split(" ").length == 2) {
				setReleaseDate(parseReleaseDateQtd2(releaseDate));
			} else {
				setReleaseDate(parseReleaseDateQtd1(releaseDate));
			}
		} catch(Exception e) { 
			e.printStackTrace();  
		};
		
		// getOwners
		String owners = "";
		if(isAspas(linha.charAt(index))) {
			index++;
			while(!(isAspas(linha.charAt(index)) && isVirgula(linha.charAt(index + 1)))) { 
				owners += linha.charAt(index++); 
			}
			index += 2; // pular ,"
		} else {
			while((!isVirgula(linha.charAt(index)))) { 
				owners += linha.charAt(index++); 
			}
			index++;
		}
		setOwners(owners);

		// getAge
		String age = "";
		if(isAspas(linha.charAt(index))) {
			index++;
			while(!(isAspas(linha.charAt(index)) && isVirgula(linha.charAt(index + 1)))) { 
				age += linha.charAt(index++); 
			}
			index += 2; // pular ,"
		} else {
			while((!isVirgula(linha.charAt(index)))) { 
				age += linha.charAt(index++); 
			}
			index++;
		}
		setAge(Integer.parseInt(age));

		// getPrice
		String price = "";
		if(isAspas(linha.charAt(index))) {
			index++;
			while(!(isAspas(linha.charAt(index)) && isVirgula(linha.charAt(index + 1)))) { 
				price += linha.charAt(index++); 
			}
			index += 2; // pular ,"
		} else {
			while((!isVirgula(linha.charAt(index)))) { 
				price += linha.charAt(index++); 
			}
			index++;
		}
		setPrice(Float.parseFloat(price));

		// getDlcs
		String dlcs = "";
		if(isAspas(linha.charAt(index))) {
			index++;
			while(!(isAspas(linha.charAt(index)) && isVirgula(linha.charAt(index + 1)))) { 
				dlcs += linha.charAt(index++); 
			}
			index += 4; // pular ,"
		} else {
			while((!isVirgula(linha.charAt(index)))) { 
				dlcs += linha.charAt(index++); 
			}
			index += 3;
		}
		setDlcs(Integer.parseInt(dlcs));
		
		// getLanguages
		String languages = "";
		//System.out.println(linha.charAt(index) + " " + linha.charAt(index - 1));
		if(linha.charAt(index - 1) == ']') {
			setLanguages(new String[1]);
		} else {
			while(linha.charAt(index) != ']') languages += linha.charAt(index++);
			setLanguages(parseLanguages(languages.replace("'", "").trim()));
		}
		
		
		// getWebsite
		String website = "";
		int contVirgula = 0;
		while(contVirgula < 2) {
			if(linha.charAt(index) == ',') {
		       		contVirgula++;
				index++;
			} else {
				website += linha.charAt(index++); 
			}
		}
		website = website.contains("\"") ? website.replace("\"", "") : website;
		website = website.contains("]") ? website.replace("]", "") : website;
		setWebsite(website.length() == 0 ? "null" : website);	
	
		//windows
		String windows = "";
		while(linha.charAt(index) != ',') windows += linha.charAt(index++);
		setWindows(windows.equals("True") ? true : false);
		index++;

		//mac
		String mac = "";
		while(linha.charAt(index) != ',') mac += linha.charAt(index++);
		setMac(mac.equals("True") ? true : false);
		index++;

		//linux
		String linux = "";
		while(linha.charAt(index) != ',') linux += linha.charAt(index++);
		setLinux(linux.equals("True") ? true : false);
		index++;
		
		//upvotes
		String qtdPos = "";
		String qtdOtr = "";
		while(linha.charAt(index) != ',') qtdPos += linha.charAt(index++);
		index++;
		while(linha.charAt(index) != ',') qtdOtr += linha.charAt(index++);
		setUpvotes(parseUpvotes(qtdPos, qtdOtr));
		index++;

		//avgPt
		String avgPt = "";
		while(linha.charAt(index) != ',') avgPt += linha.charAt(index++);
		setAvgPt(Integer.parseInt(avgPt));
		index++;

		//developers
		String developers = "";
		if(linha.charAt(index) == '"') {
			index++;
			while(linha.charAt(index) != '"') developers += linha.charAt(index++);
			index += 2;
		} else {
			while(linha.charAt(index) != ',') developers += linha.charAt(index++);
			index++;
		}
		setDevelopers(developers);
		
		
		//genres
		String genres = "";
		int contAspas = 0;
		while(contAspas < 2 && index < linha.length()) {
			if(linha.charAt(index) == '"') {
				contAspas++;
				index++;
			} else {
				genres += linha.charAt(index++);
			}
		}
		setGenres(genres.split(","));
		
		br.close();
	}

	private Date parseReleaseDateQtd3(String str) throws Exception {
		return new SimpleDateFormat("MMM dd, yyyy", Locale.US).parse(str);
	}
	
	private Date parseReleaseDateQtd2(String str) throws Exception {
		return new SimpleDateFormat("MMM yyyy", Locale.US).parse(str);
	}
	
	private Date parseReleaseDateQtd1(String str) throws Exception {
		return new SimpleDateFormat("yyyy", Locale.US).parse(str);
	}

	private String[] parseLanguages (String str) {
		int numElementos = contarVirgulas(str) + 1;
		String[] arrLanguages = new String[numElementos];
		
		arrLanguages = str.split(", ");
		
		return arrLanguages;
	}
	private int contarVirgulas(String str) {
		int resp = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ',') {
				resp++;
			}
		}
		return resp;
	}

	private float parseUpvotes(String pos, String otr) {
		Float posF = Float.parseFloat(pos);
		Float otrF = Float.parseFloat(otr);
		float resp = posF / (posF + otrF);
		return resp;
	}
	
	/*
	public String getAllEntradas() throws Exception {
		String local = "./tmp/games.csv";
		FileReader fr = new FileReader(local);
		BufferedReader br = new BufferedReader(fr);
		int index = 0;
		String linha = br.readLine();
		String resp = "";

		while(linha != null) { 
			String appId = "";
			while(linha.charAt(index) != ',') appId += linha.charAt(index++);
			resp += appId + "\n";
			index = 0;
			linha = br.readLine();
		}
		
		return resp;
	}
	*/
	
}

class Pesquisa {
	public static boolean pesquisarSequencial(Games[] games, String str, Complexidade complexidade) {
		boolean resp = false;
		for (int i = 0; i < games.length; i++) {
			complexidade.somarSelecao();
			if(games[i].imprimir().contains(str)) {
				resp = true;
			}
		}
		return resp;
	}

	public static boolean pesquisarBinario(Games[] games, String str, Complexidade complexidade) {
		boolean resp = false;
		int dir = games.length - 1, esq = 0; 
		while(esq <= dir) {
			int meio = (dir + esq) / 2;
			int strCompTo = games[meio].imprimir().compareTo(str);
			if(strCompTo == 0) {
				resp = true;
				esq = games.length;
				complexidade.somarBinaria(1);
			} else if (strCompTo > 0) {
				esq = meio + 1;
				complexidade.somarBinaria(2);
			} else {
				dir = meio - 1;
				complexidade.somarBinaria(2);
			}
		}
		return resp;
	}
}

class Arquivo {
	public static void criar(String nomeArq, String totComparacoes) throws Exception {
		RandomAccessFile raf = new RandomAccessFile(nomeArq, "rw");
		raf.writeChars("733875\n");
		raf.writeChars(totComparacoes);
		raf.writeChar('\n');
		raf.close();
	}
}

class Complexidade {
	private int compSelecao;
	private int compBinaria;

	Complexidade () {
		this.compSelecao = 0;
		this.compBinaria = 0;
	}

	public int getSelecao() { return this.compSelecao; }
	public void somarSelecao() { this.compSelecao++; }

	public int getBinaria() { return this.compBinaria; }
	public void somarBinaria(int valor) { this.compBinaria += valor; }
}

class TP02 {
	public static boolean isFim(String str) {
		return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
	}
	public static void main(String[] args) {
		String[] entrada = new String[1000];
		//String[] pesquisa = new String[1000];
		int numEntrada = 0;

		do {
			entrada[numEntrada] = MyIO.readLine();
		} while(!isFim(entrada[numEntrada++]));	
		numEntrada--;

		Games[] games = new Games[numEntrada];
		for(int i = 0; i < numEntrada; i++) {
			games[i] = new Games();
			try {
				games[i].ler(entrada[i]);
				//System.out.println(games[i].imprimir());	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		Complexidade complexidade = new Complexidade();
		numEntrada = 0;
		String tmp;
		do {
			tmp = MyIO.readLine();
			if(!isFim(tmp))
				System.out.println(Pesquisa.pesquisarBinario(games, tmp, complexidade) ? "SIM" : "NAO");
		} while(!isFim(tmp));	

		try {
			String str = Integer.toString(complexidade.getBinaria());
			Arquivo.criar("matricula_binaria.txt", str);
		} catch(Exception e) { e.printStackTrace(); }
	}
}
