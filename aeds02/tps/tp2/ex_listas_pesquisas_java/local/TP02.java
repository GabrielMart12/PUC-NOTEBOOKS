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

	public Games clonar() {
		Games clone = new Games();
		clone.setAppId(this.appId);
		clone.setName(this.name);
		clone.setReleaseDate(this.releaseDate);
		clone.setOwners(this.owners);
		clone.setAge(this.age);
		clone.setPrice(this.price);
		clone.setDlcs(this.dlcs);
		clone.setLanguages(this.languages);
		clone.setWebsite(this.website);
		clone.setWindows(this.windows);
		clone.setMac(this.mac);
		clone.setLinux(this.linux);
		clone.setUpvotes(this.upvotes);
		clone.setAvgPt(this.avgPt);
		clone.setDevelopers(this.developers);
		clone.setGenres(this.genres);
		return clone;
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

class Lista {
	private Games[] gamesLista;
	private int n;

	Lista() {
		this(new Games[100], 100, 100);
	}
	Lista(Games[] gamesMain, int listaLength, int mainLength) {
		this.gamesLista = new Games[mainLength + listaLength];
		for(int i = 0; i < mainLength; i++) { 
			this.gamesLista[i] = gamesMain[i].clonar();
		}
		this.n = mainLength;
	}

	public void inserirInicio(String appId) throws Exception {
		if(this.n >= this.gamesLista.length) 
			throw new Exception("Impossivel inserir elementos em games");
		for(int i = this.n; i > 0; i--) { 
			this.gamesLista[i] = new Games();
			String strAppId = Integer.toString(this.gamesLista[i - 1].getAppId());
			this.gamesLista[i].ler(strAppId);
		}
		this.gamesLista[0].ler(appId);
		this.n =  this.n + 1;
	}

	public void inserirFim(String appId) throws Exception {
		if(this.n >= this.gamesLista.length) 
			throw new Exception("Impossivel inserir elementos em games");
		this.gamesLista[n] = new Games();
		this.gamesLista[n].ler(appId);
		this.n =  this.n + 1;
	}

	public void inserir(String appId, int pos) throws Exception {
		if(this.n >= this.gamesLista.length || pos > this.n || pos < 0) 
			throw new Exception("Impossivel inserir elementos em games");
		for(int i = this.n; i > pos; i--) {
			this.gamesLista[i] = new Games();
			String strAppId = Integer.toString(this.gamesLista[i - 1].getAppId());
			this.gamesLista[i].ler(strAppId);
		}
		this.gamesLista[pos].ler(appId);
		this.n =  this.n + 1;
	}

	public Games removerInicio() throws Exception {
		if(this.n == 0) 
			throw new Exception("Impossivel remover elementos");
		Games tmp = this.gamesLista[0].clonar(); 
		--this.n;
		for(int i = 0; i < this.n; i++) {
			String strAppId = Integer.toString(this.gamesLista[i + 1].getAppId());
			this.gamesLista[i].ler(strAppId);
		}
		return tmp;
	}

	public Games removerFim() throws Exception {
		if(this.n == 0) 
			throw new Exception("Impossivel remover elementos");
		return this.gamesLista[--this.n].clonar();
	}

	public Games remover(int pos) throws Exception {
		if(this.n == 0 || pos > this.n || pos < 0) 
			throw new Exception("Impossivel remover elementos");
		Games tmp = this.gamesLista[pos].clonar(); 
		--this.n;
		for(int i = pos; i < this.n; i++) {
			String strAppId = Integer.toString(this.gamesLista[i + 1].getAppId());
			this.gamesLista[i].ler(strAppId);
		}
		return tmp;
	}

	public void mostrar() {
		for(int i = 0; i < n; i++) {
			System.out.println("[" + i + "] " + this.gamesLista[i].imprimir());
		}
	}

	public void definirAcaoLista(String str) {
		if(str.charAt(0) == 'I' && str.charAt(1) == 'I') {
			try { inserirInicio(str.substring(3, str.length())); 
			} catch(Exception e) { e.printStackTrace(); }
		} else if (str.charAt(0) == 'I' && str.charAt(1) == 'F') {
			try { inserirFim(str.substring(3, str.length())); 
			} catch(Exception e) { e.printStackTrace(); }
		} else if (str.charAt(0) == 'I' && str.charAt(1) == '*') {
			try { 
				int pos = Integer.parseInt(str.substring(3, 5));
				inserir(str.substring(6, str.length()), pos); 
			} catch(Exception e) { e.printStackTrace(); }
		} else if (str.charAt(0) == 'R' && str.charAt(1) == 'I') {
			try {
				Games gameRemovido = removerInicio();
				System.out.println("(R) " + gameRemovido.getName());
			} catch(Exception e) { e.printStackTrace(); }
		} else if (str.charAt(0) == 'R' && str.charAt(1) == 'F') {
			try {
				Games gameRemovido = removerFim();
				System.out.println("(R) " + gameRemovido.getName());
			} catch(Exception e) { e.printStackTrace(); }
		} else if (str.charAt(0) == 'R' && str.charAt(1) == '*') {
			try {
				int pos = Integer.parseInt(str.substring(3, 5));
				Games gameRemovido = remover(pos);
				System.out.println("(R) " + gameRemovido.getName());
			} catch(Exception e) { e.printStackTrace(); }
		}
	}
}

class Pilha {
	private Games[] gamesPilha;
	private int n;

	Pilha () {
		this(new Games[100], 100, 100);
	}
	Pilha (Games[] gamesMain, int pilhaLength, int mainLength) {
		this.gamesPilha = new Games[pilhaLength + mainLength];
		for(int i = 0; i < mainLength; i++) {
			this.gamesPilha[i] = gamesMain[i].clonar();
		}
		this.n = mainLength;
	}

	public void empilhar(String appId) throws Exception {
		if(this.n >= this.gamesPilha.length)
			throw new Exception("Nao e possivel empilhar");
		this.gamesPilha[n] = new Games();
		this.gamesPilha[n].ler(appId);
		this.n++;
	}

	public Games desempilhar() throws Exception {
		if(this.n == 0)
			throw new Exception("Nao e possivel desempilhar");
		return this.gamesPilha[--n].clonar();
	}

	public void mostrar() {
		for(int i = 0; i < n; i++) {
			System.out.println("[" + i + "] " + this.gamesPilha[i].imprimir());
		}
	}

	public void definirAcaoPilha(String str) {
		if(str.charAt(0) == 'I') {
			try {
				//System.out.println(str.substring(2, str.length()));
				empilhar(str.substring(2, str.length()));
			} catch(Exception e) { e.printStackTrace(); }
		} else if(str.charAt(0) == 'R') {
			try {
				Games gameRemovido = desempilhar();
				System.out.println("(R) " + gameRemovido.getName());
			} catch(Exception e) { e.printStackTrace(); }
		}
	}
}

class Fila {
	private Games[] gamesFila;
	private int primeiro, ultimo;

	Fila() {
		this(5);
	}
	Fila(int tamanho) {
		this.gamesFila = new Games[tamanho + 1];
		primeiro = ultimo = 0;
	}

	public void inserir(Games game) throws Exception {
		if(((ultimo + 1) % gamesFila.length) == primeiro) {
			try { Games tmp = remover(); 
			} catch(Exception e) { e.printStackTrace(); }
		}
		gamesFila[ultimo] = new Games();
		gamesFila[ultimo].ler(Integer.toString(game.getAppId()));
		ultimo = (ultimo + 1) % gamesFila.length;
		calcularAvgPt();
	}
	
	public Games remover() throws Exception {
		if(primeiro == ultimo)
			throw new Exception("Erro ao remover da fila");
		Games resp = gamesFila[primeiro].clonar();
		primeiro = (primeiro + 1) % gamesFila.length;
		return resp;
	}

	public void calcularAvgPt() {
		float tot = 0;
		int cont = 0, i = primeiro;
		while(i != ultimo) {
			tot += gamesFila[i].getAvgPt();
			i = (i + 1) % gamesFila.length;
			cont++;
		}
		System.out.println((int)Math.round(tot / cont));
	}

	public void mostrar() {
		int i = primeiro;
		while(i != ultimo) {
			System.out.println("[" + i + "] " + gamesFila[i].imprimir());
			i = (i + 1) % gamesFila.length;
		}
	}

	public void definirAcaoFila(String str) {
		if(str.charAt(0) == 'I') {
			try {
				System.out.println(str);
				Games novoGame = new Games();
				novoGame.ler(str.substring(2, str.length()));
				inserir(novoGame);
			} catch(Exception e) { e.printStackTrace(); }
		} else if(str.charAt(0) == 'R') {
			try {
				System.out.println(str);
				Games gameRemovido = remover();
				System.out.println("(R) " + gameRemovido.getName());
			} catch(Exception e) { e.printStackTrace(); }
		}
	}
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
		Fila gamesFila = new Fila();

		for(int i = 0; i < numEntrada; i++) {
			games[i] = new Games();
			try {
				games[i].ler(entrada[i]);
				gamesFila.inserir(games[i]);
				//System.out.println(games[i].imprimir());	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		int filaLength = MyIO.readInt();
		
		int iFila = 0;
		while(iFila < filaLength) {
			String tmp = MyIO.readLine();
			gamesFila.definirAcaoFila(tmp);		
			iFila++;	
		}
		
		gamesFila.mostrar();
		
		/*
		int pilhaLength = MyIO.readInt();
		Pilha gamesPilha = new Pilha(games, pilhaLength, numEntrada);

		int iPilha = 0;
		while(iPilha < pilhaLength) {
			String tmp = MyIO.readLine();
			gamesPilha.definirAcaoPilha(tmp);		
			iPilha++;	
		}

		gamesPilha.mostrar();

		int listaLength = MyIO.readInt();
		Lista gamesLista = new Lista(games, listaLength, numEntrada);

		int iLista = 0;
		while(iLista < listaLength) {
			String tmp = MyIO.readLine();
			gamesLista.definirAcaoLista(tmp);		
			iLista++;	
		}

		gamesLista.mostrar();
		
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
		*/
	}
}
